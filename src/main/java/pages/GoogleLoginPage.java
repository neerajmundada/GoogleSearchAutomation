package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleLoginPage {
    WebDriver driver;

    By emailInputField = By.id("identifierId");
    By nextButton = By.xpath("//span[text()='次へ']");
    By invalidEmailError = By.xpath("//div[contains(text(), '有効なメールアドレスまたは電話番号を入力してください')]");
    By passwordInputField = By.name("password");
    By loginNextButton = By.xpath("//span[text()='次へ']");
    By profileIcon = By.xpath("//img[@class='gb_Da gbii']");
    By forgotEmailLink = By.xpath("//button[text()='メールアドレスを忘れた場合']");



    public GoogleLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        next.click();
    }

    public void clickForgotEmailLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement forgotEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(forgotEmailLink));
        forgotEmail.click();
    }

    public boolean isInvalidEmailErrorDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailError)).isDisplayed();
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickNextAfterEmail() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        next.click();
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickNextAfterPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(loginNextButton));
        next.click();
    }

    public boolean isProfileIconDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon)).isDisplayed();
    }
}
