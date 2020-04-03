package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Adrian on 11/30/2018.
 */
public class ExplorerPage extends PageObjects {
    /**
     *Web elements for UserPage
     */

    private final By FREE_TRIAL_TITLE = By.xpath("//h2[text()='Save time and gas money by accessing court documents online.']");
    private final By EXPLORER_SEARCH_BUTTON = By.cssSelector(".fa-search");
    private final By BOOK_SEARCH_BUTTON = By.cssSelector("a[ng-click='activateBookSearchFilter()']");
    private final By MIDLAND_MAPS_SEARCH_BUTTON = By.cssSelector("a[ng-click='activateMidlandFilter()']");
    private final By PRIOR_REFERENCE_SEARCH_BUTTON = By.cssSelector("a[ng-click='activateVolPageFilter()']");
    private final By COUNTY_COMBO = By.cssSelector("aside[ui-view='filters'] select[name='countyParishId']");
    private final By PR_COUNTY_COMBO = By.cssSelector("form[ng-submit='applyFilterVolPage($event)'] select[name='countyParishId']");
    private final By CONTRACTOR_MAIN_PAGE = By.xpath("//h5[@name='Search Results']");
    private final By EXPLORE_TITLE = By.xpath("//h4[text()='EXPLORE']");
    private final By COMPANY_USAGE_DIALOG = By.cssSelector("div[class='slideOut']");
    private final By USAGE_PROGRESS_BAR = By.cssSelector("div[value='diHeaderMeterGraphOptions.county.usage']");
    private final By CLOSE_COMPANY_USAGE_DIALOG = By.cssSelector("label[class='slideOutClose']");

