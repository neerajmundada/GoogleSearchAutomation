package test.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import test.java.tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {
    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        // Test started
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Test passed
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        driver = ((BaseTest) testClass).getDriver(); // Access driver from BaseTest class
        String testName = result.getName();
        String screenshotPath = takeScreenshot(testName);
        // Log screenshot path to TestNG report
        Reporter.log("<br><b>Test Method Failed: </b>" + testName + "<br>");
        Reporter.log("<b>Screenshot:</b> <a href='" + screenshotPath + "' target='_blank'>Click to view</a><br>");
        Reporter.log("<img src='" + screenshotPath + "' height='200' width='300'/><br>");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Test skipped
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional
    }

    @Override
    public void onStart(ITestContext context) {
        // Before the test run starts
    }

    @Override
    public void onFinish(ITestContext context) {
        // After the test run finishes
    }


    private String takeScreenshot(String testName) {
        String screenshotPath = "";
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String relativePath = "screenshots/" + testName + "_" + timestamp + ".png";
            String absolutePath = System.getProperty("user.dir") + "/target/surefire-reports/" + relativePath;
            FileUtils.copyFile(screenshot, new File(absolutePath));
            return relativePath;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }

}
