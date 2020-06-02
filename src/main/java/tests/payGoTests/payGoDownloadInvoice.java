package main.java.tests.payGoTests;

import main.java.pageObjects.ExplorerPage;
import main.java.selenium.SeleniumInitializer;
import main.java.tests.commonTests.loginTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

/**
 * Created by Adrian on 12/10/2018.
 */
public class payGoDownloadInvoice extends SeleniumInitializer {
    @Parameters({"environment","userNamePayGo","payGoPassword"})
    @Test(groups = {"CH_PayGo_Download_Invoice", "Regression", "PayGo"})
    /**
     * This method called payGoExplorerSearch: basically visit the explorer search section
     * for the specified PayGo and perform a basic query using the specified county,grantor and total of searches and then
     * verify that explorer search was able to get documents
     *@params PayGo username/password, county and grantor values for the specified Pay Go user. TotalSearches is the amount of searches.
     */
    public void payGoDownloadInvoice(String environment, String userNamePayGo, String payGoPassword) throws InterruptedException {

        //Already logged in as DI Admin
        loginTest loginIntoCHMainPageTest = new loginTest();
        //Create page object
        ExplorerPage newExplorerPage = loginIntoCHMainPageTest.loginSuccessfullyTest(environment, String.format(userNamePayGo, 1), payGoPassword, getDriverInstance());

        newExplorerPage.clickOnUserMenu();
        //Validate if the user menu has been selected/displayed
        Assert.assertTrue(newExplorerPage.isMenuUserDisplayed(10), "Cannot display the User Menu");
        //Click on My Account item
        newExplorerPage.clickOnMyAccountItem();
        //Validate that Test Contract Page has been loaded
        Assert.assertTrue(newExplorerPage.isMyAccountDisplayed(10), "Cannot display My Account Page");
        newExplorerPage.clickOnDownloadDatePicker();
        //Validate that dropdown menu calendar has been displayed
        Assert.assertTrue(newExplorerPage.iDropDownCalendarDisplayed(10), "Cannot display Drop Down Calendar");
        //Select current month - 1
        LocalDate currentDate = LocalDate.now();
        Month m = currentDate.minusMonths(+1).getMonth();
        String output = m.toString().toLowerCase();
        output = output.substring(0, 1).toUpperCase() + output.substring(1);
        newExplorerPage.clickOnPreviousMonth(output);
        //click on Download Invoice Button
        newExplorerPage.clickOnDownloadInvoiceButton();
        newExplorerPage.waitForSeconds(15);
        //Read PDF Invoice
        Calendar now = Calendar.getInstance();
        newExplorerPage.readPDF("Invoice_Copy-"+now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)));
    }
}
