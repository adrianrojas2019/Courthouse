package main.java.tests.contractorTests;

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
public class contractorNotDownloadsPrintsCountyOnDemoMode extends SeleniumInitializer {
    @Parameters({"demoRunsheetName","environment","countyOnDemoMode","contractorUserName","contractorPassword","contractorGrantor"})
    @Test(groups = {"CH_Contractor_County_On_Demo_Mode", "Regression","Company_Management"})
/**
 * This test script validates that for one specified county on demo mode is not possible download/print docs
 * */
    public void contractorNotDownloadsPrintsCountyOnDemoMode(String demoRunsheetName,String environment, String countyOnDemoMode, String contractorUserName, String contractorPassword, String contractorGrantor) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,contractorUserName, contractorPassword, getDriverInstance());

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(countyOnDemoMode);
        newExplorerPage.isGrantorEnabled();
        newExplorerPage.insertGrantor(contractorGrantor);
        newExplorerPage.clickOnApplyButton();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
        newExplorerPage.clickOnFirstCheckBox();

        //Create a new Runsheet
        newExplorerPage.clickOnNewRunsheetButton();
        //Create Runsheet Name
        Calendar now = Calendar.getInstance();
        newExplorerPage.insertNewRunsheetName( demoRunsheetName +(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        newExplorerPage.clickOnSaveRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully saved."), "The new runsheet could not be added");
        //Proceed to add the previous selected documents into new runsheet
        newExplorerPage.clickOnAddToRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document(s) could not be added into new runsheet");

        //Change the option to Index with images
        newExplorerPage.changeToIndicesWithImages("Images");
        newExplorerPage.clickOnDownloadAllButton();
        Assert.assertTrue(newExplorerPage.isCountyOnDemoModeDialogDisplayed(countyOnDemoMode),"County: " + countyOnDemoMode + " is in Demo Mode Dialog has not been displayed.");
        //close the pop up dialog
        newExplorerPage.closePopUpDialog();
        //Validate that print option is not available for county on demo mode
        //Click on first row (viewer link in order to open pdf document)
        newExplorerPage.clickOnViewerPDFButton();
        //Make sure that pdf document has been opened
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");

        //Click on Print button
        newExplorerPage.clickOnPrintButton();
        //Click on OK button proceed to download the documents
        Assert.assertTrue(newExplorerPage.isCountyOnDemoModeDialogDisplayed(countyOnDemoMode),"County: " + countyOnDemoMode + " is in Demo Mode Dialog has not been displayed.");
        //close the pop up dialog
        newExplorerPage.closePopUpDialog();

    }

}
