package com.search.DuckDuck;

import base.base_redefined;
import com.duckduckgo.pages.SearchPage;
import com.epam.reportportal.annotations.attribute.Attributes;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.customAnnotations.AzureDevOps.AzureDevOpsIssue;
import utilities.customAnnotations.Jira.JiraIssue;
import utilities.customAnnotations.notOnProd.NotOnProd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SearchTest extends base_redefined {


    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @Attributes
    @SneakyThrows
    @JiraIssue(IssueID = "AUTOINFRA-4")
    //@AzureDevOpsIssue(AzIssueID="DummyID")
    //@NotOnProd
    //@Test(description = "DuckDuckSearch")
    @Parameters({"keywordToSearch"})
    public void searchInDuckDuckGo(String keywordfromTestNG) {
        SearchPage SP = new SearchPage(driver);
        SP.goTo();
        SP.doSearch(keywordfromTestNG);
        SP.goToVideos();
        int size = SP.printResult();
        Assert.assertTrue(size >100 );

    }

    @Test
    public void LoginToPortal() {
        Assert.assertTrue(true);

    }

    @Test
    public void CreateCustomer() {
        Assert.assertTrue(false);

    }

    @Test
    public void AddBilling() {
        Assert.assertTrue(true);

    }


}
