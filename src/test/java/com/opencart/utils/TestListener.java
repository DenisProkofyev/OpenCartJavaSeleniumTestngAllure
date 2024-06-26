package com.opencart.utils;

import com.opencart.base.BaseTest;
import org.openqa.selenium.WebDriver;
        import org.testng.ITestContext;
        import org.testng.ITestListener;
        import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        if (currentClass instanceof BaseTest) {
            WebDriver driver = ((BaseTest) currentClass).getDriver();
            ProjectUtils.takeScreenshot(driver, result);
        } else {
            System.err.println("Test class does not extend BaseTest: " + result.getInstanceName());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}

