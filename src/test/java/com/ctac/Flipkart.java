package com.ctac;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import pageobjects.google_home_purchase_objects;

public class Flipkart extends base {
	 private static final Logger LOGGER = LoggerFactory.getLogger(Flipkart.class);
	public google_home_purchase_objects go;
	static WebDriverWait wait;
	
	@BeforeTest(description="Initialize Driver")
	public void gotoHome_flipkart() throws IOException
	{
		driver =initializeDriver();
	//wait = new WebDriverWait(driver,15);
		
			
	}
	@Test(description="Hit Flipkart URL")
	public void hiturl()
	{
		driver.get("https://www.flipkart.com/");
		LOGGER.info("Hit Flipkart URL successful");

	}
	//@Test(description="purchase GoogleHome",dependsOnMethods="hiturl")
	public void purchase_google_home()
	{
		//go.removeloginpopup().sendKeys(Keys.ESCAPE);
		//driver.findElement(By.className("_2AkmmA _29YdH8")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By) go.clickonsearch()));
	
		go.sendproductname().sendKeys("Goole Mini");
		go.clickonsearch().click();
		
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		
	}

}
