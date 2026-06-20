package pages;

import locators.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaDetailPage extends BasePage {

    public PaDetailPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getBrandElement() {
        return driver.findElement(Locators.PA_MARKA_VALUE);
    }

    public WebElement getYear() {
        return driver.findElement(Locators.PA_YEAR_VALUE);
    }

    public WebElement getChassis() {
        return driver.findElement(Locators.PA_CHASSIS_VALUE);
    }

    public WebElement getFuel() {
        return driver.findElement(Locators.PA_FUEL_VALUE);
    }

    public PaDetailPage verifyBrand(String expectedBrand) {
        var brand = getBrandElement();
        String actualMarka = brand.getText().trim();
        assertEquals(expectedBrand, actualMarka, "Marka vozila se ne poklapa");
        return this;
    }

    public PaDetailPage verifyYearFrom(int expectedYearFrom) {
        assertTrue(isYearFromValid(expectedYearFrom), "Godište vozila je pre " + expectedYearFrom);
        return this;
    }

    private boolean isYearFromValid(int expectedYearFrom) {
        var year = getYear();
        String actualYear = year.getText().trim().substring(0,4);
        return Integer.parseInt(actualYear) >= expectedYearFrom;
    }

    public PaDetailPage verifyChassis(String expectedChassis) {
        WebElement chassisElement = getChassis();
        String actualChassis = chassisElement.getText().trim();
        assertEquals(expectedChassis, actualChassis, "Karoserija se ne poklapa");
        return this;
    }

    public PaDetailPage verifyFuel(String expectedFuel) {
        WebElement fuelElement = getFuel();
        String actualFuel = fuelElement.getText().trim();
        assertEquals(expectedFuel, actualFuel, "Gorivo se ne poklapa");
        return this;
    }

    public PaDetailPage scrollDownToInfo(){
        WebElement element = waitForClickable(Locators.PA_PANEL_INFO_TITLE);
        scrollDownToElement(element);
        return this;
    }

}