package com.opencart.model.base;

import com.opencart.model.HeaderFrame;
import com.opencart.model.TopMenuFrame;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage<T extends BasePage<T>> extends BaseModel {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverElement(WebElement element) {
        new Actions(getDriver())
                .moveToElement(element)
                .perform();
    }

    public void handleAlertIfPresent() {
        try {
            Alert alert = getDriver().switchTo().alert();
            System.out.println("Alert text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException ignored) {
        }
    }

    public TopMenuFrame<T> getTopMenu() {
        return new TopMenuFrame<>(getDriver(), (T) this);
    }

    public HeaderFrame<T> getHeader() {
        return new HeaderFrame<>(getDriver(), (T) this);
    }
}
