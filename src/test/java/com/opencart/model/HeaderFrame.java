package com.opencart.model;

import com.opencart.model.base.BaseFrame;
import com.opencart.model.base.BasePage;
import io.qameta.allure.Step;
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

    @FindBy(css = "[title='My Account']")
    private WebElement myAccountButton;

    @FindBy(css = "li [href$='account/login']")
    private WebElement loginPageButton;

    public HeaderFrame(WebDriver driver, T returnPage) {
        super(driver, returnPage);
    }

    @Step("Verify the search field is displayed")
    public boolean isSearchFieldVisible() {
        return searchField.isDisplayed();
    }

    @Step("Type in a search value")
    public HeaderFrame<T> typeInSearchValue(String value) {
        searchField.sendKeys(value);

        return this;
    }

    @Step("Click 'Search' button")
    public SearchResultPage clickSearchButton() {
        searchButton.click();

        return new SearchResultPage(getDriver());
    }

    @Step("Click cart button")
    public CartPage clickCartButton() {
        cartButton.click();

        return new CartPage(getDriver());
    }

    @Step("Click 'My Account' button")
    public T clickMyAccountButton() {
        myAccountButton.click();

        return getReturnPage();
    }

    @Step("Click 'Login' button navigating to login page")
    public LoginPage clickLoginPageButton() {
        loginPageButton.click();

        return new LoginPage(getDriver());
    }
}
