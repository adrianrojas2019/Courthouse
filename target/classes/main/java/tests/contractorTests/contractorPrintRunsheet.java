package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
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
public class contractorPrintRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetName","environment","contractorUserName","contractorPassword"})
    @Test(groups = {"CH_Contractor_Print_Runsheet", "Regression","Contractor_Test"})

    /* This method prints one document (open it using the PDV Viewer) for the specified contractor
     *@params contractor username/password, county and grantor values for the specified contractor.
    */
    public void contractorPrintRunsheet(String runsheetName,String environment, String contractorUserName, String contractorPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        //Be sure that current contractor account PDF Viewer is the default Embedded
        newExplorerPage.clickOnUserMenu();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newExplorerPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on My Account item
        newExplorerPage.clickOnMyAccountItem();
        //Validate that Test Contract Page has been loaded
        Assert.assertTrue(newExplorerPage.isMyAccountDisplayed(10), "Cannot display My Account Page");
        //Go to My Account and change current PDF Viewer option
        String pdfViewer = newExplorerPage.changePDFViewer();
        //click on Update info button
        if (pdfViewer.equals("Standalone")) {
            newExplorerPage.clickOnUpdateInfoButton();
            //Assert on success msg
            Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("User has been successfully edited."), "The change PDF Viewer could not be modified.");
        }
        //click on Home menu
        newExplorerPage.clickOnHomeButton();

        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+"Renamed");

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");

        //Click on first row (viewer link in order to open pdf document)
        newExplorerPage.clickOnViewerPDFButton();
        //Make sure that pdf document has been opened
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
        //Click on Print button
        newExplorerPage.clickOnPrintButton();
        //Get Total of Downloads
        int ntotalPrints = NumberUtils.toInt(newExplorerPage.getTotalPrints()) + 1;
        //Click on OK button proceed to download the documents
        newExplorerPage.clickOnOKButton();
        //before we will need to move to previous tab because PDF external app has been opened
        newExplorerPage.changeTab();
        //Click again on Print button
        newExplorerPage.clickOnPrintButton();
        //Assert.assertEquals in order to verify that download has been increased
        Assert.assertEquals(ntotalPrints , NumberUtils.toInt(newExplorerPage.getTotalPrints()),"Total of Prints have not been increased.");
    }
}
