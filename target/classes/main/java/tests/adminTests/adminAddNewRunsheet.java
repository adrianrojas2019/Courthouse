package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 11/28/2018.
 */
public class adminAddNewRunsheet extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","adminCounty","adminGrantor","adminRunsheetName"})
    @Test(groups = {"CH_Admin_New_Runsheet", "Regression","Admin_Management"})
/**
 * This test script assign one specified county for the specified companyID
 * */
    public void adminAddNewRunsheet(String environment, String usernameToLogIn, String passwordToLogIn, String adminCounty, String adminGrantor, String adminRunsheetName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        AddNewRunsheet(newCHMainPage.HomeButton(),adminCounty,adminGrantor,adminRunsheetName);
    }

    public void AddNewRunsheet(ExplorerPage newExplorerPage, String adminCounty, String adminGrantor, String adminRunsheetName){

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(adminCounty);
        newExplorerPage.isGrantorEnabled();
        newExplorerPage.insertGrantor(adminGrantor);
        newExplorerPage.clickOnApplyButton();
        newExplorerPage.WaitUntilSpinnerEnds();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");

        //Create a new Runsheet
        newExplorerPage.clickOnNewRunsheetButton();
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage.insertNewRunsheetName(adminRunsheetName + (now.get(Calendar.MONTH) + 1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        newExplorerPage.clickOnSaveRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully saved."), "The new runsheet could not be added");

        //Proceed to add a new document
        newExplorerPage.doubleClickOnFirstRow();
        //Assert new pop up dialog will be open
        Assert.assertTrue(newExplorerPage.isRowDetailDialogDisplayed(), "Row Detail Dialog has not been displayed.");
        //Click on cancel button
        newExplorerPage.clickOnCancelButton();
        //Proceed to add a new document
        newExplorerPage.doubleClickOnFirstRow();
        //Assert new pop up dialog will be open
        Assert.assertTrue(newExplorerPage.isRowDetailDialogDisplayed(), "Row Detail Dialog has not been displayed.");
        //Click on Add to runsheet button
        newExplorerPage.clickOnRowDetailAddToRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document could not be added into runsheet.");
    }
}
