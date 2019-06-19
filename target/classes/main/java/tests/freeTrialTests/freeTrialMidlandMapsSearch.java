package main.java.tests.freeTrialTests;

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
public class freeTrialMidlandMapsSearch extends SeleniumInitializer {
    @Parameters({"environment","userNameFreeTrial","freeTrialPassword"})
    @Test(groups = {"CH_FreeTrial_Midland_Maps_Search", "Regression","Midland_Maps_Feature"})
    /**
     * This test script validates that as Free Trial user is not able to access the new one Midland Map feature
     * */

    public void freeTrialMidlandMapsSearch(String environment, String userNameFreeTrial, String freeTrialPassword) throws InterruptedException {


        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNameFreeTrial,1), freeTrialPassword, getDriverInstance());

        MidlandMapsPage newMidlandMapsPage = newExplorerPage.clickOnMidlandMapsSearch();
        Assert.assertTrue(newMidlandMapsPage.isSuccessMessageDisplayed("Ownership maps are only available to Courthouse subscribers. Contact Sales for more information."), "The current user:" + userNameFreeTrial + "should not be able to access this feature.");

    }
}
