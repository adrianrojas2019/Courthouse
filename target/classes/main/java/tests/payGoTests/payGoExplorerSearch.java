package main.java.tests.payGoTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class payGoExplorerSearch extends SeleniumInitializer {
    @Parameters({"environment","userNamePayGo","payGoPassword","payGoCounty","multiplePayGoGrantor","totalSearches"})
    @Test(groups = {"CH_PayGo_Explorer_Search", "Regression", "PayGo"})
    /**
     * This method called payGoExplorerSearch: basically visit the explorer search section
     * for the specified PayGo and perform a basic query using the specified county,grantor and total of searches and then
     * verify that explorer search was able to get documents
     *@params PayGo username/password, county and grantor values for the specified Pay Go user. TotalSearches is the amount of searches.
     */
    public void payGoExplorerSearch(String environment, String userNamePayGo, String payGoPassword, String payGoCounty, String multiplePayGoGrantor,int totalSearches) throws InterruptedException {

        String[] multiplePayGoGrantors = multiplePayGoGrantor.split(",");
        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,String.format(userNamePayGo,1), payGoPassword, getDriverInstance());

        for(int number =1; number <= totalSearches; number++) {

            //Click on the Magnifying Glass icon on the left side of the Homepage.
            newExplorerPage.clickOnExplorerSearch();
            newExplorerPage.isExploreTitleDisplayed();

            //Get current Available Balance
            Double currentAvailableBalance = newExplorerPage.getCurrentAvailableBalance();
            //Click on County Combo
            newExplorerPage.clickOnCountyCombo(payGoCounty);
            newExplorerPage.isGrantorEnabled();
            newExplorerPage.insertGrantor(multiplePayGoGrantors[number-1]);
            newExplorerPage.clickOnApplyButton();
            //Purchase Confirmation Pop Up
            Assert.assertTrue(newExplorerPage.isPurchaseConfirmationDialogDisplayed(), "Purchase Confirmation Dialog has not been displayed.");
            //click on Ok button
            newExplorerPage.clickOnPurchaseConfirmationButton();
            //Wait until Available Balance has been updated
            Assert.assertEquals(newExplorerPage.getCurrentAvailableBalance(), currentAvailableBalance - 0.25, "Available Balance has not been updated!.");
            //Wait until Search Results retrieves documents
            Assert.assertTrue(newExplorerPage.isSearchResultsWithDocuments(), "Explorer Search Filter didn't get documents. (Search Results is empty)");
            newExplorerPage.clickOnFirstCheckBox();
            //Click on the Magnifying Glass icon on the left side of the Homepage.
            newExplorerPage.clickOnExplorerSearch();
        }
    }
}
