package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class google_home_purchase_objects {

	public static WebDriver driver;
	public google_home_purchase_objects(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	WebElement removeloginpopup;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement sendproductname;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement clickonsearch;
	
	public WebElement removeloginpopup() {
			return removeloginpopup;
	}
	
	public WebElement sendproductname() {
	
		return sendproductname;
	}
	
	public WebElement clickonsearch() {
		
		return clickonsearch;
	}
	
	
	
	
}
