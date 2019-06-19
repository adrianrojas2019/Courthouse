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
public class payGoDownloadRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetNamePayGo","environment","userNamePayGo","payGoPassword"})
    @Test(groups = {"CH_PayGo_Download_Runsheet", "Regression", "PayGo"})
    /* This method download the documents for the already existing one runsheet for the specified Pay Go
     *@params Pay Go username/password
    */
    public void payGoDownloadRunsheet(String runsheetNamePayGo,String environment, String userNamePayGo, String payGoPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNamePayGo,1), payGoPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetNamePayGo+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");

        //Change the option to Index with images
        newExplorerPage.changeToIndicesWithImages("Images");
        newExplorerPage.clickOnDownloadAllButton();
        newExplorerPage.waitForSeconds(15);
        //Pending el assert for free trial none pop up is displayed only the documents are loaded TBD
    }
}
