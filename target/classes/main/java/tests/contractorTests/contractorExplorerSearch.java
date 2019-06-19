package main.java.tests.contractorTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.PayGoPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorExplorerSearch extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","contractorCounty","contractorGrantor"})
    @Test(groups = {"CH_Contractor_Explorer_Search", "Regression","Contractor_Test"})
    /**
     * This method called contractorExplorerSearch: basically visit the explorer search section
     * for the specified contractor and perform a basic query using the specified county and grantor and then
     * verify that explorer search was able to get documents
     *@params contractor username/password, county and grantor values for the specified contractor.
     */
    public void contractorExplorerSearch(String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorGrantor) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,contractorUserName, contractorPassword, getDriverInstance());

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
        newExplorerPage.clickOnFirstCheckBox();
    }
}
