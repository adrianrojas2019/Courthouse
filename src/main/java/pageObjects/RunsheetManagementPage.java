package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Adrian on 11/28/2018.
 */
public class RunsheetManagementPage extends PageObjects {

    private final By RUNSHEET_MANAGEMENT_GRID = By.cssSelector("section[class='row runsheet-section-container ng-scope']");
    private final By REQUEST_COPY_ACTIONS = By.xpath("//h4[text()='Request Copy Actions']");
    private final By STATUS_COMBO = By.cssSelector("select[class='form-control ng-pristine ng-untouched ng-valid']");
    private final By DENY_BUTTON = By.xpath("//label[@class='btn btn-default ng-pristine ng-untouched ng-valid ng-binding'][text()='DENY']");
    private final By APPROVE_BUTTON= By.xpath("//label[@class='btn btn-default ng-pristine ng-untouched ng-valid ng-binding'][text()='APPROVE']");
    private final By SAVE_BUTTON = By.cssSelector("button[class='btn btn-success']");
    private final By DENY_BUTTON_ENABLED = By.cssSelector("label.btn-default.active");
    private final By APPROVE_BUTTON_ENABLED = By.cssSelector("label.btn-default.active");
    private final By SUCCESS_MESSAGE = By.xpath("//div[@class='toast-message']");

    String confirmationRequestCopySuccessMessage = "The request for a copy of the Runsheet: '%s' has been successfully edited.";
    String pendingRunsheetToDeny = "//span[text()='%s']";

    public RunsheetManagementPage(WebDriver driver) {
        super(driver);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRunsheetManagementGridDisplayed(){
        return webDriverCommands.waitForElementPresent(RUNSHEET_MANAGEMENT_GRID,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isRequestCopyActiionsDisplayed(){
        return webDriverCommands.waitForElementPresent(REQUEST_COPY_ACTIONS,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isDenyButtonEnabled(){
        return webDriverCommands.waitForElementPresent(DENY_BUTTON_ENABLED,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isApproveButtonEnabled(){
        return webDriverCommands.waitForElementPresent(APPROVE_BUTTON_ENABLED,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isMessageDisplayed(String myCompanyRunsheetName){
        //wait until toast msg is displayed
        webDriverCommands.waitSomeSeconds(2);
        String messageSuccess = webDriverCommands.getText(SUCCESS_MESSAGE);
        return messageSuccess.equals(String.format(confirmationRequestCopySuccessMessage,myCompanyRunsheetName));
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnStatusCombo(String status){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.type(STATUS_COMBO,status);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void findPendingRequest(String pendingRequest){
        webDriverCommands.waitSomeSeconds(2);
        webDriverCommands.click(By.xpath(String.format(pendingRunsheetToDeny,pendingRequest)));
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnDenyButton(){
        webDriverCommands.click(DENY_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnApproveButton(){
        webDriverCommands.click(APPROVE_BUTTON);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSaveButton(){
        webDriverCommands.click(SAVE_BUTTON);
    }
}
