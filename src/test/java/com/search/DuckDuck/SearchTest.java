package com.search.DuckDuck;

import base.base_redefined;
import com.duckduckgo.pages.SearchPage;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends base_redefined {


    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @SneakyThrows
   @Test(description = "DuckDuckSearch")
    @Parameters({"keywordToSearch"})
    public void searchInDuckDuckGo(String keywordfromTestNG) {
        System.out.println("UserFolder: "+System.getProperty("user.dir"));
        SearchPage SP = new SearchPage(driver);
        SP.goTo();
        SP.doSearch(keywordfromTestNG);
        SP.goToVideos();

    }

    @SneakyThrows
    @Test(description = "DuckDuckSearch")
     @Parameters({"keywordToSearch"})
     public void SearchFailTC(String keywordfromTestNG) {
         SearchPage SP = new SearchPage(driver);
         SP.goTo();
         SP.doSearch(keywordfromTestNG);
         SP.goToVideos();
         int size = SP.printResult();
         assertThat(size).withFailMessage("Expected Results Must be Grater than 1000").isGreaterThan(1000);

     }

}
