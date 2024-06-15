package com.opencart.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(css = ".table-bordered [class$='left'] [href*='product_id']")
    private WebElement addedItemName;

    @FindBy(css = "[name^='quantity']")
    private WebElement addedItemQuantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getAddedItemName() {
        getWait2().until(ExpectedConditions.visibilityOf(addedItemName));

        return addedItemName.getText();
    }

    public String getAddedGoodsQuantity() {
        getWait2().until(ExpectedConditions.visibilityOf(addedItemQuantity));
        return addedItemQuantity.getAttribute("value");
    }
}
