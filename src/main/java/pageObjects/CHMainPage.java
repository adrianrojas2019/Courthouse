package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Adrian on 11/28/2018.
 */
public class CHMainPage extends PageObjects {
    /**
     *Web elements for UserPage
     */

    private final By USER_ADMIN_GRID = By.xpath("//section[@class='row user-container ng-scope']");
    private final By USER_MENU = By.xpath("//span[@class='caret']");
    private final By HOME_BUTTON = By.xpath("//a[@class='home-btn active-item']");

    public CHMainPage(WebDriver driver) {
        super(driver);
    }

    /**
     *this method calls the waitForElementPresent method in webDriverCommands class.
     *
     *  @return boolean
     */
    public boolean isCHMainPageDisplayed(){
        return webDriverCommands.waitForElementPresent(USER_ADMIN_GRID,30);
    }

    /**
     * This method uses the PageFactory desing pattern, to direct to another pageObject.
     *  @return UserAdministrationPage
     */
    public UserAdministrationPage LoginMenu(){
        clickOnUserAdministrationMenu();
        return PageFactory.initElements(getDriver(), UserAdministrationPage.class);
    }
    /**
     * This method uses the PageFactory desing pattern, to direct to another pageObject.
     *  @return ExplorerPage
     */
    public ExplorerPage HomeButton(){

        webDriverCommands.waitForElementPresent(HOME_BUTTON,300);
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.click(HOME_BUTTON);
        webDriverCommands.waitSomeSeconds(7);

        return PageFactory.initElements(getDriver(), ExplorerPage.class);
    }

    /**
     *this method calls the click method in webDriverCommands class.
     */
    public void clickOnUserAdministrationMenu(){
        webDriverCommands.waitForElementClickable(USER_MENU, 300);
        webDriverCommands.click(USER_MENU);
    }
}
