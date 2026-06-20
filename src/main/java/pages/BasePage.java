package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void clickByJs(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].click();", element);
    }

    protected void clickByJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    protected void scrollDownToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    protected String getTextOf(By locator) {
        return waitForVisible(locator).getText().trim();
    }

    public Map<String, String> getElementAtr(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = 
            "let items = {};" +
            "for (let i = 0; i < arguments[0].attributes.length; i++) {" +
            "    let attr = arguments[0].attributes[i];" +
            "    items[attr.name] = attr.value;" +
            "}" +
            "return items;";

        // Execute script and cast the returned object to a Map
        @SuppressWarnings("unchecked")
        Map<String, String> allAttributes = (Map<String, String>) js.executeScript(script, element);
        return allAttributes;
    }

}