    private final By PRIOR_REFERENCE_TITLE = By.xpath("//h4[text()='PRIOR REFERENCE']");
    private final By GRANTOR_LABEL = By.cssSelector("label[for='grantor']");
    private final By GRANTOR = By.cssSelector("input[name='grantor']");
    private final By GRANTEE = By.cssSelector("input[name='grantee']");
    private final By GRANTOR_GRANTEE = By.cssSelector("input[name='granteeorgrantor']");
    private final By VOLUME = By.cssSelector("input[name='volume']");
    private final By PAGE = By.cssSelector("input[name='page']");
    private final By INSTRUMENT_NUMBER = By.cssSelector("input[name='instNumber']");
    private final By BOOK_TYPE = By.cssSelector("select[name='bookType']");
    private final By ABSTRACT = By.cssSelector("input[name='abstract']");
    private final By SURVEY = By.cssSelector("input[name='survey']");
    private final By SECTION = By.cssSelector("input[name='section']");
    private final By TOWNSHIP = By.cssSelector("input[name='township']");
    private final By RANGE_BLOCK = By.cssSelector("input[name='range']");
    private final By QUARTER_CALL = By.cssSelector("input[name='quarterCall']");
    private final By SUBDIVISION = By.cssSelector("input[name='subdivision']");
    private final By LOT = By.cssSelector("input[name='lot']");
    private final By BLOCK = By.cssSelector("input[name='block']");
    private final By SLIDER = By.cssSelector("div.ngrs-runner");
    private final By ACRES_MIN = By.cssSelector("input[ng-model='modelTypeMin']");
    private final By ACRES_MAX = By.cssSelector("input[ng-model='modelTypeMax']");
    private final By INST_TYPE = By.cssSelector("input[name='instType']");
    private final By RECORD_NUMBER = By.cssSelector("input[name='instNumber']");
    private final By PROPERTY_DESCRIPTION = By.cssSelector("input[name='propertyDescription']");
    private final By APPLY_BUTTON = By.cssSelector("aside[ui-view='filters'] button[class='btn btn-primary']");
    private final By PRIOR_REFERENCE_APPLY_BUTTON = By.cssSelector("div[class='form-group pull-right filter-buttons'] button[class='btn btn-primary'][ng-disabled='isRequired || disabledButton']");
    private final By FIRST_CHECKBOX = By.cssSelector("div.ngCell.col0.colt0");
    private final By ROW_DETAIL_DIALOG = By.xpath("//h3[text()='Row Detail']");
    private final By NEW_RUNSHEET_BUTTON = By.cssSelector("button[ng-click='newRunsheetBtn()']");
    private final By CANCEL_BUTTON = By.cssSelector("button[ng-click='cancel()']");
    private final By ROW_DETAIL_ADD_TO_RUNSHEET_BUTTON = By.cssSelector("button[ng-click='ok()']");
    private final By REPORT_CHARGES_BUTTON =  By.cssSelector("button[class='btn btn-warning btn-sm inline-block']");
    private final By OLD_RUNSHEET = By.cssSelector("select[class='form-control input-sm inline-block runsheet-select ng-pristine ng-untouched ng-valid']");
    private final By NEW_RUNSHEET = By.cssSelector("select[class='form-control input-sm inline-block runsheet-select ng-valid ng-dirty ng-valid-parse ng-touched']");
    private final By SAVE_RUNSHEET_BUTTON = By.cssSelector("button[ng-bind='runsheetCreateEditBtnTxt']");
    private final By ADD_TO_RUNSHEET_BUTTON = By.cssSelector("button[ng-click='addToRunsheet(selectedItems)']");
    private final By ENTER_RUNSHEET_NAME  = By.cssSelector("input[ng-model='newRunsheet.name']");
    private final By REMOVE_BUTTON = By.cssSelector("button[class='btn btn-danger btn-sm remove_border ng-binding']");
    private final By REMOVE_POP_UP_DIALOG = By.cssSelector("form[class='form-horizontal alignForm ng-pristine ng-valid']");
    private final By REMOVE_POP_UP_BUTTON = By.cssSelector("button[ng-bind='modalDeleteOptions.deleteButtonText']");
    private final By REMOVE_FREE_TRIAL_POP_UP_BUTTON = By.cssSelector("button[ng-bind='modalMoneyOptions.okButtonText']");
    private final By FIRST_REMOVE_COLUMN_BUTTON = By.cssSelector("div[class='text-center delete-btn ng-scope'] i[class='fa fa-times']");
    private final By RENAME_BUTTON = By.cssSelector("i[class='fa fa-pencil-square-o']");
    private final By EDIT_RUNSHEET_BUTTON = By.cssSelector("button[class='btn btn-primary btn-sm ng-binding']");
    private final By RENAME_RUNSHEET = By.cssSelector("input[name='runsheetName']");
    private final By INDEX_WITH_IMAGES = By.cssSelector("select[ng-model='downloadOptionSelected']");
    private final By DOWNLOAD_ALL_BUTTON = By.cssSelector("button[ng-click='downloadRunsheet()']");
    private final By DOWNLOADS_PRINTS_POP_UP_DIALOG = By.cssSelector("div[ng-if='modalAlertOptions.displayImg']");
    private final By MAX_USAGE_REACHED_MESSAGE_DISPLAYED = By.xpath("//di-meter-graph[@di-meter-graph-options='modalAlertOptions.usageMeterOptions']//div[@class='dangerIconSpace']");
    private final By TOTAL_DOWNLOADS = By.cssSelector("span[ng-bind='diMeterGraphOptions.county.downloadsUsed | number']");
    private final By TOTAL_PRINTS = By.cssSelector("span[ng-bind='diMeterGraphOptions.county.printsUsed | number']");
    private final By OK_BUTTON = By.cssSelector("button[ng-bind='modalAlertOptions.okButtonText']");
    private final By REPORT_ISSUE_BUTTON = By.cssSelector("button[class='btn btn-warning btn-sm remove_border']");
    private final By REPORT_ISSUE_DIALOG = By.cssSelector("div[ng-bind='modalAlertOptions.headerText']");
    private final By FIRST_COUNTY = By.xpath("//select[@name='countyIdIR']//option[@value=\"0\"]");
    private final By SELECT_COUNTY = By.xpath("//select[@name='countyIdIR']");
    private final By RI_VOLUME= By.cssSelector("input[name='volumeIR']");
    private final By RI_PAGE= By.cssSelector("input[name='pageIR']");
    private final By RI_INST_NUMBER= By.cssSelector("input[name='instNumberIR']");
    private final By RI_BOOK_TYPE= By.cssSelector("input[name='bookTypeIR']");
    private final By RI_INST_TYPE= By.cssSelector("input[name='instrumentTypeIR']");
    private final By RI_ISSUE_TYPE= By.cssSelector("select[name='issueTypeIR']");
    private final By RI_NOTES= By.cssSelector("textarea[name='notesIR']");
    private final By OK_PURCHASE_CONFIRMATION_BUTTON= By.cssSelector("button[class='btn btn-success ng-binding']");
    private final By SPINNER = By.xpath("//div[@class='spinner']");
    private final By SPINNER_PROGRESS = By.cssSelector("div[class='spinner'][role='progressbar']");
    private final By SPINNER_RUNSHEET_PROGRESS = By.xpath("//span[@us-spinner='spinnerConf'][@spinner-key='runsheet-spinner']//div[@role='progressbar']");
    private final By PRINT_SPINNER= By.xpath("//section[@di-pdf-viewer='pdfViewerOptions']//div[@class='spinner']");
    private final By PRINT_BUTTON_ENABLED = By.cssSelector("button[class='toolbarButton printPdf'][disabled='disabled']");
    private final By VIEWER_LINK = By.cssSelector("div.ngCell.col1.colt1");
    private final By CLOSE_STANDALONE_PDF = By.cssSelector("button[class='toolbarButton closePdf']");
    private final By SET_PREFERENCE = By.xpath("//button[text()='Set preference']");
    private final By DELETE_RUNSHEET_BUTTON = By.cssSelector("button[class='btn btn-danger btn-sm inline-block']");
    private final By CANVAS_LOADED = By.cssSelector("canvas[class=rotate0][height]");
    //private final By PDF_SPINNER = By.cssSelector("spinner[class='medium-spinner']");
    private final By CLOSE_EMBEDDED_PDF = By.cssSelector("section[di-pdf-viewer='pdfViewerOptions'] button[class='toolbarButton closePdf']");
    private final By DELETE_RUNSHEET = By.cssSelector("button[ng-bind='modalDeleteOptions.deleteButtonText']");
    private final By DELETE_RUNSHEET_DIALOG = By.cssSelector("div[ng-bind-html='modalDeleteOptions.deleteText | toTrustedHtml']");
    private final By UNASSIGN_RUNSHEET_DIALOG = By.xpath("//div[contains(text(),'You are unassigning a runsheet (test_one_county) from your account and will need a Super User to add it back. Do you want to proceed?')]");
    private final By DOCUMENT_NOT_AVAILABLE = By.xpath("//div[text()='Document not available']");
    private final By CHECK_BOX_DO_NOT_SHOW_AGAIN = By.cssSelector("div[class='modal-header warningModalHeader ng-scope']");
    private final By PDF_VIEWER_PREFERENCE = By.xpath("//div[text()='PDF Viewer Preference']");
    private final By PRINT_BUTTON = By.cssSelector(".toolbarButton.printPdf");
    private final By UPDATE_INFO_BUTTON = By.cssSelector("button[class='btn btn-success pull-right']");
    private final By HOME_BUTTON = By.cssSelector("a[class='home-btn']");

