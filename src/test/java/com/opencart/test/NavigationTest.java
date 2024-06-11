package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.base.TestUtils;
import com.opencart.data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(
            description = "TC_01 Verify the Store home page"
//            groups = {"Smoke", "Regression"},
//            testName = "NAVIGATION | Navigate to top menu"
            )
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the Store home page is opened via current URL and the page title")
    public void testStoreHomePageURLAndTitle() {

        final String expectedURL = TestData.BASE_URL + "/";
        final String expectedTitle = TestData.BASE_URL_TITLE;

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
    public void testNavigationBarMenuWithDropdown(By navBarMenu, By navBarDropdownMenu, String expectedURL, String expectedTitle) {

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
    public void testNavigationBarMenuWithoutDropdown(By navBarMenu, String expectedURL, String expectedTitle) {

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
    public void testComponentsDropdownNavigation(By componentsCategory, By componentsDropdownMenuOption,
                                                 String expectedURL, String expectedTitle) {

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
