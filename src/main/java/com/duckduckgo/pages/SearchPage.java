package com.duckduckgo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css = "input#search_form_input_homepage")
    private WebElement searchbar;
    @FindBy(css = "#search_button_homepage")
    private WebElement searchBtn;
    @FindBy(linkText = "Videos")
    private WebElement videosLink;
    @FindBy(css = ".tile.tile--c--w.tile--vid.has-detail.opt--t-xxs")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        this.wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void goTo()
    {
        driver.get("https://duckduckgo.com/");
    }
    public void doSearch(String Keyword)
    {
        wait.until(visibilityOf(searchbar));
        searchbar.sendKeys(Keyword);
      //  LoggingUtils.log("I'm logging CSS");
        searchBtn.click();
    }
    public void goToVideos()
    {
        //wait.until((d) -> videosLink.isDisplayed());
        wait.until(visibilityOf(videosLink));
        videosLink.click();
    }

    public int printResult()
    {
        By by = By.className("tile--vid");
        wait.until(numberOfElementsToBeMoreThan(by,0));
        System.out.println("Number of Videos Displayed: " +allVideos.size());
        return allVideos.size();
    }
}
