package com.opencart.model;

import com.opencart.model.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage<ProductPage> {

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
        return productBreadcrumbPath.getText();
    }
}
