package main.java.pageObjects;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
    private final By EXPLORER_SEARCH_BUTTON = By.xpath("//i[@class='fa fa-search fa-flip-horizontal']");
    private final By BOOK_SEARCH_BUTTON = By.xpath("//a[@ng-click='activateBookSearchFilter()']");
    private final By MIDLAND_MAPS_SEARCH_BUTTON = By.xpath("//a[@ng-click='activateMidlandFilter()']");
    private final By PRIOR_REFERENCE_SEARCH_BUTTON = By.xpath("//a[@ng-click='activateVolPageFilter()']");
    //private final By COUNTY_COMBO = By.xpath("//select[@class='form-control ng-pristine ng-untouched ng-scope ng-invalid ng-invalid-required county-select']");
    private final By COUNTY_COMBO = By.xpath("//div[@class='filter-input-container col-xs-8']//select");
    private final By PR_COUNTY_COMBO = By.xpath("//form[@ng-submit='applyFilterVolPage($event)']//div[@class='filter-input-container col-xs-8']//select");
    private final By CONTRACTOR_MAIN_PAGE = By.xpath("//h5[@name='Search Results']");
    private final By EXPLORE_TITLE = By.xpath("//h4[text()='EXPLORE']");
    private final By USAGE_PROGRESS_BAR = By.xpath("//div[@value='diHeaderMeterGraphOptions.county.usage']//div[@class='progress-bar progress-bar-danger']");
    private final By COMPANY_USAGE_DIALOG = By.xpath("//div[@class='slideOut']");
    private final By CLOSE_COMPANY_USAGE_DIALOG = By.xpath("//label[@class='slideOutClose']");

    private final By PRIOR_REFERENCE_TITLE = By.xpath("//h4[text()='PRIOR REFERENCE']");
    private final By GRANTOR_LABEL = By.xpath("//label[@for='grantor']");
    private final By GRANTOR = By.xpath("//input[@name='grantor']");
    private final By VOLUME = By.xpath("//input[@name='volume'][@class='form-control di-input-std ng-pristine ng-untouched ng-valid ng-scope']");
    private final By PAGE = By.xpath("//input[@name='page'][@class='form-control di-input-std ng-pristine ng-untouched ng-valid ng-scope']");
    private final By RECORD_NUMBER = By.xpath("//input[@name='instNumber']");
    private final By APPLY_BUTTON = By.xpath("//aside[@ui-view='filters']//button[@class='btn btn-primary'][@type='submit']");
    private final By PRIOR_REFERENCE_APPLY_BUTTON = By.xpath("//div[@class='form-group pull-right filter-buttons']//button[@class='btn btn-primary'][@ng-disabled='isRequired || disabledButton']");
    private final By FIRST_CHECKBOX = By.cssSelector("div.ngCell.col0.colt0");
    private final By NEW_RUNSHEET_BUTTON = By.xpath("//button[@class='btn btn-success btn-sm inline-block'][@ng-click='newRunsheetBtn()']");
    private final By OLD_RUNSHEET = By.xpath("//select[@ng-show='!runsheetTypeSelected || runsheetTypeSelected && runsheetTypeSelected.id === indexMyRunsheets']");
    private final By SAVE_RUNSHEET_BUTTON = By.xpath("//button[@class='btn btn-primary btn-sm ng-binding']");
    private final By ADD_TO_RUNSHEET_BUTTON = By.xpath("//button[@ng-click='addToRunsheet(selectedItems)']");
    private final By ENTER_RUNSHEET_NAME  = By.xpath("//input[@class='form-control input-sm ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-pattern ng-valid-minlength']");
    private final By REMOVE_BUTTON = By.xpath("//button[@class='btn btn-danger btn-sm remove_border ng-binding']");
    private final By REMOVE_POP_UP_DIALOG = By.xpath("//form[@class='form-horizontal alignForm ng-pristine ng-valid']");
    private final By REMOVE_POP_UP_BUTTON = By.xpath("//button[@ng-bind='modalDeleteOptions.deleteButtonText']");
    private final By REMOVE_FREE_TRIAL_POP_UP_BUTTON = By.xpath("//button[@ng-bind='modalMoneyOptions.okButtonText']");
    private final By FIRST_REMOVE_COLUMN_BUTTON = By.xpath("//div[@class='text-center delete-btn ng-scope']//i[@class='fa fa-times']");
    private final By RENAME_BUTTON = By.xpath("//i[@class='fa fa-pencil-square-o']");
    private final By EDIT_RUNSHEET_BUTTON = By.xpath("//button[@class='btn btn-primary btn-sm ng-binding']");
    private final By RENAME_RUNSHEET = By.xpath("//input[@class='form-control input-sm ng-pristine ng-untouched ng-valid ng-isolate-scope ng-valid-pattern ng-valid-minlength']");
    private final By INDEX_WITH_IMAGES = By.xpath("//select[@class='form-control input-sm inline-block ng-pristine ng-untouched ng-valid']");
    private final By DOWNLOAD_ALL_BUTTON = By.xpath("//button[@class='btn btn-success btn-sm inline-block'][@ng-click='downloadRunsheet()']");
    private final By DOWNLOADS_PRINTS_POP_UP_DIALOG = By.xpath("//div[@ng-if='modalAlertOptions.displayImg']");
    private final By MAX_USAGE_REACHED_MESSAGE_DISPLAYED = By.xpath("//di-meter-graph[@di-meter-graph-options='modalAlertOptions.usageMeterOptions']//div[@class='dangerIconSpace']");
    private final By TOTAL_DOWNLOADS = By.xpath("//span[@ng-bind='diMeterGraphOptions.county.downloadsUsed | number']");
    private final By TOTAL_PRINTS = By.xpath("//span[@ng-bind='diMeterGraphOptions.county.printsUsed | number']");
    private final By OK_BUTTON = By.xpath("//button[@ng-bind='modalAlertOptions.okButtonText']");
    private final By OK_PURCHASE_CONFIRMATION_BUTTON= By.xpath("//button[@class='btn btn-success ng-binding']");
    private final By SPINNER = By.xpath("//div[@class='spinner']");
    private final By VIEWER_LINK = By.cssSelector("div.ngCell.col1.colt1");
    private final By CLOSE_STANDALONE_PDF = By.xpath("//button[@class='toolbarButton closePdf']");
    private final By CLOSE_EMBEDDED_PDF = By.xpath("//section[@di-pdf-viewer='pdfViewerOptions']//button[@class='toolbarButton closePdf']");
    private final By SET_PREFERENCE = By.xpath("//button[text()='Set preference']");
    private final By DOCUMENT_NOT_AVAILABLE = By.xpath("//div[text()='Document not available']");
    private final By CHECK_BOX_DO_NOT_SHOW_AGAIN = By.xpath("//div[@class='modal-header warningModalHeader ng-scope']");
    private final By PDF_VIEWER_PREFERENCE = By.xpath("//div[text()='PDF Viewer Preference']");
    private final By PRINT_BUTTON = By.xpath("//button[@class='toolbarButton printPdf']");
    private final By UPDATE_INFO_BUTTON = By.xpath("//button[@class='btn btn-success pull-right']");
    private final By HOME_BUTTON = By.xpath("//a[@class='home-btn']");

    private final By AVAILABLE_BALANCE = By.xpath("//span[@class='positiveBalance ng-binding']");

    private final By USER_MENU = By.xpath("//span[@class='caret']");
    private final By MY_ACCOUNT_PAGE = By.xpath("//h3[@ng-bind='userSelected.personalInformation.fullName']");
    private final By USER_CONTRACT_MY_ACCOUNT_ITEM = By.xpath("//a[@href='/users/myaccount']");
    private final By DROP_DOWN_MENU_DISPLAYED = By.xpath("//ul[@class='dropdown-menu show']");
    private final By COUNTY_GRID_LIST = By.xpath("//h5[@name='Select County for details']");
    private final By SELECTED_PDF_VIEWER = By.xpath("//label[@class='btn btn-default ng-pristine ng-untouched ng-valid ng-binding active']");
    private final By EMBEDDED_BUTTON = By.xpath("//label[@ng-bind='viewerArray[0].selectName']");
    private final By STANDALONE_BUTTON = By.xpath("//label[@ng-bind='viewerArray[1].selectName']");

    private final By MY_COMPANY_RUNSHEET_COMBO = By.xpath("//select[@class='form-control input-sm inline-block runsheet-select runsheet-type ng-pristine ng-untouched ng-valid']");
    private final By MY_COMPANY_RUNSHEET_ITEM = By.xpath("//input[@name='myCompanyRunsheets']");
    private final By MY_COMPANY_RUNSHEETS_NAME = By.xpath("//input[@class='form-control input-sm inline-block runsheet-select-type-ahead ng-pristine ng-untouched ng-valid ng-valid-editable']");
    private final By MY_COMPANY_RUNSHEETS_NO_ACCESS = By.xpath("//div[@ng-show='runsheetSharingAccess !== noAccess']");
    private final By COMPANY_MANAGEMENT_ADMIN_ITEM = By.xpath("//a[@href='/users/usage']");
    private final By REQUEST_COPY_BUTTON = By.xpath("//button[@ng-show='currentRunsheet && runsheetSharingAccess === requestCopyIndex']");
    private final By MAKE_A_COPY = By.xpath("//button[@ng-show='currentRunsheet && runsheetSharingAccess === fullAccessIndex']");
    private final By RUNSHEET_IS_NOT_PRESENT = By.xpath("//input[@class='form-control input-sm inline-block runsheet-select-type-ahead ng-dirty ng-touched ng-valid-editable ng-valid']");
    private final By CONFIRMATION_ALERT_CANCEL_BUTTON = By.xpath("//button[@ng-show='modalAlertOptions.showCancelButton']");
    private final By CONFIRMATION_ALERT_REQUEST_A_COPY_BUTTON = By.xpath("//button[@ng-show='modalAlertOptions.showOkButton']");
    private final By SUCCESS_MESSAGE = By.xpath("//div[@class='toast-message']");

    private final By PURCHASE_CONFIRMATION_DIALOG = By.xpath("//div[@class='modal-dialog']");

    private final By ACTIVITY_ROW = By.xpath("//th[@class='metrics-date-range-section col-md-12']//div[@class='diDateRangePickerContainer']");
    private final By FROM_DATE = By.xpath("//p[@class='input-group calendar-left']//input");
    private final By TOTAL_DOCUMENTS_DOWNLOADED_PRINTED = By.xpath("//td[text()='Total Documents Downloaded/Printed']");
    private final By DOCUMENTS_DOWNLOADED = By.xpath("//td[text()='Documents Downloaded']/following-sibling::td");
    private final By DOCUMENTS_PRINTED = By.xpath("//td[text()='Documents Printed']/following-sibling::td");

    //Pending Runsheet Request
    private final By PENDING_RUNSHEET_REQUEST = By.xpath("//span[@class='requestCounter ng-binding']");

    String myCompanyRunsheetNameFound = "//strong['%s']";
    String confirmationRequestCopySuccessMessage = "Your request for a copy of the Runsheet: '%s' has been sent to the SuperUsers in your Company. You will receive an email once the request is approved or denied.";
    String successAlertMessage= "//div[contains(text(),'%s')]";
    ////span[@class='ngLabel ng-binding'][text()='Total Items: 2500']
    String checkbox = "//*[@id='sectionHomeGridContainerAlign']/article[1]/div[2]/div/div[2]/div/div[%s]/div[1]";
    String find_County = "//span[text()='%s']";

    String demo_Message = "//span[text()='%s is in Demo mode for the next 3 days.']";

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

    public void clickOnExplorerSearch(){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(EXPLORER_SEARCH_BUTTON);
    }

    public void clickOnUsageProgressBar(){
        webDriverCommands.click(USAGE_PROGRESS_BAR);
    }

    public void closeCompanyUsageDialog(){
        webDriverCommands.click(CLOSE_COMPANY_USAGE_DIALOG);
    }

    public void clickOnUpdateInfoButton(){
        webDriverCommands.click(UPDATE_INFO_BUTTON);
    }

    public void clickOnHomeButton(){

        webDriverCommands.waitForElementPresent(HOME_BUTTON,300);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(HOME_BUTTON);
        webDriverCommands.waitSomeSeconds(7);
    }

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

    public void clickOnPriorReferenceSearch(){
        webDriverCommands.click(PRIOR_REFERENCE_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnCountyCombo(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }

    public void clickOnCountyComboPriorReference(String contractorCounty){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.type(PR_COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(2);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isExplorerMainPageDisplayed(){
        return webDriverCommands.waitForElementPresent(CONTRACTOR_MAIN_PAGE,30);
    }

    public boolean isDemoMessageDisplayed(String countyDemoMode){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(demo_Message, countyDemoMode)),30);
    }

    public BookSearchPage clickOnBookSearch(){

        webDriverCommands.click(BOOK_SEARCH_BUTTON);
        webDriverCommands.waitSomeSeconds(7);

        return PageFactory.initElements(getDriver(), BookSearchPage.class);
    }

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

    public boolean isUsageProgressBarDisplayed(){
        return webDriverCommands.waitForElementPresent(USAGE_PROGRESS_BAR,30);
    }

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

    public Double getCurrentAvailableBalance(){
        webDriverCommands.waitSomeSeconds(5);
        return Double.parseDouble(webDriverCommands.getText(AVAILABLE_BALANCE).substring(1));
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
    public boolean isAvailableBalanceUpdated(Double currentAvailableBalance){

        return webDriverCommands.waitForElementPresent(AVAILABLE_BALANCE,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isPurchaseConfirmationDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(PURCHASE_CONFIRMATION_DIALOG,30);
    }

    public boolean isRunsheetGridWithDocuments(){
        return webDriverCommands.waitForElementPresent(FIRST_CHECKBOX,30);
    }

    public boolean isDocumentNotAvailable(){
        return webDriverCommands.waitForElementPresent(DOCUMENT_NOT_AVAILABLE,3);
    }

    public boolean isDoNotShowAgainDialogAvailable(){
        return webDriverCommands.waitForElementPresent(CHECK_BOX_DO_NOT_SHOW_AGAIN,3);
    }

    public boolean isPDFViewerPreferenceOpen(){
        return webDriverCommands.waitForElementPresent(PDF_VIEWER_PREFERENCE,3);
    }

    public boolean isDownloadsPrintsDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(DOWNLOADS_PRINTS_POP_UP_DIALOG,30);
    }

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
     * this method calls the click method in webDriverCommands class.
     */
    public void insertGrantor(String contractorGrantor){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(GRANTOR, contractorGrantor);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertVolume(String standardUserVolume){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(VOLUME, standardUserVolume);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertPage(String standardUserPage){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(PAGE, standardUserPage);
    }

    public void insertNewRunsheetName(String runSheetName){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ENTER_RUNSHEET_NAME, runSheetName);
    }

    public void insertRecordNumber(String standardUserRecordNumber){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RECORD_NUMBER, standardUserRecordNumber);
    }


    public void clickOnApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void clickOnPRApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(PRIOR_REFERENCE_APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void clickOnFirstCheckBox(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(FIRST_CHECKBOX);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void clickOnFirstRemoveColumn(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(FIRST_REMOVE_COLUMN_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void clickOnCheckBox(int numberOfDocs){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(By.xpath(String.format(checkbox,numberOfDocs)));
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnNewRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(NEW_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnRemoveButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }
    public void clickOnRemovePopUpButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_POP_UP_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnRemoveFreeTrialPopUpButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(REMOVE_FREE_TRIAL_POP_UP_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnViewerPDFButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(VIEWER_LINK);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void closePDF(String pdfType){
        if (pdfType.equals("Standalone")) {
            webDriverCommands.waitSomeSeconds(12);

            //Move to another one tab
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1)); //Tab number

            webDriverCommands.click(CLOSE_STANDALONE_PDF);
            webDriverCommands.waitSomeSeconds(1);
            driver.switchTo().window(tabs2.get(0));
        }else{
            webDriverCommands.waitSomeSeconds(3);
            webDriverCommands.click(CLOSE_EMBEDDED_PDF);
            webDriverCommands.waitSomeSeconds(1);
        }
    }

    public void SetPreference(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SET_PREFERENCE);
        webDriverCommands.waitSomeSeconds(1);
    }

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

    public void clickOnPrintButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(PRINT_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void clickOnRunsheetList(String oldRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(OLD_RUNSHEET,oldRunsheet);
    }

    public void changeToIndicesWithImages(String indicesWithImages){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(INDEX_WITH_IMAGES,indicesWithImages);
    }

    public String getTotalDownloads(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_DOWNLOADS);
    }

    public String getTotalPrints(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.getText(TOTAL_PRINTS);
    }

    public void clickOnDownloadAllButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(DOWNLOAD_ALL_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }


    public void clickOnOKButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OK_BUTTON);
        webDriverCommands.waitSomeSeconds(5);
    }

    public void clickOnPurchaseConfirmationButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(OK_PURCHASE_CONFIRMATION_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementInVisible(SPINNER,20);
    }

    public void clickOnRenameButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(RENAME_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void cllckOnEditRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(EDIT_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    public void renameRunsheet(String renameRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(RENAME_RUNSHEET,renameRunsheet);
    }

    public void clickOnSaveRunsheetButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SAVE_RUNSHEET_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param successMessage message to be displayed
     *  @return boolean
     */
    public boolean isSuccessMessageDisplayed(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successAlertMessage,successMessage)),15);
    }

    public boolean isRemovePopUpDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(REMOVE_POP_UP_DIALOG,15);
    }

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

    public void clickOnContractorCounty(String county){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(find_County, county)));
        webDriverCommands.waitSomeSeconds(1);
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

    public String isDocumentPrinted(){
        //return webDriverCommands.getText(DOCUMENTS_PRINTED);
        //workaround in the meantime CH-1077 is fixed
        int value = Integer.parseInt(webDriverCommands.getText(DOCUMENTS_PRINTED));
        DecimalFormat format = new DecimalFormat("0.00");
        return format.format(value);
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

    public void clickOnMyCompanyRunsheetsCombo(String myCompanyRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(MY_COMPANY_RUNSHEET_COMBO,myCompanyRunsheet);
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.click(MY_COMPANY_RUNSHEET_COMBO);
    }

    public void clickOnRunsheetNameField(String myCompanyRunsheet){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(MY_COMPANY_RUNSHEETS_NAME,myCompanyRunsheet);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(By.xpath(String.format(myCompanyRunsheetNameFound,myCompanyRunsheet)));
    }

    public void clickOnRequestCopyButton(){
        webDriverCommands.click(REQUEST_COPY_BUTTON);
    }

    public void clickOnMakeACopyButton(){
        webDriverCommands.click(MAKE_A_COPY);
    }

    public void clickOnConfirmRequestCopyButton(){
        webDriverCommands.click(CONFIRMATION_ALERT_REQUEST_A_COPY_BUTTON);
    }

    public boolean isMyCompanyRunsheetsDisplayed(){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(MY_COMPANY_RUNSHEET_ITEM,5);
    }

    public boolean isMyCompanyRunsheetsNotDisplayed(){
        return webDriverCommands.waitForElementPresent(MY_COMPANY_RUNSHEETS_NO_ACCESS,5);
    }

    public boolean runsheetIsNotAvailable(){
        return webDriverCommands.waitForElementPresent(RUNSHEET_IS_NOT_PRESENT,15);
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
     *this method calls the waitForElementPresent method in webDriverCommands class.
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
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public String isPendingRunsheetRequest() {
        return webDriverCommands.getText(PENDING_RUNSHEET_REQUEST);
    }

}
