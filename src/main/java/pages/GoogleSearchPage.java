package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchPage {
    WebDriver driver;
    final int GLOBAL_DELAY = 2000;

    By searchButton = By.xpath("(//input[@name='btnK'])[2]");
    By firstResult = By.xpath("(//h3)[1]");
    By paginationNext = By.id("pnnext");
    By noResultsMessage = By.id("botstuff");
    By suggestionsDropdown = By.xpath("//ul[@role='listbox']");
    By calculatorWidget = By.xpath("//span[@id='cwos']");
    By totalResultsCount = By.id("result-stats");
    By timeTaken = By.id("result-stats");



    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickSearchButton() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.click();
    }

    public void submitSearch() {
        WebElement searchBtn = driver.findElement(searchButton);
        searchBtn.sendKeys(Keys.ENTER);
    }

    public String getFirstResultTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstResult));

        WebElement firstResultTitle = driver.findElement(firstResult);
        return firstResultTitle.getText();
    }

    public void clickNextPage() {
        WebElement nextPage = driver.findElement(paginationNext);
        nextPage.click();
    }

    public boolean isNoResultsMessageDisplayed() {
        try {
            WebElement message = driver.findElement(noResultsMessage);
            return message.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTotal() {
        try {
            WebElement widget = driver.findElement(calculatorWidget);
            return widget.getText();
        } catch (Exception e) {
            return "";
        }
    }


    public String getTotalResultsCount() {
        WebElement resultStats = driver.findElement(totalResultsCount);
        return resultStats.getText();
    }

    public String getTimeTaken() {
        WebElement time = driver.findElement(timeTaken);
        return time.getText();
    }

    public boolean isSuggestionsDisplayed() {
        try {
            WebElement suggestions = driver.findElement(suggestionsDropdown);
            return suggestions.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitForSearchResultLoad()   {
        try {
            Thread.sleep(GLOBAL_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


