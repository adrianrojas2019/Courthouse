package main.java.tests.payGoTests;

import main.java.pageObjects.ExplorerPage;
import main.java.pageObjects.PayGoPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class payGoSubscriptionPage extends SeleniumInitializer {
    @Parameters({"environment","payGoURL"})
    @Test(groups = {"CH_PayGo_Subscription_Page", "Regression", "payGoURL"})
    /* This method Creates a new runsheet with at least three documents for the specified PayGo
     *@params PayGo username/password, county and grantor values for the specified free trial.
     */
    public void payGoSubscriptionPage(String environment,String payGoURL) throws InterruptedException {

        //Create page object
        PayGoPage newPayGoPage = new PayGoPage(driver);
        newPayGoPage.LoadNewURL(String.format(payGoURL,environment));
        //Under Monthly Purchase Limit Section
        Assert.assertTrue(newPayGoPage.waitForMonthlyPurchaseLimitMessageDisplayed(30), "Monthly Purchase Limit Section Message has not been updated!");

    }
}
