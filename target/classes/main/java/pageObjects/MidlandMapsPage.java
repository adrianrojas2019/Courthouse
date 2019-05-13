package main.java.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Adrian on 5/10/2019.
 */
public class MidlandMapsPage extends PageObjects  {

    private final By COUNTY_COMBO = By.xpath("//form[@name='midlandForm']//div[@class='filter-input-container col-xs-8']//select");
    private final By MIDLAND_MAPS_COUNTY = By.xpath("");

    String findMidlandMapsCounty = "//div[@class='filter-input-container col-xs-8']//option[text()='%s']";

    public MidlandMapsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCountyCombo(String contractorCounty){
        webDriverCommands.waitSomeSeconds(5);
        webDriverCommands.type(COUNTY_COMBO,contractorCounty);
        webDriverCommands.waitSomeSeconds(5);
    }

    public boolean isMidlandMapCountyDisplayed(String countyMidlandMaps){
        webDriverCommands.waitSomeSeconds(1);
        return webDriverCommands.waitForElementPresent(By.xpath(String.format(findMidlandMapsCounty, countyMidlandMaps)));
    }
}