    private final By AVAILABLE_BALANCE = By.cssSelector("span[class='positiveBalance ng-binding']");

    private final By USER_MENU = By.cssSelector(".caret");
    private final By MY_ACCOUNT_PAGE = By.cssSelector("h3[ng-bind='userSelected.personalInformation.fullName']");
    private final By USER_CONTRACT_MY_ACCOUNT_ITEM = By.xpath("//a[@href='/users/myaccount']");
    private final By DROP_DOWN_MENU_DISPLAYED = By.xpath("//ul[@class='dropdown-menu show']");
    private final By COUNTY_GRID_LIST = By.cssSelector("h5[name='Select County for details']");
    private final By SELECTED_PDF_VIEWER = By.cssSelector("label[class='btn btn-default ng-pristine ng-untouched ng-valid ng-binding active']");
    private final By EMBEDDED_BUTTON = By.xpath("//label[@ng-bind='viewerArray[0].selectName']");
    private final By STANDALONE_BUTTON = By.xpath("//label[@ng-bind='viewerArray[1].selectName']");

    private final By MY_COMPANY_RUNSHEET_COMBO = By.cssSelector("select[class='form-control input-sm inline-block runsheet-select runsheet-type ng-pristine ng-untouched ng-valid']");
    private final By MY_COMPANY_RUNSHEET_ITEM = By.cssSelector("input[name='myCompanyRunsheets']");
    private final By MY_COMPANY_RUNSHEETS_NAME = By.cssSelector("input[class='form-control input-sm inline-block runsheet-select-type-ahead ng-pristine ng-untouched ng-valid ng-valid-editable']");
    private final By MY_COMPANY_RUNSHEETS_NO_ACCESS = By.cssSelector("div[ng-show='runsheetSharingAccess !== noAccess']");
    private final By COMPANY_MANAGEMENT_ADMIN_ITEM = By.cssSelector("a[href*='users/usage']");
    private final By REQUEST_COPY_BUTTON = By.cssSelector("button[ng-show='currentRunsheet && runsheetSharingAccess === requestCopyIndex']");
    private final By MAKE_A_COPY = By.cssSelector("button[ng-show='currentRunsheet && runsheetSharingAccess === fullAccessIndex']");
    private final By CONFIRMATION_ALERT_CANCEL_BUTTON = By.cssSelector("button[ng-show='modalAlertOptions.showCancelButton']");
    private final By CONFIRMATION_ALERT_REQUEST_A_COPY_BUTTON = By.cssSelector("button[ng-show='modalAlertOptions.showOkButton']");
    private final By CLOSE_POP_UP_DIALOG = By.xpath("//button[@ng-show='modalAlertOptions.showOkButton']");
    private final By SUCCESS_MESSAGE = By.xpath("//div[@class='toast-message']");

