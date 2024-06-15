package com.opencart.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(css = "[name^='quantity']")
    private WebElement addedItemQuantity;

    @FindBy(css = ".table-bordered [class$='left'] [href*='product_id']")
    private WebElement addedItemName;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getAddedGoodsQuantity() {
        return addedItemQuantity.getAttribute("value");
    }

    public String getAddedItemName() {
        return addedItemName.getText();
    }
}
