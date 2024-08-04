package com.opencart.base;

import com.opencart.utils.DriverUtils;
import com.opencart.utils.ProjectUtils;
import com.opencart.utils.ReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
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
        ProjectUtils.logf("RUN " + result.getMethod().getMethodName());

        WebDriver driver = DriverUtils.createDriver(browser);
        this.threadLocalDriver.set(driver);

        ProjectUtils.logf("Test Thread ID: " + Thread.currentThread().getId());
        ProjectUtils.logf("TEST SUITE: " + context.getCurrentXmlTest().getSuite().getName());
        ProjectUtils.logf("RUN " + result.getMethod().getMethodName());

        if (driver == null) {
            ProjectUtils.logf("ERROR: Unknown 'browser' parameter - " + browser);
            throw new IllegalArgumentException("Unknown 'browser' parameter - " + browser);
        } else {
            ProjectUtils.logf("INFO: " + browser.substring(0, 1).toUpperCase() + browser.substring(1) + " driver created");
        }

        driver.get(ProjectUtils.getBaseUrl());
    }

    @AfterMethod(alwaysRun = true)
    @Parameters("browser")
    protected void tearDown(@Optional("chrome") String browser, ITestResult result) {
        WebDriver driver = getDriver();

        ProjectUtils.logf(result.getMethod().getMethodName() + ": " + ReportUtils.getTestStatus(result));

        if (!result.isSuccess() && ProjectUtils.isServerRun()) {
            ProjectUtils.takeScreenshot(getDriver(), result);
        }

        if (driver != null) {
            driver.quit();
            ProjectUtils.logf("INFO: " + browser.substring(0, 1).toUpperCase() + browser.substring(1) +
                    " driver closed");
            ProjectUtils.logf("After Test Thread ID: " + Thread.currentThread().getId());
            threadLocalDriver.remove();
        } else {
            ProjectUtils.logf("INFO: Driver is null");
        }

        ProjectUtils.logf("Execution time is %d sec\n", (result.getEndMillis() - result.getStartMillis()) / 1000);
    }

    public WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
