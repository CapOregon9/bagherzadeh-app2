package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryListTest {
    InventoryList inventoryList;

    @BeforeEach
    void createObjects() {
        inventoryList = new InventoryList();
        inventoryList.addItem("Name", "A-XXX-XXX-XXX", 42.00);
    }

    @Test
    void addItem() {
        //Tests to see if you can add an item to the inventory list
        //compares the size of the list to the amount of items added which is 1 in this case
        assertEquals(1, inventoryList.getInventoryItems().size());
    }

    @Test
    void add1024Items() {
        //Tests to see if you can add 1024 items to the inventory list
        //compares the size of the list to the amount of items added which is 1024 in this case
        for (int i = 0; i < 1023; i++) {
            inventoryList.addItem("new", "A-XXX-XXX", 0.0);
        }
        assertEquals(1024, inventoryList.getInventoryItems().size());
    }

    @Test
    void editItemName() {
        //Tests to see if you can edit the item name
        inventoryList.editItem("A-XXX-XXX-XXX", "NewName", "A-XXX-XXX-XXX", 42.00);
        assertEquals("NewName", inventoryList.getInventoryItems().get(0).getItemName());
    }

    @Test
    void editItemSerialNumber() {
        //Tests to see if you can edit the item's serial number
        inventoryList.editItem("A-XXX-XXX-XXX", "Name", "B-XXX-XXX-XXX", 42.00);
        assertEquals("B-XXX-XXX-XXX", inventoryList.getInventoryItems().get(0).getSerialNumber());
    }

    @Test
    void editItemValue() {
        //Tests to see if you can edit the item value
        inventoryList.editItem("A-XXX-XXX-XXX", "Name", "A-XXX-XXX-XXX", 30.00);
        assertEquals(30.00, Double.parseDouble(inventoryList.getInventoryItems().get(0).getItemValue()), 0.001);
    }

    @Test
    void itemExistsWhenAdding() {
        //Tests the item exists when adding a new item
        assertTrue(inventoryList.itemExists("A-XXX-XXX-XXX"));
    }

    @Test
    void testItemExistsWhenEditingIfSame() {
        //Tests the item exits when editing an existing item if the serial number is the same
        assertFalse(inventoryList.itemExists("A-XXX-XXX-XXX", "A-XXX-XXX-XXX"));
    }

    @Test
    void testItemExistsWhenEditingIfDifferent() {
        //Tests the item exits when editing an existing item if the serial number is different
        inventoryList.addItem("Name2", "E-XXX-XXX-XXX", 45.00);
        assertFalse(inventoryList.itemExists("A-XXX-XXX-XXX", "C-XXX-XXX-XXX"));
    }

    @Test
    void testItemExistsWhenEditingIfDifferentButAnotherMatch() {
        //Tests the item exits when editing an existing item if the serial number is different
        inventoryList.addItem("Name2", "E-XXX-XXX-XXX", 45.00);
        assertTrue(inventoryList.itemExists("A-XXX-XXX-XXX", "E-XXX-XXX-XXX"));
    }

    @Test
    void removeItem() {
        //Tests to see if we can successfully remove an item from the list
        inventoryList.removeItem("A-XXX-XXX-XXX");
        assertEquals(0, inventoryList.getInventoryItems().size());
    }

    @Test
    void clearAllItems() {
        //Tests to see if we can remove all items from the list
        inventoryList.addItem("Name2", "B-XXX-XXX-XXX", 45.00);
        inventoryList.addItem("Name3", "C-XXX-XXX-XXX", 48.00);
        inventoryList.clearAllItems();
        assertEquals(0, inventoryList.getInventoryItems().size());
    }
}