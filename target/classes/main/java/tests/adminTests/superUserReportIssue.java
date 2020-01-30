package main.java.tests.adminTests;

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
    @Parameters({"superUserName","superUserPassword"})
    @Test(groups = {"CH_Super_User_Report_Issue", "Regression","Runsheet_Management_Test"})
    /**
     * This test script Deny the previous one runsheet. New email will be sent to the contractor's email.
     * */
    public void superUserReportIssue(String superUserName, String superUserPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        ReportIssue(loginIntoCHMainPageTest.loginSuccessfully(superUserName,superUserPassword,getDriverInstance()));
    }

    public void ReportIssue(ExplorerPage newExplorerPage){

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


    }
}
