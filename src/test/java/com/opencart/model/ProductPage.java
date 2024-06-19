package com.opencart.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(tagName = "h1")
    private WebElement productName;

    @FindBy(css = "#product-product .breadcrumb")
    private WebElement productBreadcrumbPath;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the product name")
    public String getProductName() {
        return productName.getText();
    }

    @Step("Get the product breadcrumb path")
    public String getProductBreadCrumbPath() {
        return getWait5().until(ExpectedConditions.visibilityOf(productBreadcrumbPath)).getText();
    }

}
