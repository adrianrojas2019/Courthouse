package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 11/28/2018.
 */
public class bulksActionsRunsheetSharingMessage extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyAcctPayGo","companyIDPayGo"})
    @Test(groups = {"CH_Admin_BulksAction_Runsheet_Sharing_Message", "Regression","Company_Management"})
/**
 * This test script validates the issue CH-1164
 * */
    public void bulksActionsRunsheetSharingMessage(String environment, String usernameToLogIn, String passwordToLogIn, String companyAcctPayGo, String companyIDPayGo) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        BulksActions(newCHMainPage.LoginMenu(),companyAcctPayGo,companyIDPayGo);
    }

    public void BulksActions(UserAdministrationPage newAdministrationPage, String companyAcct, String companyID){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        newAdministrationPage.clickOnUserAdministrationItem();
        //Click on Add Bulk Actions button
        newAdministrationPage.clickOnBulkActionsButton();
        //Validate that Company Acct: Dialog has been loaded
        Assert.assertTrue(newAdministrationPage.isCompanyAcctPopUpDialogDisplayed(), "Cannot open Company Acct: Pop Up Dialog.");
        newAdministrationPage.selectCompanyAcct(companyID);
        Assert.assertTrue(newAdministrationPage.isCompanyAcctNameDisplayed()," cannot display Company Acct. Name.");
        //Click on Company Acct. Name
        newAdministrationPage.clickOnCompanyAcctName();
       //Select the two first rows

        for(int numberOfRows=1; numberOfRows <= 2; numberOfRows++) {

            newAdministrationPage.clickOnRow(numberOfRows);
        }
        //Make sure new msg is displayed
        Assert.assertTrue(newAdministrationPage.isRunsheetSharingMessageDisplayed(),"Wrong Runsheet Sharing Message Displayed.");
    }
}
