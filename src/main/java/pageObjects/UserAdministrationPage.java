package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.text.DecimalFormat;

/**
 * Created by Adrian on 11/28/2018.
 */
public class UserAdministrationPage extends PageObjects {

    private final By ADD_CONTRACTOR_BUTTON = By.id("addContractorBulk");
    private final By USER_MENU = By.xpath("//span[@class='caret']");
    private final By USER_ADMIN_ITEM = By.xpath("//a[@href='/users']");
    private final By RUNSHEET_MANAGEMENT_ITEM = By.xpath("//a[@href='/runsheet'][@role='menuitem']");
    private final By LOGOUT_ADMIN_ITEM = By.xpath("//a[@href='#']");
    private final By COMPANY_MANAGEMENT_ADMIN_ITEM = By.xpath("//a[@href='/users/management']");
    private final By USER_ADMIN_GRID = By.xpath("//section[@class='row user-container ng-scope']");

    private final By USER_COMPANY_GRID= By.xpath("//div[@class='user-grid-company-mgt ng-scope']");
    private final By CONTRACT_PAGE = By.xpath("//h3[text()='Add New Contractor User']");
    private final By SEARCH_USER_FIELD_CONTRACT = By.xpath("//div[@class='row topSpace usersBulkGridActionStyle di-arrow-grid-top ng-scope']//div//input[2]");
    private final By SEARCH_USER_FIELD = By.xpath("//input[@ng-model='gridOptions.filterOptions.filterText']");
    private final By USAGE_METRICS_TAB = By.xpath("//div[@class='diTabNav']//li//a[text()='Usage Metrics']");
    private final By METRICS_TAB = By.xpath("//div[@class='tab-container ng-scope']//li//a[text()='Metrics']");

    private final By COUNTY_TYPE = By.xpath("//select[@name='countyType']");
    private final By ARROW_RIGHT = By.xpath("//div[@class='arrowIcon arrowRight activeArrowRight']");
    private final By ARROW_LEFT = By.xpath("//div[@class='arrowIcon arrowLeft activeArrowLeft']");

    private final By USER_METRICS_GRID = By.xpath("//article[@ui-view='user-metrics']");
    private final By USER_METRICS_GRID_TITLE = By.xpath("//article[@ui-view='user-metrics']//h5[@name='Select County for details']");
    private final By USER_METRICS_TAB_TITLE = By.xpath("//article[@ui-view='user-metrics']//label[text()='Usage & Activity']");
    private final By FROM_DATE = By.xpath("//p[@class='input-group calendar-left']//input");
    private final By ACTIVITY_ROW = By.xpath("//th[@class='metrics-date-range-section col-md-12']//div[@class='diDateRangePickerContainer']");
    private final By DOCUMENTS_DOWNLOADED = By.xpath("//td[text()='Documents Downloaded']/following-sibling::td");
    private final By DOCUMENTS_PRINTED = By.xpath("//td[text()='Documents Printed']/following-sibling::td");

