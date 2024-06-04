package com.luma.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void setup() {
        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(chromeOptions);
//            driver = WebDriverManager.chromedriver().dockerScreenResolution("1920x1080x24").create();
        }
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
