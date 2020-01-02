package main.java.tests.adminTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.RunsheetManagementPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class superUserAssignRunsheet extends SeleniumInitializer {
    @Parameters({"superUserName","superUserPassword","runsheetUnAssigned","contractorUserName","contractorName"})
    @Test(groups = {"CH_Super_User_Assign_Runsheet", "Regression","Runsheet_Management_Test"})
    /**
     * This test script Deny the previous one runsheet. New email will be sent to the contractor's email.
     * */
    public void superUserAssignRunsheet(String superUserName, String superUserPassword, String runsheetName, String contractorUserName, String contractorName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        AssignRunsheet(loginIntoCHMainPageTest.loginSuccessfully(superUserName,superUserPassword,getDriverInstance()),runsheetName,contractorUserName,contractorName);
    }

    public void AssignRunsheet(ExplorerPage newExplorerPage, String runsheetName,String contractorUserName,String contractorName){

        //Go to User Administration Page
        UserAdministrationPage newUserAdminPage = newExplorerPage.clickOnUserAdministrationPage();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newUserAdminPage.isMenuUserDisplayed(10), "Cannot display the User Menu");

        //Click on User Administration item
        newUserAdminPage.clickOnUserAdministrationItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newUserAdminPage.isUserAdminGridDisplayed(), "Cannot access the User Grid.");
        //Find contractor user
        newUserAdminPage.clickOnSearchFieldAsContractor(contractorUserName);
        //Validate that user has been found
        Assert.assertEquals(1, NumberUtils.toInt(newUserAdminPage.isUserFound()), "Cannot find the Contract User.");
        //Click on Contractor User Name
        newUserAdminPage.clickOnContractorName(contractorName);
        //Under UnAssigned Runsheet find(previous runsheetUnAssigned), select and save changes
        newUserAdminPage.clickOnUnassignedRunsheetsField(runsheetName);
        //Assert
        Assert.assertTrue(newUserAdminPage.isUnassignedRunsheetDisplayed(runsheetName), "Cannot find RunsheetName: " + runsheetName);
        newUserAdminPage.clickOnUnassignedRunsheets(runsheetName);
        //Click on Arrow Rigth icon
        newUserAdminPage.clickOnArrowRight();
        //Click on Save button
        //click on Save button
        newUserAdminPage.clickOnSaveButton();
        //Success Message
        Assert.assertTrue(newUserAdminPage.isSuccessUserUpdatedDisplayed(),"The user modification could not be modified.");

    }
}
