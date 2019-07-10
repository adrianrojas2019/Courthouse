package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 11/28/2018.
 */
public class adminDeleteRunsheet extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","adminRunsheetName","adminCounty"})
    @Test(groups = {"CH_Admin_Delete_Runsheet", "Regression","Admin_Management"})
/**
 * This test script assign one specified county for the specified companyID
 * */
    public void adminDeleteRunsheet(String environment, String usernameToLogIn, String passwordToLogIn, String adminRunsheetName, String adminCounty) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        DeleteRunsheet(newCHMainPage.HomeButton(),adminRunsheetName, adminCounty);
    }

    public void DeleteRunsheet(ExplorerPage newExplorerPage, String adminRunsheetName, String adminCounty){

        //Find and select the runsheet
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(adminRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //click on runsheet grid for the first one document and then proceed to edit any cell in order to enable the report changes button
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");
        Assert.assertTrue(newExplorerPage.isRunsheetNameDisplayed("RUNSHEET: " + adminRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))),"Grid Title with the Runsheet Name has not been displayed.");

        //Click on delete runsheet button
        newExplorerPage.clickOnDeleteRunsheetButton();
        Assert.assertTrue(newExplorerPage.isDeleteRunsheetDialogDisplayed(),"Delete Runsheet pop up has not been displayed.");
        //click on cancel button
        newExplorerPage.clickOnCancelButton();
        //Click on delete runsheet button
        newExplorerPage.clickOnDeleteRunsheetButton();
        Assert.assertTrue(newExplorerPage.isDeleteRunsheetDialogDisplayed(),"Delete Runsheet pop up has not been displayed.");
        //click on Delete button
        newExplorerPage.clickOnDeleteRunsheet();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully deleted."), "The runsheet could not be deleted.");
    }
}
