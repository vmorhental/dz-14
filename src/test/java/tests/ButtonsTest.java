package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ButtonsPage;
import pageobjects.ElementsPage;

public class ButtonsTest extends BaseTest{
    @Test
    public void messageTextAfterClickOnClickMeButtonTest (){
        new ElementsPage(driver)
                .openButtonsPage()
                .clickOnButtonAndReturnMessage();
        String actualMessage = new ButtonsPage(driver).getClickedButtonMessage().getText();
        Assert.assertEquals(actualMessage,"You have done a dynamic click", "Incorrect message");



    }
}
