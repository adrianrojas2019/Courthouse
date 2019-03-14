package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 11/30/2018.
 */
public class PayGoPage extends PageObjects {
    /**
     *Web elements for UserPage
     */

    private final By FREE_TRIAL_TITLE = By.xpath("//h2[text()='Save time and gas money by accessing court documents online.']");
    private final By FIRST_NAME = By.xpath("//input[@name='first-name']");
    private final By LAST_NAME = By.xpath("//input[@name='last-name']");
    private final By EMAIL_USERNAME_FIELD = By.xpath("//input[@name='email']");
    private final By PHONE_NUMBER = By.xpath("//input[@name='phone']");
    private final By ORGANIZATION = By.xpath("//input[@name='organization']");
    private final By ADDRESS_1 = By.name("address1");
    private final By CITY = By.name("city");
    private final By STATE = By.xpath("//select[@name='state']");
    private final By ZIP_CODE = By.name("zipcode");
    private final By LEGAL_NAME_CC = By.name("name-on-card");
    private final By CREDIT_CARD_NUMBER = By.xpath("//input[@name='credit-card-number']");
    private final By CVV = By.xpath("//input[@name='cvv']");
    private final By MONTH_EXPIRATION_DATE = By.xpath("//input[@name='expiration-month']");
    private final By YEAR_EXPIRATION_DATE = By.xpath("//input[@name='expiration-year']");
    private final By USER_NAME = By.xpath("//input[@name='username']");
    private final By GET_ACCESS_BUTTON = By.xpath("//button[@id='submit-payment']");
    private final By CONFIRM_PAYGO_POP_UP = By.xpath("//div[contains(text(),'Confirm Subscription Purchase')]");
    private final By CONTINUE_BUTTON = By.xpath("//button[@ng-show='modalAlertOptions.showOkButton']");
    private final By LOGIN_BUTTON = By.xpath("//a[@class='btn btn-success big-link-btn']");
    private final By SUCCESS= By.xpath("//div[@class='success-confirm']");

    //Name conditions
    private final By CHECK_CONDITIONS = By.name("customDiCheck");

    public PayGoPage(WebDriver driver) {
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
        return webDriverCommands.waitForElementVisible(CONFIRM_PAYGO_POP_UP, timeToWait);
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
     * this method calls the click method in webDriverCommands class.
     */
    public void insertAddress1(String address1){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ADDRESS_1, address1);
    }

    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertCity(String city){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(CITY, city);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertState(String state){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(STATE, state);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertZipCode(String zipCode){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(ZIP_CODE, zipCode);
    }
    /**
     * this method calls the click method in webDriverCommands class.
     */
    public void insertCardInfo(String legalNameCC, String creditCardNumber, String cvv, String monthExpirationDate, String yearExpirationDate){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.type(LEGAL_NAME_CC, legalNameCC);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.switchToFrame("braintree-hosted-field-number");
        webDriverCommands.type(CREDIT_CARD_NUMBER,  creditCardNumber);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.switchContext();
        webDriverCommands.switchToFrame("braintree-hosted-field-cvv");
        webDriverCommands.type(CVV, cvv);
        webDriverCommands.switchContext();
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.switchToFrame("braintree-hosted-field-expirationMonth");
        webDriverCommands.type(MONTH_EXPIRATION_DATE, monthExpirationDate);
        webDriverCommands.switchContext();
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.switchToFrame("braintree-hosted-field-expirationYear");
        webDriverCommands.type(YEAR_EXPIRATION_DATE, yearExpirationDate);
        webDriverCommands.switchContext();
        webDriverCommands.waitSomeSeconds(1);
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
