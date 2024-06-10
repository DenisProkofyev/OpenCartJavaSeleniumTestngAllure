package com.luma.base;

import com.luma.utils.DriverUtils;
import com.luma.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    @Parameters({"browser"})
    protected void setupDriver(@Optional("chrome") String browser, ITestResult result) {
        Reporter.log("----------------------------------", true);
        Reporter.log("RUN " + result.getMethod().getMethodName(), true);

        driver = DriverUtils.createDriver(browser, driver);

        if (getDriver() == null) {
            Reporter.log("ERROR: Unknown 'browser' parameter - " + browser, true);
            System.exit(1);
        } else {
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() + browser.substring(1) +
                    " driver created", true);
        }
    }


    @AfterMethod(alwaysRun = true)
    @Parameters({"browser"})
    protected void tearDown(@Optional("chrome") String browser, ITestResult result) {
        Reporter.log(result.getMethod().getMethodName() + ": " + ReportUtils.getTestStatus(result), true);
        if (driver != null) {
            driver.quit();
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() +browser.substring(1) + " driver closed", true);
            driver = null;
        } else {
            Reporter.log("INFO: Driver is null", true);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
