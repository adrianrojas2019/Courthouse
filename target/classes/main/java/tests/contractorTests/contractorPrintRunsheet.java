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
    @Parameters({"runsheetName","environment","contractorUserName","contractorPassword","contractorCounty","contractorGrantor"})
    @Test(groups = {"CH_Contractor_Print_Runsheet", "Regression","Contractor_Test"})

    public void contractorPrintRunsheet(String runsheetName,String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorGrantor) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

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
