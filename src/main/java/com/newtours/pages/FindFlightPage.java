package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css="p > input[name='reserveFlights']")
   private WebElement FirstSubmitbtn;
    @FindBy(name = "buyFlights")
    private WebElement SecondSubmitbtn;

    public FindFlightPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void submitFindFlightPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(FirstSubmitbtn));
        FirstSubmitbtn.click();
    }

    public void goToFlightConfirmationPage()
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(SecondSubmitbtn));
        SecondSubmitbtn.click();
    }

}
