package main.java.selenium;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
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
    protected WebDriver driver;
    protected String browserName = "";


    public void setUp(String browser) throws IOException {

        this.browserName = browser;

        ChromeDriverManager.chromedriver().setup();
        //create chrome instance
        ChromeOptions options = new ChromeOptions();
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        options.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        //driver = new ChromeDriver(capabilities);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS.SECONDS);
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
            /*DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("logs"));
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
