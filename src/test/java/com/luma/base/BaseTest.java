package com.luma.base;

import com.luma.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public abstract class BaseTest {

    private WebDriver driver;

    @BeforeSuite
    protected void setupWebDriverManager() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void setupDriver() {
        this.driver = DriverUtils.createDriver(getDriver());

        System.out.println("Open the browser");
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        System.out.println("Close the browser");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
