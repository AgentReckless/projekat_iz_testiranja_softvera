package pages;

import constants.Constants;
import locators.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaHomePage extends BasePage {

    public PaHomePage(WebDriver driver) {
        super(driver);
    }

    public PaHomePage selectBrand(String brand) {
        waitForClickable(Locators.PA_BRAND_DROPDOWN).click();
        clickByJs(Locators.paDropdownOption("brand", brand.toLowerCase()));
        return this;
    }

    public PaHomePage selectYearFrom(String year) {
        waitForVisible(Locators.PA_YEAR_FROM_DROPDOWN);
        WebElement element = waitForClickable(Locators.PA_YEAR_FROM_DROPDOWN);
        element.click();

        clickByJs(Locators.paDropdownOption("yearFrom", year));
        
        return this;
    }

    public PaHomePage selectChassis(String chassis) {
        WebElement element = waitForClickable(Locators.PA_CHASSIS_DROPDOWN);
        var atr = this.getElementAtr(element);
        element.click();
        clickByJs(Locators.paDropdownOption("chassis", chassis));
        return this;
    }

    public PaHomePage selectFuel(String fuel) {
        WebElement element = waitForClickable(Locators.PA_FUEL_DROPDOWN);
        element.click();
        clickByJs(Locators.paDropdownOption("fuel", fuel));
        var atr = this.getElementAtr(element);
        element.click();
        return this;
    }

    public PaResultsPage clickSearch() {
        WebElement element = waitForClickable(Locators.PA_SEARCH_BUTTON);
        // clickByJs(Locators.PA_SEARCH_BUTTON);
        var atr = this.getElementAtr(element);
        element.click();
        return new PaResultsPage(driver);
    }

    public PaResultsPage clickDetailedSearch(){
        WebElement element = waitForClickable(Locators.PA_EXPANDED_SEARCH_BUTTON);
        // clickByJs(Locators.PA_SEARCH_BUTTON);
        var atr = this.getElementAtr(element);
        clickByJs(element);
        return new PaResultsPage(driver);
    }

    public PaHomePage scrollToFooter() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        return this;
    }

    public PaHomePage verifyFooterContainsONamaLink() {
        assertTrue(waitForVisible(Locators.PA_FOOTER_O_NAMA_LINK).isDisplayed(), "Footer ne sadrži link 'O nama'");
        return this;
    }

    public PaHomePage verifyFooterContainsKontaktLink() {
        assertTrue(waitForVisible(Locators.PA_FOOTER_KONTAKT_LINK).isDisplayed(), "Footer ne sadrži link 'Kontakt'");
        return this;
    }

    public PaHomePage verifyFooterContainsUsloviKoriscenjaLink() {
        assertTrue(waitForVisible(Locators.PA_FOOTER_USLOVI_KORISCENJA_LINK).isDisplayed(), "Footer ne sadrži link 'Uslovi korišćenja'");
        return this;
    }

    public PaHomePage scrollDownToSearch() {
        WebElement element = waitForClickable(Locators.PA_BRAND_DROPDOWN);
        scrollDownToElement(element);
        return this;
    }
}
