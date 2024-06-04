package com.luma.data;

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

    public static final By COMPONENTS_MENU = By.xpath("//li/a[text()='Components']");
    public static final By ALL_COMPONENTS_DROPDOWN_MENU = By.xpath("//li//a[text()='Show All Components']");
    public static final String ALL_COMPONENTS_URL = BASE_URL + "/index.php?route=product/category&path=25";
    public static final String ALL_COMPONENTS_PAGE_TITLE = "Components";

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

    @DataProvider(name = "navigationWithDropdownData")
    public static Object[][] getNavMenuWithDropdownData() {
        return new Object[][] {
                {BASE_URL, DESKTOPS_MENU, ALL_DESKTOPS_DROPDOWN_MENU, ALL_DESKTOPS_URL, ALL_DESKTOPS_PAGE_TITLE},
                {BASE_URL, LAPTOPS_NOTEBOOKS_MENU, ALL_LAPTOPS_NOTEBOOKS_DROPDOWN_MENU, ALL_LAPTOPS_NOTEBOOKS_URL, ALL_LAPTOPS_NOTEBOOKS_PAGE_TITLE},
                {BASE_URL, COMPONENTS_MENU, ALL_COMPONENTS_DROPDOWN_MENU, ALL_COMPONENTS_URL, ALL_COMPONENTS_PAGE_TITLE},
                {BASE_URL, MP3_PLAYERS_MENU, ALL_MP3_PLAYERS_DROPDOWN_MENU, ALL_MP3_PLAYERS_URL, ALL_MP3_PLAYERS_PAGE_TITLE}
        };
    }

    @DataProvider(name = "navigationWithoutDropdownData")
    public static Object[][] getNavMenuWithoutDropdownData() {
        return new Object[][] {
                {BASE_URL, TABLETS_MENU, TABLETS_URL, TABLETS_PAGE_TITLE},
                {BASE_URL, SOFTWARE_MENU, SOFTWARE_URL, SOFTWARE_PAGE_TITLE},
                {BASE_URL, PHONES_PDA_MENU, PHONES_PDA_URL, PHONES_PDA_PAGE_TITLE},
                {BASE_URL, CAMERAS_MENU, CAMERAS_URL, CAMERAS_PAGE_TITLE}
        };
    }
}
