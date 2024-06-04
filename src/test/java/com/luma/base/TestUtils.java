package com.luma.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {

    public static void hoverOverAnElement(BaseTest baseTest, By locator) {
        WebElement elementToHover = baseTest.getDriver().findElement(locator);
        new Actions(baseTest.getDriver())
                .moveToElement(elementToHover)
                .perform();
    }
}
