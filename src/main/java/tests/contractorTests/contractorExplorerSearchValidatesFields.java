package main.java.tests.contractorTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorExplorerSearchValidatesFields extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","contractorCounty","contractorEnhancedClerkCounty"})
    @Test(groups = {"CH_Contractor_Explorer_Search_Validates_Fields", "Regression","Contractor_Test"})
    /**
     * This method called contractorExplorerSearch: basically visit the explorer search section
     * for the specified contractor and perform a basic query using the specified county and grantor and then
     * verify that explorer search was able to get documents
     *@params contractor username/password, county and grantor values for the specified contractor.
     */
    public void contractorExplorerSearchValidatesFields(String environment, String contractorUserName, String contractorPassword, String contractorCounty, String contractorEnhancedClerkCounty) throws InterruptedException {

        //test = extent.createTest("CH_Contractor_Explorer_Search_Validates_Fields","Make sure that all fields are visibles for Abstract Plant/Enhanced Clerk County.");
        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment,contractorUserName, contractorPassword, getDriverInstance());

       //Click on the Magnifying Glass icon on the left side of the Homepage.
        newExplorerPage.clickOnExplorerSearch();
        newExplorerPage.isExploreTitleDisplayed();
        //Click on County Combo
        newExplorerPage.clickOnCountyCombo(contractorCounty);
        //Validate all fields for Abstract Plant County are appearing visible

        Assert.assertTrue(newExplorerPage.isGrantorFieldVisible(), "Explorer Search: Grantor Field is not present.");
        Assert.assertTrue(newExplorerPage.isGranteeFieldVisible(), "Explorer Search: Grantee Field is not present.");
        Assert.assertTrue(newExplorerPage.isGrantorOrGranteeFieldVisible(), "Explorer Search: Grantor or Grantee Field is not present.");

        Assert.assertTrue(newExplorerPage.isVolumeFieldVisible(), "Explorer Search: Volume Field is not present.");
        Assert.assertTrue(newExplorerPage.isPageFieldVisible(), "Explorer Search: Page Field is not present.");
        Assert.assertTrue(newExplorerPage.isInstrumentNumberFieldVisible(), "Explorer Search: Instrument # Field is not present.");

        Assert.assertTrue(newExplorerPage.isBookTypeFieldVisible(), "Explorer Search: Book Type Field is not present.");
        Assert.assertTrue(newExplorerPage.isInstrumentTypeFieldVisible(), "Explorer Search: Instrument Type Field is not present.");

        Assert.assertTrue(newExplorerPage.isDateFromFieldVisible(), "Explorer Search: From Date Field is not present.");
        Assert.assertTrue(newExplorerPage.isDateToFieldVisible(), "Explorer Search: From To Field is not present.");

        Assert.assertTrue(newExplorerPage.isAbstractFieldVisible(), "Explorer Search: Abstract Field is not present.");
        Assert.assertTrue(newExplorerPage.isSurveyFieldVisible(), "Explorer Search: Survey Field is not present.");

        Assert.assertTrue(newExplorerPage.isSectionFieldVisible(), "Explorer Search: Section Field is not present.");
        Assert.assertTrue(newExplorerPage.isTownshipFieldVisible(), "Explorer Search: Township Field is not present.");
        Assert.assertTrue(newExplorerPage.isRangeBlockFieldVisible(), "Explorer Search: Range/Block Field is not present.");
        Assert.assertTrue(newExplorerPage.isQuarterCallFieldVisible(), "Explorer Search: Quarter Call Field is not present.");

        Assert.assertTrue(newExplorerPage.isSubdivisionFieldVisible(), "Explorer Search: Subdivision Field is not present.");
        Assert.assertTrue(newExplorerPage.isLotFieldVisible(), "Explorer Search: Lot Field is not present.");
        Assert.assertTrue(newExplorerPage.isBlockFieldVisible(), "Explorer Search: Block Field is not present.");
        //missing validate the acress min/max fields and the slider
        Assert.assertTrue(newExplorerPage.isSliderFieldVisible(), "Explorer Search: Slider Field is not present.");
        Assert.assertTrue(newExplorerPage.isAcresMinFieldVisible(), "Explorer Search: Acres Min Field is not present.");
        Assert.assertTrue(newExplorerPage.isAcresMaxFieldVisible(), "Explorer Search: Acres Max is not present.");


        //Now proceed to select one Enhanced Clerck County
        newExplorerPage.clickOnCountyCombo(contractorEnhancedClerkCounty);
        //Validate all fields for Enhanced Clerk County are appearing visible
        Assert.assertTrue(newExplorerPage.isGrantorFieldVisible(), "Explorer Search: Grantor Field is not present.");
        Assert.assertTrue(newExplorerPage.isGranteeFieldVisible(), "Explorer Search: Grantee Field is not present.");
        Assert.assertTrue(newExplorerPage.isGrantorOrGranteeFieldVisible(), "Explorer Search: Grantor or Grantee Field is not present.");

        Assert.assertTrue(newExplorerPage.isVolumeFieldVisible(), "Explorer Search: Volume Field is not present.");
        Assert.assertTrue(newExplorerPage.isPageFieldVisible(), "Explorer Search: Page Field is not present.");
        Assert.assertTrue(newExplorerPage.isInstrumentNumberFieldVisible(), "Explorer Search: Instrument # Field is not present.");

        Assert.assertTrue(newExplorerPage.isBookTypeFieldVisible(), "Explorer Search: Book Type Field is not present.");
        Assert.assertTrue(newExplorerPage.isInstrumentTypeFieldVisible(), "Explorer Search: Instrument Type Field is not present.");

        Assert.assertTrue(newExplorerPage.isDateFromFieldVisible(), "Explorer Search: From Date Field is not present.");
        Assert.assertTrue(newExplorerPage.isDateToFieldVisible(), "Explorer Search: From To Field is not present.");

        Assert.assertTrue(newExplorerPage.isPropertyDescriptionFieldVisible(), "Explorer Search: Property Description Field is not present.");
        //missing validate the acress min/max fields and the slider
        Assert.assertTrue(newExplorerPage.isSliderFieldVisible(), "Explorer Search: Slider Field is not present.");
        Assert.assertTrue(newExplorerPage.isAcresMinFieldVisible(), "Explorer Search: Acres Min Field is not present.");
        Assert.assertTrue(newExplorerPage.isAcresMaxFieldVisible(), "Explorer Search: Acres Max is not present.");

    }
}
