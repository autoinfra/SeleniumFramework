package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(name = "passCount")
    private WebElement passengercountDropDown;
    @FindBy(name = "findFlights")
    private WebElement submitBtn;
    @FindBy(css = "tr:nth-of-type(3) > .frame_action_xrows > input[name='outFlight']")
    private WebElement flightslist;
    public FlightDetailsPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassangers(String noOfPassangers)
    {
        this.wait.until(ExpectedConditions.elementToBeClickable(passengercountDropDown));
        Select select = new Select(passengercountDropDown);
        select.selectByValue(noOfPassangers);
     }

     public void goToFindFlightsPage()
     {
         submitBtn.click();
         wait.until(ExpectedConditions.visibilityOf(flightslist));
     }
}
