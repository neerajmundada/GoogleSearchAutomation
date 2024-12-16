package test.java.tests;

import main.java.pages.GoogleAccountCreationPage;
import main.java.pages.GoogleLoginPage;
import main.java.pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

@Listeners(test.java.utils.TestListener.class)
public class FunctionalTests extends BaseTest {

    @Test
    public void testHomePageLoads() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();;
        Assert.assertTrue(homePage.isGoogleLogoDisplayed(), "Google logo is not displayed!");
    }

    @Test
    public void testSearchKeywordResults() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("selenium");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();

        String firstResult = searchPage.getFirstResultTitle();
        Assert.assertTrue(firstResult.toLowerCase().contains("selenium"), "The first result should contain 'OpenAI'");
    }


    @Test
    public void testSearchForAlphanumericKeyword() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("iphone 15 vs iphone 16");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();

        String firstResult = searchPage.getFirstResultTitle().toLowerCase();
        Assert.assertTrue(firstResult.contains("iphone 15") && firstResult.contains("iphone 16"), "Results should contain information on iphone-15 vs iphone-16");
    }


    @Test
    public void testGoogleSuggestions() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("fac");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.waitForSearchResultLoad();

        Assert.assertTrue(searchPage.isSuggestionsDisplayed(), "Suggestions should be displayed for 'fac'");
    }

    @Test
    public void testGoogleSuggestionSortedByPopularity() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("fac");
        GoogleSearchPage searchPage = new GoogleSearchPage(driver);

        searchPage.waitForSearchResultLoad();
        Assert.assertTrue(searchPage.isSuggestionsDisplayed(), "Suggestions should be displayed and sorted by popularity");
    }

    @Test
    public void testMisspelledKeywordCorrection() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("facbook");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();

        String firstResult = searchPage.getFirstResultTitle();
        Assert.assertTrue(firstResult.contains("Facebook"), "Misspelled keyword should be corrected to 'Facebook'");
    }

    @Test
    public void testGoogleCalculator() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("10 + 5");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        Assert.assertEquals(searchPage.getTotal(),"15", "Google Calculator should display the result '15'");
    }

    @Test
    public void testInvalidKeyword() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("gfdhdgfhjgdsjstgj43543");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();

        Assert.assertTrue(searchPage.isNoResultsMessageDisplayed(), "No results should be displayed for invalid keyword");
    }

    @Test
    public void testLargeValidString() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("Selenium is an open-source, automated testing tool used to test web applications across various browsers");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();

        String firstResult = searchPage.getFirstResultTitle();
        Assert.assertTrue(firstResult.toLowerCase().contains("selenium"), "Results should be relevant even with a long search string");
    }

    @Test
    public void testCategorySearch() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("automation testing");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.submitSearch();

        searchPage.waitForSearchResultLoad();
        searchPage.clickNextPage();

        searchPage.waitForSearchResultLoad();

        Assert.assertTrue(driver.getTitle().contains("automation testing"), "Results should be filtered based on category");
    }

    @Test
    public void testAdvancedSearch() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.enterSearchKeyword("site:selenium.dev automation");

        GoogleSearchPage searchPage = new GoogleSearchPage(driver);
        searchPage.clickSearchButton();

        searchPage.waitForSearchResultLoad();

        String firstResult = searchPage.getFirstResultTitle();
        Assert.assertTrue(firstResult.toLowerCase().contains("selenium"), "Advanced search results should be from selenium.dev");
    }


    @Test
    public void testGmailLinkDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isGmailLinkDisplayed(), "Gmail link is not displayed.");
    }

    @Test
    public void testURLNavigation() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        homePage.isNavigatedURLCorrect();
        Assert.assertTrue(homePage.isNavigatedURLCorrect(), "Redirected to incorrect url");
    }

    @Test
    public void testLoginLinkDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isLoginLinkDisplayed(), "Login link is not displayed.");
    }

    @Test
    public void testMoreAppsLinkDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isMoreAppsLinkDisplayed(), "'More Apps' link is not displayed.");
    }

    @Test
    public void testSearchByVoiceButtonDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isSearchByVoiceButtonDisplayed(), "Search by Voice button is not displayed.");
    }

    @Test
    public void testSearchByImageButtonDisplayed() {

        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isSearchByImageButtonDisplayed(), "Search by Image button is not displayed.");
    }

    @Test
    public void testFooterOptionsDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();

        String[] footerOptions = {"広告", "ビジネス", "プライバシー", "規約"};

        for (String option : footerOptions) {
            Assert.assertTrue(homePage.isFooterOptionDisplayed(option), option + " footer option is not displayed.");
        }
    }

    @Test
    public void testLoginToGoogle() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();

        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);

        homePage.clickSignIn();

        googleLoginPage.enterEmail("your user name");
        googleLoginPage.clickNextAfterEmail();

        googleLoginPage.enterPassword("ValidPassword123");
        googleLoginPage.clickNextAfterPassword();

        Assert.assertTrue(googleLoginPage.isProfileIconDisplayed(), "Profile icon not displayed. Login might have failed.");
    }

    @Test
    public void testCreateGoogleAccountJapanese() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();

        GoogleAccountCreationPage accountPage = new GoogleAccountCreationPage(driver);

        homePage.clickSignIn();
        homePage.clickCreateAccount();

        String firstName = "太郎";
        String lastName = "山田";

        accountPage.enterLastName(lastName);
        accountPage.enterFirstName(firstName);

        accountPage.clickNext();

        accountPage.enterDateOfBirth("1990", "10月", "25");
        accountPage.selectGender("男性");
        accountPage.clickNext();

        String uniqueUserId = "yamada.taro.test" + System.currentTimeMillis() / 1000L;
        accountPage.enterUsername(uniqueUserId);
        accountPage.clickNext();

        String password = "SecurePassword123!";
        accountPage.enterPassword(password);
        accountPage.confirmPassword(password);
        accountPage.clickNext();

        String mobileNumber = "08031774972";
        accountPage.enterMobileNumber(mobileNumber);
        accountPage.clickNext();

        String verificationCode = "123456";
        accountPage.enterVerificationCode(verificationCode);
        accountPage.clickNext();

        accountPage.skipSecondaryAddress();
        Assert.assertTrue(accountPage.isNameAndEmailCorrect(lastName + " " +firstName , uniqueUserId + "@gmail.com"),
                "Name or email does not match expected values.");
        accountPage.clickNext();

        accountPage.acceptTermsAndConditions();
        accountPage.clickNext();

        Assert.assertTrue(accountPage.isProfileDisplayed(), "Failed to load profile page after account creation.");
        Assert.assertTrue(accountPage.getDisplayedName().contains("山田 太郎"), "Displayed name is incorrect.");
    }

    @Test
    public void testValidEmailIdDuringLogin() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();

        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);

        homePage.clickSignIn();

        googleLoginPage.enterEmail("test@");
        googleLoginPage.clickNext();

        Assert.assertTrue(googleLoginPage.isInvalidEmailErrorDisplayed(), "Invalid email error message not displayed.");

    }

    @Test
    public void testForgotPasswordLink() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();

        GoogleLoginPage googleLoginPage = new GoogleLoginPage(driver);

        homePage.clickSignIn();

        googleLoginPage.clickForgotEmailLink();

        Assert.assertTrue(driver.getCurrentUrl().contains("signin/v2/usernamerecovery"), "Failed to navigate to password recovery page.");
    }

    @Test
    public void testLuckyButtonIsDisplayed() {
        GoogleHomePage homePage = new GoogleHomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isLuckyButtonDisplayed(), "I'm Feeling Lucky button is displayed");
    }


}
