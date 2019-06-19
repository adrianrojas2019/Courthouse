package main.java.tests.contractorTests;

import main.java.pageObjects.BookSearchPage ;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class contractorBrokerBoxSearch extends SeleniumInitializer {
    @Parameters({"environment","contractorUserName","contractorPassword","brokerBoxCounty","brokerBoxBookType","brokerBoxIndexBook","brokerBoxBookmarks","brokerBoxVolume","brokerBoxPage","runsheetName"})
    @Test(groups = {"CH_Contractor_Broker_Box_Search", "Regression","Broker_Box"})
/**
 * This test script performs a simple search for broker box Feature
 * */
    public void contractorBrokerBoxSearch(String environment, String contractorUserName, String contractorPassword, String brokerBoxCounty, String brokerBoxBookType, String brokerBoxIndexBook, String brokerBoxBookmarks, String brokerBoxVolume, String brokerBoxPage, String runsheetName) throws InterruptedException {


        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        BookSearchPage newBookSearchPage = loginIntoCHMainPageTest.loginSuccessfullyBrokerBox(environment,contractorUserName, contractorPassword, getDriverInstance());

       //Click on the Book icon on the left side of the Homepage.
        newBookSearchPage.isBrokerBoxTitleDisplayed();
        //Click on County Combo
        newBookSearchPage.clickOnCountyCombo(brokerBoxCounty);
        //Click on Book Type combo
        newBookSearchPage.clickOnBookType(brokerBoxBookType);
        //Click on Index Book combo
        newBookSearchPage.clickOnIndexBook(brokerBoxIndexBook);
        //Click on Bookmarks combo
        newBookSearchPage.clickOnBookmarks(brokerBoxBookmarks);

        newBookSearchPage.clickOnApplyButton();
        //Wait until Progress Bar is gone
        newBookSearchPage.isProgressBarDone();

        //click on Volume text field
        newBookSearchPage.insertVolume(brokerBoxVolume);
        //Click on Go button
        newBookSearchPage.clickOnGoButton();
        //Assert Warning Msg
        Assert.assertTrue(newBookSearchPage.isSuccessMessageDisplayed("Page field can not be empty"), "The new document(s) could not be added into new runsheet");
        //Wait until Toaster is gone
        newBookSearchPage.isToasterDone();

        //Click on Page text field
        newBookSearchPage.insertPage(brokerBoxPage);
        //Click on Go button
        newBookSearchPage.clickOnGoButton();

        //Wait until Progress Bar is gone
        newBookSearchPage.isProgressBarDone();

        //Proceed to add the previous selected documents into new runsheet
        newBookSearchPage.clickOnAddToRunsheetButton();

        //Click on Add runsheet?
        Calendar now = Calendar.getInstance();
        newBookSearchPage.selectRunsheetName(runsheetName+(now.get(Calendar.MONTH)+1) + " " + (now.get(Calendar.DAY_OF_MONTH) + " " + now.get(Calendar.YEAR)));
        //Click on Ok button
        newBookSearchPage.clickOnOKButton();
        //Success Message
        Assert.assertTrue(newBookSearchPage.isSuccessMessageDisplayed("Document(s) have been successfully added."), "The new document(s) could not be added into new runsheet");
    }
}
