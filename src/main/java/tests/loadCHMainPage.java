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

    /* Make sure that the application is loading as expected
     *@params admin credentials
     */
    public void loadCHMainPage(String environment, String usernameToLogIn, String passwordToLogIn) throws InterruptedException {

        test = extent.createTest("CH_Login_Load_CH_Main_Page","Test loading Main Page");
        //Login into Gallery
        loginTest loginIntoCHMainPageTest = new loginTest();
        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
    }
}
