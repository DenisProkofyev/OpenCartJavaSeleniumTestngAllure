package com.opencart.test;

import com.opencart.base.BaseTest;
import com.opencart.data.TestData;
import com.opencart.model.HomePage;
import com.opencart.model.ProductWithFilesUploadingPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoadingTests extends BaseTest {

    @Test(groups = "regression")
    @Story("Product page")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the successful file uploading on the Apple Cinema page")
    public void testAppleCinemaFileUploading() {

        new HomePage(getDriver())
                .hoverOverComponentsCategory()
                .openMonitorsSubcategory()
                .clickAppleCinemaImage()
                .uploadFile(TestData.FILE_TO_UPLOAD_PATH);

        Assert.assertEquals(new ProductWithFilesUploadingPage(getDriver()).getSuccessfullyUploadedFileAlertMessage(),
                TestData.UPLOADED_FILE_ALERT_MESSAGE);
    }
}
