package com.opencart.base;

import com.opencart.utils.DriverUtils;
import com.opencart.utils.ProjectUtils;
import com.opencart.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    private final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    protected void setupDriver(@Optional("chrome") String browser, ITestContext context, ITestResult result) {
        Reporter.log("RUN " + result.getMethod().getMethodName(), true);

        WebDriver driver = DriverUtils.createDriver(browser);
        this.threadLocalDriver.set(driver);

        Reporter.log("Test Thread ID: " + Thread.currentThread().getId(), true);
        Reporter.log("TEST SUITE: " + context.getCurrentXmlTest().getSuite().getName(), true);
        Reporter.log("RUN " + result.getMethod().getMethodName(), true);

        if (driver == null) {
            Reporter.log("ERROR: Unknown 'browser' parameter - " + browser, true);
            throw new IllegalArgumentException("Unknown 'browser' parameter - " + browser);
        } else {
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() + browser.substring(1) + " driver created", true);
        }

        driver.get(ProjectUtils.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    @Parameters("browser")
    protected void tearDown(@Optional("chrome") String browser, ITestResult result) {
        WebDriver driver = getDriver();

        Reporter.log(result.getMethod().getMethodName() + ": " + ReportUtils.getTestStatus(result), true);

        if (driver != null) {
            driver.quit();
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() + browser.substring(1) +
                    " driver closed", true);
            Reporter.log("After Test Thread ID: " + Thread.currentThread().getId(), true);
            threadLocalDriver.remove();
        } else {
            Reporter.log("INFO: Driver is null", true);
        }

        ProjectUtils.logf("Execution time is %d sec\n", (result.getEndMillis() - result.getStartMillis()) / 1000);
    }

    protected WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
