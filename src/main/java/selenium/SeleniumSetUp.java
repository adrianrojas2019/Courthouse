package main.java.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 * Created by Adrian on 4/13/2018.
 */
public abstract class SeleniumSetUp {
    //protected WebDriver driver;
    protected RemoteWebDriver driver;
    protected String browserName = "";


    public void setUp(String browser,String remoteDriver, String serverIPAddress, String enableVNC, String enableServerLog, String enableVideo) throws IOException {

        this.browserName = browser;
        if (browser.equals("Chrome")) {
            ChromeDriverManager.chromedriver().setup();
            //Comment/uncomment if testing is local
            if (remoteDriver.equals("LocalDriver")) {
                ChromeOptions options = new ChromeOptions();
                options.setCapability(ChromeOptions.CAPABILITY, options);
                System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                System.setProperty("webdriver.chrome.verboseLogging", "true");
                driver = new ChromeDriver(options);
            }

            //Comment/Uncomment if testing is using srv selenoid container
            if (remoteDriver.equals("RemoteDriver")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                /*capabilities.setVersion("78");
                capabilities.setCapability("enableVNC", Boolean.parseBoolean(enableVNC));
                capabilities.setCapability("enableLog", Boolean.parseBoolean(enableServerLog));
                capabilities.setCapability("enableVideo", Boolean.parseBoolean(enableVideo));*/
                //System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                driver = new RemoteWebDriver(new URL("http://" + serverIPAddress + "/wd/hub"), capabilities);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS.SECONDS);
        }
        else {
            FirefoxDriverManager.firefoxdriver().setup();
            if (remoteDriver.equals("LocalDriver")) {
                FirefoxOptions options = new FirefoxOptions();
                options.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
                System.setProperty("webdriver.firefox.logfile", "firefox.log");
                System.setProperty("webdriver.firefox.verboseLogging", "true");
                driver = new FirefoxDriver(options);
            }
            //Comment/Uncomment if testing is using srv selenoid container
            if (remoteDriver.equals("RemoteDriver")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName("Firefox");
                /*capabilities.setVersion("78");
                capabilities.setCapability("enableVNC", Boolean.parseBoolean(enableVNC));
                capabilities.setCapability("enableLog", Boolean.parseBoolean(enableServerLog));
                capabilities.setCapability("enableVideo", Boolean.parseBoolean(enableVideo));*/
                //System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
                driver = new RemoteWebDriver(new URL("http://" + serverIPAddress + "/wd/hub"), capabilities);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS.SECONDS);
        }
    }

    public void tearDown(ITestResult result) throws Throwable {
        String name = result.getTestClass().getName();
        String[] nameList = name.split("\\.");
        name = nameList[(nameList.length-1)];
        Files.copy(Paths.get("chromedriver.log"), Paths.get("logs/"+name+".log"),REPLACE_EXISTING);
        Files.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE).toPath(), Paths.get("logs/"+name+".jpg"), REPLACE_EXISTING);
//        driver.quit();
//        super.finalize();
    }

    public void setUpDirectory() throws IOException {
        if(Files.exists(Paths.get("logs"))){
            //delete content in log directory
          /*  DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("logs"));
            for (Path path : directoryStream) {
                Files.delete(path);
            }*/
        }
        else {
            Files.createDirectories(Paths.get("logs"));
        }
    }

    public WebDriver getDriverInstance(){
        return driver;
    }
}
