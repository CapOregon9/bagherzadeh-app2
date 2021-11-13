package baseline;

import com.sun.javafx.application.HostServicesDelegate;
import javafx.application.HostServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryListControllerTest {
    //Sorting by value, serial number, and name is handled by the table view object innately without any adjustment needed
    //You click the appropriate column header to sort
    InventoryListController inventoryListController;
    InventoryList inventoryList;

    @BeforeEach
    void createObjects() {
        inventoryListController = new InventoryListController();
        inventoryList = new InventoryList();
        inventoryList.addItem("Name", "A-X1X-222-333", 45.00);
        inventoryList.addItem("Name2", "A-X1X-222-333", 48.00);
        inventoryList.addItem("Aame3", "A-X2X-222-333", 51.00);
        inventoryListController.setInventoryList(inventoryList);
    }

    @Test
    void serialNumberContained() {
        //Tests to see if the serial number search is editing the list to give back to the observable list
        List<Item> tempList = inventoryListController.serialNumberContained("A-X1X");
        assertEquals(2, tempList.size());
    }

    @Test
    void itemNameContained() {
        //Tests to see if the item name number search is editing the list to give back to the observable list
        List<Item> tempList = inventoryListController.itemNameContained("Nam");
        assertEquals(2, tempList.size());
    }
}