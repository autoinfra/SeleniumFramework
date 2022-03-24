package com.search.DuckDuck;

import base.base_redefined;
import com.duckduckgo.pages.SearchPage;
import com.epam.reportportal.annotations.attribute.Attributes;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.customAnnotations.AzureDevOps.AzureDevOps;
import utilities.customAnnotations.Jira.JiraIssue;

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

    @AzureDevOps(WorkItemID = 123)
    @Test(priority = 1)
    public void LoginToPortal() {
        Assert.assertTrue(true);

    }

    @AzureDevOps(WorkItemID = 456)
    @Test(priority = 2)
    public void CreateCustomer() {
        Assert.assertTrue(false);

    }

    @SneakyThrows
    @AzureDevOps(WorkItemID = 987)
    @Test(priority = 3)
    public void AddBilling() {
        Thread.sleep(70000);
        Assert.assertTrue(true);

    }


}
