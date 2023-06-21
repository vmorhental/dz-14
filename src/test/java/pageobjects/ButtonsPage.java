package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonsPage extends BasePage{

    private static final By CLICK_ME_BUTTON = By.xpath("//button[text()='Click Me']");

    private static final By CLICK_ME_BUTTON_CLICKED_MESSAGE = By.xpath("//p[@id='dynamicClickMessage' and contains (text(),'You have done a dynamic click')]");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonAndReturnMessage (){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",getElement(CLICK_ME_BUTTON));
        System.out.println(getElement(CLICK_ME_BUTTON_CLICKED_MESSAGE).getText());
    }

    public WebElement getClickedButtonMessage(){
        return getElement(CLICK_ME_BUTTON_CLICKED_MESSAGE);
    }
}
