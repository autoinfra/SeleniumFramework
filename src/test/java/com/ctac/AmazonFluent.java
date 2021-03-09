package com.ctac;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.alexapurchaseobjects;
import base.base;


public class AmazonFluent extends base {

	public alexapurchaseobjects ao;
	//public static Logger log =LogManager.getLogger(base.class.getName());
	//private static final Logger LOGGER = LoggerFactory.getLogger(base.class.getName());
	private static final Logger LOGGER =LogManager.getLogger(AmazonFluent.class);

	@BeforeTest(description = "navigatetoamazon")
	public void driverInitialization() throws IOException
	{
		driver =initializeDriver();
		
		 //LOGGER.info("Hello from my simple test");
		//log.info("navigated to amazon");
	}

	@Test(description = "Hit AmazonURL")
    public void gotoamazonurl()
    {
		driver.get("https://www.amazon.in");
		
    }

	@Test(description = "logintoamazon", dependsOnMethods ="gotoamazonurl")
	public void login()
	{
		ao = new alexapurchaseobjects(driver);
		ao.ClickSigninbtnhome().click();
		ao.email().sendKeys("bhargavm7007@gmail.com");
		ao.clickcontinue().click();
		ao.enterpassword().sendKeys("India@2019");
		ao.clicklogin().click();
		
				
	}
	
	@Test(description="search-product", dependsOnMethods ="login")
	public void searchproduct()
	{
		ao.enterproduct().sendKeys("alexa");
		ao.clickonsearch_product().click();
		ao.clickonalexa().click();

		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it =ids.iterator();
		String Parentwindow=it.next();
		String ChildWindow=it.next();
		driver.switchTo().window(ChildWindow);
	}
	
	@Test(description="Add and Remove from Cart", dependsOnMethods = "searchproduct")
	public void add_clear_cart()
	{
		ao.addtocart().click();
		ao.buynow().click();
		ao.viewcart().click();
		ao.clearcart().click();
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.close();
		
	}




}
