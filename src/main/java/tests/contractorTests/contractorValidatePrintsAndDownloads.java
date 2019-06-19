package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorValidatePrintsAndDownloads extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","contractorCounty","totalDownloads","totalPrints"})
    @Test(groups = {"CH_Contractor_Validate_Prints_Downloads", "Regression","Contractor_Test"})

    /* This method validates the total of prints and downloads for the specified contractor matching with the totalDownloads/Prints params.
     *@params contractor username/password values for the specified contractor.
    */
    public void contractorValidatePrintsAndDownloads(String environment, String contractorUserName, String contractorPassword, String contractorCounty,String totalDownloads, String totalPrints) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, contractorUserName, contractorPassword, getDriverInstance());

        newExplorerPage.clickOnUserMenu();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newExplorerPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on Company Management item
        //Call Company Management item
        newExplorerPage.clickOnCompanyManagement();
        //Validate that grid has been displayed
        Assert.assertTrue(newExplorerPage.isCountyGridListDisplayed(10), "Cannot display County Grid List");
        //Find contractorCounty
        newExplorerPage.clickOnContractorCounty(contractorCounty);
        //Filter current date
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        //workaround to format mm dd yyyy when month or day is 1 digit
        newExplorerPage.addFromDate((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR));
        //Make sure that at least 1 document has been updated under Documents Downloaded
        Assert.assertEquals(totalDownloads,newExplorerPage.isDocumentDownloaded(), "Cannot match Documents Downloaded.");
        //Make sure that at least 1 document has been updated under Documents Printed
        Assert.assertEquals(totalPrints,newExplorerPage.isDocumentPrinted(), "Cannot math Documents Printed.");
    }
}
