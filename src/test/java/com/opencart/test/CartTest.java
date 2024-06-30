package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    @Story("Cart preview")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the added item name via cart preview")
    public void testAddedItemNameViaCartPreview() {
        final String expectedItemName = "Samsung Galaxy Tab 10.1";

        String actualAddedItemName = new HomePage(getDriver())
                .getTopMenu().openTabletsCategory()
                .addTabletToCart()
                .clickPreviewCartButton()
                .getCartPreviewAddedItemName();

        Assert.assertEquals(actualAddedItemName, expectedItemName);
    }

    @Test(groups = {"smoke", "regression"})
    @Story("Cart preview")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the added item quantity via cart preview")
    public void testAddedItemQuantityViaCartPreview() {

        String actualAddedItemQuantity = new HomePage(getDriver())
                .getTopMenu().openTabletsCategory()
                .addTabletToCart()
                .clickPreviewCartButton()
                .getCartPreviewAddedItemQuantity();

        Assert.assertEquals(actualAddedItemQuantity, "1");
    }

    @Test(groups = {"smoke", "regression"})
    @Story("Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the added item name via cart")
    public void testAddedItemNameViaCart() {
        final String expectedItemName = "Samsung Galaxy Tab 10.1";

        String actualAddedItemName = new HomePage(getDriver())
                .getTopMenu().openTabletsCategory()
                .addTabletToCart()
                .getHeader().clickCartButton()
                .getAddedItemName();

        Assert.assertEquals(actualAddedItemName, expectedItemName);
    }

    @Test(groups = {"smoke", "regression"})
    @Story("Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify the added item quantity via cart")
    public void testAddedItemQuantityViaCart() {

        String actualAddedItemQuantity = new HomePage(getDriver())
                .getTopMenu().openTabletsCategory()
                .addTabletToCart()
                .getHeader().clickCartButton()
                .getAddedGoodsQuantity();

        Assert.assertEquals(actualAddedItemQuantity, "1");
    }
}
