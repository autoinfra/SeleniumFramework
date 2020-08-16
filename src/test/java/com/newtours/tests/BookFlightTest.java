package com.newtours.tests;

import base.base_redefined;
import com.newtours.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.retry;

public class BookFlightTest extends base_redefined {
    private static final Logger LOGGER = LogManager.getLogger(BookFlightTest.class);

    private String noofPassangers;
    private String expectedprice;

    @BeforeTest
    @Parameters({"noofPassangers","expectedprice"})
    public void Parameters(String noofPassangers, String expectedprice)
    {
        this.noofPassangers=noofPassangers;
        this.expectedprice=expectedprice;
    }

    @Test(description = "UserRegistration" , retryAnalyzer=retry.class)
    public void RegistrationPage()
    {
        RegistrationPage RP = new RegistrationPage(driver);
        RP.goTo();
        RP.enterUserDetails("abcd","efgh", "1234567891","Auto.Infra@Auto.com");
        RP.enterMailingInfo("AmdocsT2","Magarpatta","Pune","MH","411014",92);
        RP.enterUserCredentials("abcd.efgh","abcd.efgh");
        RP.submit();
    }
    @Test(dependsOnMethods = "RegistrationPage",description = "RegistrationConfirmation" , retryAnalyzer=retry.class)
    public void RegistrationConfirmation()
    {
        RegistrationConfirmationPage RCP = new RegistrationConfirmationPage(driver);
        RCP.gotoFlightDetailsPage();
    }
    @Test(dependsOnMethods = "RegistrationConfirmation",description = "FlgihtdetailsPage" , retryAnalyzer=retry.class)
    public void FlgihtdetailsPage()
    {
        FlightDetailsPage FDP = new FlightDetailsPage(driver);
        FDP.selectPassangers(noofPassangers);
        FDP.goToFindFlightsPage();
    }
    @Test(dependsOnMethods = "FlgihtdetailsPage",description = "FindFlightPage" , retryAnalyzer=retry.class)
    public void FindFlightPage()
    {
        FindFlightPage FLP = new FindFlightPage(driver);
        FLP.submitFindFlightPage();
        FLP.goToFlightConfirmationPage();
    }
    @Test(dependsOnMethods = "FindFlightPage",description = "FlightConfirmationPage" , retryAnalyzer=retry.class)
    public void FlightConfirmationPage()
    {
        FlightConfirmationPage FCP = new FlightConfirmationPage(driver);
       String ActualPrice= FCP.GetPrice();
        Assert.assertEquals(ActualPrice,expectedprice);
    }
}
