package com.opencart.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {

    public static final String BASE_URL = "https://naveenautomationlabs.com/opencart";
    public static final String BASE_URL_TITLE = "Your Store";

    // Navigation Bar Menu

    public static final By DESKTOPS_MENU = By.xpath("//li/a[text()='Desktops']");
    public static final By ALL_DESKTOPS_DROPDOWN_MENU = By.xpath("//li//a[text()='Show All Desktops']");
    public static final String ALL_DESKTOPS_URL = BASE_URL + "/index.php?route=product/category&path=20";
    public static final String ALL_DESKTOPS_PAGE_TITLE = "Desktops";

    public static final By LAPTOPS_NOTEBOOKS_MENU = By.xpath("//li/a[text()='Laptops & Notebooks']");
    public static final By ALL_LAPTOPS_NOTEBOOKS_DROPDOWN_MENU = By.xpath("//li//a[text()='Show All Laptops & Notebooks']");
    public static final String ALL_LAPTOPS_NOTEBOOKS_URL = BASE_URL + "/index.php?route=product/category&path=18";
    public static final String ALL_LAPTOPS_NOTEBOOKS_PAGE_TITLE = "Laptops & Notebooks";

    // Components category
    public static final By COMPONENTS_MENU = By.xpath("//li/a[text()='Components']");
    public static final By ALL_COMPONENTS_DROPDOWN_MENU = By.xpath("//li//a[text()='Show All Components']");
    public static final String ALL_COMPONENTS_URL = BASE_URL + "/index.php?route=product/category&path=25";
    public static final String ALL_COMPONENTS_PAGE_TITLE = "Components";
    public static final By MICE_AND_TRACKBALLS = By.xpath("//li/a[text()='Mice and Trackballs (0)']");
    public static final By MONITORS = By.xpath("//li/a[text()='Monitors (2)']");
    public static final By PRINTERS = By.xpath("//li/a[text()='Printers (0)']");
    public static final By SCANNERS = By.xpath("//li/a[text()='Scanners (0)']");
    public static final By WEB_CAMERAS = By.xpath("//li/a[text()='Web Cameras (0)']");

    public static final String MICE_AND_TRACKBALLS_URL = BASE_URL + "/index.php?route=product/category&path=25_29";
    public static final String MICE_AND_TRACKBALLS_PAGE_TITLE = "Mice and Trackballs";

    public static final String MONITORS_URL = BASE_URL + "/index.php?route=product/category&path=25_28";
    public static final String MONITORS_PAGE_TITLE = "Monitors";

    public static final String PRINTERS_URL = BASE_URL + "/index.php?route=product/category&path=25_30";
    public static final String PRINTERS_PAGE_TITLE = "Printers";

    public static final String SCANNERS_URL = BASE_URL + "/index.php?route=product/category&path=25_31";
    public static final String SCANNERS_PAGE_TITLE = "Scanners";

    public static final String WEB_CAMERAS_URL = BASE_URL + "/index.php?route=product/category&path=25_32";
    public static final String WEB_CAMERAS_PAGE_TITLE = "Web Cameras";

    public static final By MP3_PLAYERS_MENU = By.xpath("//li/a[text()='MP3 Players']");
    public static final By ALL_MP3_PLAYERS_DROPDOWN_MENU = By.xpath("//li//a[text()='Show All MP3 Players']");
    public static final String ALL_MP3_PLAYERS_URL = BASE_URL + "/index.php?route=product/category&path=34";
    public static final String ALL_MP3_PLAYERS_PAGE_TITLE = "MP3 Players";

    public static final By TABLETS_MENU = By.xpath("//li/a[text()='Tablets']");
    public static final String TABLETS_URL = BASE_URL + "/index.php?route=product/category&path=57";
    public static final String TABLETS_PAGE_TITLE = "Tablets";

    public static final By SOFTWARE_MENU = By.xpath("//li/a[text()='Software']");
    public static final String SOFTWARE_URL = BASE_URL + "/index.php?route=product/category&path=17";
    public static final String SOFTWARE_PAGE_TITLE = "Software";

    public static final By PHONES_PDA_MENU = By.xpath("//li/a[text()='Phones & PDAs']");
    public static final String PHONES_PDA_URL = BASE_URL + "/index.php?route=product/category&path=24";
    public static final String PHONES_PDA_PAGE_TITLE = "Phones & PDAs";

    public static final By CAMERAS_MENU = By.xpath("//li/a[text()='Cameras']");
    public static final String CAMERAS_URL = BASE_URL + "/index.php?route=product/category&path=33";
    public static final String CAMERAS_PAGE_TITLE = "Cameras";

    public static final String UPLOADED_FILE_ALERT_MESSAGE = "Your file was successfully uploaded!";
    public static final String FILE_TO_UPLOAD_PATH = "src/test/resources/toTestUploading.txt";

    public static final String APPLE_CINEMA_QUANTITY_MESSAGE = "This product has a minimum quantity of 2";

    // login data
    public static final String EMAIL = "jahoba4756@kinsef.com";
    public static final String PASSWORD = "TestPassword";

    @DataProvider(name = "withDropdownNavigationData")
    public static Object[][] getWithDropdownNavMenuData() {
        return new Object[][] {
                {DESKTOPS_MENU, ALL_DESKTOPS_DROPDOWN_MENU, ALL_DESKTOPS_URL, ALL_DESKTOPS_PAGE_TITLE},
                {LAPTOPS_NOTEBOOKS_MENU, ALL_LAPTOPS_NOTEBOOKS_DROPDOWN_MENU, ALL_LAPTOPS_NOTEBOOKS_URL, ALL_LAPTOPS_NOTEBOOKS_PAGE_TITLE},
                {COMPONENTS_MENU, ALL_COMPONENTS_DROPDOWN_MENU, ALL_COMPONENTS_URL, ALL_COMPONENTS_PAGE_TITLE},
                {MP3_PLAYERS_MENU, ALL_MP3_PLAYERS_DROPDOWN_MENU, ALL_MP3_PLAYERS_URL, ALL_MP3_PLAYERS_PAGE_TITLE}
        };
    }

    @DataProvider(name = "withoutDropdownNavigationData")
    public static Object[][] getWithoutDropdownNavMenuData() {
        return new Object[][] {
                {TABLETS_MENU, TABLETS_URL, TABLETS_PAGE_TITLE},
                {SOFTWARE_MENU, SOFTWARE_URL, SOFTWARE_PAGE_TITLE},
                {PHONES_PDA_MENU, PHONES_PDA_URL, PHONES_PDA_PAGE_TITLE},
                {CAMERAS_MENU, CAMERAS_URL, CAMERAS_PAGE_TITLE}
        };
    }

    @DataProvider(name = "componentsCategoryNavigationData")
    public static Object[][] getComponentsCategoryNavigationData() {
        return new Object[][] {
                {COMPONENTS_MENU, MICE_AND_TRACKBALLS, MICE_AND_TRACKBALLS_URL, MICE_AND_TRACKBALLS_PAGE_TITLE},
                {COMPONENTS_MENU, MONITORS, MONITORS_URL, MONITORS_PAGE_TITLE},
                {COMPONENTS_MENU, PRINTERS, PRINTERS_URL, PRINTERS_PAGE_TITLE},
                {COMPONENTS_MENU, SCANNERS, SCANNERS_URL, SCANNERS_PAGE_TITLE},
                {COMPONENTS_MENU, WEB_CAMERAS, WEB_CAMERAS_URL, WEB_CAMERAS_PAGE_TITLE}
        };
    }
}
