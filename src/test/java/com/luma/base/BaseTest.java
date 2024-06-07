package com.luma.base;

import com.luma.utils.DriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.sql.Driver;


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
