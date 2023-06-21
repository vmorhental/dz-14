package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.image.ByteLookupTable;

public class TablesPage extends BasePage {
    private static final By ADD_NEW_RECORD_BUTTON = By.xpath("//button[@id='addNewRecordButton']");
    private static final By FIRST_NAME_INPUT = By.xpath("//input[@id='firstName']");
    private static final By LAST_NAME_INPUT = By.xpath("//input[@id='lastName']");
    private static final By EMAIL_INPUT = By.xpath("//input[@id='userEmail']");
    private static final By AGE_INPUT = By.xpath("//input[@id='age']");
    private static final By SALARY_INPUT = By.xpath("//input[@id='salary']");
    private static final By DEPARTMENT_INPUT = By.xpath("//input[@id='department']");
    private static final By SUBMIT_BUTTON = By.xpath("//button[@id='submit']");
    private static final By EDIT_BUTTON = By.xpath("//div[@class='action-buttons']/span[@title='Edit']");
    private static final By TABLE_OF_RECORDS = By.xpath("//div[@class='rt-tbody']");
    private static String resultRow;
    private static WebElement neeededRow;

    int matchedRow;
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    public TablesPage(WebDriver driver) {
        super(driver);
    }

    public TablesPage createRecord(String firstName, String lastName) {
        executor.executeScript("arguments[0].click();", getElement(ADD_NEW_RECORD_BUTTON));
        getElement(FIRST_NAME_INPUT).sendKeys(firstName);
        getElement(LAST_NAME_INPUT).sendKeys(lastName);
        getElement(EMAIL_INPUT).sendKeys("Bob@test.com");
        getElement(AGE_INPUT).sendKeys("55");
        getElement(SALARY_INPUT).sendKeys("9000");
        getElement(DEPARTMENT_INPUT).sendKeys("QA");
        executor.executeScript("arguments[0].click();", getElement(SUBMIT_BUTTON));
        return this;
    }

    public TablesPage openEditFormOfGivenRecord(String firstName) {
        String TABLE_ROWS = "//div[@class='rt-tbody']//div[@role='rowgroup']";
        int numberOfRows = getElements(By.xpath(TABLE_ROWS)).size();
        for (int i = 1; i <= numberOfRows; i++) {
            if (driver.findElement(By.xpath(TABLE_ROWS + "[" + i + "]//div[@class='rt-td']")).getText().equals(firstName)) {
                matchedRow = i;
                break;
            }
        }
        resultRow = (TABLE_ROWS + "//div[@class='action-buttons']/span[@id='edit-record-" + matchedRow + "']");
        neeededRow = getElement(By.xpath(resultRow));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", neeededRow);
        return this;
    }

    public TablesPage updateAddedRecord() {
        getElement(FIRST_NAME_INPUT).sendKeys("UpdatedFirstName");
        getElement(LAST_NAME_INPUT).sendKeys("UpdatedLastName");
        executor.executeScript("arguments[0].click();", getElement(SUBMIT_BUTTON));
        return this;
    }

    public WebElement getFirstNameField() {
        return getElement(FIRST_NAME_INPUT);
    }

}
