package main.java.tests.contractorTests;

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
public class contractorRemoveDocsFromRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetName","environment","contractorUserName","contractorPassword","contractorCounty","contractorGrantor"})
    @Test(groups = {"CH_Contractor_Del_Docs_From_Runsheet", "Regression","Contractor_Test"})

    /* This method removes a couple docs from the already existing one runsheet for the specified contractor.
     *@params contractor username/password, county and grantor values for the specified contractor.
     */
    public void contractorRemoveDocsFromRunsheet(String runsheetName,String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorGrantor) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        newExplorerPage.clickOnFirstCheckBox();

        //Click on Remove button
        newExplorerPage.clickOnRemoveButton();
        //Wait until Remove Pop up Dialog is displayed
        Assert.assertTrue(newExplorerPage.isRemovePopUpDialogDisplayed(), "Remove Pop Up Dialog was not displayed.(1)");
        //Click on Remove button
        newExplorerPage.clickOnRemovePopUpButton();

        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document has been successfully removed from the runsheet."), "The new runsheet could not be added");

        //Remove another one document using the 'x' remove column option
        newExplorerPage.clickOnFirstRemoveColumn();
        //Wait until Remove Pop up Dialog is displayed
        Assert.assertTrue(newExplorerPage.isRemovePopUpDialogDisplayed(), "Remove Pop Up Dialog was not displayed.(2)");
        //Click on Remove button
        newExplorerPage.clickOnRemovePopUpButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document has been successfully removed from the runsheet."), "The new runsheet could not be added");

    }
}
