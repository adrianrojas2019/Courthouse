package main.java.tests.contractorTests;

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
public class contractorMidlandMapShowCoverage extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword"})
    @Test(groups = {"CH_Contractor_Midland_Map_Show_Coverage", "Regression","Midland_Maps_Feature"})
    /**
     * This test script verifies that show coverage link is working for the Midland Map Feature
     * */

    public void contractorMidlandMapShowCoverage(String environment,String contractorUserName, String contractorPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());

        MidlandMapsPage newMidlandMapsPage = newExplorerPage.clickOnMidlandMapsSearch();
        Assert.assertTrue(newMidlandMapsPage.isMidlandMapTitleDisplayed(),"MIDLAND MAP TITLE has not been displayed.");

        //Click on Show coverage link
        newMidlandMapsPage.clickOnShowCoverageLink();

        Assert.assertTrue(newMidlandMapsPage.CountyLambHasBeenDisplayed(), "County Lamb has not been displayed.");
        Assert.assertTrue(newMidlandMapsPage.CountyYoakumHasBeenDisplayed(), "County Yoakum has not been displayed.");
        Assert.assertTrue(newMidlandMapsPage.CountyBordenHasBeenDisplayed(), "County Borden has not been displayed.");

        //Click on hide coverage link
        newMidlandMapsPage.clickOnHideCoverageLink();

    }
}
