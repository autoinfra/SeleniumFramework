package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "firstName")
    private WebElement firstNameTxt;
    @FindBy(name="lastName")
    private WebElement lastnameTxt;
    @FindBy(name="phone")
    private WebElement PhoneNum;
    @FindBy(id = "userName")
    private WebElement EmailId;
    @FindBy(name = "address1")
    private WebElement AddressLine1;
    @FindBy(name = "address2")
    private WebElement AddressLine2;
    @FindBy(name = "city")
    private WebElement City;
    @FindBy(name = "state")
    private WebElement State;
    @FindBy(name = "postalCode")
    private WebElement PostalCode;
    @FindBy(name = "country") //value 92
    private WebElement Country;
    @FindBy(id = "email")
    private WebElement username;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name="confirmPassword")
    private WebElement confirmPassword;
    @FindBy(name="register")
    private WebElement register;
/* Creating a constructor [ A method same name as Class Name]. As Constructor commands are executed First and then other commands
 when executed a program, which means constructor is executed by default */
    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);
    }

    public void goTo()
    {
        driver.get("http://newtours.demoaut.com/mercuryregister.php?osCsid=6a47212b18e16a8a318cd7a8adf7bc0a");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String LastName, String PhoneNum, String EmailId)
    {
        this.firstNameTxt.sendKeys(firstName);
        this.lastnameTxt.sendKeys(LastName);
        this.PhoneNum.sendKeys(PhoneNum);
        this.EmailId.sendKeys(EmailId);
    }
    public void enterMailingInfo(String AddressLine1, String AddressLine2, String City, String State, String PostalCode, Integer CountryNum)
    {
        this.AddressLine1.sendKeys(AddressLine1);
        this.AddressLine2.sendKeys(AddressLine2);
        this.City.sendKeys(City);
        this.State.sendKeys(State);
        this.PostalCode.sendKeys(PostalCode);
        Select s = new Select(Country);
        s.selectByIndex(CountryNum);
    }
    public void enterUserCredentials(String Username, String Password)
    {
        this.username.sendKeys(Username);
        this.password.sendKeys(Password);
        this.confirmPassword.sendKeys(Password);

    }
    public void submit()
    {
        this.register.click();
    }

}
