package com.luma.base;

import com.luma.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest {

    private WebDriver driver;
//    private final String browser = "chrome";
//    private final String browser = "firefox";
//    private final String browser = "chromium";

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.chromiumdriver().setup();
    }


//    String browser
    @BeforeMethod
    @Parameters({"browser"})
    protected void setupDriver(@Optional("chrome") String browser) {
//        if(browser.equals("chrome")) {
//            driver = DriverUtils.createChromeDriver(getDriver());
//            Reporter.log("INFO: Chrome browser created", true);
//        } else {
//            Reporter.log("ERROR: Unknown 'browser' parameter - '" + browser, true);
//            System.exit(1);
//        }
//        System.out.println("Open the browser");
        Reporter.log("----------------------------------", true);
        driver = DriverUtils.createDriver(browser, driver);

        if (getDriver() != null) {
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() +browser.substring(1) + " driver created", true);

        } else {
            Reporter.log("ERROR: Unknown 'browser' parameter - " + browser, true);
            System.exit(1);
        }
    }


    @AfterMethod(alwaysRun = true)
    @Parameters({"browser"})
    protected void tearDown(@Optional("chrome") String browser) {
        if (driver != null) {
            driver.quit();
            Reporter.log("INFO: " + browser.substring(0, 1).toUpperCase() +browser.substring(1) + " driver closed", true);
            driver = null;
        } else {
            Reporter.log("INFO: Driver is null", true);
        }
//        System.out.println("Close the browser");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
