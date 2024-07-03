package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.model.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    @Story("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify a registered user can log in")
    public void testLogin() {

    String actualHeading = new HomePage(getDriver())
            .getHeader().clickMyAccountButton()
            .getHeader().clickLoginPageButton()
            .enterLoginData()
            .clickLoginButton()
            .getAccountHeading();

        Assert.assertEquals(actualHeading, "My Account");
    }
}
