package com.luma.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;
    private static final FirefoxOptions firefoxOptions;
//    private static final ChromiumOptions<ChromeOptions> chromiumOptions;

    static {
        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
    }

    static {
        firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
    }

//    static {
//        chromiumOptions = chromeOptions;
//
//        chromiumOptions.addArguments("--incognito");
//        chromiumOptions.addArguments("--headless");
//        chromiumOptions.addArguments("--window-size=1920,1080");
//        chromiumOptions.addArguments("--disable-gpu");
//        chromiumOptions.addArguments("--no-sandbox");
//        chromiumOptions.addArguments("--disable-dev-shm-usage");
//    }

    private static WebDriver createChromeDriver(WebDriver driver) {
        if (driver == null) {
            return new ChromeDriver(chromeOptions);
        } else {
            driver.quit();
            return new ChromeDriver(chromeOptions);
        }
    }

    private static WebDriver createFirefoxDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
        FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
//        if (driver == null) {
//            return new FirefoxDriver(firefoxOptions);
//        } else {
//            driver.quit();
//            return new FirefoxDriver(firefoxOptions);
//        }
        return firefoxDriver;
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
//        System.out.println("Open the browser");
        switch (browser) {
            case "chrome" -> {
                return createChromeDriver(driver);
            }
            case "firefox" -> {
                return createFirefoxDriver(driver);
            }
            default -> {
                return null;
        }
//        if(browser.equals("chrome")) {
//            driver = DriverUtils.createChromeDriver(driver);
//
//            return driver;
//        } else {
//            return null;
////            System.exit(1);
        }
    }
}
