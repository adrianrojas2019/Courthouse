package main.java.tests.contractorTests;

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

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorRunsheetSharingRequestCopy extends SeleniumInitializer {
    @Parameters({"environment","superUserName","superUserPassword","contractorUserName","contractorPassword","myCompanyName","myCompanyRunsheetName"})
    @Test(groups = {"CH_Contractor_Request_Runsheet_Request_Copy", "Regression"})

    public void contractorRunsheetSharingRequestCopy(String environment,String superUserName, String superUserPassword, String contractorUserName, String contractorPassword,String myCompanyName, String myCompanyRunsheetName) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfully(superUserName, superUserPassword, getDriverInstance());

        //Go to User Administration Page
        UserAdministrationPage newUserAdminPage = newExplorerPage.clickOnUserAdministrationPage();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newUserAdminPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        newUserAdminPage.clickOnUserAdministrationItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newUserAdminPage.isUserAdminGridDisplayed(), "Cannot access the User Administration Grid.");

        //Find contractor user
        newUserAdminPage.clickOnSearchFieldAsSuperUser(contractorUserName);
        //Validate that user has been found
        Assert.assertEquals(1, NumberUtils.toInt(newUserAdminPage.isUserFound()), "Cannot find the Contract User.");
        //Click on Contractor User Name
        newUserAdminPage.clickOnContractorName(myCompanyName);
        //click on Runsheet Sharing Access Combo
        newUserAdminPage.clickOnRunsheetSharingAccess("Request Copy");
        //click on Save button
        newUserAdminPage.clickOnSaveButton();
        //Success Message
        Assert.assertTrue(newUserAdminPage.isSuccessUserUpdatedDisplayed(),"The user modification could not be modified.");
        //Logout and log in using contract account
        LoginPage newLoginPage = Logout(newExplorerPage.clickOnUserAdministrationPage());
        ExplorerPage newExplorerPage1 = ValidateContractAccess(environment,contractorUserName, contractorPassword, newLoginPage);
        //Make sure that according to current Runsheet Sharing Access the contract user account does not have access to: Today's Company Runsheet
        newExplorerPage1.clickOnMyCompanyRunsheetsCombo("My Company Runsheets");
        Assert.assertTrue(newExplorerPage1.isMyCompanyRunsheetsDisplayed(),"My Company Runsheet Name Input has not been displayed.");
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetNameField(myCompanyRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        //Runsheet is present and proceed to Request Copy
        //Assert.assertFalse(newExplorerPage.runsheetIsNotAvailable(),"Runsheet should not be available. Contractor does not have access to Runsheet Sharing Access");
        newExplorerPage.clickOnRequestCopyButton();
        Assert.assertTrue(newExplorerPage.isConfirmationAlertPopUpDialogDisplayed(),"Confirmation Alert Dialog is not present. (Request Copy)");
        //Click on Request a Copy button
        newExplorerPage.clickOnConfirmRequestCopyButton();
        //Assert on success msg
        Assert.assertTrue(newExplorerPage.isRequestCopyMessageDisplayed(myCompanyRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))),"Request Copy Runsheet Success Message has not been displayed. (Request Copy)");
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

    public ExplorerPage ValidateContractAccess(String environment, String contractorUserName, String contractorPassword, LoginPage newLoginPage){

        newLoginPage.clickOnStandaloneSignInButton(environment);
        Assert.assertTrue(newLoginPage.isLoginStandaloneTitleDisplayed(), "Cannot access the StandAlone Page. Standalone Title not displayed");
        newLoginPage.with(contractorUserName, contractorPassword);
        newLoginPage.clickOnSignInButton();

        ExplorerPage newExplorerPage = newLoginPage.clickOnHomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");
        return newExplorerPage ;
    }
}
