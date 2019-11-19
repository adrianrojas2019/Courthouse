package main.java.tests.contractorTests;

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
public class contractorPDFViewer extends SeleniumInitializer {
    @Parameters({"runsheetName","environment","contractorUserName","contractorPassword","contractorCounty","contractorGrantor"})
    @Test(groups = {"CH_Contractor_PDF_Viewer", "Regression","Contractor_Test"})

    /* This method opens one document for the specified contractor first at all as stand alone and then as embedded PDF Viewer option.
     * @params contractor username/password values for the specified contractor.
    */
    public void contractorPDFViewer(String runsheetName,String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorGrantor) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        String pdfViewer ="";

        for(int count=1;count <=2;count++)
        {
            newExplorerPage.clickOnUserMenu();
            //Validate if the user menu has been selected/displayed
            Assert.assertTrue(newExplorerPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
            //Click on My Account item
            newExplorerPage.clickOnMyAccountItem();
            //Validate that Test Contract Page has been loaded
            Assert.assertTrue(newExplorerPage.isMyAccountDisplayed(10), "Cannot display My Account Page");
            //Go to My Account and change current PDF Viewer option
            pdfViewer = newExplorerPage.changePDFViewer();
            //click on Update info button
            newExplorerPage.clickOnUpdateInfoButton();
            //Assert Success messsage
            //Assert on success msg
            //Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("User has been successfully edited."), "The change PDF Viewer could not be modified.");
            //click on Home icon
            newExplorerPage.clickOnHomeButton();
            //Click on the Magnifying Glass icon on the left side of the Homepage.
            newExplorerPage.clickOnExplorerSearch();
            newExplorerPage.isExploreTitleDisplayed();
            //Click on County Combo
            newExplorerPage.clickOnCountyCombo(contractorCounty);
            newExplorerPage.isGrantorEnabled();
            newExplorerPage.insertGrantor(contractorGrantor);
            newExplorerPage.clickOnApplyButton();
            //Wait until Search Results retrieves documents
            Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");

            //Click on first row (viewer link in order to open pdf document)
            newExplorerPage.clickOnViewerPDFButton();
            //Make sure that pdf document has been opened
            //Wait until Search Results retrieves documents
            Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
            if (pdfViewer.equals("Standalone"))
            {
                //Close opened PDF
                newExplorerPage.closePDF("Embedded");
            }else{
                //Close opened PDF
                newExplorerPage.closePDF("Standalone");
            }
        }
    }
}
