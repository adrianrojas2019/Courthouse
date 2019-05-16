package main.java.tests.payGoTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.MidlandMapsPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class payGoMidlandMapsSearch extends SeleniumInitializer {
    @Parameters({"environment","userNamePayGo","payGoPassword"})
    @Test(groups = {"CH_PayGo_Midland_Maps_Search", "Regression","Midland_Maps_Feature"})

    public void payGoMidlandMapsSearch(String environment, String userNamePayGo, String payGoPassword) throws InterruptedException {

//Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNamePayGo,1), payGoPassword, getDriverInstance());

        MidlandMapsPage newMidlandMapsPage = newExplorerPage.clickOnMidlandMapsSearch();
        Assert.assertTrue(newMidlandMapsPage.isSuccessMessageDisplayed("Ownership maps are only available to Courthouse subscribers. Contact Sales for more information."), "The current user:" + userNamePayGo + "should not be able to access this feature.");

    }
}