    private final By DOCUMENTS_DOWNLOADED_BY_METRICS = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Documents Downloaded']/following-sibling::td");
    private final By DOCUMENTS_PRINTED_BY_METRICS = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Prints']/following-sibling::td");
    private final By DOCUMENTS_ADDED_TO_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Added To Runsheet']/following-sibling::td");
    private final By DOCUMENTS_VIEWED = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Documents Viewed']/following-sibling::td");
    private final By DOCUMENTS_REMOVED_FROM_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Removed from Runsheet']/following-sibling::td");
    private final By DOCUMENTS_RENAMED_FROM_RUNSHEET = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Runsheet edits made']/following-sibling::td");
    private final By TOTAL_SEARCHES_BY_COUNTY = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByCounty']//td[2]");
    private final By TOTAL_SEARCHES_BY_TYPE =  By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByType']//td[2]");
    private final By TOTAL_SEARCHES_BY_TYPE_BB_INDEX_BOOK =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='BB Index Book']/following-sibling::div");
    private final By TOTAL_SEARCHES_BY_TYPE_BB_VOLUME_PAGE =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='BB Volume Page']/following-sibling::div");
    private final By TOTAL_SEARCHES_BY_TYPE_PR =  By.xpath("//tr[@items='userMetrics.searchesByType']//div[text()='Prior Reference']/following-sibling::div");
    private final By PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByType']//i[@class='fa fa-plus-square-o']");
    private final By PLUS_SQUARE_TOTAL_SEARCHES_BY_COUNTY = By.xpath("//article[@ui-view='user-metrics']//tr[@items='userMetrics.searchesByCounty']//i[@class='fa fa-plus-square-o']");
    private final By DURATION = By.xpath("//article[@ui-view='user-metrics']//div[@class='row metrics-table']//td[text()='Duration']/following-sibling::td");

    private final By TOTAL_DOCUMENTS_DOWNLOADED_PRINTED = By.xpath("//td[text()='Total Documents Downloaded/Printed']");

    private final By FIRST_NAME = By.xpath("//input[@name='firstName']");
    private final By LAST_NAME = By.xpath("//input[@name='lastName']");
    private final By USER_NAME = By.xpath("//input[@name='userName']");
    private final By EMAIL_USERNAME_FIELD = By.xpath("//input[@name='email']");

    private final By COMPANY_ACCT = By.xpath("//input[@name='companyAccount']");
    private final By COMPANY_ID = By.xpath("//div[@class='ngCellText ng-scope col1 colt1 centerCellHeader']//span");
    private final By FIND_COMPANY_ACCT = By.xpath("//strong['DI Internal Acct']");
    private final By MY_COMPANY = By.xpath("//input[@name='myCompany']");
    private final By RUN_SHEET_SHARING_ACCESS = By.xpath("//select[@name='runsheetSharing']");
    private final By SAVE_BUTTON = By.xpath("//button[@ng-click='save()']");
    private final By FIND_NEW_USERNAME = By.xpath("//input[@class='form-control ng-pristine ng-untouched ng-valid']");
    private final By SELECT_NEW_USERNAME = By.xpath("//div[@class='ngCanvas']");
    private final By NEW_USER_EXISTS = By.xpath("//label[@ng-bind='userSelected.userName']");
    //private final By SUCCESS_ALERT_MESSAGE = By.xpath("//div[contains(text(),'User has been successfully saved.')]");
    private final By SUCCESS_USER_UPDATE_MESSAGE = By.xpath("//div[contains(text(),'User has been successfully edited.')]");

    private final By TOTAL_ITEMS = By.xpath("//div[@class='ngFooterTotalItems']//span");
    private final By TOTAL_ITEMS_BY_ADMIN = By.xpath("//div[@class='ngFooterTotalItems ngNoMultiSelect']//span");

    private final By SEARCH_MIDLAND_MAP_COUNTY = By.xpath("//div[@di-data-assigned='assignedCounties']//input[@type='text'][@ng-model='searchItem.name']");
    private final By REMOVE_MIDLAND_MAP_COUNTY = By.xpath("//div[@di-data-assigned='assignedCounties']//input[@type='text'][@ng-model='searchItemAssign.name']");

    String find_County = "//span[text()='%s']";
    String find_Unassigned_County = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String find_Assigned_County = "//li[@ng-repeat=\"item in diDataAssigned | filter:searchItemAssign | orderBy:'name'\"][text()='%s']";
    String find_County_Type = "//option[text()='%s']";
    String contractor_Name = "//span[text()='%s']";
    String my_Company_Name = "//span[text()='%s']";
    String find_Broker_Box_County = "//div[text()='%s']//following-sibling::div";

    String my_County_Midland_Maps_Name = "//li[@ng-repeat=\"item in diData | filter:searchItem | orderBy:'name'\"][text()='%s']";
    String my_Assigned_County_Midland_Maps_Name = "//li[@ng-repeat=\"item in diDataAssigned | filter:searchItemAssign | orderBy:'name'\"][text()='%s']";

    String successAlertMessage= "//div[contains(text(),'%s')]";

    public UserAdministrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddContractorButton(){
        webDriverCommands.click(ADD_CONTRACTOR_BUTTON);
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
    public void clickOnUserAdministrationItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(USER_ADMIN_ITEM);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public RunsheetManagementPage clickOnRunsheetManagementItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(RUNSHEET_MANAGEMENT_ITEM);
        return PageFactory.initElements(getDriver(), RunsheetManagementPage.class);
    }

    /**
     *this method calls the click method in webDriverCommands class.
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
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSearchFieldAsSuperUser(String searchContractUserName){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(SEARCH_USER_FIELD_CONTRACT,searchContractUserName);
        webDriverCommands.waitSomeSeconds(5);
    }

    public void clickOnContractorName(String findMyCompanyName){
        webDriverCommands.click(By.xpath(String.format(my_Company_Name, findMyCompanyName)));
    }

    public void clickOnCountyMidlandMaps(String findCountyMidlandMap){
        webDriverCommands.click(By.xpath(String.format(my_County_Midland_Maps_Name, findCountyMidlandMap)));
        webDriverCommands.waitSomeSeconds(2);
    }

    public void clickOnAssignedCountyMidlandMaps(String findCountyMidlandMap){
        webDriverCommands.click(By.xpath(String.format(my_Assigned_County_Midland_Maps_Name, findCountyMidlandMap)));
        webDriverCommands.waitSomeSeconds(2);
    }


    public void addMidlandMapsCounty(String midlandMapCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(SEARCH_MIDLAND_MAP_COUNTY,midlandMapCounty);
    }

    public void removeMidlandMapsCounty(String midlandMapCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(REMOVE_MIDLAND_MAP_COUNTY,midlandMapCounty);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSearchFieldAsContractor(String searchContractUserName){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(SEARCH_USER_FIELD_CONTRACT,searchContractUserName);
        webDriverCommands.waitSomeSeconds(5);
    }

    public void clickOnRunsheetSharingAccess(String option){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RUN_SHEET_SHARING_ACCESS,option);
    }
    public void clickOnSaveButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SAVE_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSearchUser(String searchUser){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(SEARCH_USER_FIELD,searchUser);
        webDriverCommands.waitSomeSeconds(3);
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
    public boolean isUserMetricsTabDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(USER_METRICS_GRID);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(USER_METRICS_TAB_TITLE);
        return webDriverCommands.waitForElementPresent(USER_METRICS_TAB_TITLE,30);
    }

    public boolean isCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_County, county)),30);
    }

    public boolean isUnassignedCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Unassigned_County, county)),30);
    }

    public boolean isAssignedCountyDisplayed(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Assigned_County, county)),30);
    }

    public boolean isCountyAssigned(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Assigned_County, county)),30);
    }

    public boolean isCountyUnassigned(String county){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(find_Unassigned_County, county)),30);
    }

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
     *  @return String
     */
    public String isCompanyDisplayed(){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.getText(COMPANY_ID);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentDownloaded(){
        //workaround in the meantime CH-1077 is fixed
        int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_DOWNLOADED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }

    public String isDocumentDownloadByMetrics(){
        return webDriverCommands.getText(DOCUMENTS_DOWNLOADED_BY_METRICS);
    }

    public String isPrints(){
        return webDriverCommands.getText(DOCUMENTS_PRINTED_BY_METRICS);
    }

    public String isDocumentPrinted(){
        //return webDriverCommands.getText(DOCUMENTS_PRINTED);
        //workaround in the meantime CH-1077 is fixed
        int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_PRINTED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
    }

    public String isAddedToRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_ADDED_TO_RUNSHEET);
    }

    public String isDocumentViewed(){
        return webDriverCommands.getText(DOCUMENTS_VIEWED);
    }

    public String isRemovedFromRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_REMOVED_FROM_RUNSHEET);
    }

    public String isRenamedFromRunsheet(){
        return webDriverCommands.getText(DOCUMENTS_RENAMED_FROM_RUNSHEET);
    }

    public String isTotalSearchesByCounty(){
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_COUNTY);
    }

    public String isTotalSearchesByCountyBB(String brokerBoxCounty){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_COUNTY);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(By.xpath(String.format(find_Broker_Box_County, brokerBoxCounty)));
    }

    public String isTotalSearchesByType(){
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE);
    }

    public String isTotalSearchesByTypeBBIndexBook(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_BB_INDEX_BOOK);
    }

    public String isTotalSearchesByTypeBBVolumePage(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_BB_VOLUME_PAGE);
    }

    public String isTotalSearchesByTypePR(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(PLUS_SQUARE_TOTAL_SEARCHES_BY_TYPE);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_SEARCHES_BY_TYPE_PR);
    }

    public void clickOnCompanyRow(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(COMPANY_ID);
    }

    public void selectCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_County, county)));
    }

    public void selectUnassignedCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_Unassigned_County, county)));
    }

    public void selectAssignedCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_Assigned_County, county)));
    }

    public void clickOnUsageMetricsTab(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(USAGE_METRICS_TAB);
    }

    public void clickOnCountyTypeCombo(String countyType){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(COUNTY_TYPE, countyType);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void clickOnArrowRight(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(ARROW_RIGHT);
    }

    public void clickOnArrowLeft(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(ARROW_LEFT);
    }

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
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNewUserFound(String userName){

        return webDriverCommands.getText(NEW_USER_EXISTS).equals(userName);
    }

    /**
     *this method calls the click method in webDriverCommands class.
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
    public void addFromDate(String currentDate){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ACTIVITY_ROW);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(TOTAL_DOCUMENTS_DOWNLOADED_PRINTED);
    }
    public void addFromDateByMetric(String currentDate){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ACTIVITY_ROW);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        webDriverCommands.waitSomeSeconds(2);
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

    public String isUserFound(){
        webDriverCommands.waitSomeSeconds(2);
        String [] array = webDriverCommands.getText(TOTAL_ITEMS).split(":");

        return array[1].trim();
    }

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
