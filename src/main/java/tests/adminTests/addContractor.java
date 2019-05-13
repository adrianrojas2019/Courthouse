package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.LoginPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 11/28/2018.
 */
public class addContractor extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","lastName","firstName","userName","companyAcct","myCompany","runsheetSharingAccess","emailUserName","numberOfUserToCreate"})
    @Test(groups = "CH_Add_Contractor")

    public void addContractor(String environment, String usernameToLogIn, String passwordToLogIn, String lastName, String firstName, String userName, String companyAcct, String myCompany,String runsheetSharingAccess, String emailUserName, int numberOfUserToCreate) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        AddContractor(newCHMainPage.LoginMenu(),lastName,firstName,userName,companyAcct,myCompany,runsheetSharingAccess,emailUserName,numberOfUserToCreate);
    }

    public void AddContractor(UserAdministrationPage newAdministrationPage, String lastName, String firstName, String userName, String companyAcct, String myCompany,String runsheetSharingAccess, String emailUserName, int numberOfUserToCreate ){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        newAdministrationPage.clickOnUserAdministrationItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newAdministrationPage.isUserAdminGridDisplayed(), "Cannot access the User Administration Grid.");

        for(int numberOfUser=1; numberOfUser <= numberOfUserToCreate; numberOfUser++) {
            //Click on Add Contractor button
            newAdministrationPage.clickOnAddContractorButton();
            //Validate that Contractor Page has been load
            Assert.assertTrue(newAdministrationPage.isContractPageDisplayed(), "Cannot access Contract Page.");
            //Add First&Last Name
            newAdministrationPage.insertName(lastName,firstName);
            newAdministrationPage.insertUserName(String.format(userName,numberOfUser));
            newAdministrationPage.insertCompanyInfo(companyAcct,myCompany);
            newAdministrationPage.insertRunsheetSharingAccess(runsheetSharingAccess);
            newAdministrationPage.insertEmailUserName(String.format(emailUserName,numberOfUser));
            newAdministrationPage.clickSaveButton();
            Assert.assertTrue(newAdministrationPage.isSuccessMessageDisplayed("User has been successfully saved."), "The new users could not be added");
            //Find and Select previous user on user grid
            newAdministrationPage.selectNewUserName(String.format(userName,numberOfUser));
            Assert.assertTrue(newAdministrationPage.isNewUserFound(String.format(userName,numberOfUser)), "The new user has not been found into grid");
        }
        //Assert.assertTrue(usersPage.isAllUserTitleDisplayed(), "The new users could not be added");
    }

}
