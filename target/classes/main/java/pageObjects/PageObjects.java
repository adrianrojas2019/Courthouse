package main.java.pageObjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import main.java.selenium.WebDriverCommands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Adrian on 4/16/2018.
 */
public class  PageObjects {

    protected WebDriver driver;
    protected WebDriverCommands webDriverCommands;

    public PageObjects(WebDriver driver){
        webDriverCommands = new WebDriverCommands(driver);
        this.driver = driver;

    }

    /**
     *this method calls the constructor from his parent.
     *  @return WebDriver
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    public void saveScreenshot(String name) throws IOException {
        Files.copy(((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE).toPath(), Paths.get("logs/"+name+".jpg"), REPLACE_EXISTING);
    }

    public void waitForSeconds(int seconds){
        webDriverCommands.waitSomeSeconds(seconds);
    }
}

