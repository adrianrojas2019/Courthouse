package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.LoginPage;
import main.java.pageObjects.MidlandMapsPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorMidlandMapsSearch extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","searchMidlandMapsCountyName","searchMidlandMapsCountyYear"})
    @Test(groups = {"CH_Contractor_Midland_Maps_Search", "Regression","Midland_Maps_Feature"})

    public void contractorMidlandMapsSearch(String environment,String contractorUserName, String contractorPassword,String searchMidlandMapsCountyName, String searchMidlandMapsCountyYear) throws InterruptedException {


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

        //Make sure that image (pdf file) has beed loaded/displayed successfully
        //Wait until Progress Bar is gone
        newMidlandMapsPage.isProgressBarDone();
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newMidlandMapsPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");

        //Click on next map icon
        newMidlandMapsPage.clickOnNextMapIcon();
        //Make sure that warning message is being displayed
        Assert.assertTrue(newMidlandMapsPage.isNewWarningDisplayed(), "Add warning message for Midland Map viewing is not being displayed.");

        //Wait until Progress Bar is gone
        newMidlandMapsPage.isProgressBarDone();
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newMidlandMapsPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
    }
}
