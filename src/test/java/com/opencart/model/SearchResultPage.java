package com.opencart.model;

import com.opencart.model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage<SearchResultPage> {

    @FindBy(tagName = "h1")
    private WebElement pageHeading;

    @FindBy(css = "h2 + p")
    private WebElement noResultsMessage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getPageHeading() {
        return pageHeading.getText().replace("Search - ", "");
    }

    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }
}
