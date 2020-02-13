package main.java.tests.adminTests;

import main.java.pageObjects.EmailAccountPage;
import main.java.pageObjects.ExplorerPage;
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
public class superUserReportIssue extends SeleniumInitializer {
    @Parameters({"superUserName","superUserPassword","emailURL","emailAddress","emailPassword"})
    @Test(groups = {"CH_Super_User_Report_Issue", "Regression","Runsheet_Management_Test"})
    /**
     * This test script Deny the previous one runsheet. New email will be sent to the contractor's email.
     * */
    public void superUserReportIssue(String superUserName, String superUserPassword,String emailURL,String emailAddress, String emailPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        ValidateEmail(ReportIssue(loginIntoCHMainPageTest.loginSuccessfully(superUserName,superUserPassword,getDriverInstance())),emailURL,emailAddress,emailPassword);
    }

    public void ValidateEmail(EmailAccountPage newEmailAccountPage,String emailURL,String emailAddress, String emailPassword){

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
        //Make sure outlook inbox has been loaded and then find the new email with new report issue has been generated as expected
        Assert.assertTrue(newEmailAccountPage.isNewReportIssueEmailReceived(),"Courthouse User is reporting an issue with a document has not been received");
        //Delete email
        newEmailAccountPage.clickOnReceivedReportIssueEmail();
        Assert.assertTrue(newEmailAccountPage.isEmailSelected("A Courthouse user is reporting an issue with a document."),"Email has not been selected.");
        //click on delete button
        newEmailAccountPage.clickOnDeleteButton();
        //Assert email has been deleted
        Assert.assertFalse(newEmailAccountPage.isNewReportIssueEmailReceived(),"Email has not been deleted.");
    }

    public EmailAccountPage ReportIssue(ExplorerPage newExplorerPage){

        newExplorerPage.clickOnReportIssueButton();
        //Make sure that Report Issue Dialog has been loaded
        Assert.assertTrue(newExplorerPage.isReportIssueDialogDisplayed(),"Report Issue Dialog was not displayed.");

        //Click on First element
        newExplorerPage.selectFirstCounty();
        newExplorerPage.addVolume();
        newExplorerPage.addPage();
        newExplorerPage.addInstrumentNumber();
        newExplorerPage.addBookType();
        newExplorerPage.addInstrumentType();
        newExplorerPage.selectIssueType();
        newExplorerPage.addNotes();

        //Click on Report Issue button
        newExplorerPage.clickOnOKButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document issue has been successfully reported.") ,"The report issue could not be send.");
        return newExplorerPage.clickOnEmailAccount();

    }
}
