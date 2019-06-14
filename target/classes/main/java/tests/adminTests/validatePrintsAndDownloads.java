package main.java.tests.adminTests;

import main.java.pageObjects.CHMainPage;
import main.java.pageObjects.UserAdministrationPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Adrian on 11/28/2018.
 */
public class validatePrintsAndDownloads extends SeleniumInitializer {
    @Parameters({"environment","usernameToLogIn","passwordToLogIn","companyAcct","companyID","county","totalDownloads","totalPrints"})
    @Test(groups = {"CH_Admin_Validate_Prints_Downloads", "Regression","Contractor_Test"})

    public void validatePrintsAndDownloads(String environment, String usernameToLogIn, String passwordToLogIn, String companyAcct, String companyID, String county,String totalDownloads, String totalPrints) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        //UserAdministrationPage newAdministrationPage =
        ValidatePrintsAndDownloads(newCHMainPage.LoginMenu(),companyAcct,companyID,county,totalDownloads,totalPrints);
    }

    public void ValidatePrintsAndDownloads(UserAdministrationPage newAdministrationPage, String companyAcct, String companyID,String county, String totalDownloads, String totalPrints){

        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newAdministrationPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on Company Management item
        newAdministrationPage.clickOnCompanyManagement();
        //Validate that User Grid Company has been displayed
        Assert.assertTrue(newAdministrationPage.isUserGridCompanyDisplayed(), "Cannot access the User Grid Company.");
        //Click on Search Filter
        newAdministrationPage.clickOnSearchUser(companyID);
        //Validate that Company has been found
        Assert.assertEquals(companyID,newAdministrationPage.isCompanyDisplayed(), "Cannot find Company ID.");
        //Select row
        newAdministrationPage.clickOnCompanyRow();
        //Click on Usage Metrics tab
        newAdministrationPage.clickOnUsageMetricsTab();
        Assert.assertTrue(newAdministrationPage.isUserMetricsGridDisplayed(), "Cannot display user metrics View. (Select County for Details).");
        //Select County
        newAdministrationPage.selectCounty(county);
        Assert.assertTrue(newAdministrationPage.isCountyDisplayed(county), "Cannot find County: " + county);
        //filter Activity for today

        Date today = new Date(); // Fri Jun 17 14:54:28 PDT 2016
        Calendar cal = Calendar.getInstance();
        cal.setTime(today); // don't forget this if date is arbitrary e.g. 01-01-2014
        //workaround to format mm dd yyyy when month or day is 1 digit
        newAdministrationPage.addFromDate((String.format("%02d",cal.get(Calendar.MONTH)+1)) + "." + String.format("%02d",cal.get(Calendar.DAY_OF_MONTH)) + "." + cal.get(Calendar.YEAR));
        //Make sure that at least 1 document has been updated under Documents Downloaded
        Assert.assertEquals(totalDownloads,newAdministrationPage.isDocumentDownloaded(), "Cannot match Documents Downloaded.");
        //Make sure that at least 1 document has been updated under Documents Printed
        Assert.assertEquals(totalPrints,newAdministrationPage.isDocumentPrinted(), "Cannot math Documents Printed.");
    }
}
