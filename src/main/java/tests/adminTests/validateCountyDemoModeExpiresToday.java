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
public class validateCountyDemoModeExpiresToday extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyID","countyOnDemoMode","contractorUserName","contractorPassword"})
    @Test(groups = {"CH_Admin_County_Mode_Expires_Today", "Regression","Company_Management"})

    public void validateCountyDemoModeExpiresToday(String environment, String usernameToLogIn, String passwordToLogIn, String companyID, String countyOnDemoMode, String contractorUserName, String contractorPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        ValidateCountyDemoModeExpiresToday(newCHMainPage.LoginMenu(),environment,companyID,countyOnDemoMode,contractorUserName,contractorPassword);
    }

    public void ValidateCountyDemoModeExpiresToday(UserAdministrationPage newAdministrationPage, String environment, String companyID,String countyOnDemoMode, String contractorUserName, String contractorPassword){

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
        //Click on Demo Management tab
        newAdministrationPage.clickOnDemoManagementTab();
        Assert.assertTrue(newAdministrationPage.isUserDemoManamentGridDisplayed(), "Cannot display Demo Management View. (Select County for Details).");
        //Select County
        newAdministrationPage.selectCounty(countyOnDemoMode);
        Assert.assertTrue(newAdministrationPage.isCountyDisplayed(countyOnDemoMode), "Cannot find County: " + countyOnDemoMode);
        //Edit Expiration Date: current date + 2 days
        newAdministrationPage.clickOnEditButton();
        Assert.assertTrue(newAdministrationPage.isEditExpirationDateDialogDisplayed(), "Cannot display Edit Expiration Date Dialog.");
        Assert.assertTrue(newAdministrationPage.isCountyNameDisplayed(countyOnDemoMode), "Cannot display County Name: " + countyOnDemoMode + " on the County Name Field. [Edit Expiration Date Dialog]");
        //Click on calendar icon
        //Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,0);

        //cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        //workaround to format mm dd yyyy when month or day is 1 digit
        newAdministrationPage.addNewExpirationDate((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR));
        //click on Save button
        newAdministrationPage.clickOnExpirationDateSaveButton();

        //Logout and log in using contractor and validate that current county message will be on demo only for TODAY
        LoginPage newLoginPage = Logout(newAdministrationPage.clickOnUserAdministrationPage());
        ExplorerPage newExplorerPage1 = ValidateCountyDemoMessage(environment,contractorUserName, contractorPassword, newLoginPage);
        // Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage1.clickOnExplorerSearch();
        newExplorerPage1.isExploreTitleDisplayed();
        // Click on County Combo
        newExplorerPage1.clickOnCountyCombo(countyOnDemoMode);
        // Validate county demo message"[CountyOnDemoMode] expires today."
        Assert.assertTrue(newExplorerPage1.isDemoExpiresTodayMessageDisplayed(countyOnDemoMode), "Your Demo of " + countyOnDemoMode + " expires today message is not being displayed.");
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


    public ExplorerPage ValidateCountyDemoMessage(String environment, String contractorUserName, String contractorPassword, LoginPage newLoginPage){

        newLoginPage.clickOnStandaloneSignInButton(environment);
        Assert.assertTrue(newLoginPage.isLoginStandaloneTitleDisplayed(), "Cannot access the StandAlone Page. Standalone Title not displayed");
        newLoginPage.with(contractorUserName, contractorPassword);
        newLoginPage.clickOnSignInButton();

        ExplorerPage newExplorerPage = newLoginPage.clickOnHomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");
        return newExplorerPage ;
    }

}
