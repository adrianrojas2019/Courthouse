package main.java.tests.adminTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.RunsheetManagementPage;
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
public class superUserApproveRequestCopyRunsheet extends SeleniumInitializer {
    @Parameters({"superUserName","superUserPassword","myCompanyRunsheetName"})
    @Test(groups = {"CH_Super_User_Approve_Request_Copy_Runsheet", "Regression","Runsheet_Management"})
    /**
        * This test script Approves the previous one runsheet. New email will be sent to the contractor's email.
    * */
    public void superUserApproveRequestCopyRunsheet(String superUserName, String superUserPassword, String myCompanyRunsheetName) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        ApproveRequestCopyRunsheet(loginIntoCHMainPageTest.loginSuccessfully(superUserName,superUserPassword,getDriverInstance()),myCompanyRunsheetName);
    }

    public void ApproveRequestCopyRunsheet(ExplorerPage newExplorerPage, String myCompanyRunsheetName){

        //Make sure that 1 runsheet is pending to approve/deny
        Assert.assertNotEquals(0, NumberUtils.toInt(newExplorerPage.isPendingRunsheetRequest()), "Pending Runsheet Request value is not correct.");
        //call Runsheet Management item. Go to User Administration Page
        UserAdministrationPage newUserAdminPage = newExplorerPage.clickOnUserAdministrationPage();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newUserAdminPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        RunsheetManagementPage newRunsheetManagementPage = newUserAdminPage.clickOnRunsheetManagementItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newRunsheetManagementPage.isRunsheetManagementGridDisplayed(), "Cannot access the Runsheet Management Grid.");
        //Filter by Pending
        newRunsheetManagementPage.clickOnStatusCombo("0");
        //Find my Company Runsheet //select[@class='form-control ng-pristine ng-untouched ng-valid']
        Calendar now = Calendar.getInstance();
        //Notice at the end "(1) in order to find the second one super user runsheet
        newRunsheetManagementPage.findPendingRequest(myCompanyRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+"(1)");
        Assert.assertTrue(newRunsheetManagementPage.isRequestCopyActiionsDisplayed(), "Request Copy Actions has not been displayed.(Approve & Deny");
        //Deny it
        newRunsheetManagementPage.clickOnApproveButton();
        //Deny button has been selected
        Assert.assertTrue(newRunsheetManagementPage.isApproveButtonEnabled(), "Approve button has not been enabled.(Approve & Deny");
        //Click on Save button
        newRunsheetManagementPage.clickOnSaveButton();
        Assert.assertTrue(newRunsheetManagementPage.isMessageDisplayed(myCompanyRunsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+"(1)"), "Approve Runsheet Message has not been displayed.(Approve & Deny");
    }
}
