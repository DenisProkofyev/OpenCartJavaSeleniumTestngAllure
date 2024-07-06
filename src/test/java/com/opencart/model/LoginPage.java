package com.opencart.model;

import com.opencart.data.TestData;
import com.opencart.model.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(css = "[value='Login']")
    private WebElement loginButton;

    @FindBy(className = "list-group-item")
    private List<WebElement> loginSidebarOptions;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter login data")
    public LoginPage enterLoginData() {
        emailField.sendKeys(TestData.EMAIL);
        passwordField.sendKeys(TestData.PASSWORD);

        return this;
    }

    @Step("Click login button")
    public AccountPage clickLoginButton() {
        loginButton.click();

        return new AccountPage(getDriver());
    }

    @Step("Get login sidebar menu options")
    public List<String> getSidebarMenuOptions() {
        return loginSidebarOptions.stream()
                .map(WebElement::getText)
                .toList();
    }
}
