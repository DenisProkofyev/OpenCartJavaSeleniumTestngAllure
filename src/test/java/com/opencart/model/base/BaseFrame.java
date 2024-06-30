package com.opencart.model.base;

import org.openqa.selenium.WebDriver;

public abstract class BaseFrame<T extends BasePage<T>> extends BasePage<T> {

    private final T returnPage;

    protected BaseFrame(WebDriver driver, T returnPage) {
        super(driver);
        this.returnPage = returnPage;
    }

    public T getReturnPage() {
        return returnPage;
    }
}
