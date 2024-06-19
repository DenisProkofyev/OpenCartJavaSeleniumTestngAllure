package com.opencart.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MacSubCategoryPage extends BasePage {

    public MacSubCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the product image")
    public ProductPage clickProductImage(String productId) {
        getDriver().findElement(By.cssSelector(".image [href$='product_id=" + productId + "']")).click();

        return new ProductPage(getDriver());
    }
}
