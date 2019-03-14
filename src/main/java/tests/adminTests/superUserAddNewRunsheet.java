package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class superUserAddNewRunsheet extends SeleniumInitializer {
    @Parameters({"superUserName","superUserPassword","myCompanyRunsheetName","superUserCounty","contractorGrantor"})
    @Test(groups = "CH_Super_User_Create_New_Runsheet")

    public void superUserAddNewRunsheet(String superUserName, String superUserPassword, String myCompanyRunsheetName,String superUserCounty, String contractorGrantor) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        AddNewRunsheet(loginIntoCHMainPageTest.loginSuccessfully(superUserName,superUserPassword,getDriverInstance()),myCompanyRunsheetName,superUserCounty,contractorGrantor);
    }

    public void AddNewRunsheet(ExplorerPage newExplorerPage, String myCompanyRunsheetName,String superAdminCounty, String contractorGrantor){

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(superAdminCounty);
        newExplorerPage.isGrantorEnabled();
        newExplorerPage.insertGrantor(contractorGrantor);
        newExplorerPage.clickOnApplyButton();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        //Add at least 3 documents into a new Runsheet
        for (int numberOfDocs = 1; numberOfDocs <= 3; numberOfDocs++) {
            newExplorerPage.clickOnCheckBox(numberOfDocs);
        }
        //Create two new runsheet in order to approve and deny them

        //Create a new Runsheet
        newExplorerPage.clickOnNewRunsheetButton();
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage.insertNewRunsheetName(myCompanyRunsheetName + (now.get(Calendar.MONTH) + 1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        newExplorerPage.clickOnSaveRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully saved."), "The new runsheet could not be added");
        //Proceed to add the previous selected documents into new runsheet
        newExplorerPage.clickOnAddToRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document(s) could not be added into new runsheet");
    }
}
