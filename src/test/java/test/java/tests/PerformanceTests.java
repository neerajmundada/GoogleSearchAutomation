package test.java.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(test.java.utils.TestListener.class)
public class PerformanceTests extends BaseTest{

    @Test
    public void testPageLoadTime() {
        long startTime = System.currentTimeMillis();
        pages.GoogleHomePage homePage = new pages.GoogleHomePage(driver);
        homePage.open();
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        Assert.assertTrue(responseTime < 4000, "Search response time exceeded 4 seconds");
    }

}
