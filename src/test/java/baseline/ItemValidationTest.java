package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemValidationTest {
    ItemValidation itemValidation;

    @BeforeEach
    void createObjects() {
        itemValidation = new ItemValidation();
    }

    @Test
    void itemValueValidation() {
        //Test that checks it the item value is greater than 0 and in numeric format
        //Can't Show false check because alert is being made and shown there causing an exception when running the test
        //Can check alerts during runtime of the application
        assertTrue(itemValidation.itemValueValidation("35.00"));
    }

    @Test
    void serialNumberFormatCheck() {
        //Test that checks it the item serial number is of the right format and doesn't exist in the list already
        //Can't Show false check because alert is being made and shown there causing an exception when running the test
        //Can check alerts during runtime of the application
        assertTrue(itemValidation.serialNumberFormatCheck("A-XXX-XXX-XXX", new InventoryList()));
    }

    @Test
    void SerialNumberFormatCheckWithSameSerialNumber() {
        //Test that checks it the item serial number is of the right format and doesn't exist in the list already besides itself when editing
        //Can't Show false check because alert is being made and shown there causing an exception when running the test
        //Can check alerts during runtime of the application
        assertTrue(itemValidation.serialNumberFormatCheck("A-XXX-XXX-XXX", "A-XXX-XXX-XXX", new InventoryList()));
    }

    @Test
    void itemNameLengthCheck() {
        //Checks if the name is between 2 and 256 characters inclusive
        //Can't Show false check because alert is being made and shown there causing an exception when running the test
        //Can check alerts during runtime of the application
        assertTrue(itemValidation.itemNameLengthCheck("Item Name First"));
    }
}