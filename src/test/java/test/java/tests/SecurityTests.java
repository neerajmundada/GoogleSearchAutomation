package test.java.tests;

import main.java.pages.GoogleSearchPage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import test.java.tests.*;

import java.time.Duration;

@Listeners(test.java.utils.TestListener.class)
public class SecurityTests extends BaseTest {



    @Test
    public void testXSSAttack() {
        String xssPayload = "<script>alert('XSS')</script>";
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword(xssPayload);
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);

        searchPage.submitSearch();
        searchPage.waitForSearchResultLoad();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Assert.assertTrue(false,"XSS vulnerability detected!");
        } catch (TimeoutException e) {
            Assert.assertTrue(true);
        }

    }

}
