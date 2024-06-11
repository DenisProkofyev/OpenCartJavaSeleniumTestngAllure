package com.opencart.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(name = "search")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }
}
