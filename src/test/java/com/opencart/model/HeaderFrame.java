package com.opencart.model;

import com.opencart.model.base.BaseFrame;
import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderFrame<T extends BasePage<T>> extends BaseFrame<T> {

    @FindBy(name = "search")
    private WebElement searchField;

    @FindBy(css = "[class$='search']")
    private WebElement searchButton;

    @FindBy(css = "[title='Shopping Cart']")
    private WebElement cartButton;

    public HeaderFrame(WebDriver driver, T returnPage) {
        super(driver, returnPage);
    }

    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    public HeaderFrame<T> typeInSearchValue(String value) {
        searchField.sendKeys(value);

        return this;
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();

        return new SearchResultPage(getDriver());
    }

    public CartPage clickCartButton() {
        cartButton.click();

        return new CartPage(getDriver());
    }
}
