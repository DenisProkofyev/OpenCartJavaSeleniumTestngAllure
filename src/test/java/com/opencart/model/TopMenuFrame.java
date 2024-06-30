package com.opencart.model;

import com.opencart.model.base.BaseFrame;
import com.opencart.model.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuFrame<T extends BasePage<T>> extends BaseFrame<T> {

    @FindBy(linkText = "Tablets")
    private WebElement tabletsLink;

    @FindBy(linkText = "Desktops")
    private WebElement desktopsLink;

    @FindBy(css = "[href$='20_27']")
    private WebElement macSubcategoryLink;

    @FindBy(linkText = "Components")
    private WebElement componentsLink;

    @FindBy(css = "[href$='25_28']")
    private WebElement monitorsSubcategoryLink;

    public TopMenuFrame(WebDriver driver, T returnPage) {
        super(driver, returnPage);
    }

    @Step("Open 'Tablets' category")
    public TabletsPage openTabletsCategory() {
        tabletsLink.click();

        return new TabletsPage(getDriver());
    }

    @Step("Hover over 'Desktops' category")
    public T hoverOverDesktopsCategory() {
        hoverOverElement(desktopsLink);

        return getReturnPage();
    }

    @Step("Open 'Mac' subcategory")
    public MacSubcategoryPage openMacSubcategory() {
        macSubcategoryLink.click();

        return new MacSubcategoryPage(getDriver());
    }

    @Step("Hover over 'Components' category")
    public T hoverOverComponentsCategory() {
        hoverOverElement(componentsLink);

        return getReturnPage();
    }

    @Step("Open 'Monitors' subcategory")
    public MonitorsSubcategoryPage openMonitorsSubcategory() {
        monitorsSubcategoryLink.click();

        return new MonitorsSubcategoryPage(getDriver());
    }
}
