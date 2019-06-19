package main.java.tests.freeTrialTests;

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
public class freeTrialPrintRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetNameFreeTrial","environment","userNameFreeTrial","freeTrialPassword","setPreference"})
    @Test(groups = {"CH_FreeTrial_Print_Runsheet", "Regression","FreeTrial"})
    /* This method prints one document (open it using the PDV Viewer) for the specified Free Trial
     *@params Free Trial username/password. SetPreference is used in order to know what is the PDF Viewer option
    */
    public void freeTrialPrintRunsheet(String runsheetNameFreeTrial,String environment, String userNameFreeTrial, String freeTrialPassword, String setPreference) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNameFreeTrial,1), freeTrialPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetNameFreeTrial+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+"Renamed");

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");

        //Click on first row (viewer link in order to open pdf document)
        newExplorerPage.clickOnViewerPDFButton();
        //Assert PDF Viewer Preference Dialog has been opened only the first time
        if (setPreference.equals("true")) {
            Assert.assertTrue(newExplorerPage.isPDFViewerPreferenceOpen(), "PDF Viewer Preference has not been opened");
            //SET PDF Viewer Embedded Viewer as Default
            newExplorerPage.SetPreference();
        }
        //Make sure that pdf document has been opened
        //Wait until Search Results retrieves documents
        Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
        //Click on Print button
        newExplorerPage.clickOnPrintButton();
        //before we will need to move to previous tab because PDF external app has been opened
        newExplorerPage.changeTab();
        newExplorerPage.waitForSeconds(15);
        //Pending el assert for free trial none pop up is displayed only the documents are loaded TBD
    }
}
