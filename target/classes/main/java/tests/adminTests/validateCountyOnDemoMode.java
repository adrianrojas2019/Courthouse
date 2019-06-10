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
public class validateCountyOnDemoMode extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyAcct","companyID","countyOnDemoMode","contractorUserName","contractorPassword","contractorName"})
    @Test(groups = {"CH_Admin_County_On_Demo_Mode", "Regression"})

    public void validateCountyOnDemoMode(String environment, String usernameToLogIn, String passwordToLogIn, String companyAcct, String companyID, String countyOnDemoMode, String contractorUserName, String contractorPassword, String contractorName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        ValidateCountyOnDemoMode(newCHMainPage.LoginMenu(),environment,companyAcct,companyID,countyOnDemoMode,contractorUserName,contractorPassword,contractorName);
    }

    public void ValidateCountyOnDemoMode(UserAdministrationPage newAdministrationPage, String environment, String companyAcct, String companyID,String countyOnDemoMode, String contractorUserName, String contractorPassword,String contractorName){

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
        newAdministrationPage.clickOnEditButton(countyOnDemoMode);
        Assert.assertTrue(newAdministrationPage.isEditExpirationDateDialogDisplayed(), "Cannot display Edit Expiration Date Dialog.");
        Assert.assertTrue(newAdministrationPage.isCountyNameDisplayed(countyOnDemoMode), "Cannot display County Name: " + countyOnDemoMode + " on the County Name Field. [Edit Expiration Date Dialog]");
        //Click on calendar icon
        //Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,2);
        //cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        //workaround to format mm dd yyyy when month or day is 1 digit
        newAdministrationPage.addNewExpirationDate((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR));
        //click on Save button
        newAdministrationPage.clickOnExpirationDateSaveButton();

        //Select the contractor and make sure that county on demo mode has been assigned to the contractor account
        AssignDemoCountyToContractor(newAdministrationPage, contractorUserName, countyOnDemoMode,contractorName);

        //Logout and log in using contractor and validate that current county message will be on demo only for the following 2 days
        LoginPage newLoginPage = Logout(newAdministrationPage.clickOnUserAdministrationPage());
        ExplorerPage newExplorerPage1 = ValidateCountyDemoMessage(environment,contractorUserName, contractorPassword, newLoginPage);
        // Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage1.clickOnExplorerSearch();
        newExplorerPage1.isExploreTitleDisplayed();
        // Click on County Combo
        newExplorerPage1.clickOnCountyCombo(countyOnDemoMode);
        // Validate county demo message"[CountyOnDemoMode] is in Demo mode for the next 3 days."
        Assert.assertTrue(newExplorerPage1.isDemoMessageDisplayed(countyOnDemoMode), "Demo message for County is not being displayed successfully." + countyOnDemoMode + " is in Demo mode for the next 3 days.");

    }
    public void AssignDemoCountyToContractor(UserAdministrationPage newAdministrationPage, String contractorUserName, String countyOnDemoMode,String contractorName){

        newAdministrationPage.clickOnUserAdministrationMenu();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on Company Management item
        newAdministrationPage.clickOnUserAdministrationItem();
        //Validate that User Grid Company has been displayed
        Assert.assertTrue(newAdministrationPage.isUserAdminGridDisplayed(), "Cannot access the User Administration Grid.");
        //Find contractor user
        newAdministrationPage.clickOnSearchUser(contractorUserName);
        //Validate that user has been found
        Assert.assertEquals(1, NumberUtils.toInt(newAdministrationPage.isUserFoundByAdmin()), "Cannot find the Contract User.");
        //Click on Contractor User Name
        newAdministrationPage.clickOnContractorName(contractorName);
        //Find the county on un-assign counties and proceed to assign and then save it
        //Proceed to assign the county

        if (newAdministrationPage.isUnassignedCountyDisplayed(countyOnDemoMode)){
            //Add on Unassigned counties search text box: CountyMidland Map

            newAdministrationPage.searchUnAssignedCounty(countyOnDemoMode);
            newAdministrationPage.clickOnUnassignedCounty(countyOnDemoMode);
            Assert.assertTrue(newAdministrationPage.isUnassignedCountyDisplayed(countyOnDemoMode), "Cannot find County: " + countyOnDemoMode);

            newAdministrationPage.clickOnArrowRight();
            Assert.assertTrue(newAdministrationPage.isCountyAssigned(countyOnDemoMode), "County has not been assigned.");

            //click on Save button
            newAdministrationPage.clickOnSaveButton();
            //Success Message
            Assert.assertTrue(newAdministrationPage.isSuccessUserUpdatedDisplayed(),"The user modification could not be modified.");
        }

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
