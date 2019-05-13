package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.LoginPage;
import main.java.pageObjects.MidlandMapsPage;
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
public class contractorMidlandMapsAssign extends SeleniumInitializer {
    @Parameters({"environment","superUserName","superUserPassword","contractorUserName","contractorPassword","myCompanyName","countyMidlandMaps"})
    @Test(groups = {"CH_Contractor_Midland_Maps_Assign", "Regression","Midland_Maps_Feature"})

    public void contractorMidlandMapsAssign(String environment,String superUserName, String superUserPassword, String contractorUserName, String contractorPassword,String myCompanyName, String countyMidlandMaps) throws InterruptedException {


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
        //Add on Unassigned counties search text box: CountyMidland Map
        newUserAdminPage.addMidlandMapsCounty(countyMidlandMaps);
        newUserAdminPage.clickOnCountyMidlandMaps(countyMidlandMaps);
        Assert.assertTrue(newUserAdminPage.isUnassignedCountyDisplayed(countyMidlandMaps), "Cannot find County: " + countyMidlandMaps);

        //Proceed to assign the county
        newUserAdminPage.clickOnArrowRight();
        Assert.assertTrue(newUserAdminPage.isCountyAssigned(countyMidlandMaps), "County has not been assigned.");

        //click on Save button
        newUserAdminPage.clickOnSaveButton();
        //Success Message
        Assert.assertTrue(newUserAdminPage.isSuccessUserUpdatedDisplayed(),"The user modification could not be modified.");
        //Logout and log in using contract account
        LoginPage newLoginPage = Logout(newExplorerPage.clickOnUserAdministrationPage());
        MidlandMapsPage newMidlandMapsPage = ValidateContractAccess(environment,contractorUserName, contractorPassword, newLoginPage);

        //Make sure that current contract user is able to see the previous assigned midland maps county
        newMidlandMapsPage.clickOnCountyCombo(countyMidlandMaps);
        Assert.assertTrue(newMidlandMapsPage.isMidlandMapCountyDisplayed(countyMidlandMaps),"Midland Map County has not been displayed." + countyMidlandMaps);

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

    public MidlandMapsPage ValidateContractAccess(String environment, String contractorUserName, String contractorPassword, LoginPage newLoginPage){

        newLoginPage.clickOnStandaloneSignInButton(environment);
        Assert.assertTrue(newLoginPage.isLoginStandaloneTitleDisplayed(), "Cannot access the StandAlone Page. Standalone Title not displayed");
        newLoginPage.with(contractorUserName, contractorPassword);
        newLoginPage.clickOnSignInButton();

        ExplorerPage newExplorerPage = newLoginPage.clickOnHomeButton();
        Assert.assertTrue(newExplorerPage.isExplorerMainPageDisplayed(), "Cannot access the Home Administration Page. (Search Results)");

        MidlandMapsPage newMidlandMapsPage = newExplorerPage.clickOnMidlandMapsSearch();
        return newMidlandMapsPage;
    }
}
