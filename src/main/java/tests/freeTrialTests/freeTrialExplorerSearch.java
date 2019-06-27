package main.java.tests.freeTrialTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class freeTrialExplorerSearch extends SeleniumInitializer {
    @Parameters({"environment","userNameFreeTrial","freeTrialPassword","freeTrialCounty","multipleFreeTrialGrantor","totalSearches"})
    @Test(groups = {"CH_FreeTrial_Explorer_Search", "Regression","FreeTrial"})

    /**
     * This method called freeTrialExplorerSearch: basically visit the explorer search section
     * for the specified freetrial and perform a basic query using the specified county,grantor and total of searches and then
     * verify that explorer search was able to get documents
     *@params freeTrial username/password, county and grantor values for the specified Free Trial user. TotalSearches is the amount of searches.
     */
    public void freeTrialExplorerSearch(String environment, String userNameFreeTrial, String freeTrialPassword, String freeTrialCounty, String multipleFreeTrialGrantor,int totalSearches) throws InterruptedException {

        String[] multipleFreeTrialGrantors = multipleFreeTrialGrantor.split(",");
        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,String.format(userNameFreeTrial,1), freeTrialPassword, getDriverInstance());

        for(int number =1; number <= totalSearches; number++) {

            //Click on the Magnifying Glass icon on the left side of the Homepage.
            newExplorerPage.clickOnExplorerSearch();
            newExplorerPage.isExploreTitleDisplayed();

            //Get current Available Balance
            Double currentAvailableBalance = newExplorerPage.getCurrentAvailableBalance();
            //Click on County Combo
            newExplorerPage.clickOnCountyCombo(freeTrialCounty);
            newExplorerPage.isGrantorEnabled();
            newExplorerPage.insertGrantor(multipleFreeTrialGrantors[number-1]);
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
