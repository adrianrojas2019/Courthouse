package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.LoginPage;
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
public class modifyUsageMetrics extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyID","usageMetricsCounty"})
    @Test(groups = {"CH_Admin_Modify_Usage_Metrics", "Regression","Company_Management"})
/**
 * This test script validates the correct info message (usage max reach progress bar) for one specified county. Abstract Plants.
 * */
    public void modifyUsageMetrics(String environment, String usernameToLogIn, String passwordToLogIn, String companyID, String usageMetricsCounty) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        ModifyUsageMetrics(newCHMainPage.LoginMenu(),environment,companyID,usageMetricsCounty);
    }

    public void ModifyUsageMetrics(UserAdministrationPage newAdministrationPage, String environment, String companyID,String usageMetricsCounty){

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
        newAdministrationPage.selectCounty(usageMetricsCounty);
        Assert.assertTrue(newAdministrationPage.isCountyDisplayed(usageMetricsCounty), "Cannot find County: " + usageMetricsCounty);

        //get total Usage Limit
        String totalUsageLimit = newAdministrationPage.getUsageLimit();

        newAdministrationPage.clickOnBurgerMenu();
        newAdministrationPage.clickOnDownloadsAndPrintsAvailableCheckBox();
        newAdministrationPage.clickOnBurgerMenu();
        //Proceed to click on edit button in order to change or increase the current limit one more
        newAdministrationPage.clickOnChangeLimitButton();
        Assert.assertTrue(newAdministrationPage.isDownloadsPrintsDialogDisplayed(usageMetricsCounty), "Edit Downloads/Prints Dialog has not been displayed.");

        //Click on Fixed Number check box
        //newAdministrationPage.clickOnFixedNumber();
        //Proceed to change the current limit. Increase fixed number with more one
        newAdministrationPage.increaseLimitNumber(totalUsageLimit);
        //Toast Success Message
        Assert.assertTrue(newAdministrationPage.isSuccessMessageDisplayed("New usage limit has been successfully saved."), "The new limit has not been saved. For the County: " + usageMetricsCounty);
        newAdministrationPage.clickOnBurgerMenu();
        newAdministrationPage.clickOnDownloadsAndPrintsAvailableCheckBox();
        newAdministrationPage.clickOnBurgerMenu();
    }

}
