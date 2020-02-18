package main.java.tests.standardTests;

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
public class priorReferenceSearch extends SeleniumInitializer {
    @Parameters({"standardUserName","standardUserPassword","standardUserCounty","standardUserVolume","standardUserPage","standardUserRecordNumber"})
    @Test(groups = {"CH_Standard_Prior_Reference_Search", "Regression","Standard_Test"})
/**
 * This test script performs a simple search for Prior Reference Search Feature
 * */
    public void priorReferenceSearch(String standardUserName, String standardUserPassword,String standardUserCounty, String standardUserVolume,String standardUserPage,String standardUserRecordNumber) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        PriorReferenceSearch(loginIntoCHMainPageTest.loginSuccessfully(standardUserName,standardUserPassword,getDriverInstance()),standardUserCounty,standardUserVolume,standardUserPage,standardUserRecordNumber);
    }

    public void PriorReferenceSearch(ExplorerPage newExplorerPage,String standardUserCounty, String standardUserVolume,String standardUserPage, String standardUserRecordNumber){

        //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnPriorReferenceSearch();
        newExplorerPage.isPriorReferenceTitleDisplayed();

        //Click on County Combo
        newExplorerPage.clickOnCountyComboPriorReference(standardUserCounty);

        newExplorerPage.clickOnPRApplyButton();
        //Error Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Please type a value for volume and page or a record #."), "The new document(s) could not be added into new runsheet");
        //Add Volume and Page and click on Apply button
        newExplorerPage.insertVolume(standardUserVolume);
        newExplorerPage.clickOnPRApplyButton();
        //Error Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Please type a value for volume and page or a record #."), "The new document(s) could not be added into new runsheet");
        //Add Volume and Page and click on Apply button
        newExplorerPage.insertPage(standardUserPage);
        newExplorerPage.clickOnPRApplyButton();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Prior Reference Search Filter didn't get documents. (Search Results is empty)");
        //Find using Record # or Instrument Number
        newExplorerPage.clickOnPriorReferenceSearch();
        //Click on Prior Reference Search button again
        newExplorerPage.clickOnPriorReferenceSearch();
        newExplorerPage.insertRecordNumber(standardUserRecordNumber);
        newExplorerPage.clickOnPRApplyButton();
        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Prior Reference Search Filter didn't get documents. (Search Results is empty)");

    }
}
