package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.text.DecimalFormat;


/**
 * Created by Adrian on 11/28/2018.
 */
public class UserAdministrationPage extends PageObjects {

    private final By ADD_CONTRACTOR_BUTTON = By.id("addContractorBulk");
    private final By BULK_ACTIONS_BUTTON = By.id("editBulk");
    private final By CHANGE_COMPANY_BUTTON = By.id("changeCompany");
    private final By USER_MENU = By.cssSelector(".caret");
    private final By USER_ADMIN_ITEM = By.cssSelector("a[href='/users']");
    private final By RUNSHEET_MANAGEMENT_ITEM = By.cssSelector("a[href='/runsheet'][role='menuitem']");
    private final By RUNSHET_SHARING_ACCESS_MESSAGE = By.cssSelector("span[ng-show='isRunsheetSharingDisabled']");
    private final By LOGOUT_ADMIN_ITEM = By.xpath("//a[@href='#']");
    private final By COMPANY_MANAGEMENT_ADMIN_ITEM = By.cssSelector("a[href*='users/management']");
    private final By USER_ADMIN_GRID = By.cssSelector("section[class='row user-container ng-scope']");
    private final By USER_COMPANY_GRID= By.cssSelector(".user-grid-company-mgt.ng-scope");
    private final By CONTRACT_PAGE = By.xpath("//h3[text()='Add New Contractor User']");
    private final By COMPANY_ACCT_POP_UP = By.cssSelector("div[class='modal-dialog']");
    private final By EDIT_EXPIRATION_DATE_DIALOG = By.cssSelector(".headerTitle");
    private final By SEARCH_USER_FIELD_CONTRACT = By.cssSelector("input[ng-model='gridOptionsMirror.filterOptions.filterText']");
    private final By SEARCH_UNASSIGN_RUNSHEET = By.xpath("//div[@di-left-title='Unassigned Runsheets']//input[@type='text'][@ng-model='searchItem.name']");
    private final By SEARCH_USER_FIELD = By.cssSelector("input[ng-model='gridOptions.filterOptions.filterText']");
    private final By USAGE_METRICS_TAB = By.cssSelector("div[class='diTabNav'] li:nth-child(2) > a");
    private final By DEMO_MANAGEMENT_TAB = By.xpath("//div[@class='diTabNav']//li//a[text()='Demo Management']");
    private final By METRICS_TAB = By.xpath("//div[@class='tab-container ng-scope']//li//a[text()='Metrics']");
    private final By COUNTY_TYPE = By.cssSelector("select[name='countyType']");
    private final By ARROW_RIGHT = By.cssSelector("div[class='arrowIcon arrowRight activeArrowRight']");
    private final By ARROW_LEFT = By.cssSelector("div[class='arrowIcon arrowLeft activeArrowLeft']");

    private final By USER_METRICS_GRID = By.cssSelector("article[ui-view='user-metrics']");
    private final By USER_METRICS_GRID_TITLE = By.cssSelector("article[ui-view='user-metrics'] h5[name='Select County for details']");
    private final By USER_METRICS_TAB_TITLE = By.xpath("//article[@ui-view='user-metrics']//label[text()='Usage & Activity']");

    private final By EDIT_DOWNLOADS_PRINTS_DIALOG = By.cssSelector("div[class='modal-content']");
    private final By EDIT_DOWNLOADS_PRINTS_TITLE = By.xpath("//div[text()='EDIT DOWNLOADS/PRINTS']");
    private final By NEW_LIMIT_NUMBER = By.cssSelector("input[name='newLimit']");
    private final By BURGER_MENU = By.cssSelector("article[ui-view='user-metrics'] div[class='ngHeaderButtonBurgerMenu']");
    private final By DOWNLOAD_PRINTS_AVAILABLE_CHECK_BOX = By.xpath("//span[text()='Downloads/Prints Available']//..//label");

