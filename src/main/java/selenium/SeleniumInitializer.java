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

/**
 * Created by Adrian on 4/13/2018.
 */
public class SeleniumInitializer extends SeleniumSetUp {

    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest(alwaysRun = true)
    public void setUpDirectory() throws IOException {
        super.setUpDirectory();
        //location of the extent report
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

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url","environment"})
    public void setUp(String browserName, String url, String environment) throws IOException {
        super.setUp(browserName);
        driver.get(String.format(url,environment));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Throwable {

        if(result.getStatus() == ITestResult.FAILURE)
        {
            //MarkupHelper is used to display the output in different colors
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.

            //	String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            //String screenshotPath = TakeScreenshot(driver, result.getName());
            //To add it in the extent report

            //test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));


        }
        else if(result.getStatus() == ITestResult.SKIP){
            //logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
            //String screenshotPath = TakeScreenshot(driver, result.getName());
            //test.pass("Test Case Passed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
        }
        super.tearDown(result);
        extent.flush();
        //driver.quit();
    }

    /*public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }*/
}
