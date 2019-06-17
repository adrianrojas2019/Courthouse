package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by Adrian on 11/30/2018.
 */
public class BookSearchPage extends PageObjects {
    /**
     *Web elements for UserPage
     */

    private final By FREE_TRIAL_TITLE = By.xpath("//h2[text()='Save time and gas money by accessing court documents online.']");
    private final By EXPLORER_SEARCH_BUTTON = By.xpath("//i[@class='fa fa-search fa-flip-horizontal']");
    private final By COUNTY_COMBO = By.cssSelector("form[name='brokerBoxForm'] select[name='countyParishId']");
    private final By BOOK_TYPE_COMBO = By.cssSelector("select[name='bookType']");
    private final By INDEX_BOOK_COMBO= By.cssSelector("select[name='indexBook']");
    private final By BOOKMARKS_COMBO = By.cssSelector("select[name='bookmarks']");
    private final By CONTRACTOR_MAIN_PAGE = By.xpath("//h5[@name='Search Results']");
    private final By BROKER_BOX_TITLE = By.xpath("//h4[text()='Broker Box']");
    private final By GRANTOR_LABEL = By.cssSelector("label[for='grantor']");
    private final By GRANTOR = By.cssSelector("input[name='grantor']");
    private final By VOLUME = By.cssSelector("input[ng-model='diPdfViewer.volume']");
    private final By PAGE = By.xpath("//input[@ng-model='diPdfViewer.page']");
    private final By SPINNER_POPUP = By.xpath("//span[@spinner-key='di-spinner-pdf']//div");
    private final By TOASTER_POPUP = By.xpath("//div[@class='toast toast-warning']");
    private final By APPLY_BUTTON = By.xpath("//aside[@ui-view='filtersBookSearch']//button[@class='btn btn-primary'][@type='submit']");
    private final By GO_BUTTON = By.cssSelector("span.btn.btn-di.pull-right");

    private final By FIRST_CHECKBOX = By.cssSelector("div.ngCell.col0.colt0");
    private final By OLD_RUNSHEET = By.xpath("//select[@ng-show='!runsheetTypeSelected || runsheetTypeSelected && runsheetTypeSelected.id === indexMyRunsheets']");
    private final By ADD_TO_RUNSHEET_BUTTON = By.cssSelector("button.btn.btn-success.ng-scope");
    private final By ENTER_RUNSHEET_NAME  = By.xpath("//select[@class='form-control input-sm ng-pristine ng-untouched ng-valid']");

    private final By OK_BUTTON = By.xpath("//button[@ng-bind='modalNormalOptions.okButtonText']");
    private final By DOCUMENT_NOT_AVAILABLE = By.xpath("//div[text()='Document not available']");
    private final By HOME_BUTTON = By.xpath("//a[@class='home-btn']");

    private final By USER_MENU = By.xpath("//span[@class='caret']");
    private final By DROP_DOWN_MENU_DISPLAYED = By.xpath("//ul[@class='dropdown-menu show']");
    private final By COMPANY_MANAGEMENT_ADMIN_ITEM = By.xpath("//a[@href='/users/usage']");


    String successAlertMessage= "//div[contains(text(),'%s')]";

    public BookSearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param timeToWait amount of maximum seconds to wait
     *  @return boolean
     */
    public boolean waitForElementVisible(int timeToWait){
        return webDriverCommands.waitForElementVisible(FREE_TRIAL_TITLE, timeToWait);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     *
     */
    public void clickOnExplorerSearch(){
        webDriverCommands.click(EXPLORER_SEARCH_BUTTON);
    }
    /**
     *this method calls the waitForElementPresent and click method in webDriverCommands class.
     *
     *
     */
    public void clickOnHomeButton(){

        webDriverCommands.waitForElementPresent(HOME_BUTTON,300);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(HOME_BUTTON);
        webDriverCommands.waitSomeSeconds(7);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *  @param brokerBoxCounty This param has the BrokerBox County
     */
    public void clickOnCountyCombo(String brokerBoxCounty){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(COUNTY_COMBO,brokerBoxCounty);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *  @param brokerBoxBookType: This contains the Broker Box Book Type
     *  @return void
     */
    public void clickOnBookType(String brokerBoxBookType){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(BOOK_TYPE_COMBO,brokerBoxBookType);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *  @param brokerBoxIndexBook: This param contains the Broker Box Index Book value
     *  @return void
     */
    public void clickOnIndexBook(String brokerBoxIndexBook){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(INDEX_BOOK_COMBO,brokerBoxIndexBook);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *  @Param String brokerBoxBookmarks
     *  @return void
     */
    public void clickOnBookmarks(String brokerBoxBookmarks){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(BOOKMARKS_COMBO,brokerBoxBookmarks);
        webDriverCommands.waitSomeSeconds(3);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isExplorerMainPageDisplayed(){
        return webDriverCommands.waitForElementPresent(CONTRACTOR_MAIN_PAGE,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isBrokerBoxTitleDisplayed(){
        return webDriverCommands.waitForElementPresent(BROKER_BOX_TITLE,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isGrantorEnabled(){
        return webDriverCommands.waitForElementPresent(GRANTOR_LABEL,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSearchResultsWithDocuments(){
        return webDriverCommands.waitForElementPresent(FIRST_CHECKBOX,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRunsheetGridWithDocuments(){
        return webDriverCommands.waitForElementPresent(FIRST_CHECKBOX,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDocumentNotAvailable(){
        return webDriverCommands.waitForElementPresent(DOCUMENT_NOT_AVAILABLE,3);
    }

    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void insertGrantor(String contractorGrantor){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(GRANTOR, contractorGrantor);
    }

    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void insertVolume(String standardUserVolume){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(VOLUME, standardUserVolume);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void insertPage(String standardUserPage){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(PAGE, standardUserPage);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void selectRunsheetName(String runSheetName){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ENTER_RUNSHEET_NAME, runSheetName);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnGoButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(GO_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the waitForElementInVisible method in webDriverCommands class.
    *
    */
    public void isProgressBarDone() {
        webDriverCommands.waitForElementInVisible(SPINNER_POPUP, 120);
    }
    /**
     *this method calls the waitForElementInVisible method in webDriverCommands class.
     *
     */
    public void isToasterDone() {
        webDriverCommands.waitForElementInVisible(TOASTER_POPUP, 120);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void clickOnRunsheetList(String oldRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(OLD_RUNSHEET,oldRunsheet);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
     public void clickOnOKButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OK_BUTTON);
        webDriverCommands.waitSomeSeconds(5);
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
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnAddToRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ADD_TO_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public UserAdministrationPage clickOnUserAdministrationPage(){

        webDriverCommands.waitForElementClickable(USER_MENU, 300);
        webDriverCommands.click(USER_MENU);

        return PageFactory.initElements(getDriver(), UserAdministrationPage.class);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCompanyManagement(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(COMPANY_MANAGEMENT_ADMIN_ITEM);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMenuUserDisplayed(int secondsToWait){
        return webDriverCommands.waitForElementPresent(USER_MENU, secondsToWait);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void isMenuUserDisplayed(){
        webDriverCommands.waitForElementClickable(DROP_DOWN_MENU_DISPLAYED, 300);
        webDriverCommands.click(DROP_DOWN_MENU_DISPLAYED);
    }
}
