package com.ctac;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import pageobjects.alexapurchaseobjects;
import rp.com.google.common.io.BaseEncoding;
import utilities.retry;
import base.base;


public class amazon extends base {

	public alexapurchaseobjects ao;

	private static final Logger LOGGER =LogManager.getLogger(amazon.class);

	@BeforeClass(description = "Initialize Driver")
	public void driverInitialization() throws IOException
	{
		driver =initializeDriver();
		
	}

	@Test(description = "Hit AmazonURL", retryAnalyzer=retry.class)
    public void gotoamazonurl()
    {
		driver.get("https://www.amazon.in");
		WebDriverWait wait = new WebDriverWait(driver,10);
		ao = new alexapurchaseobjects(driver);
    }

	//@Test(enabled = false, description = "logintoamazon", dependsOnMethods ="gotoamazonurl", retryAnalyzer=retry.class)
	public void login() throws InterruptedException {

		ao.clickcart().click();
		ao.ClickSigninbtnhome().click();
		driver.wait(10);
		ao.email().sendKeys("YOUR_USERNAME");
		ao.clickcontinue().click();
		ao.enterpassword().sendKeys("YOUR_PASSWORD");
		ao.clicklogin().click();
		
				
	}
	@Test(description="search-product")//, dependsOnMethods ="login")
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
	
	@Test(description="Add and Remove from Cart", dependsOnMethods = "searchproduct", retryAnalyzer=retry.class)
	public void add_clear_cart()
	{
		ao.addtocart().click();
		ao.buynow().click();
		ao.viewcart().click();
		ao.clearcart().click();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
		
	}




}
