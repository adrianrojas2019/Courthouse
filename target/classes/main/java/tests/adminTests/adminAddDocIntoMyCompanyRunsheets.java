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
public class adminAddDocIntoMyCompanyRunsheets extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","adminCounty","adminGrantor","adminRunsheetName"})
    @Test(groups = {"CH_Admin_Doc_Into_Company_Runsheet", "Regression","Admin_Management"})
/**
 * This test script assign one specified county for the specified companyID
 * */
    public void adminAddDocIntoMyCompanyRunsheets(String environment, String usernameToLogIn, String passwordToLogIn, String adminCounty, String adminGrantor, String adminRunsheetName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        TryToAddDocIntoMyCompanyRunsheet(newCHMainPage.HomeButton(),adminCounty,adminGrantor,adminRunsheetName);
    }

    public void TryToAddDocIntoMyCompanyRunsheet(ExplorerPage newExplorerPage, String adminCounty, String adminGrantor, String adminRunsheetName){

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

        //Select adminRunsheet on My Company Runsheets
        newExplorerPage.clickOnMyCompanyRunsheetsCombo("My Company Runsheets");
        Assert.assertTrue(newExplorerPage.isMyCompanyRunsheetsDisplayed(),"My Company Runsheet Name Input has not been displayed.");
        newExplorerPage.clickOnRunsheetNameField(adminRunsheetName);

        //Proceed to add a new document
        newExplorerPage.doubleClickOnFirstRow();
        //Assert new pop up dialog will be open
        Assert.assertTrue(newExplorerPage.isRowDetailDialogDisplayed(), "Row Detail Dialog has not been displayed.");
        //Click on Add to runsheet button
        newExplorerPage.clickOnRowDetailAddToRunsheetButton();
        //Error Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("This action is not permitted for a Runsheet belonging to your Company. Please Make a copy of the Runsheet to be able to execute the action successfully."), "Error Message has not been displayed.");
    }
}
