package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ElementsPage;
import pageobjects.TablesPage;

public class TablesTest extends BaseTest {
    @Test
    public void testAddedRecordIsPresentOnTablesPage() {
        new ElementsPage(driver)
                .openTablesPage()
                .createRecord("Bob", "Tester")
                .openEditFormOfGivenRecord("Bob");
        String addedRecordFirstName = new TablesPage(driver).getFirstNameField().getAttribute("value");
        Assert.assertEquals(addedRecordFirstName, "Bob", "Record is not added");
    }

    @Test
    public void testAddedRecordIsEdited() {
        new ElementsPage(driver)
                .openTablesPage()
                .createRecord("Bob", "Tester")
                .openEditFormOfGivenRecord("Bob")
                .updateAddedRecord()
                .openEditFormOfGivenRecord("BobUpdatedFirstName");
        String addedRecordFirstName = new TablesPage(driver).getFirstNameField().getAttribute("value");
        Assert.assertEquals(addedRecordFirstName, "BobUpdatedFirstName", "Record is not added");
    }
}
