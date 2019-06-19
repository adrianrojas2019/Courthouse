package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.LoginPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian on 11/28/2018.
 */
public class validateLimitReached extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyID","limitReachedCounty","contractorUserName","contractorPassword","contractorGrantor","LimitNewRunsheetName"})
    @Test(groups = {"CH_Admin_Max_Usage_Reached", "Regression","Company_Management"})
/**
 * This test script validates the correct info message (usage max reach progress bar) for one specified county. Abstract Plants.
 * */
    public void validateLimitReached(String environment, String usernameToLogIn, String passwordToLogIn, String companyID, String limitReachedCounty, String contractorUserName, String contractorPassword, String contractorGrantor,String LimitNewRunsheetName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        ValidatePrintsAndDownloads(newCHMainPage.LoginMenu(),environment,companyID,limitReachedCounty,contractorUserName,contractorPassword, contractorGrantor,LimitNewRunsheetName);
    }

    public void ValidatePrintsAndDownloads(UserAdministrationPage newAdministrationPage, String environment, String companyID,String limitReachedCounty, String contractorUserName, String contractorPassword, String contractorGrantor, String LimitNewRunsheet){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on Company Management item
        newAdministrationPage.clickOnCompanyManagement();
        //Validate that User Grid Company has been displayed
        Assert.assertTrue(newAdministrationPage.isUserGridCompanyDisplayed(), "Cannot access the User Grid Company.");
        //Click on Search Filter
        newAdministrationPage.clickOnSearchUser(companyID);
        //Validate that Company has been found
        Assert.assertEquals(companyID,newAdministrationPage.isCompanyDisplayed(), "Cannot find Company ID.");
        //Select row
        newAdministrationPage.clickOnCompanyRow();
        //Click on Usage Metrics tab
        newAdministrationPage.clickOnUsageMetricsTab();
        Assert.assertTrue(newAdministrationPage.isUserMetricsGridDisplayed(), "Cannot display user metrics View. (Select County for Details).");

        //Select County Abstract Plant
        newAdministrationPage.selectCounty(limitReachedCounty);
        Assert.assertTrue(newAdministrationPage.isCountyDisplayed(limitReachedCounty), "Cannot find County: " + limitReachedCounty);
        //get total Downloads Used
        int totalDownloadsUsed = Integer.parseInt(newAdministrationPage.getTotalDownloadsUsed());
        //get total Prints Used
        int totalPrintsUsed = Integer.parseInt(newAdministrationPage.getTotalPrintsUsed());

        //Assert validate that current County Abstract Plant has been reached the limit
        Assert.assertTrue(newAdministrationPage.isLimitReachedMessageDisplayed(), "Current County: " + limitReachedCounty + " has not reached the limit.");

        newAdministrationPage.clickOnBurgerMenu();
        newAdministrationPage.clickOnDownloadsAndPrintsAvailableCheckBox();
        newAdministrationPage.clickOnBurgerMenu();
        //Proceed to click on edit button in order to change or increase the current limit one more
        newAdministrationPage.clickOnChangeLimitButton();
        Assert.assertTrue(newAdministrationPage.isDownloadsPrintsDialogDisplayed(limitReachedCounty), "Edit Downloads/Prints Dialog has not been displayed.");
        //Proceed to change the current limit. Increase fixed number with more one
        newAdministrationPage.addNewLimitNumber(totalDownloadsUsed + totalPrintsUsed);
        //Toast Success Message
        Assert.assertTrue(newAdministrationPage.isSuccessMessageDisplayed("New usage limit has been successfully saved."), "The new limit has not been saved. For the County: " + limitReachedCounty);
        //Logout and proceed to validate that one contractor with access to limitReachedCounty is able to download/print only one document
        newAdministrationPage.clickOnBurgerMenu();
        newAdministrationPage.clickOnDownloadsAndPrintsAvailableCheckBox();
        newAdministrationPage.clickOnBurgerMenu();

        //Logout and log in using contractor and validate that current county message will be on demo only for the following 2 days
        LoginPage newLoginPage = Logout(newAdministrationPage.clickOnUserAdministrationPage());
        ExplorerPage newExplorerPage1 = ValidateCountyLimit(environment,contractorUserName, contractorPassword, newLoginPage);
        // Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage1.clickOnExplorerSearch();
        newExplorerPage1.isExploreTitleDisplayed();
        // Click on County Combo
        newExplorerPage1.clickOnCountyCombo(limitReachedCounty);
        // Validate that new usage progress bar has been displayed
        Assert.assertTrue(newExplorerPage1.isUsageProgressBarDisplayed(), "Usage Progress Bar has not been displayed.");
        //Click on Usage Progress Bar
        newExplorerPage1.clickOnUsageProgressBar();
        //Validate that Company Usage Dialog has been displayed as expected
        Assert.assertTrue(newExplorerPage1.isCompanyUsageDialogDisplayed(), "Company Usage Dialog has not been displayed.");

        Assert.assertEquals(Integer.toString(totalDownloadsUsed),newExplorerPage1.getTotalDownloads(), "Cannot match Totals Downloads: " + totalDownloadsUsed);
        Assert.assertEquals(Integer.toString(totalPrintsUsed),newExplorerPage1.getTotalPrints(), "Cannot match Totals Downloads: " + totalPrintsUsed);

        //Close the Company Usage Dialog
        newExplorerPage1.closeCompanyUsageDialog();

        //Perform a new Explore Search and download one runsheet
        PerformNewExplorerSearch(newExplorerPage1,limitReachedCounty,contractorGrantor,LimitNewRunsheet);

    }

    public void PerformNewExplorerSearch(ExplorerPage newExplorerPage1, String CountyName, String GrantorName, String LimitNewRunsheet){

        newExplorerPage1.isGrantorEnabled();
        newExplorerPage1.insertGrantor(GrantorName);
        newExplorerPage1.clickOnApplyButton();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage1.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        newExplorerPage1.clickOnFirstCheckBox();

        //Create a new Runsheet
        newExplorerPage1.clickOnNewRunsheetButton();
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage1.insertNewRunsheetName(LimitNewRunsheet+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        newExplorerPage1.clickOnSaveRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage1.isSuccessMessageDisplayed("Runsheet has been successfully saved."), "The new runsheet could not be added");
        //Proceed to add the previous selected documents into new runsheet
        newExplorerPage1.clickOnAddToRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage1.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document(s) could not be added into new runsheet");

        //Change the option to Index with images
        newExplorerPage1.changeToIndicesWithImages("Images");
        newExplorerPage1.clickOnDownloadAllButton();
        //Make sure that new Pop Up Dialog is being displayed at least that somebody pressed the check box
        //"Dont' show me this message again."
        Assert.assertTrue(newExplorerPage1.isDownloadsPrintsDialogDisplayed(), "Downloads & Prints Pop Up Dialog has not been displayed. (Pop Up Dialog)");
        //Get Total of Downloads
        //int ntotalDownloads = NumberUtils.toInt(newExplorerPage1.getTotalDownloads()) + 1;
        //Click on OK button proceed to download the documents
        newExplorerPage1.clickOnOKButton();
        //Click again on DownloadAllButton
        newExplorerPage1.clickOnDownloadAllButton();
        //Assert.assertEquals in order to verify that current county has reached the max of downloads/prints
        Assert.assertTrue(newExplorerPage1.isMaxUsageReachedMessageDisplayed(),"Max Usage Reached: Downlaods & Printing Suspended Message has not been displayed.");
    }

    public LoginPage Logout(UserAdministrationPage newUserAdminPage){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newUserAdminPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        LoginPage newLoginPage = newUserAdminPage.clickOnLogoutItem();
        //Validate that User has been logged out
        Assert.assertTrue(newLoginPage.isLoginStandardTitleDisplayed(), "Cannot access the Login Page.");
        return newLoginPage;
    }


    public ExplorerPage ValidateCountyLimit(String environment, String contractorUserName, String contractorPassword, LoginPage newLoginPage){

        newLoginPage.clickOnStandaloneSignInButton(environment);
        Assert.assertTrue(newLoginPage.isLoginStandaloneTitleDisplayed(), "Cannot access the StandAlone Page. Standalone Title not displayed");
        newLoginPage.with(contractorUserName, contractorPassword);
        newLoginPage.clickOnSignInButton();

        ExplorerPage newExplorerPage = newLoginPage.clickOnHomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");
        return newExplorerPage ;
    }
}