    private final By PURCHASE_CONFIRMATION_DIALOG = By.cssSelector("div[class='modal-dialog']");

    private final By ACTIVITY_ROW = By.xpath("//th[@class='metrics-date-range-section col-md-12']//div[@class='diDateRangePickerContainer']");
    private final By OPEN_CALENDAR_ICON = By.cssSelector("button[class='btn btn-default'][ng-click='openFrom($event)']");
    private final By FROM_DATE = By.cssSelector("input[ng-model='diDateRangePicker.dateFrom']");
    private final By FROM_TO = By.cssSelector("input[ng-model='diDateRangePicker.dateTo']");
    private final By TOTAL_DOCUMENTS_DOWNLOADED_PRINTED = By.xpath("//td[text()='Total Documents Downloaded/Printed']");
    private final By DOCUMENTS_DOWNLOADED = By.cssSelector("tr:nth-child(1) > td.col-md-2.ng-binding");
    private final By DOCUMENTS_PRINTED = By.cssSelector("tr:nth-child(2) > td.col-md-2.ng-binding");
    private final By EDIT_CELL = By.xpath("//div[@ng-edit-cell-if='isFocused && true']/input");
    //private final By EDIT_CELL = By.cssSelector("div.ngCell.col2.colt2");

    //Pending Runsheet Request
    private final By PENDING_RUNSHEET_REQUEST = By.cssSelector("span[class='requestCounter ng-binding']");

    String myCompanyRunsheetNameFound = "//strong['%s']";
    String confirmationRequestCopySuccessMessage = "Your request for a copy of the Runsheet: '%s' has been sent to the SuperUsers in your Company. You will receive an email once the request is approved or denied.";
    String successAlertMessage= "//div[contains(text(),'%s')]";
    ////span[@class='ngLabel ng-binding'][text()='Total Items: 2500']
    //String checkbox = "//*[@id='sectionHomeGridContainerAlign']/article[1]/div[2]/div/div[2]/div/div[%s]/div[1]";
    String checkbox = "div:nth-child(%s) > div.ngCell.col0.colt0";
    String find_County = "//span[text()='%s']";

    String demo_Message = "//span[text()='%s is in Demo mode for the next 3 days.']";
    String demo_Expires_Today_Message = "//span[text()='Your Demo of %s expires today.']";
    String county_On_Demo_Mode_Message = "//div[text()='%s is a Demo County. You are not able to print or download documents for a Demo County.']";

    String county_Not_Displayed = "//div[@class='filter-input-container col-xs-8']//select//option[text()='%s']";
    String find_Runsheet = "option[label='%s']";
    String grid_Title_Runsheet_Name = "h5[name='%s']";
    String first_Cell = "//span[text()='%s']";

