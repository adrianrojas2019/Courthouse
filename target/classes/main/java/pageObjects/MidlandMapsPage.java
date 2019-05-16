package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 5/10/2019.
 */
public class MidlandMapsPage extends PageObjects  {

    private final By COUNTY_COMBO = By.xpath("//form[@name='midlandForm']//div[@class='filter-input-container col-xs-8']//select");
    private final By COUNTY_YEAR_COMBO = By.xpath("//form[@name='midlandForm']//select[@class='form-control ng-pristine ng-untouched ng-scope ng-invalid ng-invalid-required']");
    private final By APPLY_BUTTON = By.xpath("//aside[@ui-view='filtersMidland']//button[@class='btn btn-primary'][@type='submit']");
    private final By NEXT_MAP = By.xpath("//button[@class='toolbarButton nextDocument']");
    private final By SPINNER_POPUP = By.xpath("//section[@ng-show='searchFilterMidlandSearchOpen']//article[@di-pdf-viewer='pdfViewerOptions']//div[@class='spinner']");
    private final By DOCUMENT_NOT_AVAILABLE = By.xpath("//canvas[@width=856][@height=1108]");

    String findMidlandMapsCounty = "//div[@class='filter-input-container col-xs-8']//option[text()='%s']";
    String findMidlandMapsCountyYear = "//option[text()='%s']";
    String successAlertMessage= "//div[contains(text(),'%s')]";

    public MidlandMapsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCountyCombo(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }

    public void clickOnYearCombo(String contractorCountyYear){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_YEAR_COMBO,contractorCountyYear);
        webDriverCommands.waitSomeSeconds(5);
    }
    public void clickOnApplyButton(){
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(APPLY_BUTTON);
        webDriverCommands.waitSomeSeconds(3);
    }

    public void isProgressBarDone() {
        webDriverCommands.waitForElementInVisible(SPINNER_POPUP, 260);
    }

    public void clickOnNextMapIcon() {
        webDriverCommands.waitSomeSeconds(3);
        webDriverCommands.click(NEXT_MAP);
        webDriverCommands.waitSomeSeconds(3);
    }

    public boolean isDocumentNotAvailable(){
        return webDriverCommands.waitForElementPresent(DOCUMENT_NOT_AVAILABLE,3);
    }

    public boolean isMidlandMapCountyDisplayed(String countyMidlandMaps){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(findMidlandMapsCounty, countyMidlandMaps)));
    }

    /**
     *this method calls the waitForElementVisible method in webn.DriverCommands class.
     *@param successMessage message to be displayed
     *  @return boolean
     */
    public boolean isSuccessMessageDisplayed(String successMessage){
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(successAlertMessage,successMessage)),15);
    }

    public boolean isMidlandMapCountyYearDisplayed(String countyYearMidlandMaps){
        webDriverCommands.waitSomeSeconds(2);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(findMidlandMapsCountyYear, countyYearMidlandMaps)));
    }
}
