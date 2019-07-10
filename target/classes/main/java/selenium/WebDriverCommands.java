package main.java.selenium;

import com.google.common.base.Function;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Adrian on 4/13/2018.
 */
public class WebDriverCommands extends  SeleniumSetUp {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public WebDriverCommands(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(this.driver, 30);
    }

    public void type(By element, String data){
        if(waitForElementPresent(element)) {
            //driver.findElement(element).clear();
            driver.findElement(element).sendKeys(data);
        }
    }

    public void clear(By element){
        if(waitForElementPresent(element)) {
            driver.findElement(element).clear();
        }
    }

    public void click(final By element){
       // if(waitForElementVisible(element,30)) {
       //     driver.findElement(element).click();
       // }
        WebElement elementToClick = waitUntilElement(ExpectedConditions.presenceOfElementLocated(element), element);
        elementToClick.click();

    }

    public void doubleClick(final By element){
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(element);
        actions.doubleClick(elementLocator).perform();
    }

    public void doubleClickCell(final By element, String data){
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(element);
        actions.doubleClick(elementLocator).perform();
    }
    public void editCell(final By element) {
        //Actions actions = new Actions(driver);
        driver.findElement(element).sendKeys(Keys.ENTER);
        //actions.doubleClick(elementLocator).sendKeys(data);
        //actions.doubleClick(elementLocator).sendKeys(Keys.ENTER);
    }
        /**
         * wait until the element is displayed.
         * @param expectedCondition expected condition to apply in the webdriver
         * @return boolean if the element was found
         */
    public WebElement waitUntilElement(ExpectedCondition<WebElement> expectedCondition, By element) {
        try {
            return getWaitDriver().until(expectedCondition);
        } catch (TimeoutException exception) {
            throw new RuntimeException(String.format("The element is not visible in the expected time before clicking " +
                    "it: %s", element));
        }
    }
    /**
     *
     * @return the web driver wait instance
     */
    public WebDriverWait getWaitDriver() {
        return this.webDriverWait;
    }

