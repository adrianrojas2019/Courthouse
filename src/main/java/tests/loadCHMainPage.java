package main.java.tests;

import main.java.pageObjects.CHMainPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 11/28/2018.
 */
public class loadCHMainPage extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn"})
    @Test(groups = {"CH_Login_Load_CH_Main_Page", "Regression"})
    public void loadCHMainPage(String environment, String usernameToLogIn, String passwordToLogIn) throws InterruptedException {

        //Login into Gallery
        loginTest loginIntoCHMainPageTest = new loginTest();
        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
    }
}
