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
public class contractorUnassignRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetUnAssigned","environment","contractorUserName","contractorPassword"})
    @Test(groups = {"CH_Contractor_Unassign_Runsheet", "Regression","Runsheet_Management_Test"})

    /* This method renames the new one runsheet for the specified contractor
     *@params contractor username/password, county and grantor values for the specified contractor.
    */
    public void contractorUnassignRunsheet(String runsheetName,String environment, String contractorUserName, String contractorPassword) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        //Find-Select previous created runsheet
        newExplorerPage.clickOnRunsheetList(runsheetName);

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");
        //Click on delete runsheet button
        newExplorerPage.clickOnDeleteRunsheetButton();
        //Assert.assertTrue(newExplorerPage.isDeleteRunsheetDialogDisplayed(),"Delete Runsheet pop up has not been displayed.");
        Assert.assertTrue(newExplorerPage.isUnassignRunsheetDialogDisplayed(),"Unassign Runsheet pop up has not been displayed.");
        //click on cancel button
        newExplorerPage.clickOnCancelButton();
        //Click on delete runsheet button
        newExplorerPage.clickOnDeleteRunsheetButton();
        //Assert.assertTrue(newExplorerPage.isDeleteRunsheetDialogDisplayed(),"Delete Runsheet pop up has not been displayed.");
        Assert.assertTrue(newExplorerPage.isUnassignRunsheetDialogDisplayed(),"Unassign Runsheet pop up has not been displayed.");
        //click on Delete button
        newExplorerPage.clickOnDeleteRunsheet();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully unassigned."), "The runsheet could not be deleted.");
        //Make sure that runsheet has been unassigned
        Assert.assertFalse(newExplorerPage.isUnassignRunsheetDisplayed(runsheetName),"Unassigned Runsheet still is appearing.");
    }
}