    public boolean isDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }

    public boolean isEnabled(By element_value){
        boolean isVisible = true;
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.findElement(element_value).click();
            //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(element_value));
        }catch (NoSuchElementException e){
            isVisible = false;
        }
        return isVisible;
    }


    /**
     * This method calls the findElements of selenium
     * @param element, are the elements to find out in the html
     * @return int(number of elements found)
     */
    public int findElements(By element){
        List<WebElement> elementsFound = new LinkedList<>();
        if(waitForElementPresent(element))
            elementsFound = driver.findElements(element);

        return elementsFound.size();
    }

    /**
     * This method calls the findElements of selenium
     * @param element, are the elements to find out in the html
     * @return WebElement
     */
    public WebElement findElement(By element){
        WebElement elementFound = driver.findElement(element);
        if(waitForElementPresent(element))
            elementFound = driver.findElement(element);
        return elementFound;
    }

    /**
     * This method calls the findElements of selenium
     * @param element, are the elements to find out in the html
     * @return int(number of elements found)
     */
    public List<String> getTexFromAListElements(By element){
        List<WebElement> elementsFound = new LinkedList<>();
        List<String> textFromElementsList = new LinkedList<>();
        List<WebElement> lista2 = driver.findElements(element);
        if(waitForElementPresent(element)) {
            elementsFound = driver.findElements(element);
            for (int tempWebElement = 0; tempWebElement < elementsFound.size(); tempWebElement++) {
                textFromElementsList.add(tempWebElement, elementsFound.get(tempWebElement).getText());
            }
        }
        return textFromElementsList;
    }

    /**
     * This method calls the findElements of selenium
     * @param element, are the elements to find out in the html
     * @return List<WebElement>
     */
    public List<WebElement> getWebElements(By element){
        List<WebElement> elementsFound = new LinkedList<>();
        if(waitForElementPresent(element)) {
            elementsFound = driver.findElements(element);
        }
        return elementsFound;
    }

    /**
     * This method calls the text from the element
     * @param element to get the text
     * @return String info of the textfield
     */
    public String getText(By element){
        String infoInTextField = "";
        if(waitForElementPresent(element))
            for(int i =0; i < 10; i++) {
                try {
                    infoInTextField =  driver.findElement(element).getText();
                    break;
                }
                catch (StaleElementReferenceException e){}
            }
        return infoInTextField;
    }

    /**
     * This method calls the text from the element
     * @param element to get the text
     *  @param attribute, is the attribute to find out in the html
     * @return String info of the textfield
     */
    public String getAttribute(By element, String attribute){
        String infoInTextField = "";
        if(waitForElementPresent(element))
            infoInTextField =  driver.findElement(element).getAttribute(attribute);
        return infoInTextField;
    }

    /**
     * This method wait for the element in order to perform the following action
     * @param element element to wait
     * @param amountSecondsToWait overall of second to wait.
     *  @return boolean
     */
    public boolean waitForElementPresent(final By element, int amountSecondsToWait){

        boolean isElementPresent = true;


        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    //.withTimeout(amountSecondsToWait, SECONDS)
                    .withTimeout(java.time.Duration.ofSeconds(amountSecondsToWait))
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, SECONDS);
                    WebElement webElement = d.findElement(element);
                    return webElement;
                }
            });

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;

    }

    /**
     * This method wait that the element is present in order to perform the following action
     * @param element element to wait
     * @param timeToWait overall of second to wait.
     *  @return boolean
     */
    public boolean waitForElementVisible(final By element, int timeToWait){

        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;

    }


    /**
     * This method wait that the element is present in order to perform the following action
     * @param element element to wait
     * @param timeToWait overall of second to wait.
     *  @return boolean
     */
    public boolean waitForElementInVisible(final By element, int timeToWait){

        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;

    }

    /**
     * This method wait that the element is present in order to perform the following action
     * @param element element to wait
     *  @return boolean
     */
    public boolean waitForElementInVisible(final By element){

        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;

    }

    /**
     * This method wait for the element in order to perform the following action
     * @param element element to wait
     *  @return boolean
     */

    public boolean waitForElementPresent(final By element) {
        boolean isElementPresent = true;


        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
                    //.withTimeout(10, SECONDS)
                    .withTimeout(java.time.Duration.ofSeconds(10))
                    .ignoring(NoSuchElementException.class);

            wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver d) {
                    d.manage().timeouts().implicitlyWait(0, SECONDS);
                    WebElement we = d.findElement(element);
                    return we;
                }
            });

        } catch (TimeoutException te) {
            isElementPresent = false;
        }

        return isElementPresent;
    }


    /**
     * This method has the intention to verify if the page is already loaded
     * @return boolean
     */
    public boolean waitForPageLoad(){
        boolean isLoaded = true;
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 60000);
        try {
            wait.until(pageLoadCondition);
        }catch (TimeoutException e){
            isLoaded = false;
        }
        return isLoaded;
    }

    /**
     * This method has the intention to select any value from a dropdown
     * @param  element dropdown to select a value
     * @param valueToSelect name to select in the dropdown
     */
    public void selectByVisibleText(final By element, String valueToSelect){
        if(waitForElementPresent(element)) {
            Select dropdown = new Select(driver.findElement(element));
            dropdown.selectByVisibleText(valueToSelect);
        }
    }

    /**
     * This method get the options elements in a dropdown.
     * @param  element dropdown to get options
     * @return List<WebElement> the options in select.
     */
    public List<WebElement> getElementsInDropdown(final By element){
        List<WebElement> options = new LinkedList<>();
        if(waitForElementPresent(element)) {
            Select dropdown = new Select(driver.findElement(element));
            options = dropdown.getOptions();
        }
        return options;
    }

    /**
     * This method has the intention to compare if a value is selected in a dropdown
     * @param  element dropdown to select a value
     * @param valueToSelect name to check if is selected
     * @return boolean
     */
    public boolean isValueSelected(final By element, String valueToSelect){
        boolean isSelected = false;
        if(waitForElementPresent(element)) {
            Select dropdown = new Select(driver.findElement(element));
            isSelected = dropdown.getFirstSelectedOption().getText().equals(valueToSelect);
        }
        return isSelected;
    }

    /**
     * This method calls the getWindowHandles of selenium to know how many tabs are opened
     * @return int(number of tabs found)
     */
    public int getWindowHandles(){
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        return tabs.size();
    }

    /**
     * This method removes the readonly for inputs in the html
     */
    public void disableReadOnlyField(){
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        for (WebElement input : inputs) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].removeAttribute('readonly','readonly')",input);
        }
    }

    /**
     * This method waits for X amount of seconds for continuing the next instruction
     * @param timeToWait overall of second to wait.
     */
    public void waitSomeSeconds(int timeToWait){
        long startTime = System.currentTimeMillis(); //fetch starting time
        //it is going to be in the loop until the time from is less than 90 seconds and the amount of tabs be 2
        timeToWait = timeToWait*1000;
        while((System.currentTimeMillis()-startTime)<timeToWait)
        {
        }
    }

    /**
     * This method calls the isSelected method of selenium to know if a checkbox is selected
     * @param element the WebElement to check
     * @return boolean
     */
    public boolean isSelected(By element) {
        boolean isElementSelected = false;
        if(waitForElementPresent(element)) {
            for (int i = 0; i < 10; i++) {
                try {
                    isElementSelected = driver.findElement(element).isSelected();
                    break;
                } catch (StaleElementReferenceException e) {
                }
            }
        }
        return isElementSelected;
    }

    /**
     * This method calls the Javascript executor of selenium to apply scrollIntoView to the element
     * @param elementToScroll the By object to scroll
     */
    public void goToElementJS(By elementToScroll){
        if(waitForElementPresent(elementToScroll)) {
            WebElement rowOfRole = driver.findElement(elementToScroll);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", rowOfRole);
        }
    }

    /**
     * This method wait that the element is clickable in order to perform the following action
     * @param element element to wait
     * @param timeToWait overall of second to wait.
     *  @return boolean
     */
    public boolean waitForElementClickable(final By element, int timeToWait){
        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.elementToBeClickable(element));

        } catch (TimeoutException te) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    /**
     *this method right-click the element using Actions class
     * @param locator used to right click it.
     */
    public void rightClickElement(By locator){
        for(int i =0; i < 10; i++) {
            try {
                Actions action = new Actions(driver).contextClick(driver.findElement(locator));
                action.build().perform();
                break;
            }
            catch (StaleElementReferenceException e){}
        }
    }

    /**
     *this method right-click the element using JavaScript Executor
     * @param locator used to right click it.
     */
    public void rightClickByJs(By locator){
        WebElement element = driver.findElement(locator);
        JavascriptExecutor jse =  (JavascriptExecutor)driver;
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        jse.executeScript(
                "var element = arguments[0];if (window.CustomEvent) {element.dispatchEvent(new CustomEvent('contextmenu'));} else if (document.createEvent) {var ev = document.createEvent('HTMLEvents');ev.initEvent('contextmenu', true, false);element.dispatchEvent(ev);} else {element.fireEvent('oncontextmenu');;}", element
        );

    }
    /**
     * This method waits for 60 sec to the amount of tabs to be in order to perform the following action
     * @param numberTabs element to wait
     *  @return boolean
     */
    public boolean waitWindowsTabToBe(int numberTabs) {
        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.numberOfWindowsToBe(numberTabs));

        } catch (TimeoutException te) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    /**
     * This method create an action that perform pressing the down arrow key with the shift key down
     *  @param  numberDownKeys the number of times to press down arroy key.
     */
    public void shiftClickDown(int numberDownKeys) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT);
        for (int i = 0; i < numberDownKeys; i++) {
            actions.sendKeys(Keys.ARROW_DOWN);
        }
        actions.keyUp(Keys.SHIFT)
                .build().perform();
    }

    /**
     * This method waits until the text in the elemetn math the regular expression
     * @param locator the element to get the text
     * @param pattern the regular expressions to use
     * @param timeToWait the seconds to wait
     * @return true if the text matches the regular expression.
     */
    public boolean waitForTextToMatch(By locator, Pattern pattern, int timeToWait) {
        boolean isElementPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.textMatches(locator, pattern));

        } catch (TimeoutException te) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    /**
     * This method waits until the text is the expected
     * @param locator the element to get the text
     * @param text the value to wait for
     * @param timeToWait the seconds to wait
     * @return true if the text is present in the element
     */
    public boolean waitForTextToBe(By locator, String text, int timeToWait){
        boolean isTextPresent = true;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeToWait);
            wait.until(ExpectedConditions.textToBe(locator, text));

        } catch (TimeoutException te) {
            isTextPresent = false;
        }
        return isTextPresent;
    }

    /**
     * Opens the url we need to interact with
     * @param url string with the url to open
     */
    public void openUrl(String url) {
        if (!StringUtils.isEmpty(url)) {
            driver.get(url);
        } else {
            throw new RuntimeException("The url could not be an empty value");
        }
    }

    /**
     * This method clicks on any element in the html
     * @param element webElement to click on
     */
    public void clickJs(By element) {
        try {
            WebElement elementToClick = waitUntilElement(ExpectedConditions.elementToBeClickable(element), element);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", elementToClick);
        }catch (org.openqa.selenium.WebDriverException exception) {
            throw new RuntimeException(String.format("The element cannot be clickable: %s", element), exception);
        }
    }

    /**
     * Gets the frame we need to work on based on the the frame name
     * @return Web driver
     */
    public void switchToFrame(String frameName) {
        try {
            waitUntilIframe(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
            //driver.switchTo().frame(frameName);
        }catch (IndexOutOfBoundsException exception) {
            throw new RuntimeException(String.format("Frame could not be located. %s" , exception));
        }
    }
    /**
     * wait until the element is displayed if it is not found, an exception is throws.
     * @param expectedCondition expected condition to apply in the webdriver
     * @throws TimeoutException if the default time is reach, this exception is throws
     */
    public void waitUntilIframe(ExpectedCondition<WebDriver> expectedCondition) {
        try {
            getWaitDriver().until(expectedCondition);
        } catch (TimeoutException exception) {
            throw new RuntimeException("Popup was not displayed");
        }
    }

    /**
     * Gets the frame we need to work on based on the the frame name
     * @return Web driver
     */
    public void switchContext() {
        try {
            driver.switchTo().defaultContent();
            //driver.switchTo().frame(frameName);
        }catch (IndexOutOfBoundsException exception) {
            throw new RuntimeException(String.format("Frame could not be located. %s" , exception));
        }
    }
}
