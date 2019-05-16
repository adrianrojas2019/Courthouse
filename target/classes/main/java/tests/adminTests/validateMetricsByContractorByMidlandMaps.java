package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.apache.commons.lang3.math.NumberUtils;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Adrian on 11/28/2018.
 */
public class validateMetricsByContractorByMidlandMaps extends SeleniumInitializer {
    @Parameters({"contractorName","contractorUserName","environment","usernameToLogIn","passwordToLogIn","searchMidlandMapsCountyName","totalDownloadMidlandMaps","totalSearchesByCountyMidlandMaps"})
    @Test(groups = {"CH_Admin_Metrics_By_Contractor_By_Midland_Maps", "Regression","Midland_Maps_Feature"})

    public void validateMetricsByContractorByMidlandMaps(String contractorName, String contractorUserName, String environment, String usernameToLogIn, String passwordToLogIn, String searchMidlandMapsCountyName,String totalDownloadMidlandMaps, String totalSearchesByCountyMidlandMaps) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        ValidateMetrics(newCHMainPage.LoginMenu(),contractorUserName,contractorName,searchMidlandMapsCountyName,totalDownloadMidlandMaps,totalSearchesByCountyMidlandMaps);
    }

    public void ValidateMetrics(UserAdministrationPage newAdministrationPage, String contractorUserName, String contractorName,String searchMidlandMapsCountyName, String totalDownloadMidlandMaps, String totalSearchesByCountyMidlandMaps){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on User Administration item
        newAdministrationPage.clickOnUserAdministrationItem();
        //Validate that User Grid has been displayed
        Assert.assertTrue(newAdministrationPage.isUserAdminGridDisplayed(), "Cannot access the User Grid.");
        //Click on Search Filter
        newAdministrationPage.clickOnSearchUser(contractorUserName);
        //Validate that user has been found
        Assert.assertEquals(1, NumberUtils.toInt(newAdministrationPage.isUserFoundByAdmin()), "Cannot find the Contract User.");
        //Click on Contractor User Name
        newAdministrationPage.clickOnContractorName(contractorName);
        //Click on Usage Metrics tab
        newAdministrationPage.clickOnMetricsTab();
        Assert.assertTrue(newAdministrationPage.isUserMetricsTabDisplayed(), "Cannot display user metrics Tab. (Usage & Activity).");
        //filter Activity for today
        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        newAdministrationPage.addFromDateByMetric((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR));

        //Proceed to validate some metrics
        //Make sure that at least 2 searches have been executed by Broker Box County
        Assert.assertEquals(totalDownloadMidlandMaps,newAdministrationPage.isTotalSearchesByCountyBB(searchMidlandMapsCountyName), "Cannot math Total Searches By County. (Total Searches by County)");

        //Make sure that at least 1 search have been executed by Type
        Assert.assertEquals(totalSearchesByCountyMidlandMaps,newAdministrationPage.isTotalSearchesByTypeBBIndexBook(), "Cannot math Total Searches By County/Year.");

    }
}
