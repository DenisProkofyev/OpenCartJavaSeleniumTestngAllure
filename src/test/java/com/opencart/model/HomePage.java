package com.opencart.model;

import io.qameta.allure.Step;
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

    @FindBy(linkText = "Desktops")
    private WebElement desktopsLink;

    @FindBy(css = "[href$='20_27']")
    private WebElement macSubcategoryLink;

    @FindBy(linkText = "Components")
    private WebElement componentsLink;

    @FindBy(css = "[href$='25_28']")
    private WebElement monitorsSubcategoryLink;

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

    @Step("Hover over 'Desktops' category")
    public HomePage hoverOverDesktopsCategory() {
        hoverOverElement(desktopsLink);

        return this;
    }

    @Step("Open Mac subcategory")
    public MacSubcategoryPage openMacSubcategory() {
        macSubcategoryLink.click();

        return new MacSubcategoryPage(getDriver());
    }

    @Step("Hover over 'Components' category")
    public HomePage hoverOverComponentsCategory() {
        hoverOverElement(componentsLink);

        return this;
    }

    @Step("Open 'Monitors' subcategory")
    public MonitorsSubcategoryPage openMonitorsSubcategory() {
        monitorsSubcategoryLink.click();

        return new MonitorsSubcategoryPage(getDriver());
    }
}
