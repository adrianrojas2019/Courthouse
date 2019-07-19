package main.java.selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * Created by Adrian on 4/13/2018.
 */
public class SeleniumInitializer extends SeleniumSetUp  {

    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void extentReportSetup() {
        //location of the extent report
        if (null == null) {
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
            extent = new ExtentReports();  //create object of ExtentReports
            extent.attachReporter(htmlReporter);

            htmlReporter.config().setDocumentTitle("Automation Report"); // Tittle of Report
            htmlReporter.config().setReportName("Extent Report V4"); // Name of the report
            htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

            // General information releated to application
            extent.setSystemInfo("Application Name", "DI Courthouse");
            extent.setSystemInfo("User Name", "Adrian Rojas");
            extent.setSystemInfo("Envirnoment", "Development");
        }
    }
    public void setUpDirectory() throws IOException {
        super.setUpDirectory();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url","environment","remoteDriver","serverIPAddress"})
    public void setUp(String browserName, String url, String environment,String remoteDriver, String serverIPAddress) throws IOException {
        super.setUp(browserName,remoteDriver,serverIPAddress);
        driver.get(String.format(url,environment));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Throwable {
        super.tearDown(result);

        test = extent.createTest(result.getName());

        if(result.getStatus() == ITestResult.FAILURE)
        {
            //MarkupHelper is used to display the output in different colors
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.

            String screenshotPath = TakeScreenshot(driver,"TestCaseFailed");

            //String screenshotPath = TakeScreenshot(driver, result.getName());
            //To add it in the extent report

            test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));

        }
        else if(result.getStatus() == ITestResult.SKIP){
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
            String screenshotPath = TakeScreenshot(driver, result.getName());
            test.pass("Test Case Passed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
        }

        driver.quit();
        super.finalize();
        extent.flush();
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }

    public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
}
