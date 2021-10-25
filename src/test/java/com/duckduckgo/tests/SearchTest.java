package com.duckduckgo.tests;

import com.BaseTest;
import com.duckduckgo.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    public void setSearchTestClasses(){
        this.searchPage = new SearchPage(driver);
    }

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        searchPage.goTo();
        searchPage.doSearch(keyword);
        searchPage.goToVideos();
        int size = searchPage.printResult();

        Assert.assertTrue(size > 0);
    }

}
