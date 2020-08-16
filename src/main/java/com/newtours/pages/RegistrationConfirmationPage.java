package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(partialLinkText = "sign-in")
    private WebElement signinLink;
    @FindBy(partialLinkText = "Flights")
    private WebElement flightslink;

    public RegistrationConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);
    }

    public void gotoFlightDetailsPage()
    {
        this.wait.until(ExpectedConditions.visibilityOf(signinLink));
        signinLink.click();
        flightslink.click();
    }



}
