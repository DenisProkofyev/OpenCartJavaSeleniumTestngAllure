package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddedItemNameViaCartPreview() {
        final String expectedItemName = "Samsung Galaxy Tab 10.1";

        String actualAddedItemName = new HomePage(getDriver())
                .openTabletsCategory()
                .addTabletToCart()
                .clickPreviewCartButton()
                .getCartPreviewAddedItemName();

        Assert.assertEquals(actualAddedItemName, expectedItemName);
    }

    @Test
    public void testAddedItemQuantityViaCartPreview() {

        String actualAddedItemQuantity = new HomePage(getDriver())
                .openTabletsCategory()
                .addTabletToCart()
                .clickPreviewCartButton()
                .getCartPreviewAddedItemQuantity();

        Assert.assertEquals(actualAddedItemQuantity, "1");
    }

    @Test
    public void testAddedItemNameViaCart() {
        final String expectedItemName = "Samsung Galaxy Tab 10.1";

        String actualAddedItemName = new HomePage(getDriver())
                .openTabletsCategory()
                .addTabletToCart()
                .clickCartButton()
                .getAddedItemName();

        Assert.assertEquals(actualAddedItemName, expectedItemName);
    }

    @Test
    public void testAddedItemQuantityViaCart() {

        String actualAddedItemQuantity = new HomePage(getDriver())
                .openTabletsCategory()
                .addTabletToCart()
                .clickCartButton()
                .getAddedGoodsQuantity();

        Assert.assertEquals(actualAddedItemQuantity, "1");
    }
}
