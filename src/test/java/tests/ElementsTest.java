package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ElementsPage;

public class ElementsTest extends BaseTest{
@Test
    public void buttonsPageIsOpenedTest (){
    new ElementsPage(driver).openButtonsPage();
    String actualResultURL = driver.getCurrentUrl();
    Assert.assertEquals(actualResultURL, "https://demoqa.com/buttons", "Incorrect page is opened");
}
}
