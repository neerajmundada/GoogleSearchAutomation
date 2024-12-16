package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleAccountCreationPage {
    WebDriver driver;

    public GoogleAccountCreationPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By usernameField = By.name("Username");
    By passwordField = By.xpath("//input[@name='Passwd']");
    By confirmPasswordField = By.xpath("//input[@name='PasswdAgain']");
    By nextButton = By.xpath("//span[text()='次へ']");
    By mobileNumberField = By.id("phoneNumberId");
    By verificationCodeField = By.name("code");
    By yearField = By.id("year");
    By monthDropdown = By.id("month");
    By dayField = By.id("day");
    By genderDropdown = By.id("gender");
    By skipSecondaryAddressButton = By.xpath("//button[text()='スキップ']");
    By nameConfirmationText = By.xpath("//span[contains(@text, '名前')]");
    By emailConfirmationText = By.xpath("//span[contains(@text, '@gmail.com')]");
    By agreeCheckbox = By.xpath("//input[@type='checkbox']");
    By profileName = By.xpath("//div[contains(@class, 'profile-name')]");
    By profileHeader = By.xpath("//h1[text()='プロフィール']");


    // Actions
    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameElement.clear();
        firstNameElement.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameElement.clear();
        lastNameElement.sendKeys(lastName);
    }

    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void confirmPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmPasswordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
        confirmPasswordElement.clear();
        confirmPasswordElement.sendKeys(password);
    }

    public void enterMobileNumber(String mobileNumber) {
        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
    }

    public void enterVerificationCode(String code) {
        driver.findElement(verificationCodeField).sendKeys(code);
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement next = wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        next.click();
    }

    public void enterDateOfBirth(String year, String month, String day) {
        driver.findElement(yearField).sendKeys(year);
        new Select(driver.findElement(monthDropdown)).selectByVisibleText(month);
        driver.findElement(dayField).sendKeys(day);
    }

    public void selectGender(String gender) {
        new Select(driver.findElement(genderDropdown)).selectByVisibleText(gender);
    }


    public void skipSecondaryAddress() {
        driver.findElement(skipSecondaryAddressButton).click();
    }

    public boolean isNameAndEmailCorrect(String name, String email) {
        String displayedName = driver.findElement(nameConfirmationText).getText();
        String displayedEmail = driver.findElement(emailConfirmationText).getText();
        return displayedName.equals(name) && displayedEmail.equals(email);
    }

    public void acceptTermsAndConditions() {
        driver.findElement(agreeCheckbox).click();
    }

    public boolean isProfileDisplayed() {
        return driver.findElement(profileHeader).isDisplayed();
    }

    public String getDisplayedName() {
        return driver.findElement(profileName).getText();
    }
}
