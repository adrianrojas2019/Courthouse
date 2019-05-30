package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian on 11/28/2018.
 */
public class bulksActionsCancelChangeCompany extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyAcct","companyID"})
    @Test(groups = {"CH_Admin_BulksAction_Cancel_ChangeCompany", "Regression"})

    public void bulksActionsCancelChangeCompany(String environment, String usernameToLogIn, String passwordToLogIn, String companyAcct, String companyID) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        BulksActions(newCHMainPage.LoginMenu(),companyAcct,companyID);
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
        //Get the current Total Items: ##
        String totalItems;
        totalItems = newAdministrationPage.getTotalItems();
        //click on Change company button
        newAdministrationPage.clickOnChangeCompanyButton();
        //Validate that Company Acct: Dialog has been loaded
        Assert.assertTrue(newAdministrationPage.isCompanyAcctPopUpDialogDisplayed(), "Cannot open Company Acct: Pop Up Dialog.");
        //Click on Cancel Button
        newAdministrationPage.clickOnCancelButton();
        Assert.assertEquals(totalItems,newAdministrationPage.getTotalItems(), "Cannot match Total Items. (Users)");
        //Click on any Header Column filter issue 1164
        newAdministrationPage.clickOnNextPage();
        Assert.assertEquals(totalItems,newAdministrationPage.getTotalItems(), "Cannot match Total Items. (Users)");
    }
}
