package com.opencart.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class ProductWithFilesUploadingPage extends ProductPage{

    @FindBy(id = "button-upload222")
    private WebElement uploadButton;

    @FindBy(css = "#form-upload input[type='file']")
    private WebElement uploadFileViaSelenium;

    public ProductWithFilesUploadingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Upload a file")
    public void uploadFile(String pathToFile) {
        File file = new File(pathToFile);

        uploadButton.click();
        uploadFileViaSelenium.sendKeys(file.getAbsolutePath());

        getWait2().until(ExpectedConditions.alertIsPresent());
    }

    @Step("Get successfully uploaded file Alert message")
    public String getSuccessfullyUploadedFileAlertMessage() {
        return getDriver().switchTo().alert().getText();
    }
}
