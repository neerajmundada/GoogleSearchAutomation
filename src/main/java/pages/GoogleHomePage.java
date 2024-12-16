package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleHomePage {
    WebDriver driver;
    final  String url = "https://www.google.com/";  //For assignment added here, good practice is to read it from config/env files

    By searchTextBox = By.name("q");
    By googleLogo = By.xpath("//img[@alt='Google']");
    By luckyButton = By.xpath(" //input[@id='gbqfbb' ]");
    By gmail = By.linkText("Gmail");
    By loginLnk = By.linkText("ログイン");
    By createAccountLink = By.xpath("//button/span[text()='アカウントを作成']");
    By personalAccountType = By.xpath("//li/span[text()='個人で使用']");
    By moreLink = By.id("gbwa");
    By imageSearch = By.xpath("//div[@aria-label='画像で検索']");
    By voiceSearch = By.xpath("//div[@aria-label='音声で検索']");


    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isGoogleLogoDisplayed() {
        return driver.findElement(googleLogo).isDisplayed();
    }

    public void open() {
        driver.get(url);
    }

    public void enterSearchKeyword(String keyword) {
        WebElement searchBox = driver.findElement(searchTextBox);
        searchBox.sendKeys(keyword);
    }

    public boolean isGmailLinkDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement gmailLink = wait.until(ExpectedConditions.visibilityOfElementLocated(gmail));
        return gmailLink.isDisplayed();
    }

    public boolean isLoginLinkDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLnk));
        return loginLink.isDisplayed();
    }

    public boolean isMoreAppsLinkDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement moreAppsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(moreLink));
        return moreAppsLink.isDisplayed();
    }

    public boolean isSearchByVoiceButtonDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement voiceSearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(voiceSearch));
        return voiceSearchButton.isDisplayed();
    }

    public boolean isSearchByImageButtonDisplayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement imageSearchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(imageSearch));
        return imageSearchButton.isDisplayed();
    }

    public boolean isFooterOptionDisplayed(String footerOptionText) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement footerOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(footerOptionText)));
        return footerOption.isDisplayed();
    }

    public boolean isNavigatedURLCorrect() {
        return driver.getCurrentUrl().equals(url);
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginLnk));
        signIn.click();
    }

    public void clickCreateAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(createAccountLink));
        createAccount.click();

        WebElement personalAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(personalAccountType));
        personalAccount.click();
    }

    public boolean isLuckyButtonDisplayed() {
        try {
            return driver.findElement(luckyButton).isDisplayed();
        }catch(Exception e){
            e.printStackTrace();
            return  false;
        }

    }
}
