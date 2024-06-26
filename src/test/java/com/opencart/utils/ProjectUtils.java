package com.opencart.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ProjectUtils {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ProjectUtils.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static void logf(String str, Object... arr) {
        String formattedMessage = String.format(str, arr);
        Reporter.log(formattedMessage, true);
    }

    public static boolean isServerRun() {
        return System.getenv("CI_RUN") != null;
    }

    public static void takeScreenshot(WebDriver driver, ITestResult testResult) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Paths.get("screenshots"));
            FileHandler.copy(screenshot, new File(
                    "screenshots/" + testResult.getInstanceName() + "." + testResult.getName() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
