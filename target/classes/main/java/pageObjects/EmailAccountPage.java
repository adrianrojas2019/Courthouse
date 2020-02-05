package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 2/3/2020.
 */
public class EmailAccountPage extends PageObjects {

    private final By EMAIL_ADDRESS = By.cssSelector("input[type=email]");
    private final By EMAIL_PASSWORD = By.xpath("//div[text()='Enter password']");
    private final By PASSWORD = By.cssSelector("input[name='passwd']");
    private final By EMAIL_ADDRESS_DIALOG= By.cssSelector("div[class='inner app fade-in-lightbox']");
    private final By NEXT_BUTTON = By.cssSelector("input[class='btn btn-block btn-primary']");

    private final By NEW_REPORT_ISSUE_EMAIL_RECEIVED = By.xpath("//span[text()='Courthouse User is reporting an issue with a document']");

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
    public boolean isEnterPasswordDialogDisplayed(){
        return webDriverCommands.waitForElementPresent(EMAIL_PASSWORD,60);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isNewReportIssueEmailReceived(){
        return webDriverCommands.waitForElementPresent(NEW_REPORT_ISSUE_EMAIL_RECEIVED,30);
    }

}
