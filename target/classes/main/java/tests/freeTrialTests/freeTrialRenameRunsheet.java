package main.java.tests.freeTrialTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class freeTrialRenameRunsheet extends SeleniumInitializer {
    @Parameters({"runsheetNameFreeTrial","environment","userNameFreeTrial","freeTrialPassword"})
    @Test(groups = {"CH_FreeTrial_Rename_Runsheet", "Regression"})

    public void freeTrialRenameRunsheet(String runsheetNameFreeTrial,String environment, String userNameFreeTrial, String freeTrialPassword) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNameFreeTrial,1), freeTrialPassword, getDriverInstance());
        //Find-Select previous created runsheet
        Calendar now = Calendar.getInstance();
        newExplorerPage.clickOnRunsheetList(runsheetNameFreeTrial+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));

        //Wait until Search Results retrieves documents
        Assert.assertTrue(newExplorerPage.isRunsheetGridWithDocuments(), "Runsheet Grid with not documents. (Runsheet Grid is empty)");
        //Click on Rename button
        newExplorerPage.clickOnRenameButton();

        newExplorerPage.renameRunsheet("Renamed");

        //Click on Edit Runsheet button
        newExplorerPage.cllckOnEditRunsheetButton();
        //Success Message
        Assert.assertTrue(newExplorerPage.isSuccessMessageDisplayed("Runsheet has been successfully renamed."), "The runsheet could not be renamed");

    }
}
