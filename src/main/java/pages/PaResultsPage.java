package pages;

import locators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaResultsPage extends BasePage {

    public PaResultsPage(WebDriver driver) {
        super(driver);
    }

    public PaResultsPage sortBy(String sortOption) {
        waitForClickable(Locators.PA_SORT_DROPDOWN).click();
        clickByJs(Locators.paSortOption(sortOption));
        return this;
    }

    public String getResultCount() {
        return getTextOf(Locators.PA_RESULT_COUNT);
    }

    public PaResultsPage verifyBadSearchResult() {
        WebElement noResultsMessage = waitForVisible(Locators.PA_NO_RESULTS_MESSAGE);
        assertTrue(noResultsMessage.isDisplayed(), "Poruka za pretragu bez rezultata nije prikazana");
        return this;
    }

    public PaResultsPage scrollDownToSearch() {
        WebElement element = waitForClickable(Locators.PA_SORT_DROPDOWN);
        scrollDownToElement(element);
        return this;
    }

    public PaDetailPage getFirstResult() {
        // Uzmemo sve elemente koji imaju PA_FEATURED_ADS xpath
        WebElement firstResult = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                Locators.PA_FEATURED_ADS,
                0
        )).get(0);
        // za dobijeni element uzmemo link koji se u njemu nalazi
        WebElement firstResultLink = firstResult.findElement(By.xpath(".//a[@href]"));
        scrollDownToElement(firstResultLink);
        clickByJs(firstResultLink);
        return new PaDetailPage(driver);
    }

    public PaResultsPage inputSearch(String badInput){
        WebElement element = waitForClickable(Locators.PA_OBELEZJE_INPUT);
        element.clear();
        element.sendKeys(badInput);
        clickSearch();
        return this;
    }

    public PaResultsPage clickSearch() {
        WebElement element = waitForClickable(Locators.PA_SEARCH_BUTTON);
        // clickByJs(Locators.PA_SEARCH_BUTTON);
        var atr = this.getElementAtr(element);
        element.click();
        return new PaResultsPage(driver);
    }
}
