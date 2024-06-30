package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TabletsPage extends BasePage<TabletsPage> {

    @FindBy(css = "[onclick^=\"cart.add('49', '1')\"]")
    private WebElement addTabletToCartButton;

    @FindBy(css = "#cart button[data-toggle='dropdown']")
    private WebElement cartPreviewButton;

    @FindBy(css = ".table-striped [class$='left'] [href*='product_id']")
    private WebElement cartPreviewAddedItemName;

    @FindBy(xpath = "(//td[@class='text-right'])[1]")
    private WebElement cartPreviewAddedItemQuantity;

    @FindBy(className = "alert")
    private WebElement itemAddedSuccessfullyMessage;

    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    public TabletsPage addTabletToCart() {
        addTabletToCartButton.click();

        return this;
    }

    public TabletsPage clickPreviewCartButton() {
        getWait2().until(ExpectedConditions.visibilityOf(itemAddedSuccessfullyMessage));
        cartPreviewButton.click();

        return this;
    }

    public String getCartPreviewAddedItemName() {
        getWait2().until(ExpectedConditions.visibilityOf(cartPreviewAddedItemName));

        return cartPreviewAddedItemName.getText();
    }

    public String getCartPreviewAddedItemQuantity() {
        getWait2().until(ExpectedConditions.visibilityOf(cartPreviewAddedItemQuantity));

        return cartPreviewAddedItemQuantity.getText().replace("x ", "");
    }
}
