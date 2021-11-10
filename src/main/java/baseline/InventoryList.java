package baseline;

import java.util.ArrayList;
import java.util.List;

public class InventoryList {
    //create an arraylist to store the items of the inventory
    List<Item> inventoryItems = new ArrayList<>();

    public void addItem() {
        //used to add an item to the list
    }

    public void editItem() {
        //used to edit an item in the list
    }

    public boolean itemExists() {
        //used to see if the item exists in the inventory and returns that boolean value
        return false;
    }

    public void removeItem() {
        //used to remove an item from the list
    }

    public void clearAllItems() {
        //used to clear all items from the array list
    }

    public List<Item> getInventoryList() {
        //gives the list of items to implement file saving and file opening
        return inventoryItems;
    }
}
