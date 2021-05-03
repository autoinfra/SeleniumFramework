package com.search.DuckDuck;

import base.base_redefined;
import com.duckduckgo.pages.SearchPage;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.retry;

public class SearchTest extends base_redefined {
 public WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @BeforeTest
    @SneakyThrows
    public void InitializeDriver()
    {
        driver=SetupDriver();
    }

    @SneakyThrows
    @Test//(description = "DuckDuckSearch" , retryAnalyzer= retry.class)
    @Parameters({"keywordToSearch"})
    public void search(String keywordfromTestNG) {
        SearchPage SP = new SearchPage(driver);
        SP.goTo();
        SP.doSearch(keywordfromTestNG);
        SP.goToVideos();
        int size = SP.printResult();
        Assert.assertTrue(size <100 );

    }

}