    private final By USER_DEMO_MANAGEMENT_GRID_TITLE = By.cssSelector("article[ui-view='user-metrics-bulk'] h5[name='Select County for details']");

    private final By FROM_DATE = By.cssSelector("input[ng-model='diDateRangePicker.dateFrom']");
    private final By ACTIVITY_ROW = By.cssSelector("div[class='diDateRangePickerContainer']");
    private final By DOCUMENTS_DOWNLOADED = By.xpath("//td[text()='Documents Downloaded']/following-sibling::td");
    private final By DOCUMENTS_PRINTED = By.xpath("//td[text()='Documents Printed']/following-sibling::td");

    private final By DOCUMENTS_DOWNLOADED_BY_METRICS = By.xpath("//article[@ui-view='user-metrics']//td[text()='Documents Downloaded']/following-sibling::td");
    private final By DOCUMENTS_PRINTED_BY_METRICS = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Prints']/following-sibling::td");
    private final By DOCUMENTS_ADDED_TO_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Added To Runsheet']/following-sibling::td");
    private final By DOCUMENTS_VIEWED = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Documents Viewed']/following-sibling::td");
    private final By DOCUMENTS_REMOVED_FROM_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Removed from Runsheet']/following-sibling::td");
    private final By DOCUMENTS_RENAMED_FROM_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Runsheet edits made']/following-sibling::td");
    private final By TOTAL_SEARCHES_BY_COUNTY = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByCounty']//td[2]");
    private final By TOTAL_SEARCHES_BY_TYPE =  By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByType']//td[2]");
    private final By TOTAL_SEARCHES_BY_TYPE_BB_INDEX_BOOK =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='BB Index Book']/following-sibling::div");
    private final By TOTAL_SEARCHES_BY_TYPE_MIDLAND_MAP = By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='Midland Map']/following-sibling::div");
    private final By TOTAL_SEARCHES_BY_TYPE_BB_VOLUME_PAGE =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='BB Volume Page']/following-sibling::div");
    private final By TOTAL_SEARCHES_BY_TYPE_PR =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='Prior Reference']/following-sibling::div");
    private final By PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByType']//i[@class='fa fa-plus-square-o']");
    private final By PLUS_SQUARE_TOTAL_SEARCHES_BY_COUNTY = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByCounty']//i[@class='fa fa-plus-square-o']");
    private final By DURATION = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Duration']/following-sibling::td");

    private final By TOTAL_DOCUMENTS_DOWNLOADED_PRINTED = By.xpath("//td[text()='Total Documents Downloaded/Printed']");
    private final By NEW_EXPIRATION_DATE = By.xpath("//input[@name='datePicker']");
    private final By OPEN_CALENDAR_ICON = By.cssSelector("button[class='btn btn-default'][ng-click='open($event)']");
    private final By OPEN_CALENDAR = By.cssSelector("button[class='btn btn-default'][ng-click='openFrom($event)']");

    private final By FIRST_NAME = By.cssSelector("input[name='firstName']");
    private final By LAST_NAME = By.cssSelector("input[name='lastName']");
    private final By USER_NAME = By.cssSelector("input[name='userName']");
    private final By EMAIL_USERNAME_FIELD = By.cssSelector("input[name='email']");

    private final By COMPANY_ACCT = By.xpath("//input[@name='companyAccount']");
    private final By SELECT_COMPANY_ACCT = By.cssSelector("input[name='companyAccount'][ng-model='modalAlertOptions.companyAccount']");
    private final By COMPANY_ID = By.cssSelector("div[class='ngCellText ng-scope col1 colt1 centerCellHeader']");
    private final By FIND_COMPANY_ACCT = By.xpath("//strong['DI Internal Acct']");
    private final By OK_BUTTON = By.cssSelector("button[ng-show='modalAlertOptions.showOkButton']");
    private final By CANCEL_BUTTON = By.cssSelector("button[ng-show='modalAlertOptions.showCancelButton']");
    private final By PAGE_FORWARD = By.cssSelector("div[class='ngPagerContainer'] button[ng-click='pageForward()']");
    private final By MY_COMPANY = By.cssSelector("input[name='myCompany']");
    private final By RUN_SHEET_SHARING_ACCESS = By.cssSelector("select[name='runsheetSharing']");
    private final By SAVE_BUTTON = By.cssSelector("button[ng-click='save()']");
    private final By EXPIRATION_DATE_SAVE_BUTTON = By.cssSelector("button[ng-show='modalAlertOptions.showOkButton']");
    private final By FIND_NEW_USERNAME = By.cssSelector("article[ui-view='user-grid'] input[class='form-control ng-pristine ng-untouched ng-valid']");
    private final By SELECT_NEW_USERNAME = By.cssSelector("div[di-grid='gridOptions'] div[class='ngCanvas']");
    private final By NEW_USER_EXISTS = By.cssSelector("label[ng-bind='userSelected.userName']");
    private final By SUCCESS_USER_UPDATE_MESSAGE = By.xpath("//div[contains(text(),'User has been successfully edited.')]");

    private final By TOTAL_ITEMS = By.xpath("//div[@class='ngFooterTotalItems']//span");
    private final By TOTAL_USERS = By.xpath("//div[@class='ngFooterTotalItems']//span[@class='ngLabel ng-binding']");
    private final By TOTAL_ITEMS_BY_ADMIN = By.xpath("//div[@class='ngFooterTotalItems ngNoMultiSelect']//span");

    private final By SEARCH_MIDLAND_MAP_COUNTY = By.xpath("//div[@di-data-assigned='assignedCounties']//input[@type='text'][@ng-model='searchItem.name']");
    private final By SEARCH_UNASSIGNED_COUNTY = By.xpath("//div[@di-data-assigned='assignedCounties']//input[@type='text'][@ng-model='searchItem.name']");
    private final By REMOVE_MIDLAND_MAP_COUNTY = By.xpath("//div[@di-data-assigned='assignedCounties']//input[@type='text'][@ng-model='searchItemAssign.name']");
    private final By EDIT_BUTTON= By.cssSelector("div.ng-scope.ngRow.even.selected div[ng-click='diGrid.onEditRow(row, $event)']");
    private final By SPINNER = By.cssSelector("div[class='spinner'][role='progressbar']");

    String find_County = "//span[text()='%s']";
    String find_County_Name = "//b[text()='%s']";
    String find_Unassigned_County = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String find_Unassigned_Runsheet = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String find_Assigned_County = "//li[@ng-repeat=\"item in diDataAssigned | filter:searchItemAssign | orderBy:'name'\"][text()='%s']";
    String find_County_Type = "//option[text()='%s']";
    String contractor_Name = "//span[text()='%s']";
    String my_Company_Name = "//span[text()='%s']";
    String find_Broker_Box_County = "//div[text()='%s']//following-sibling::div";
    String find_Midland_Map_County = "//div[text()='%s']//following-sibling::div";

    String tomorrow_Date = "//td[not(contains(@class,'datePicker'))]//span[text()='%s'][@class='ng-binding']";
    String today_Date = "//td[not(contains(@class,'datePicker'))]//span[text()='%s'][@class='ng-binding text-info']";
    String tomorrow_Disabled_Date = "//td[not(contains(@class,'datePicker'))]//span[text()='%s'][@class='ng-binding text-muted']";

    private final By DOWNLOADS_USED = By.cssSelector("div.ng-scope.ngRow.odd.selected div[class='ngCellText ng-scope col3 colt3 centerCellHeader']");
    private final By PRINTS_USED = By.cssSelector("div.ng-scope.ngRow.odd.selected div[class='ngCellText ng-scope col4 colt4 centerCellHeader']");
    private final By EDIT_LIMIT_BUTTON = By.cssSelector("div.ng-scope.ngRow.odd.selected div[class='ngCellText text-center edit-btn ng-scope']");
    private final By LIMIT_REACHED_MESSAGE = By.cssSelector("div.ng-scope.ngRow.odd.selected div[class='ngCellText ng-scope col5 colt5 centerCellHeader']");

    String my_County_Midland_Maps_Name = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String my_Unassigned_County = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String my_Assigned_County_Midland_Maps_Name = "//li[@ng-repeat=\"item in diDataAssigned | filter:searchItemAssign | orderBy:'name'\"][text()='%s']";
    String successAlertMessage= "//div[contains(text(),'%s')]";

    //String clickCheckBox = "//div[@di-grid='gridOptionsMirror']//div[@style='top: %spx; height: 30px;']//div[@class='ngCell  col0 colt0']";
    String clickCheckBox = "div.row.alignGrid.di-arrow-row-grid.users-grid-bulk.ng-scope > div:nth-child(3) > div > div.ngViewport.ng-scope > div > div:nth-child(%s) > div.ngCell.col0.colt0";
    String runsheetSharingAccessMessage = "Super users have full access to runsheet sharing. To update runsheet sharing permissions for Contractor or Standard users please unselect all Super users.";

    /**
     * This method uses the PageFactory desing pattern, to direct to another pageObject.
     *  @return UserAdministrationPage
     */
    public UserAdministrationPage clickOnUserAdministrationPage(){

        webDriverCommands.waitForElementClickable(USER_MENU, 300);
        webDriverCommands.click(USER_MENU);

        return PageFactory.initElements(getDriver(), UserAdministrationPage.class);
    }

    public UserAdministrationPage(WebDriver driver) {
        super(driver);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnAddContractorButton(){
        webDriverCommands.click(ADD_CONTRACTOR_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnBulkActionsButton(){
        webDriverCommands.click(BULK_ACTIONS_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCancelButton(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(CANCEL_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnNextPage(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PAGE_FORWARD);
        webDriverCommands.waitSomeSeconds(2);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnChangeCompanyButton(){
        webDriverCommands.click(CHANGE_COMPANY_BUTTON);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMenuUserDisplayed(int secondsToWait){
        return webDriverCommands.waitForElementPresent(USER_MENU, secondsToWait);
    }

    /**
     *this method calls the waitForElementPresent and click method in webDriverCommands class.
     */
    public void clickOnUserAdministrationMenu(){
        webDriverCommands.waitForElementClickable(USER_MENU, 300);
        webDriverCommands.click(USER_MENU);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnUserAdministrationItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(USER_ADMIN_ITEM);
    }

    /**
     * This method uses the PageFactory desing pattern, to direct to another pageObject.
     *  @return RunsheetManagementPage
     */
    public RunsheetManagementPage clickOnRunsheetManagementItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(RUNSHEET_MANAGEMENT_ITEM);
        return PageFactory.initElements(getDriver(), RunsheetManagementPage.class);
    }

    /**
     * This method uses the PageFactory desing pattern, to direct to another pageObject.
     *  @return LoginPage
     */
    public LoginPage clickOnLogoutItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(LOGOUT_ADMIN_ITEM);
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCompanyManagement(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(COMPANY_MANAGEMENT_ADMIN_ITEM);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnSearchFieldAsSuperUser(String searchContractUserName){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(SEARCH_USER_FIELD_CONTRACT,searchContractUserName);
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.waitForElementInVisible(SPINNER,90);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnUnassignedRunsheetsField(String searchUnassignRunsheetName){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(SEARCH_UNASSIGN_RUNSHEET,searchUnassignRunsheetName);
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.waitForElementInVisible(SPINNER,10);
    }



    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnContractorName(String findMyCompanyName){
        webDriverCommands.click(By.xpath(String.format(my_Company_Name, findMyCompanyName)));
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCountyMidlandMaps(String findCountyMidlandMap){
        webDriverCommands.click(By.xpath(String.format(my_County_Midland_Maps_Name, findCountyMidlandMap)));
        webDriverCommands.waitSomeSeconds(2);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnUnassignedCounty(String findCounty){
        webDriverCommands.click(By.xpath(String.format(my_Unassigned_County, findCounty)));
        webDriverCommands.waitSomeSeconds(2);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnAssignedCountyMidlandMaps(String findCountyMidlandMap){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(my_Assigned_County_Midland_Maps_Name, findCountyMidlandMap)));
        webDriverCommands.waitSomeSeconds(2);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void addMidlandMapsCounty(String midlandMapCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(SEARCH_MIDLAND_MAP_COUNTY,midlandMapCounty);
        //selectDropDownOptionByValue(SEARCH_MIDLAND_MAP_COUNTY,midlandMapCounty);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void searchUnAssignedCounty(String searchCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(SEARCH_UNASSIGNED_COUNTY,searchCounty);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void removeMidlandMapsCounty(String midlandMapCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(REMOVE_MIDLAND_MAP_COUNTY,midlandMapCounty);
        //selectDropDownOptionByValue(REMOVE_MIDLAND_MAP_COUNTY,midlandMapCounty);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnSearchFieldAsContractor(String searchContractUserName){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(SEARCH_USER_FIELD_CONTRACT,searchContractUserName);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnRunsheetSharingAccess(String option){
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.type(RUN_SHEET_SHARING_ACCESS,option);
        Select dropdown = new Select(webDriverCommands.findElement(RUN_SHEET_SHARING_ACCESS));
        dropdown.selectByValue(option);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSaveButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SAVE_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnExpirationDateSaveButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(EXPIRATION_DATE_SAVE_BUTTON);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnSearchUser(String searchUser){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(SEARCH_USER_FIELD,searchUser);
        webDriverCommands.waitSomeSeconds(3);
        //wait until spinner is gone
        webDriverCommands.waitForElementInVisible(SPINNER,90);
    }

    public String getTotalItems(){
        webDriverCommands.waitSomeSeconds(2);
        String [] array = webDriverCommands.getText(TOTAL_USERS).split(":");
        return array[1].trim();
    }
    /**
     *this method calls the getText method in webDriverCommands class.
     * return String with the total of downloads used
     */
    public String getTotalDownloadsUsed(){
        return webDriverCommands.getText(DOWNLOADS_USED);
    }
    /**
     *this method calls the getText method in webDriverCommands class.
     * return String with the total of prints used
     */
    public String getTotalPrintsUsed(){
        return webDriverCommands.getText(PRINTS_USED);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void selectCompanyAcct(String companyID){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(SELECT_COMPANY_ACCT,companyID);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnCompanyAcctName(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(FIND_COMPANY_ACCT);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OK_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnRow(Integer firstColumn){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(By.cssSelector(String.format(clickCheckBox, Integer.toString(firstColumn))));
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUserAdminGridDisplayed(){
        return webDriverCommands.waitForElementPresent(USER_ADMIN_GRID,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUserGridCompanyDisplayed(){
        return webDriverCommands.waitForElementPresent(USER_COMPANY_GRID,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUserMetricsGridDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(USER_METRICS_GRID);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(USER_METRICS_GRID_TITLE);
        return webDriverCommands.waitForElementPresent(USER_METRICS_GRID_TITLE,30);
    }


    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUserDemoManamentGridDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.waitForElementPresent(USER_DEMO_MANAGEMENT_GRID_TITLE,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUserMetricsTabDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(USER_METRICS_GRID);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(USER_METRICS_TAB_TITLE);
        return webDriverCommands.waitForElementPresent(USER_METRICS_TAB_TITLE,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_County, county)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUnassignedCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Unassigned_County, county)),5);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUnassignedRunsheetDisplayed(String unassignedRunsheet){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Unassigned_Runsheet, unassignedRunsheet)),5);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public void clickOnUnassignedRunsheets(String unassignedRunsheet){
        webDriverCommands.click(By.xpath(String.format(find_Unassigned_Runsheet, unassignedRunsheet)));
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isAssignedCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Assigned_County, county)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyAssigned(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Assigned_County, county)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyUnassigned(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Unassigned_County, county)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyTypeSelected(String countyType){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_County_Type, countyType)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isContractPageDisplayed(){
        return webDriverCommands.waitForElementPresent(CONTRACT_PAGE,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCompanyAcctPopUpDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(COMPANY_ACCT_POP_UP,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCompanyAcctNameDisplayed(){
        return webDriverCommands.waitForElementPresent(FIND_COMPANY_ACCT,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRunsheetSharingMessageDisplayed(){
        String label_Text = webDriverCommands.getText(RUNSHET_SHARING_ACCESS_MESSAGE);
        webDriverCommands.waitSomeSeconds(1);

        if (label_Text.equals(runsheetSharingAccessMessage)) {
            return true;
        }else {
            return false;
        }
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isEditExpirationDateDialogDisplayed(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(EDIT_EXPIRATION_DATE_DIALOG,10);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyNameDisplayed(String countyOnDemoMode){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_County_Name, countyOnDemoMode)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return String
     */
    public String isCompanyDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.getText(COMPANY_ID);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return boolean if the getText() returns the same value than "Limit Reached"
     */
    public boolean isLimitReachedMessageDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.getText(LIMIT_REACHED_MESSAGE).equals("Limit Reached");
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDownloadsPrintsDialogDisplayed(String limitReachedCounty){
        webDriverCommands.waitSomeSeconds(2);
        if (webDriverCommands.waitForElementPresent(EDIT_DOWNLOADS_PRINTS_DIALOG,10)){
            return webDriverCommands.waitForElementPresent(EDIT_DOWNLOADS_PRINTS_TITLE,10);
        }else {
            return false;
        }
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentDownloaded(){
        //workaround in the meantime CH-1077 is fixed
        int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_DOWNLOADED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentDownloadByMetrics(){
        return webDriverCommands.getText(DOCUMENTS_DOWNLOADED_BY_METRICS);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isPrints(){
        return webDriverCommands.getText(DOCUMENTS_PRINTED_BY_METRICS);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentPrinted(){
        //return webDriverCommands.getText(DOCUMENTS_PRINTED);
        //workaround in the meantime CH-1077 is fixed
        int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_PRINTED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isAddedToRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_ADDED_TO_RUNSHEET);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentViewed(){
        return webDriverCommands.getText(DOCUMENTS_VIEWED);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isRemovedFromRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_REMOVED_FROM_RUNSHEET);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isRenamedFromRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_RENAMED_FROM_RUNSHEET);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByCounty(){
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_COUNTY);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByCountyBB(String brokerBoxCounty){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_COUNTY);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(By.xpath(String.format(find_Broker_Box_County, brokerBoxCounty)));
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByCountyMidlandMaps(String midlandMapCounty){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_COUNTY);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(By.xpath(String.format(find_Midland_Map_County, midlandMapCounty)));
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByType(){
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByTypeBBIndexBook(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_BB_INDEX_BOOK);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */

    public String isTotalSearchesByTypeMidlandMap(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_MIDLAND_MAP);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByTypeBBVolumePage(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_BB_VOLUME_PAGE);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isTotalSearchesByTypePR(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_PR);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnCompanyRow(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(COMPANY_ID);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnChangeLimitButton(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(EDIT_LIMIT_BUTTON);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void selectCounty(String county){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(By.xpath(String.format(find_County, county)));
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnBurgerMenu(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(BURGER_MENU);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnDownloadsAndPrintsAvailableCheckBox(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(DOWNLOAD_PRINTS_AVAILABLE_CHECK_BOX);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void addNewLimitNumber(int total){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(NEW_LIMIT_NUMBER);
        total = total + 1;
        webDriverCommands.type(NEW_LIMIT_NUMBER, Integer.toString(total));
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(OK_BUTTON);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void selectUnassignedCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_Unassigned_County, county)));
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void selectAssignedCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_Assigned_County, county)));
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
    */
    public void clickOnUsageMetricsTab(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(USAGE_METRICS_TAB);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
    */
    public void clickOnDemoManagementTab(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(DEMO_MANAGEMENT_TAB);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementInVisible(SPINNER,30);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnEditButton(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(EDIT_BUTTON);
    }
    /**
     *this method calls the type() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnCountyTypeCombo(String countyType){
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.type(COUNTY_TYPE, countyType);
        selectDropDownOptionByValue(COUNTY_TYPE,countyType);
        webDriverCommands.waitSomeSeconds(3);
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
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnArrowRight(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(ARROW_RIGHT);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnArrowLeft(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(ARROW_LEFT);
    }
    /**
     *this method calls the click() method in webDriverCommands class.
     *
     *  @return String
     */
    public void clickOnMetricsTab(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(METRICS_TAB);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    /*public boolean isSuccessMessageDisplayed(){
        return webDriverCommands.waitForElementPresent(SUCCESS_ALERT_MESSAGE,30);
    }*/

    public boolean isSuccessMessageDisplayed(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successAlertMessage,successMessage)),15);
    }


    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSuccessUserUpdatedDisplayed(){
        return webDriverCommands.waitForElementPresent(SUCCESS_USER_UPDATE_MESSAGE,30);
    }

    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNewUserFound(String userName){

        return webDriverCommands.getText(NEW_USER_EXISTS).equals(userName);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void insertName(String firstName, String lastName){
        webDriverCommands.type(FIRST_NAME,firstName);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(LAST_NAME, lastName);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     *@param emailUserName info to enter in the username's field
     */
    public void insertEmailUserName(String emailUserName){
        webDriverCommands.type(EMAIL_USERNAME_FIELD, emailUserName);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void addFromDate(String currentDate) throws ParseException{
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ACTIVITY_ROW);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(TOTAL_DOCUMENTS_DOWNLOADED_PRINTED);
      /*  webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        //webDriverCommands.click(OPEN_CALENDAR);
        webDriverCommands.waitSomeSeconds(1);

        // Provide the day of the month to select the date.
        //SelectDayFromMultiDateCalendar(currentDate,"today");
        //webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(TOTAL_DOCUMENTS_DOWNLOADED_PRINTED);*/
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void selectCurrentDateOLD(String currentDate,String extraFilter) throws ParseException{

        webDriverCommands.click(OPEN_CALENDAR_ICON);
        webDriverCommands.waitSomeSeconds(1);

        // Provide the day of the month to select the date.
        //SelectDayFromMultiDateCalendar(currentDate,extraFilter);

    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void addNewExpirationDate(String currentDate){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(NEW_EXPIRATION_DATE);
        //webDriverCommands.typeJS(NEW_EXPIRATION_DATE, currentDate);
        webDriverCommands.type(NEW_EXPIRATION_DATE, currentDate);
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.tab(NEW_EXPIRATION_DATE);*/
       /* webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(NEW_EXPIRATION_DATE);
        webDriverCommands.type(NEW_EXPIRATION_DATE, currentMonth);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(NEW_EXPIRATION_DATE, currentDay);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(NEW_EXPIRATION_DATE, currentYear);
        webDriverCommands.waitSomeSeconds(1);*/
    }

    // Function to select the day of month in the date picker.
    public void SelectDayFromMultiDateCalendar_OLD(String currentDate,String extraFilter) throws ParseException {
        // We are using a special XPath style to select the day of current
        // month.
        // It will ignore the previous or next month day and pick the correct
        // one.
        String[] arrayDate = currentDate.split("\\.");

        if (extraFilter.equals("today")){
            By calendarXpath = By.xpath(String.format(today_Date, arrayDate[1]));
            driver.findElement(calendarXpath).click();
            webDriverCommands.waitSomeSeconds(1);
        }else{
            if (extraFilter.equals("tomorrow")) {
                By calendarXpath = By.xpath(String.format(tomorrow_Date, arrayDate[1]));
                driver.findElement(calendarXpath).click();
                webDriverCommands.waitSomeSeconds(1);
                driver.findElement(NEW_EXPIRATION_DATE).click();
                webDriverCommands.waitSomeSeconds(1);
                String newDate = webDriverCommands.getText(NEW_EXPIRATION_DATE);
                //Parsing the given String to Date object
                Date date1 = new SimpleDateFormat("dd.mm.yyyy").parse(newDate);
                Date date2 = new SimpleDateFormat("dd.mm.yyyy").parse(currentDate);
                //Compare two dates

                if (date1.compareTo(date2) < 0) {
                    webDriverCommands.click(OPEN_CALENDAR_ICON);
                    calendarXpath = By.xpath(String.format(tomorrow_Disabled_Date, arrayDate[1]));
                    driver.findElement(calendarXpath).click();
                    webDriverCommands.waitSomeSeconds(1);                }
            }
        }
    }

    /**
     *this method calls the type method in webDriverCommands class.
     */
    //public void addFromDateByMetric(String currentDate, String extraFilter) throws ParseException{
    public void addFromDateByMetric(String currentDate) throws ParseException{
/*        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ACTIVITY_ROW);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(DURATION);*/
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        //webDriverCommands.click(OPEN_CALENDAR);
        webDriverCommands.waitSomeSeconds(1);

        // Provide the day of the month to select the date.
        //SelectDayFromMultiDateCalendar(currentDate,extraFilter);
        //webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(DURATION);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *@param userName info to enter in the username's field
     */
    public void insertUserName(String userName){
        webDriverCommands.type(USER_NAME, userName);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *@param userName info to enter in the username's field
     */
    public void selectNewUserName(String userName){
        //webDriverCommands.click(FIND_NEW_USERNAME);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FIND_NEW_USERNAME, userName);
        //Wait in order to see the user in the grid user
        webDriverCommands.waitSomeSeconds(4);
        webDriverCommands.click(SELECT_NEW_USERNAME);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void insertCompanyInfo(String companyAcct, String myCompany){
        webDriverCommands.type(COMPANY_ACCT,companyAcct);
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(FIND_COMPANY_ACCT);
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(MY_COMPANY, myCompany);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *@param runsheetSharingAccess info to enter in the username's field
     */
    public void insertRunsheetSharingAccess(String runsheetSharingAccess){
        webDriverCommands.click(RUN_SHEET_SHARING_ACCESS);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RUN_SHEET_SHARING_ACCESS, runsheetSharingAccess);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     * return the total of items for the specified user
     */
    public String isUserFound(){
        webDriverCommands.waitSomeSeconds(2);
        String [] array = webDriverCommands.getText(TOTAL_ITEMS).split(":");

        return array[1].trim();
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     * return the total of items for the specified user
     */
    public String isUserFoundByAdmin(){
        webDriverCommands.waitSomeSeconds(3);
        String [] array = webDriverCommands.getText(TOTAL_ITEMS_BY_ADMIN).split(":");

        return array[1].trim();
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickSaveButton(){

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", SAVE_BUTTON);*/
        /*if(webDriverCommands.waitForElementVisible(SAVE_BUTTON,30)) {
            //waitForElementInVisible(By.id("PulsePopupTransparency"));
            //webDriverCommands(By.className("PulsePopupTransparency"), 30);
           driver.findElement(SAVE_BUTTON).click();
        }*/
        webDriverCommands.click(SAVE_BUTTON);
    }
}
