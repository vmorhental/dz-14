package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends BasePage {
    private static final By BUTTONS_BUTTON = By.xpath("//span[@class='text' and contains (text(),'Buttons')]");
    private static final By TABLES_BUTTON = By.xpath("//span[@class='text' and contains (text(),'Web Tables')]");

    public ElementsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    public ButtonsPage openButtonsPage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",getElement(BUTTONS_BUTTON));
        return new ButtonsPage(driver);
    }

    public TablesPage openTablesPage() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",getElement(TABLES_BUTTON));
        return new TablesPage(driver);
    }


}
