package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 2/3/2020.
 */
public class EmailAccountPage extends PageObjects {

    private final By EMAIL_ADDRESS = By.cssSelector("input[type=email]");
    private final By EMAIL_PASSWORD = By.cssSelector("input[type='password']");
    private final By PASSWORD = By.cssSelector("input[name='passwd']");
    private final By EMAIL_ADDRESS_DIALOG= By.cssSelector("input[type='email']");
    private final By NEXT_BUTTON = By.cssSelector("input[class='btn btn-block btn-primary']");
    private final By NEW_REPORT_ISSUE_EMAIL_RECEIVED = By.xpath("//span[text()='Courthouse User is reporting an issue with a document']");
    private final By NEW_REPORT_CHANGE_EMAIL_RECEIVED = By.xpath("//span[text()='DrillingInfo: Report Changes']");
    //private final By DELETE_BUTTON = By.xpath("//button[@type='button'][@name='Delete']");
    private final By CHECK_BOX = By.cssSelector("i[data-icon-name='StatusCircleCheckmark']");
    private final By EMPTY_FOLDER = By.xpath("//span[text()='Empty folder']");
    private final By SIGN_IN_BUTTON = By.xpath("//nav[@class='auxiliary-actions']//li//a[text()='Sign in']");
    private final By MAIL_PAGE = By.xpath("//mark[@class='corp-name']//a[@title='Microsoft']");

    String successEmailBody = "//div[h1='%s']//h1";

    public EmailAccountPage(WebDriver driver) {
        super(driver);
    }


    /**
     *this method calls the openUrl method in webDriverCommands class.
     *
     *  @return boolean
     */
    public void LoadNewURL(String newURL){
        webDriverCommands.openUrl(newURL);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addEmailAddress(String emailAddress){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(EMAIL_ADDRESS, emailAddress);
        webDriverCommands.waitSomeSeconds(1);
    }


    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void addEmailPassword(String emailPassword){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(PASSWORD, emailPassword);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnNextButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(NEXT_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnSignInButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(SIGN_IN_BUTTON);
        webDriverCommands.waitSomeSeconds(1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnReceivedReportIssueEmail(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(NEW_REPORT_ISSUE_EMAIL_RECEIVED);
        webDriverCommands.waitSomeSeconds(5);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnReceivedEmail(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(NEW_REPORT_CHANGE_EMAIL_RECEIVED);
        webDriverCommands.waitSomeSeconds(1);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void clickOnDeleteButton(){
        webDriverCommands.waitSomeSeconds(15);
        //webDriverCommands.click(DELETE_BUTTON);
        webDriverCommands.click(CHECK_BOX);
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(EMPTY_FOLDER);
        webDriverCommands.waitSomeSeconds(3);

    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isEmailAddressDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(EMAIL_ADDRESS_DIALOG,60);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isMailPageDisplayed(){
        return webDriverCommands.waitForElementPresent(MAIL_PAGE,60);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isEnterPasswordDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(EMAIL_PASSWORD,60);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNewReportIssueEmailReceived(){
        return webDriverCommands.waitForElementPresent(NEW_REPORT_ISSUE_EMAIL_RECEIVED,15);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNewReportChangeEmailReceived(){
        return webDriverCommands.waitForElementPresent(NEW_REPORT_CHANGE_EMAIL_RECEIVED,15);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isEmailSelected(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successEmailBody,successMessage)),30);
    }

}
