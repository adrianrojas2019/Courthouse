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
public class validateMetricTypeDefault extends SeleniumInitializer {
    @Parameters({"contractorName","contractorUserName","environment","usernameToLogIn","passwordToLogIn","metricTypeDefault"})
    @Test(groups = {"CH_Admin_Metrics_Type_Default", "Regression","Contractor_Test"})

    /* This method validates the metrics for the specified contractor.
     *@params contractor username/password values for the specified contractor.
     * The following param:  metricTypeDefault
     * is used in order to match and verify that 'No. of logins' appears as first under metric type combo box
    */
    public void validateMetricTypeDefault(String contractorName, String contractorUserName, String environment, String usernameToLogIn, String passwordToLogIn, String metricTypeDefault) throws InterruptedException, ParseException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();

        CHMainPage newCHMainPage = loginIntoCHMainPageTest.loginSuccessfullyGalleryTest(environment,usernameToLogIn, passwordToLogIn, getDriverInstance());
        ValidateMetrics(newCHMainPage.LoginMenu(),contractorUserName,contractorName,metricTypeDefault);
    }

    public void ValidateMetrics(UserAdministrationPage newAdministrationPage, String contractorUserName, String contractorName,String metricTypeDefault) throws ParseException {

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
        //Make sure that under Metric Type the param value 'metricTypeDefault' appears as default
        Assert.assertTrue(newAdministrationPage.isMetricTypeSelected(metricTypeDefault),"Metric Type is not the correct Default");
    }
}
