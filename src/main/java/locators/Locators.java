package locators;

import org.openqa.selenium.By;

public class Locators {


    // =====================
    // PA - Home Page
    // =====================
    public static final By PA_BRAND_DROPDOWN = By.xpath("//*[@id=\"brand\"]");
    // public static final By PA_YEAR_FROM_DROPDOWN = By.xpath("//*[contains(text(), 'Godište od') or @title='Godište od']");

    public static final By PA_YEAR_FROM_DROPDOWN = By.xpath("//*[@data-testid='yearFromPlaceholder']");    
    public static final By PA_CHASSIS_DROPDOWN = By.xpath("//div[@data-testid=\"chassisPlaceholder\"]");
    public static final By PA_FUEL_DROPDOWN = By.xpath("//div[@data-testid=\"fuel\"]");
    // Looks for a button containing "Pretraga" or "PRETRAGA"
    public static final By PA_SEARCH_BUTTON = By.xpath("//*[@data-testid='searchButton']");
    public static final By PA_EXPANDED_SEARCH_BUTTON = By.xpath("//*[@data-testid=\"detailedSearchButtonDataTestId\"]");
    public static final By PA_FOOTER_O_NAMA_LINK = By.xpath("(//a[normalize-space()='O nama'])[last()]");
    public static final By PA_FOOTER_KONTAKT_LINK = By.xpath("(//a[normalize-space()='Kontaktiraj nas'])[last()]");
    public static final By PA_FOOTER_USLOVI_KORISCENJA_LINK = By.xpath("(//a[normalize-space()='Uslovi korišćenja'])[last()]");
    // public static final By PA_SEARCH_BUTTON = By.xpath("//button[contains(text(), 'Pretraga') or contains(text(), 'PRETRAGA')]");

    // Dinamicki lokatori za opcije SumoSelect dropdowna
    public static By paDropdownOption(String option, String optionText) {
        return By.xpath(String.format(
                "//*[@data-testid='%s-option-%s']",
                option,
                optionText
        ));
    }

    // =====================
    // PA - Results Page
    // =====================
    public static final By PA_SORT_DROPDOWN = By.xpath("//*[@data-testid=\"top-selected-option-basic\"]");
    public static final By PA_RESULT_COUNT = By.xpath("//p[contains(text(),'Prikazano')]");
    public static final By PA_FEATURED_ADS = By.xpath("//*[@data-testid='featuredAd']");
    public static final By PA_NO_RESULTS_MESSAGE = By.cssSelector("[data-testid='noResultsMessage']");
    public static final By PA_OBELEZJE_INPUT = By.xpath("//input[@placeholder='Obeležje']");

    public static By paSortOption(String optionText) {
        return By.xpath(String.format(
                "//*[@data-testid='top-selected-option-%s']",
                optionText
        ));
    }

    // =====================
    // PA - Detail Page
    // =====================
    public static final By PA_PANEL_INFO_TITLE = By.xpath("//*[@data-testid='panelInfoTitle']");
    public static final By PA_MARKA_VALUE = By.xpath("//span[contains(., 'Marka')]/following-sibling::span");
    public static final By PA_CHASSIS_VALUE = By.xpath("//span[contains(., 'Karoserija')]/following-sibling::span");
    public static final By PA_FUEL_VALUE = By.xpath("//span[contains(., 'Gorivo')]/following-sibling::span");
    public static final By PA_YEAR_VALUE = By.xpath("//span[contains(., 'Godište')]/following-sibling::span");


    public static final By PA_DETAIL_BRAND = By.xpath("//div[contains(@class,'uk-width-1-2') and normalize-space(text())='Marka']/following-sibling::div[1]");
    public static final By PA_DETAIL_YEAR = By.xpath("//div[contains(@class,'uk-width-1-2') and normalize-space(text())='Godište']/following-sibling::div[1]");
    public static final By PA_DETAIL_CHASSIS = By.xpath("//div[contains(@class,'uk-width-1-2') and normalize-space(text())='Karoserija']/following-sibling::div[1]");
    public static final By PA_DETAIL_FUEL = By.xpath("//div[contains(@class,'uk-width-1-2') and normalize-space(text())='Gorivo']/following-sibling::div[1]");
    public static final By PA_DETAIL_TITLE = By.xpath("//h1[contains(@class,'classified-title')] | //h1[contains(text(),'godište')]");

}
