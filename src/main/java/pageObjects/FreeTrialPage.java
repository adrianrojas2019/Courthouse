package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 11/30/2018.
 */
public class FreeTrialPage extends PageObjects {
    /**
     *Web elements for UserPage
     */

    private final By FREE_TRIAL_TITLE = By.xpath("//h2[text()='Save time and gas money by accessing court documents online.']");
    private final By FIRST_NAME = By.xpath("//input[@name='first-name']");
    private final By LAST_NAME = By.xpath("//input[@name='last-name']");
    private final By EMAIL_USERNAME_FIELD = By.xpath("//input[@name='email']");
    private final By PHONE_NUMBER = By.xpath("//input[@name='phone']");
    private final By ORGANIZATION = By.xpath("//input[@name='organization']");
    private final By USER_NAME = By.xpath("//input[@name='username']");
    private final By GET_ACCESS_BUTTON = By.xpath("//button[contains(text(),'GET INSTANT ACCESS')]");

    private final By CONFIRM_FREE_TRIAL_POP_UP = By.xpath("//div[contains(text(),'Confirm Free trial Subscription')]");
    private final By CONTINUE_BUTTON = By.xpath("//button[@ng-show='modalAlertOptions.showOkButton']");
    private final By LOGIN_BUTTON = By.xpath("//a[@class='btn btn-success big-link-btn']");
    private final By SUCCESS= By.xpath("//div[@class='success-confirm']");

    //Name conditions
    private final By CHECK_CONDITIONS = By.name("customDiCheck");

    public FreeTrialPage(WebDriver driver) {
        super(driver);
    }

    public void LoadNewURL(String newURL){
        webDriverCommands.openUrl(newURL);
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
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param timeToWait amount of maximum seconds to wait
     *  @return boolean
     */
    public boolean waitForFreeTrialSubscriptionPopUpDisplayed(int timeToWait){
        return webDriverCommands.waitForElementVisible(CONFIRM_FREE_TRIAL_POP_UP, timeToWait);
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param timeToWait amount of maximum seconds to wait
     *  @return boolean
     */
    public boolean waitForSuccessMessageDisplayed(int timeToWait){
        return webDriverCommands.waitForElementVisible(SUCCESS, timeToWait);
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
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void insertPhoneNumber(String phoneNumber){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(PHONE_NUMBER, phoneNumber);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertOrganization(String organization){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ORGANIZATION, organization);
    }

    /**
     *this method calls the type method in webDriverCommands class.
     *@param userName info to enter in the username's field
     */
    public void insertUserName(String userName){
        webDriverCommands.type(USER_NAME, userName);
    }


    public void checkConditions(){
        webDriverCommands.click(CHECK_CONDITIONS);
        webDriverCommands.waitSomeSeconds(1);
        //webDriverCommands.clickJs(CHECK_CONDITIONS);
    }

    public void clickOnGetAccessButton(){
        webDriverCommands.click(GET_ACCESS_BUTTON);
    }

    public void clickOnContinueButton(){
        webDriverCommands.click(CONTINUE_BUTTON);
    }

    public void clickOnLoginButton(){
        webDriverCommands.click(LOGIN_BUTTON);
    }
}
