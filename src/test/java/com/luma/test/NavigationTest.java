package com.luma.test;

import com.luma.base.BaseTest;
import com.luma.base.TestUtils;
import com.luma.data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC_01 Open the Store base URL")
    public void testOpenStoreBaseURL() {

        final String expectedURL = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_URL_TITLE;

        Allure.step("Open the Store home page");
        getDriver().get("https://naveenautomationlabs.com/opencart");

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify the Store home page URL");
        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");
        Allure.step("Verify the Store home page title");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

    @Test(dataProvider = "navigationWithDropdownData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_02 Open the Store navigation menu options via dropdown")
    public void testNavigationBarMenuWithDropdown(String baseURL, By navBarMenu, By navBarDropdownMenu, String expectedURL, String expectedTitle) {

        Allure.step("Open the Store home page");
        getDriver().get(baseURL);

        Allure.step("Hover over the menu option");
        TestUtils.hoverOverAnElement(this, navBarMenu);

        Allure.step("Select all goods of the menu option");
        getDriver().findElement(navBarDropdownMenu).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify the navigated page URL");
        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");
        Allure.step("Verify the navigated page title");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

    @Test(dataProvider = "navigationWithoutDropdownData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_03 Open the Store navigation menu options without dropdown")
    public void testNavigationBarMenuWithoutDropdown(String baseURL, By navBarMenu, String expectedURL, String expectedTitle) {

        Allure.step("Open the Store home page");
        getDriver().get(baseURL);

        Allure.step("Click on the menu option");
        getDriver().findElement(navBarMenu).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify the navigated page URL");
        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");
        Allure.step("Verify the navigated page title");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }
}
