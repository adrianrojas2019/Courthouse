package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian on 11/28/2018.
 */
public class validateMetricsByPayGo extends SeleniumInitializer {
    @Parameters({"firstNamePayGo","lastNamePayGo","userNamePayGo","environment","usernameToLogIn","passwordToLogIn","county","totalDownloads","totalPrints","totalAddedToRunsheet","totalDocumentsViewed","totalRemovedFromRunsheet","totalSearchesByCounty","totalSearchesByTypeExplorerPanel","totalRenamedFromRunsheet"})
    @Test(groups = {"CH_Admin_Metrics_By_PayGo", "Regression","PayGo"})
    /* This method validates the metrics for the specified PayGo.
     *@params PayGo username/password.
     * All the following params: totalDownloads,totalPrints,totalAddedToRunsheet,totalDocumentsViewed,totalRemovedFromRunsheet,totalRenamedFromRunsheet
     * are used in order to match and verify that metric/piwik service is working as expected
    */
    public void validateMetricsByPayGo(String firstNamePayGo, String lastNamePayGo, String userNamePayGo, String environment, String usernameToLogIn, String passwordToLogIn, String county,String totalDownloads, String totalPrints, String totalAddedToRunsheet, String totalDocumentsViewed, String totalRemovedFromRunsheet, String totalSearchesByCounty, String totalSearchesByTypeExplorerPanel, String totalRenamedFromRunsheet) throws InterruptedException, ParseException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        ValidateMetrics(newCHMainPage.LoginMenu(),firstNamePayGo,lastNamePayGo,userNamePayGo,county,totalDownloads,totalPrints,totalAddedToRunsheet,totalDocumentsViewed,totalRemovedFromRunsheet,totalSearchesByCounty,totalSearchesByTypeExplorerPanel,totalRenamedFromRunsheet);
    }

    public void ValidateMetrics(UserAdministrationPage newAdministrationPage, String firstNamePayGo,String lastNamePayGo,String userNamePayGo, String county, String totalDownloads, String totalPrints,String totalAddedToRunsheet,String totalDocumentsViewed, String totalRemovedFromRunsheet, String totalSearchesByCounty, String totalSearchesByTypeExplorerPanel, String totalRenamedFromRunsheet) throws ParseException {

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        newAdministrationPage.clickOnUserAdministrationItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newAdministrationPage.isUserAdminGridDisplayed(), "Cannot access the User Grid.");
        //Click on Search Filter
        newAdministrationPage.clickOnSearchUser(String.format(userNamePayGo,1));
        //Validate that user has been found
        Assert.assertEquals(1, NumberUtils.toInt(newAdministrationPage.isUserFoundByAdmin()), "Cannot find the FreeTrial User.");
        //Click on Contractor User Name
        newAdministrationPage.clickOnContractorName(firstNamePayGo + " " + lastNamePayGo);
        //Click on Usage Metrics tab
        newAdministrationPage.clickOnMetricsTab();
        Assert.assertTrue(newAdministrationPage.isUserMetricsTabDisplayed(), "Cannot display user metrics Tab. (Usage & Activity).");
        //filter Activity for today
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        newAdministrationPage.addFromDateByMetric((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR),"today");

        //Proceed to validate some metrics
        // Added To Runsheet - Documents Viewed - Documents Downloaded - Removed from Runsheet

        //Make sure that at least 1 document has been updated under Documents Downloaded
        Assert.assertEquals(totalDownloads,newAdministrationPage.isDocumentDownloadByMetrics(), "Cannot match Documents Downloaded.");
        //Make sure that at least 1 document has been updated under Documents Printed
        Assert.assertEquals(totalPrints,newAdministrationPage.isPrints(), "Cannot math Documents Printed.");
        //Make sure that at least 3 documents have been added to Runsheet
        Assert.assertEquals(totalAddedToRunsheet,newAdministrationPage.isAddedToRunsheet(), "Cannot math Documents Added to Runsheet.");
        //Make sure that at least 3 documents have been added to Runsheet
        Assert.assertEquals(totalDocumentsViewed,newAdministrationPage.isDocumentViewed(), "Cannot math Documents Viewed.");
        //Make sure that at least 3 documents have been added to Runsheet
        Assert.assertEquals(totalRemovedFromRunsheet,newAdministrationPage.isRemovedFromRunsheet(), "Cannot math Documents Removed from Runsheet.");

        //Make sure that at least 3 documents have been added to Runsheet
        Assert.assertEquals(totalRenamedFromRunsheet,newAdministrationPage.isRenamedFromRunsheet(), "Cannot math Documents Renamed from Runsheet.");

        //Make sure that at least 3 searches have been executed by County
        //Increase a new county found using pay go
        Assert.assertEquals(totalSearchesByCounty,newAdministrationPage.isTotalSearchesByCounty(), "Cannot math Total Searches By County.");

        //Make sure that at least 4 searches have been executed by County
        Assert.assertEquals(totalSearchesByTypeExplorerPanel,newAdministrationPage.isTotalSearchesByType(), "Cannot math Total Searches By Type. (Explorer Panel)");

    }
}
