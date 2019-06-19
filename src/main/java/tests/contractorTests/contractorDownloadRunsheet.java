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
public class contractorDownloadRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetName","environment","contractorUserName","contractorPassword"})
    @Test(groups = {"CH_Contractor_Download_Runsheet", "Regression","Contractor_Test"})

    /* This method download the documents for the already existing one runsheet for the specified contractor
     *@params contractor username/password for the specified contractor.
    */
    public void contractorDownloadRunsheet(String runsheetName,String environment, String contractorUserName, String contractorPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR))+"Renamed");

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");

        //Change the option to Index with images
        newExplorerPage.changeToIndicesWithImages("Images");
        newExplorerPage.clickOnDownloadAllButton();
        //Make sure that new Pop Up Dialog is being displayed at least that somebody pressed the check box
        //"Dont' show me this message again."
        Assert.assertTrue(newExplorerPage.isDownloadsPrintsDialogDisplayed(), "Downloads & Prints Pop Up Dialog has not been displayed. (Pop Up Dialog)");
        //Get Total of Downloads
        int ntotalDownloads = NumberUtils.toInt(newExplorerPage.getTotalDownloads()) + 1;
        //Click on OK button proceed to download the documents
        newExplorerPage.clickOnOKButton();
        //Click again on DownloadAllButton
        newExplorerPage.clickOnDownloadAllButton();
        //Assert.assertEquals in order to verify that download has been increased
        Assert.assertEquals(ntotalDownloads , NumberUtils.toInt(newExplorerPage.getTotalDownloads()),"Total of Downloads have not been increased.");

    }
}
