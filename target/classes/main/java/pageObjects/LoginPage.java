package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import main.java.pageObjects.CHMainPage;
import java.util.ArrayList;

/**
 * Created by Adrian on 4/16/2018.
 */
public class LoginPage extends PageObjects {
    /**
     *Web elements for LoginPage
     */
    private final By MAIN_SIGN_IN = By.xpath("//p[@class='signInText-login']");
    //Courthouse 2.0 Thumbnail
    //private final By COURTHOUSE_THUMBNAIL = By.xpath("//img[@class='di_county_scans_20']");
    //private final By COURTHOUSE_NAME_APP= By.xpath("//span[@title='DI Courthouse 2.0']");
    //Courthouse 3.0 Thumbnail
    private final By COURTHOUSE_THUMBNAIL = By.xpath("//img[@class='di-carousel-item-img di_county_scans_20']");
    private final By COURTHOUSE_NAME_APP= By.xpath("//span[@class='item-title-text'][text()='Courthouse 2.0']");
    private final By SPINNER_POPUP = By.xpath("//div[@class='di-app-loading-message']");
    private final By LOGGING_OUT = By.xpath("//h2[text()='Logging out from COURTHOUSE...']");
    private final By USER_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login");
    private final By STANDALONE_TITLE = By.xpath("//p[text()='Courthouse Contractor/PayGo/Free Trial']");
    //private final By STANDARD_TITLE = By.xpath("//p[text()='Sign In']");
    //private final By STANDARD_TITLE = By.xpath("//span[text()='SIGN IN']");
    private final By STANDARD_TITLE = By.cssSelector("button[class='signin']");
    private final By HOME_BUTTON = By.cssSelector(".home-btn.active-item");

    //private final By SIGN_STANDALONE_LINK = By.xpath("//a[@href='https://app.%sdrillinginfo.com/courthouse/login']");
    String sign_Standalone_link = "//a[@href='https://app.%sdrillinginfo.com/courthouse/login']";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param timeToWait amount of maximum seconds to wait
     *  @return boolean
     */
    public boolean waitForElementVisible(int timeToWait){
        return webDriverCommands.waitForElementVisible(MAIN_SIGN_IN, timeToWait);
    }

     /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isLoginTitleDisplayed(){
        webDriverCommands.waitForElementInVisible(SPINNER_POPUP, 120);
        webDriverCommands.waitSomeSeconds(5);
        return webDriverCommands.waitForElementPresent(COURTHOUSE_THUMBNAIL,100);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isLoginStandaloneTitleDisplayed(){
        webDriverCommands.waitForElementInVisible(SPINNER_POPUP, 120);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(STANDALONE_TITLE,30);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isLoginStandardTitleDisplayed(){
        webDriverCommands.waitForElementInVisible(LOGGING_OUT, 30);
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(STANDARD_TITLE,30);
    }
    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public CHMainPage clickOnCourthouseThumbnailButton(){

        webDriverCommands.waitForElementPresent(COURTHOUSE_NAME_APP,300);
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.waitForElementPresent(COURTHOUSE_THUMBNAIL,100);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(COURTHOUSE_THUMBNAIL);
        webDriverCommands.waitSomeSeconds(5);
        //Move to another one tab
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1)); //Tab number

        //Can change it for next tab like that or previous:

        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));

        return PageFactory.initElements(getDriver(), CHMainPage.class);
    }
    /**
     *this method calls the waitForElementPresent and click method in webDriverCommands class.
     *
     *  @return boolean
     */
    public ExplorerPage clickOnHomeButton(){

        webDriverCommands.waitForElementPresent(HOME_BUTTON,300);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(HOME_BUTTON);
        webDriverCommands.waitSomeSeconds(7);

        return PageFactory.initElements(getDriver(), ExplorerPage.class);
    }
    /**
     *this method calls the type method in webDriverCommands class.
     *@params username, password info to enter in the password's field
     */
    public void with(String username, String password){
        webDriverCommands.type(USER_FIELD, username);
        webDriverCommands.type(PASSWORD_FIELD,password);
    }
    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnSignInButton(){
        webDriverCommands.waitSomeSeconds(1);
        webDriverCommands.click(LOGIN_BUTTON);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnStandaloneSignInButton(String environment){
        webDriverCommands.click(By.xpath(String.format(sign_Standalone_link,environment)));
    }


}
