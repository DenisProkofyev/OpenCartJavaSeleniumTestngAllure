package com.opencart.base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {

    public static void hoverOverAnElement(BaseTest baseTest, By locator) {
        WebElement elementToHover = baseTest.getDriver().findElement(locator);
        new Actions(baseTest.getDriver())
                .moveToElement(elementToHover)
                .perform();
    }

    public static void handleAlertIfPresent(BaseTest baseTest) {
        try {
            Alert alert = baseTest.getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException ignored) {
        }
    }
}
