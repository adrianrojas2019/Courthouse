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
public class unassignMidlandMapsCounty extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyAcct","companyID","countyMidlandMaps","countyType"})
    @Test(groups = {"CH_Admin_Unassign_Midland_Maps_County", "Regression","Midland_Maps_Feature"})

    public void unassignMidlandMapsCounty(String environment, String usernameToLogIn, String passwordToLogIn, String companyAcct, String companyID, String countyMidlandMaps,String countyType) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        UnassignMidlandMapsCounty(newCHMainPage.LoginMenu(),companyAcct,companyID,countyMidlandMaps,countyType);
    }

    public void UnassignMidlandMapsCounty(UserAdministrationPage newAdministrationPage, String companyAcct, String companyID,String countyMidlandMaps, String countyType){

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

        //Click on County Type Combo
        newAdministrationPage.clickOnCountyTypeCombo(countyType);
        Assert.assertTrue(newAdministrationPage.isCountyTypeSelected(countyType), "Cannot display County Type List.");

        //Select County
        newAdministrationPage.selectAssignedCounty(countyMidlandMaps);
        Assert.assertTrue(newAdministrationPage.isAssignedCountyDisplayed(countyMidlandMaps), "Cannot find County: " + countyMidlandMaps);

        //Proceed to assign the county
        newAdministrationPage.clickOnArrowLeft();
        Assert.assertTrue(newAdministrationPage.isCountyUnassigned(countyMidlandMaps), "County has not been Unassigned.");

        //Click on Save button
        newAdministrationPage.clickOnSaveButton();
        //Assert on success msg
        Assert.assertTrue(newAdministrationPage.isSuccessMessageDisplayed("The new changes have been successfully applied."), "The unassigned county could not be assigned.");
    }
}
