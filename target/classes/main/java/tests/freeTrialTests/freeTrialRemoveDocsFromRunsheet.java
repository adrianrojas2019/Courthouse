package main.java.tests.freeTrialTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class freeTrialRemoveDocsFromRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetNameFreeTrial","environment","userNameFreeTrial","freeTrialPassword"})
    @Test(groups = {"CH_FreeTrial_Del_Docs_From_Runsheet", "Regression"})

    public void freeTrialRemoveDocsFromRunsheet(String runsheetNameFreeTrial,String environment, String userNameFreeTrial, String freeTrialPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNameFreeTrial,1) , freeTrialPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetNameFreeTrial+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        newExplorerPage.clickOnFirstCheckBox();

        //Click on Remove button
        newExplorerPage.clickOnRemoveButton();
        //Wait until Remove Pop up Dialog is displayed
        Assert.assertTrue(newExplorerPage.isRemovePopUpDialogDisplayed(), "Remove Pop Up Dialog was not displayed.(1)");
        //Click on Remove button
        newExplorerPage.clickOnRemoveFreeTrialPopUpButton();

        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document has been successfully removed from the runsheet."), "The new runsheet could not be added");

        //Remove another one document using the 'x' remove column option
        newExplorerPage.clickOnFirstRemoveColumn();
        //Wait until Remove Pop up Dialog is displayed
        Assert.assertTrue(newExplorerPage.isRemovePopUpDialogDisplayed(), "Remove Pop Up Dialog was not displayed.(2)");
        //Click on Remove button
        newExplorerPage.clickOnRemoveFreeTrialPopUpButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document has been successfully removed from the runsheet."), "The new runsheet could not be added");

    }
}
