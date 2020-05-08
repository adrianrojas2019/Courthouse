package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.EmailAccountPage;
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
public class adminReportChanges extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","adminRunsheetName","adminCounty","emailURL","emailAddress","emailPassword"})
    @Test(groups = {"CH_Admin_Report_Changes", "Regression","Admin_Management"})
/**
 * This test script assign one specified county for the specified companyID
 * */
    public void adminReportChanges(String environment, String usernameToLogIn, String passwordToLogIn,  String adminRunsheetName, String adminCounty,String emailURL,String emailAddress, String emailPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        ValidateEmail(ReportChanges(newCHMainPage.HomeButton(),adminRunsheetName, adminCounty),adminRunsheetName,emailURL,emailAddress,emailPassword);
    }

    public EmailAccountPage ReportChanges(ExplorerPage newExplorerPage, String adminRunsheetName, String adminCounty){

        //Find and select the runsheet
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(adminRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //click on runsheet grid for the first one document and then proceed to edit any cell in order to enable the report changes button
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");
        Assert.assertTrue(newExplorerPage.isRunsheetNameDisplayed("RUNSHEET: " + adminRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))),"Grid Title with the Runsheet Name has not been displayed.");
        //Click on Rename button
        //newExplorerPage.doubleClickOnFirstCell(adminCounty);

        //Get the value and edit it
        String cellValue = newExplorerPage.retrievesCellValue(adminCounty);
        cellValue = cellValue + "Gap Testing";

        newExplorerPage.editCell(cellValue,adminCounty);

        //Report Changes button will be enabled
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Cell value has been successfully edited."), "The cell changes have not been updated.");
        //click on it
        newExplorerPage.clickOnReportChargesButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Changes have been successfully reported."), "The new report changes message was not displayed.");
        return newExplorerPage.clickOnEmailAccount();
    }

    public void ValidateEmail(EmailAccountPage newEmailAccountPage, String adminRunsheetName, String emailURL, String emailAddress, String emailPassword){

        newEmailAccountPage.LoadNewURL(emailURL);
        Assert.assertTrue(newEmailAccountPage.isMailPageDisplayed(), "Outlook Main Page  has not been displayed.");
        //Click on Sign in button
        newEmailAccountPage.clickOnSignInButton();
        //Add email address
        //Make sure that pop up has been displayed
        Assert.assertTrue(newEmailAccountPage.isEmailAddressDialogDisplayed(),"Email Address Dialog was not displayed.");
        newEmailAccountPage.addEmailAddress(emailAddress);
        //Click on Next Button
        newEmailAccountPage.clickOnNextButton();

        //Make sure Enter Password Dialog has been displayed
        Assert.assertTrue(newEmailAccountPage.isEnterPasswordDialogDisplayed(),"Enter Password Dialog has not been displayed.");
        newEmailAccountPage.addEmailPassword(emailPassword);
        //Click on Sign in button
        newEmailAccountPage.clickOnNextButton();
        //Make sure outlook inbox has been loaded and then find the new email with new report changes has been generated as expected
        Assert.assertTrue(newEmailAccountPage.isNewReportChangeEmailReceived(),"DrillingInfo: Report Changes has not been received");
        //Delete email
        newEmailAccountPage.clickOnReceivedEmail();
        Calendar now = Calendar.getInstance();

        Assert.assertTrue(newEmailAccountPage.isEmailSelected("Runsheet " + adminRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+ " Report"),"Email has not been selected.");
        //click on delete button
        newEmailAccountPage.clickOnDeleteButton();
        //Assert email has been deleted
        Assert.assertFalse(newEmailAccountPage.isNewReportChangeEmailReceived(),"Email has not been deleted.");
    }

}
