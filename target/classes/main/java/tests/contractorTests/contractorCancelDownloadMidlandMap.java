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
public class contractorCancelDownloadMidlandMap extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","searchMidlandMapsCountyName","searchMidlandMapsCountyYear"})
    @Test(groups = {"CH_Contractor_Cancel_Download_Midland_Map", "Regression","Midland_Maps_Feature"})
    /**
     * This test script validates that as cancel download map button is working
     * */

    public void contractorCancelDownloadMidlandMap(String environment,String contractorUserName, String contractorPassword,String searchMidlandMapsCountyName, String searchMidlandMapsCountyYear) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());

        MidlandMapsPage newMidlandMapsPage = newExplorerPage.clickOnMidlandMapsSearch();


        //Make sure that current contract user is able to see the previous assigned midland maps county
        newMidlandMapsPage.clickOnCountyCombo(searchMidlandMapsCountyName);
        Assert.assertTrue(newMidlandMapsPage.isMidlandMapCountyDisplayed(searchMidlandMapsCountyName), "Midland Map County has not been displayed." + searchMidlandMapsCountyName);

        //Make sure that current contract user is able to see the previous assigned midland maps county
        newMidlandMapsPage.clickOnYearCombo(searchMidlandMapsCountyYear);
        Assert.assertTrue(newMidlandMapsPage.isMidlandMapCountyYearDisplayed(searchMidlandMapsCountyYear), "Midland Map County Year has not been displayed." + searchMidlandMapsCountyName);

        //Click on Apply button
        newMidlandMapsPage.clickOnApplyButton();

        //Make sure that warning message is being displayed
        Assert.assertTrue(newMidlandMapsPage.isNewWarningDisplayed(), "Add warning message for Midland Map viewing is not being displayed.");

        //Click on Cancel button
        newMidlandMapsPage.clickOnCancelDownloadButton();
        //Make sure that document download has been cancelled
        Assert.assertTrue(newMidlandMapsPage.isSuccessMessageDisplayed("Document download cancelled."), "The document download cancelled message has not been displayed.");

    }
}
