package com.search.DuckDuck;

import base.base_redefined;
import com.duckduckgo.pages.SearchPage;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;

public class SearchTest extends base_redefined {


    private static final Logger LOGGER = LogManager.getLogger(SearchTest.class);

    @SneakyThrows
   // @Test(description = "DuckDuckSearch")
    @Parameters({"keywordToSearch"})
    public void searchInDuckDuckGo(String keywordfromTestNG) {
        SearchPage SP = new SearchPage(driver);
        SP.goTo();
        SP.doSearch(keywordfromTestNG);
        SP.goToVideos();
        int size = SP.printResult();
        //ssert.assertTrue(size >100 );

    }

}
