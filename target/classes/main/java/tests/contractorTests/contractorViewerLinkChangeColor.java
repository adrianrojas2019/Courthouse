package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorViewerLinkChangeColor extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","contractorCounty","contractorGrantor","cssColor"})
    @Test(groups = {"CH_Contractor_Viewer_Link_Change_Color", "Regression","Contractor_Test"})
    /**
     * This method called contractorExplorerSearch: basically visit the explorer search section
     * for the specified contractor and perform a basic query using the specified county and grantor and then
     * verify that explorer search was able to get documents
     *@params contractor username/password, county and grantor values for the specified contractor.
     */
    public void contractorViewerLinkChangeColor(String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorGrantor, String cssColor) throws InterruptedException {


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
        //Click on Viewer link (open the pdf viewer)
        newExplorerPage.clickOnViewerPDFButton();
        Assert.assertFalse(newExplorerPage.isDocumentNotAvailable(), "Document not available. (PDF Viewer: Document is empty)");
        //Close opened PDF
        newExplorerPage.closePDF("Embedded");
        //Make sure that viewer link color has been changed
        Assert.assertEquals(cssColor,newExplorerPage.getViewerColorAttribute(),"The viewer color has not changed");
    }
}