    public ExplorerPage(WebDriver driver) {
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
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnExplorerSearch(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(EXPLORER_SEARCH_BUTTON);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnUsageProgressBar(){
        webDriverCommands.click(USAGE_PROGRESS_BAR);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void closeCompanyUsageDialog(){
        webDriverCommands.click(CLOSE_COMPANY_USAGE_DIALOG);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnUpdateInfoButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(UPDATE_INFO_BUTTON);
    }
    /**
     * this method calls the waitForElementPresent and click method in webDriverCommands class.
     */
    public void clickOnHomeButton(){

        webDriverCommands.waitForElementPresent(HOME_BUTTON,300);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(HOME_BUTTON);
        webDriverCommands.waitSomeSeconds(7);
    }
    /**
     * This method calls the getText method in webn.DriverCommands class.
     * and change the current PDFViewer option
     * @return String
     * indicates what is the selected PDFViewer
     */
    public String changePDFViewer() {
        //Get current PDF Viewer selected option
        String selectedPDFViewer = webDriverCommands.getText(SELECTED_PDF_VIEWER);
        if (selectedPDFViewer.equals("Standalone")){
            //Click/select Embedded option
            webDriverCommands.click(EMBEDDED_BUTTON);
        }else{
            //Click/select Standalone option
            webDriverCommands.click(STANDALONE_BUTTON);
        }
        return selectedPDFViewer;
    }
    /**
    * this method calls the click method in webDriverCommands class.
    */
    public void clickOnPriorReferenceSearch(){
        webDriverCommands.click(PRIOR_REFERENCE_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void clickOnCountyCombo(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        //selectDropDownOptionByValue(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void clickOnCountyComboByType(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void clickOnCountyComboPriorReference(String contractorCounty){
        webDriverCommands.waitSomeSeconds(2);
        //webDriverCommands.type(PR_COUNTY_COMBO,contractorCounty);
        selectDropDownOptionByValue(PR_COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(2);
    }

    /**
     * This method selects a dropdown option depending on the value.
     *
     * @param webElement dropdown to select the option
     * @param value      value to select in the dropdown
     */
    public void selectDropDownOptionByValue(final By webElement, String value) {
        Select dropdown = new Select(webDriverCommands.findElement(webElement));
        webDriverCommands.waitSomeSeconds(1);
        dropdown.selectByVisibleText(value);
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
    public boolean isDemoMessageDisplayed(String countyDemoMode){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(demo_Message, countyDemoMode)),30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDemoExpiresTodayMessageDisplayed(String countyDemoMode){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(demo_Expires_Today_Message, countyDemoMode)),30);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     *
     *  @return BookSearchPage
     */

    public BookSearchPage clickOnBookSearch(){

        webDriverCommands.click(BOOK_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(7);

        return PageFactory.initElements(getDriver(), BookSearchPage.class);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     *
     *  @return EmailAccountPage
     */

    public EmailAccountPage clickOnEmailAccount(){

        /*webDriverCommands.click(BOOK_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(7);
*/
        return PageFactory.initElements(getDriver(), EmailAccountPage.class);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     *
     *  @return MidlandMapsPage
     */
    public MidlandMapsPage clickOnMidlandMapsSearch(){

        webDriverCommands.click(MIDLAND_MAPS_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
        return PageFactory.initElements(getDriver(), MidlandMapsPage.class);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isExploreTitleDisplayed(){
        return webDriverCommands.waitForElementPresent(EXPLORE_TITLE,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNotCountyDisplayed(String countyDemoMode){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(county_Not_Displayed,countyDemoMode)),10);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isReportIssueDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(REPORT_ISSUE_DIALOG,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUsageProgressBarDisplayed(){
        return webDriverCommands.waitForElementPresent(USAGE_PROGRESS_BAR,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCompanyUsageDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(COMPANY_USAGE_DIALOG,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isPriorReferenceTitleDisplayed(){
        return webDriverCommands.waitForElementPresent(PRIOR_REFERENCE_TITLE,30);
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
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return Double
     */
/*    public Double getCurrentAvailableBalance(){
        webDriverCommands.waitSomeSeconds(5);
        return Double.parseDouble(webDriverCommands.getText(AVAILABLE_BALANCE).substring(1));
    }*/

    public String getCurrentAvailableBalance(){
        webDriverCommands.waitSomeSeconds(5);
        return webDriverCommands.getText(AVAILABLE_BALANCE).substring(1);
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
    public boolean isRowDetailDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(ROW_DETAIL_DIALOG,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isGrantorFieldVisible(){
        return webDriverCommands.waitForElementPresent(GRANTOR,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isGranteeFieldVisible(){
        return webDriverCommands.waitForElementPresent(GRANTEE,5);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isGrantorOrGranteeFieldVisible(){
        return webDriverCommands.waitForElementPresent(GRANTOR_GRANTEE,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isVolumeFieldVisible(){
        return webDriverCommands.waitForElementPresent(VOLUME,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isPageFieldVisible(){
        return webDriverCommands.waitForElementPresent(PAGE,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isInstrumentNumberFieldVisible(){
        return webDriverCommands.waitForElementPresent(INSTRUMENT_NUMBER,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isBookTypeFieldVisible(){
        return webDriverCommands.waitForElementPresent(BOOK_TYPE,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isInstrumentTypeFieldVisible(){
        return webDriverCommands.waitForElementPresent(INST_TYPE,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDateFromFieldVisible(){
        return webDriverCommands.waitForElementPresent(FROM_DATE,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDateToFieldVisible(){
        return webDriverCommands.waitForElementPresent(FROM_TO,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isPropertyDescriptionFieldVisible(){
        return webDriverCommands.waitForElementPresent(PROPERTY_DESCRIPTION,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isAbstractFieldVisible(){
        return webDriverCommands.waitForElementPresent(ABSTRACT,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSurveyFieldVisible(){
        return webDriverCommands.waitForElementPresent(SURVEY,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSectionFieldVisible(){
        return webDriverCommands.waitForElementPresent(SECTION,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isTownshipFieldVisible(){
        return webDriverCommands.waitForElementPresent(TOWNSHIP,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRangeBlockFieldVisible(){
        return webDriverCommands.waitForElementPresent(RANGE_BLOCK,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isQuarterCallFieldVisible(){
        return webDriverCommands.waitForElementPresent(QUARTER_CALL,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSubdivisionFieldVisible(){
        return webDriverCommands.waitForElementPresent(SUBDIVISION,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isLotFieldVisible(){
        return webDriverCommands.waitForElementPresent(LOT,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isBlockFieldVisible(){
        return webDriverCommands.waitForElementPresent(BLOCK,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isSliderFieldVisible(){
        return webDriverCommands.waitForElementPresent(SLIDER,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isAcresMinFieldVisible(){
        return webDriverCommands.waitForElementPresent(ACRES_MIN,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isAcresMaxFieldVisible(){
        return webDriverCommands.waitForElementPresent(ACRES_MAX,5);
    }
    /**
    *this method calls the waitForElementPresent method in webDriverCommands class.
    *
    *  @return boolean
    */
    public boolean isPurchaseConfirmationDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(PURCHASE_CONFIRMATION_DIALOG,30);
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
    public boolean isDeleteRunsheetDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(DELETE_RUNSHEET_DIALOG,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isUnassignRunsheetDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(UNASSIGN_RUNSHEET_DIALOG ,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRunsheetNameDisplayed(String runsheet_Name){
        return webDriverCommands.waitForElementPresent(By.cssSelector(String.format(grid_Title_Runsheet_Name,runsheet_Name)),30);
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
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDoNotShowAgainDialogAvailable(){
        return webDriverCommands.waitForElementPresent(CHECK_BOX_DO_NOT_SHOW_AGAIN,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isPDFViewerPreferenceOpen(){
        return webDriverCommands.waitForElementPresent(PDF_VIEWER_PREFERENCE,3);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDownloadsPrintsDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(DOWNLOADS_PRINTS_POP_UP_DIALOG,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCountyOnDemoModeDialogDisplayed(String CountyDemoMode){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(county_On_Demo_Mode_Message,CountyDemoMode)),30);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return boolean true if the max usage has been reached
     */
    public boolean isMaxUsageReachedMessageDisplayed(){

        String max_Usage_Reached_Message = webDriverCommands.getText(MAX_USAGE_REACHED_MESSAGE_DISPLAYED);

        if (max_Usage_Reached_Message.equals("Max Usage Reached: Downloads & Printing Suspended")) {
            return true;
        }
        else {
            return false;
        }

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
    public void insertNewRunsheetName(String runSheetName){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ENTER_RUNSHEET_NAME, runSheetName);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void insertRecordNumber(String standardUserRecordNumber){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RECORD_NUMBER, standardUserRecordNumber);
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
     * this method calls the waitForElementInVisible method in webDriverCommands class.
     */
    public void WaitUntilRunsheetSpinnerEnds(){
        webDriverCommands.waitForElementInVisible(SPINNER_RUNSHEET_PROGRESS);
    }
    /**
     * this method calls the waitForElementInVisible method in webDriverCommands class.
     */
    public void WaitUntilSpinnerEnds(){
        webDriverCommands.waitForElementInVisible(SPINNER_PROGRESS);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnPRApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(PRIOR_REFERENCE_APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnFirstCheckBox(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(FIRST_CHECKBOX);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnFirstRemoveColumn(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(FIRST_REMOVE_COLUMN_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnCheckBox(int numberOfDocs){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(By.cssSelector(String.format(checkbox,numberOfDocs)));
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnReportChargesButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REPORT_CHARGES_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the double click method in webDriverCommands class.
     */
    public void doubleClickOnFirstRow(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.doubleClick(By.cssSelector(String.format(checkbox,1)));
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the double click method in webDriverCommands class.
     */
    public void doubleClickOnFirstCell(String adminCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.doubleClick(By.xpath(String.format(first_Cell,adminCounty)));
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public String retrievesCellValue(String adminCounty){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(By.xpath(String.format(first_Cell,adminCounty)));
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void editCell(String newCellValue, String adminCounty){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.doubleClickCell(By.xpath(String.format(first_Cell,adminCounty)),newCellValue);
        //webDriverCommands.waitForElementPresent(EDIT_CELL);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(EDIT_CELL,newCellValue);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.editCell(EDIT_CELL);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnRowDetailAddToRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ROW_DETAIL_ADD_TO_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnCancelButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(CANCEL_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnNewRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(NEW_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnRemoveButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnRemovePopUpButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_POP_UP_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnRemoveFreeTrialPopUpButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_FREE_TRIAL_POP_UP_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnViewerPDFButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(VIEWER_LINK);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * This method calls some methods in webDriverCommands class in order to close the new PDF window.
     * @Param String pdfType indicates what is the current PDF Viewer option
     */
    public void closePDF(String pdfType){
        if (pdfType.equals("Standalone")) {
            webDriverCommands.waitSomeSeconds(5);
            //wait for element visible
            //Move to another one tab
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1)); //Tab number
            webDriverCommands.waitForElementPresent(CANVAS_LOADED,60);
            webDriverCommands.waitSomeSeconds(1);
            //webDriverCommands.waitForElementInVisible(PDF_SPINNER,60);
            webDriverCommands.click(CLOSE_STANDALONE_PDF);
            webDriverCommands.waitSomeSeconds(1);
            driver.switchTo().window(tabs2.get(0));
        }else{
            webDriverCommands.waitForElementPresent(CANVAS_LOADED,60);
            webDriverCommands.waitSomeSeconds(1);
            //wait for element visible
            webDriverCommands.click(CLOSE_EMBEDDED_PDF);
            webDriverCommands.waitSomeSeconds(1);
        }
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void SetPreference(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SET_PREFERENCE);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnDeleteRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(DELETE_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnDeleteRunsheet(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(DELETE_RUNSHEET);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * This method calls some methods in webDriverCommands class in order to change the current window.
     */
    public void changeTab(){
        webDriverCommands.waitSomeSeconds(1);
        //Move to another one tab
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0)); //Tab number

        //Can change it for next tab like that or previous:

        driver.switchTo().window(tabs2.get(0));
        //driver.switchTo().window(tabs2.get(1));
        //driver.close();
    }
    /**
     * This method calls some methods in webDriverCommands class in order to click on Print Button.
     */
    public void clickOnPrintButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementInVisible(PRINT_SPINNER);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementInVisible(PRINT_BUTTON_ENABLED);
        webDriverCommands.waitSomeSeconds(10);
        webDriverCommands.click(PRINT_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void clickOnRunsheetList(String oldRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OLD_RUNSHEET);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(By.cssSelector(String.format(find_Runsheet, oldRunsheet)));
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the type method in webDriverCommands class.
     */
    public boolean isUnassignRunsheetDisplayed(String runsheetName){
        return webDriverCommands.waitForElementPresent(By.cssSelector(String.format(find_Runsheet, runsheetName)),30);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void changeToIndicesWithImages(String indicesWithImages){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(INDEX_WITH_IMAGES,indicesWithImages);
    }
    /**
     *this method calls the getText method in webDriverCommands class.
     *
     *  @return String
     */
    public String getTotalDownloads(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_DOWNLOADS);
    }
    /**
     *this method calls the getText method in webDriverCommands class.
     *
     *  @return String
     */
    public String getTotalPrints(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_PRINTS);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnDownloadAllButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(DOWNLOAD_ALL_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
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
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnReportIssueButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REPORT_ISSUE_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void selectFirstCounty(){
        webDriverCommands.waitSomeSeconds(1);
        String countyName = webDriverCommands.getText(FIRST_COUNTY);
        webDriverCommands.type(SELECT_COUNTY, countyName);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addVolume(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_VOLUME, "1");
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addPage(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_PAGE, "2");
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addInstrumentNumber(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_INST_NUMBER, "11");
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addBookType(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_BOOK_TYPE, "QCD");
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addInstrumentType(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_INST_TYPE, "deed");
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void selectIssueType(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_ISSUE_TYPE, "Other");
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addNotes(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RI_NOTES, "This is for testing purposes");
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void closePopUpDialog(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(CLOSE_POP_UP_DIALOG);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnPurchaseConfirmationButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OK_PURCHASE_CONFIRMATION_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.waitForElementInVisible(SPINNER, 60);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnRenameButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(RENAME_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void cllckOnEditRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(EDIT_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the type method in webDriverCommands class.
     */
    public void renameRunsheet(String renameRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RENAME_RUNSHEET,renameRunsheet);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnSaveRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SAVE_RUNSHEET_BUTTON);
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param successMessage message to be displayed
     *  @return boolean
     */
    public boolean isSuccessMessageDisplayed(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successAlertMessage,successMessage)),30);
    }
    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *  @return boolean
     */
    public boolean isRemovePopUpDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(REMOVE_POP_UP_DIALOG,15);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnAddToRunsheetButton(){
        webDriverCommands.waitForElementInVisible(SPINNER_PROGRESS);
        //webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ADD_TO_RUNSHEET_BUTTON);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
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
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnContractorCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_County, county)));
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentDownloaded(){
        //workaround in the meantime CH-1077 is fixed
        /*int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_DOWNLOADED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);*/
        //CH-1077 has been fixed
        return webDriverCommands.getText(DOCUMENTS_DOWNLOADED);
    }
    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isDocumentPrinted(){
        //CH-1077 has been fixed
        return webDriverCommands.getText(DOCUMENTS_PRINTED);
        //workaround in the meantime CH-1077 is fixed
        /*int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_PRINTED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);*/
    }

    public void addFromDate(String currentDate, String extraFilter){
        /*webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(ACTIVITY_ROW);
        webDriverCommands.waitSomeSeconds(1);*/
        webDriverCommands.clear(FROM_DATE);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(FROM_DATE, currentDate);
        //webDriverCommands.click(OPEN_CALENDAR_ICON);
        webDriverCommands.waitSomeSeconds(1);
        //String[] arrayDate = currentDate.split("\\.");

        // Provide the day of the month to select the date.
        //SelectDayFromMultiDateCalendar(arrayDate[1],extraFilter);

        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(TOTAL_DOCUMENTS_DOWNLOADED_PRINTED);
    }
    // Function to select the day of month in the date picker.
    public void SelectDayFromMultiDateCalendar_OLD(String day, String extraFilter)
    {
        // We are using a special XPath style to select the day of current
        // month.
        // It will ignore the previous or next month day and pick the correct
        // one.
        By calendarXpath = By
                .xpath("//td[not(contains(@class,'datePicker'))]//span[text()='"+ day +"']"+ extraFilter+"");
        driver.findElement(calendarXpath).click();

        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMenuUserDisplayed(int secondsToWait){
        return webDriverCommands.waitForElementPresent(USER_MENU, secondsToWait);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMyAccountDisplayed(int secondsToWait){
        return webDriverCommands.waitForElementPresent(MY_ACCOUNT_PAGE, secondsToWait);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isCountyGridListDisplayed(int secondsToWait){
        return webDriverCommands.waitForElementPresent(COUNTY_GRID_LIST, secondsToWait);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnUserMenu(){
        webDriverCommands.waitForElementClickable(USER_MENU, 300);
        webDriverCommands.click(USER_MENU);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void isMenuUserDisplayed(){
        webDriverCommands.waitForElementClickable(DROP_DOWN_MENU_DISPLAYED, 300);
        webDriverCommands.click(DROP_DOWN_MENU_DISPLAYED);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnMyAccountItem(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(USER_CONTRACT_MY_ACCOUNT_ITEM);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     */
    public void clickOnMyCompanyRunsheetsCombo(String myCompanyRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.type(MY_COMPANY_RUNSHEET_COMBO,myCompanyRunsheet);
        selectDropDownOptionByValue(MY_COMPANY_RUNSHEET_COMBO,myCompanyRunsheet);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     *this method calls the type and click method in webDriverCommands class.
     */
    public void clickOnRunsheetNameField(String myCompanyRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(MY_COMPANY_RUNSHEETS_NAME,myCompanyRunsheet);
        //webDriverCommands.waitSomeSeconds(10);
        WaitUntilRunsheetSpinnerEnds();
        //until spinner is gone
        webDriverCommands.click(By.xpath(String.format(myCompanyRunsheetNameFound,myCompanyRunsheet)));
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnRequestCopyButton(){
        webDriverCommands.click(REQUEST_COPY_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnMakeACopyButton(){
        webDriverCommands.click(MAKE_A_COPY);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnConfirmRequestCopyButton(){
        webDriverCommands.click(CONFIRMATION_ALERT_REQUEST_A_COPY_BUTTON);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMyCompanyRunsheetsDisplayed(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(MY_COMPANY_RUNSHEET_ITEM,5);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *  @return boolean
     */
    public boolean isMyCompanyRunsheetsNotDisplayed(){
        return webDriverCommands.waitForElementPresent(MY_COMPANY_RUNSHEETS_NO_ACCESS,5);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isConfirmationAlertPopUpDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(CONFIRMATION_ALERT_CANCEL_BUTTON,30);
    }

    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRequestCopyMessageDisplayed(String myCompanyRunsheetName){
        //return webDriverCommands.waitForElementPresent(By.xpath(String.format(confirmationRequestCopySuccessMessage,myCompanyRunsheetName)));
        //String messageSuccess = webDriverCommands.getText(SUCCESS_MESSAGE);
        //messageSuccess == String.format(confirmationRequestCopySuccessMessage,myCompanyRunsheetName));
        String messageSuccess = webDriverCommands.getText(SUCCESS_MESSAGE);
        return messageSuccess.equals(String.format(confirmationRequestCopySuccessMessage,myCompanyRunsheetName));
    }

    /**
     *this method calls the getText() method in webDriverCommands class.
     *
     *  @return String
     */
    public String isPendingRunsheetRequest() {
        return webDriverCommands.getText(PENDING_RUNSHEET_REQUEST);
    }

}
