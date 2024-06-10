package com.luma.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtils {
    private static final ChromeOptions chromeOptions;
    private static final FirefoxOptions firefoxOptions;

    static {
        chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");

        firefoxOptions = new FirefoxOptions();

        firefoxOptions.addArguments("--incognito");
        firefoxOptions.addArguments("--headless");
        firefoxOptions.addArguments("--window-size=1920,1080");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--no-sandbox");
        firefoxOptions.addArguments("--disable-dev-shm-usage");
    }

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

        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver createDriver(String browser, WebDriver driver) {
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
        }
    }
}
