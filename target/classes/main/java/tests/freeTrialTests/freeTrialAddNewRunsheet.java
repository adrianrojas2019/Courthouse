package main.java.tests.freeTrialTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class freeTrialAddNewRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetNameFreeTrial","environment","userNameFreeTrial","freeTrialPassword","freeTrialCounty","freeTrialGrantor"})
    @Test(groups = "CH_FreeTrial_Add_New_Runsheet")

    public void freeTrialAddNewRunsheet(String runsheetNameFreeTrial,String environment, String userNameFreeTrial, String freeTrialPassword, String freeTrialCounty, String freeTrialGrantor) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,String.format(userNameFreeTrial,1), freeTrialPassword, getDriverInstance());

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(freeTrialCounty);
        newExplorerPage.isGrantorEnabled();
        newExplorerPage.insertGrantor(freeTrialGrantor);
        newExplorerPage.clickOnApplyButton();
        //Purchase Confirmation Pop Up
        Assert.assertTrue(newExplorerPage.isPurchaseConfirmationDialogDisplayed(), "Purchase Confirmation Dialog has not been displayed.");
        //click on Ok button
        newExplorerPage.clickOnPurchaseConfirmationButton();

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        //Add at least 3 documents into a new Runsheet
        for (int numberOfDocs = 1; numberOfDocs <= 3; numberOfDocs++)
        {
            newExplorerPage.clickOnCheckBox(numberOfDocs);
        }

        //Create a new Runsheet
        newExplorerPage.clickOnNewRunsheetButton();
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage.insertNewRunsheetName(runsheetNameFreeTrial+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        newExplorerPage.clickOnSaveRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully saved."), "The new runsheet could not be added");
        //Proceed to add the previous selected documents into new runsheet
        newExplorerPage.clickOnAddToRunsheetButton();
        //Purchase Confirmation Pop Up
        Assert.assertTrue(newExplorerPage.isPurchaseConfirmationDialogDisplayed(), "Purchase Confirmation Dialog has not been displayed.");

        //Pop Up Purchase Confirmation Dialog
        //click on Ok button
        newExplorerPage.clickOnPurchaseConfirmationButton();

        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document(s) could not be added into new runsheet");

    }
}
