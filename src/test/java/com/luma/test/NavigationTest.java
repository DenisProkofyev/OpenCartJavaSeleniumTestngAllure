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
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("TC_01 Verify the Store base URL")
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

    @Test(dataProvider = "withDropdownNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_02 Verify the Store navigation menu options via dropdown")
    public void testNavigationBarMenuWithDropdown(String baseURL, By navBarMenu, By navBarDropdownMenu, String expectedURL, String expectedTitle) {

        Allure.step("Open the Store home page");
        getDriver().get(baseURL);

        Allure.step("Hover over the menu option");
        TestUtils.hoverOverAnElement(this, navBarMenu);

        Allure.step("Show all goods of the category");
        getDriver().findElement(navBarDropdownMenu).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify the navigated page URL");
        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");

        Allure.step("Verify the navigated page title");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }

    @Test(dataProvider = "withoutDropdownNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_03 Verify the Store navigation menu options without dropdown")
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

    @Test(dataProvider = "componentsCategoryNavigationData", dataProviderClass = TestData.class)
    @Story("Navigation")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC_04 Verify the 'Components' category dropdown options navigation")
    public void testComponentsDropdownNavigation(String baseURL, By componentsCategory, By componentsDropdownMenuOption,
                                                 String expectedURL, String expectedTitle) {
        Allure.step("Open the Store home page");
        getDriver().get(baseURL);

        Allure.step("Hover over the 'Components' category menu option");
        TestUtils.hoverOverAnElement(this, componentsCategory);

        Allure.step("Select the appropriate dropdown menu option");
        getDriver().findElement(componentsDropdownMenuOption).click();

        final String actualURL = getDriver().getCurrentUrl();
        final String actualTitle = getDriver().getTitle();

        Allure.step("Verify the navigated page URL");
        Assert.assertEquals(actualURL, expectedURL, "Actual URL is different");

        Allure.step("Verify the navigated page title");
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title is different");
    }
}
