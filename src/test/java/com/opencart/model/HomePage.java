package com.opencart.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(name = "search")
    private WebElement searchField;

    @FindBy(css = "[class$='search']")
    private WebElement searchButton;

    @FindBy(linkText = "Tablets")
    private WebElement tabletsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public HomePage typeInSearchValue(String value) {
        searchField.sendKeys(value);

        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();

        return new SearchResultPage(getDriver());
    }

    public TabletsPage openTabletsCategory() {
        tabletsLink.click();

        return new TabletsPage(getDriver());
    }
}
