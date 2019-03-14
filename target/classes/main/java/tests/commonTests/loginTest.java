package main.java.tests.commonTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.LoginPage;
import main.java.pageObjects.CHMainPage;
import main.java.selenium.SeleniumInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 11/28/2018.
 */
public class loginTest extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn"})
    @Test(groups = "CH_Confirmation")

    public CHMainPage loginSuccessfullyGalleryTest(String environment, String usernameToLogIn, String passwordToLogIn, WebDriver driver) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.waitForElementVisible(300), "Cannot login the Gallery Site");
        loginPage.with(usernameToLogIn, passwordToLogIn);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "Cannot access the Gallery site. Gallery Library Title not displayed");
        CHMainPage newCHMainPage = loginPage.clickOnCourthouseThumbnailButton();
        Assert.assertTrue(newCHMainPage.isCHMainPageDisplayed(), "Cannot access the User Administration Page. (User Grid)");
        return newCHMainPage;
    }

    public ExplorerPage loginSuccessfully(String usernameToLogIn, String passwordToLogIn, WebDriver driver) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.waitForElementVisible(300), "Cannot login the Gallery Site");
        loginPage.with(usernameToLogIn, passwordToLogIn);
        loginPage.clickOnSignInButton();
        Assert.assertTrue(loginPage.isLoginTitleDisplayed(), "Cannot access the Gallery site. Gallery Library Title not displayed");
        CHMainPage newCHMainPage = loginPage.clickOnCourthouseThumbnailButton();

        ExplorerPage newExplorerPage = newCHMainPage.HomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");
        return newExplorerPage ;
    }

    public ExplorerPage loginSuccessfullyTest(String environment,String usernameToLogIn, String passwordToLogIn, WebDriver driver) throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.waitForElementVisible(300), "Cannot login the Standard Login Page");
        loginPage.clickOnStandaloneSignInButton(environment);
        Assert.assertTrue(loginPage.isLoginStandaloneTitleDisplayed(), "Cannot access the StandAlone Page. Standalone Title not displayed");
        loginPage.with(usernameToLogIn, passwordToLogIn);
        loginPage.clickOnSignInButton();

        ExplorerPage newExplorerPage = loginPage.clickOnHomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");
        return newExplorerPage ;
    }

}
