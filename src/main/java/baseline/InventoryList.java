/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Alexander Bagherzadeh
 */
package baseline;

import java.util.ArrayList;
import java.util.List;


public class InventoryList {
    //create an arraylist to store the items of the inventory
    private List<Item> inventoryItems = new ArrayList<>();

    public void addItem(String itemName, String serialNumber, double itemValue) {
        //used to add an item to the list
        inventoryItems.add(new Item(itemName, serialNumber, itemValue));
    }

    public void editItem(String serialNumber, String newItemName, String newSerialNumber, double newItemValue) {
        //used to edit an item in the list
        for (Item item : inventoryItems) {
            if(item.getSerialNumber().equals(serialNumber)) {
                item.setItemName(newItemName);
                item.setItemValue(newItemValue);
                item.setSerialNumber(newSerialNumber);
                return;
            }
        }
    }

    public boolean itemExists(String serialNumber) {
        //used to see if the item exists in the inventory and returns that boolean value
        for (Item item : inventoryItems) {
            if(item.getSerialNumber().equals(serialNumber)) {
                return true;
            }
        }
        return false;
    }

    public boolean itemExists(String serialNumber, String newSerialNumber) {
        //used to see if the item exists in the inventory and returns that boolean value
        //can be the same serial number than itself due to being called from edit inventory item controller
        if (!serialNumber.equals(newSerialNumber)) {
            for (Item item : inventoryItems) {
                if (item.getSerialNumber().equals(newSerialNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void removeItem(String serialNumber) {
        //used to remove an item from the list
        for (Item item : inventoryItems) {
            if(item.getSerialNumber().equals(serialNumber)) {
                inventoryItems.remove(item);
                return;
            }
        }
    }

    public void clearAllItems() {
        //used to clear all items from the array list
        inventoryItems.clear();
    }

    public List<Item> getInventoryItems() {
        //gives the list of items to implement file saving and file opening
        return inventoryItems;
    }
}
