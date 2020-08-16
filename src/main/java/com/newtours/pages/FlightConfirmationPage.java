package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css=".frame_header_info > table  tr > td:nth-of-type(1) > b > font > font > b > font:nth-of-type(1)")
    private WebElement flightConfirmationHeader;
    @FindBy (xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;
    @FindBy(partialLinkText = "SIGN-OFF")
    private WebElement signoff;

    public FlightConfirmationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public String GetPrice()
    {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        System.out.println("Total Price: "+prices.get(1).getText());
        String Actualprice = prices.get(1).getText();
        //Assert.assertEquals(prices.get(1).getText(), "$44 USD");
        signoff.click();
        return Actualprice;

    }

}
