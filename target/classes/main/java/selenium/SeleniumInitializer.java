package main.java.selenium;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

/**
 * Created by Adrian on 4/13/2018.
 */
public class SeleniumInitializer extends SeleniumSetUp {
    @BeforeTest(alwaysRun = true)
    public void setUpDirectory() throws IOException {
        super.setUpDirectory();
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url","environment"})
    public void setUp(String browserName, String url, String environment) throws IOException {
        super.setUp(browserName);
        driver.get(String.format(url,environment));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) throws Throwable {
        super.tearDown(result);
    }
}
