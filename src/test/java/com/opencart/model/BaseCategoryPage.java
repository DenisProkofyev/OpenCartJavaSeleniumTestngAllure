package com.opencart.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseCategoryPage extends BasePage {

    public BaseCategoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the product {productId} image")
    public ProductPage clickProductImage(String productId) {
        getDriver().findElement(By.cssSelector(".image [href$='product_id=" + productId + "']")).click();

        return new ProductPage(getDriver());
    }
}
