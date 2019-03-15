package main.java.tests.payGoTests;

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
public class payGoCH1089 extends SeleniumInitializer {
    @Parameters({"runsheetNamePayGo", "environment", "userNamePayGo", "payGoPassword","payGoCounty","payGoGrantor"})
    @Test(groups = {"CH_PayGo_CH1089", "Regression"})

    public void payGoCH1089(String runsheetNamePayGo, String environment, String userNamePayGo, String payGoPassword, String payGoCounty, String payGoGrantor) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNamePayGo, 1), payGoPassword, getDriverInstance());

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(payGoCounty);
        newExplorerPage.isGrantorEnabled();
        newExplorerPage.insertGrantor(payGoGrantor);
        newExplorerPage.clickOnApplyButton();
        //Purchase Confirmation Pop Up
        Assert.assertTrue(newExplorerPage.isPurchaseConfirmationDialogDisplayed(), "Purchase Confirmation Dialog has not been displayed.");
        //click on Ok button
        newExplorerPage.clickOnPurchaseConfirmationButton();

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");

        //Click on first row (viewer link in order to open pdf document)
        newExplorerPage.clickOnViewerPDFButton();

        //Pop Up Purchase Confirmation Dialog
        //click on Ok button
        newExplorerPage.clickOnPurchaseConfirmationButton();

        //Make sure that pdf document has been opened
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
        //Close the tab
        //Assume that right now the pay go user has Embedded PDF Viewer as default
        //Close opened PDF
        newExplorerPage.closePDF("Embedded");
        //Validate the new one "don't show again check box" "You have not added this document to a Runsheet. If you add it later you could be charged again for the first page."
        Assert.assertTrue(newExplorerPage.isDoNotShowAgainDialogAvailable(), "Don't show again Check box missing.");
    }
}
