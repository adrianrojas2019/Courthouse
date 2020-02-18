package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Adrian on 5/10/2019.
 */
public class MidlandMapsPage extends PageObjects  {

    private final By COUNTY_COMBO = By.cssSelector("form[name='midlandForm'] select[name='countyParishId']");
    private final By COUNTY_YEAR_COMBO = By.cssSelector("form[name='midlandForm'] select[name='yearId']");
    private final By APPLY_BUTTON = By.cssSelector("aside[ui-view='filtersMidland'] button[class='btn btn-primary']");
    private final By CANCEL_DOWNLOAD_BUTTON = By.cssSelector("button[ng-if='isLoadingDocument']");
    private final By CLEAR_ALL_BUTTON = By.cssSelector("button[ng-click='cleanFilterMidlandSearch()']");
    private final By NEXT_MAP = By.cssSelector("button[class='toolbarButton nextDocument']");
    private final By SPINNER_POPUP = By.xpath("//section[@ng-show='searchFilterMidlandSearchOpen']//article[@di-pdf-viewer='pdfViewerOptions']//div[@class='spinner']");
    private final By DOCUMENT_NOT_AVAILABLE = By.xpath("//canvas[@width=856][@height=1108]");
    private final By LATEST_ONE_MAP = By.xpath("//button[@class='toolbarButton nextDocument'][@disabled='disabled']");
    private final By NEW_WARNING_MESSAGE = By.xpath("//span[text()='Due to the large file size please expect longer wait times when loading an ownership map.']");
    private final By MIDLAND_MAP_TITLE = By.xpath("//h4[text()='Midland Map']");
    private final By SHOW_COVERAGE_LINK = By.cssSelector("form[name='midlandForm'] a[popover-label='show coverage']");
    private final By HIDE_COVERAGE_LINK = By.xpath("//a[text()=' hide coverage']");
    private final By SHOW_COVERAGE_LOADING = By.cssSelector("form[@name='midlandForm'] a[popover-label='loading...']");
    private final By MIDLAND_MAP_COUNTY_BORDEN = By.xpath("//div[text()='Borden Midland Maps']");
    private final By MIDLAND_MAP_COUNTY_YOAKUM = By.xpath("//div[text()='Yoakum Midland Maps']");
    private final By MIDLAND_MAP_COUNTY_LAMB = By.xpath("//div[text()='Lamb Midland Maps']");

    String findMidlandMapsCounty = "//div[@class='filter-input-container col-xs-8']//option[text()='%s']";
    String findMidlandMapsCountyYear = "//option[text()='%s']";
    String successAlertMessage= "//div[contains(text(),'%s')]";

    public MidlandMapsPage(WebDriver driver) {
        super(driver);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnCountyCombo(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        //webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        selectDropDownOptionByValue(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnCountyComboNotAssigned(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        //selectDropDownOptionByValue(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     * This method selects a dropdown option depending on the value.
     *
     * @param webElement dropdown to select the option
     * @param value      value to select in the dropdown
     */
    public void selectDropDownOptionByValue(final By webElement, String value) {
        Select dropdown = new Select(webDriverCommands.findElement(webElement));
        dropdown.selectByVisibleText(value);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnYearCombo(String contractorCountyYear){
        webDriverCommands.waitSomeSeconds(5);
        //webDriverCommands.type(COUNTY_YEAR_COMBO,contractorCountyYear);
        selectDropDownOptionByValue(COUNTY_YEAR_COMBO,contractorCountyYear);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCancelDownloadButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(CANCEL_DOWNLOAD_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnShowCoverageLink(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SHOW_COVERAGE_LINK);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementInVisible(SHOW_COVERAGE_LOADING);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnHideCoverageLink(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(HIDE_COVERAGE_LINK);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnClearAllButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(CLEAR_ALL_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the waitForElementInVisible method in webDriverCommands class.
     */
    public void isProgressBarDone() {
        webDriverCommands.waitForElementInVisible(SPINNER_POPUP, 260);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnNextMapIcon() {
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(NEXT_MAP);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean isDocumentNotAvailable(){
        return webDriverCommands.waitForElementPresent(DOCUMENT_NOT_AVAILABLE,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean isNotLatestMap(){
        return webDriverCommands.waitForElementPresent(LATEST_ONE_MAP,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean isNewWarningDisplayed(){
        return webDriverCommands.waitForElementPresent(NEW_WARNING_MESSAGE,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean isMidlandMapTitleDisplayed(){
        return webDriverCommands.waitForElementPresent(MIDLAND_MAP_TITLE,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean CountyLambHasBeenDisplayed(){
        return webDriverCommands.waitForElementPresent(MIDLAND_MAP_COUNTY_LAMB,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     */
    public boolean CountyYoakumHasBeenDisplayed(){
        return webDriverCommands.waitForElementPresent(MIDLAND_MAP_COUNTY_YOAKUM,3);
    }
    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *  @return boolean
     */
    public boolean CountyBordenHasBeenDisplayed() {
        return webDriverCommands.waitForElementPresent(MIDLAND_MAP_COUNTY_BORDEN, 3);
    }
    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param countyMidlandMaps message to be displayed
     *  @return boolean
     */
    public boolean isMidlandMapCountyDisplayed(String countyMidlandMaps){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(findMidlandMapsCounty, countyMidlandMaps)));
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param successMessage message to be displayed
     *  @return boolean
     */
    public boolean isSuccessMessageDisplayed(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successAlertMessage,successMessage)),15);
    }
    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param countyYearMidlandMaps message to be displayed
     *  @return boolean
     */
    public boolean isMidlandMapCountyYearDisplayed(String countyYearMidlandMaps){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(findMidlandMapsCountyYear, countyYearMidlandMaps)));
    }
}
