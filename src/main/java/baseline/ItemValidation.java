/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Alexander Bagherzadeh
 */
package baseline;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ItemValidation {
    //This class is used to store methods that validate input from the user

    public boolean itemValueValidation(String itemValue) {
        //checks if the item value is grater than or equal to 0
        double tempValue;
        try {
            tempValue = Double.parseDouble(itemValue);
        } catch (NumberFormatException e) {
            //print alert message and return false
            Alert alert = new Alert(Alert.AlertType.ERROR, "Value must be numeric.", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }
        if (tempValue >= 0) {
            return true;
        } else {
            //print alert message and return false
            Alert alert = new Alert(Alert.AlertType.ERROR, "Value must be greater than 0.", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }

    }

    public boolean serialNumberFormatCheck(String serialNumber, InventoryList inventoryList) {
        //checks if the item serial number is in the format of A-XXX-XXX-XXX where A must be a letter and X can be a letter or a digit
        //Serial number unique check is done in the inventory list to see if the item exists
        String regex = "[A-Za-z]-\\w{3}-\\w{3}-\\w{3}\\Z";
        if (serialNumber.matches(regex) && !inventoryList.itemExists(serialNumber)) {
            return true;
        } else {
            //print alert message and return false
            Alert alert = new Alert(Alert.AlertType.ERROR, "Serial Number must be unique and in the format of A-XXX-XXX-XXX where A is any letter and X is any letter or digit.", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }
    }

    public boolean serialNumberFormatCheck(String serialNumber, String newSerialNumber, InventoryList inventoryList) {
        //checks if the item serial number is in the format of A-XXX-XXX-XXX where A must be a letter and X can be a letter or a digit
        //Serial number unique check is done in the inventory list to see if the item exists
        //used for edit item controller.
        String regex = "[A-Za-z]-\\w{3}-\\w{3}-\\w{3}\\Z";
        if (newSerialNumber.matches(regex) && !inventoryList.itemExists(serialNumber, newSerialNumber)) {
            return true;
        } else {
            //print alert message and return false
            Alert alert = new Alert(Alert.AlertType.ERROR, "Serial Number must be unique and in the format of A-XXX-XXX-XXX where A is any letter and X is any letter or digit.", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }
    }

    public boolean itemNameLengthCheck(String itemName) {
        //checks if the item name is between 2 and 256 (inclusive)
        //returns the boolean value of the result
        if (itemName.length() > 1 && itemName.length() < 257) {
            return true;
        } else {
            //print alert message and return false
            Alert alert = new Alert(Alert.AlertType.ERROR, "Name must be between 2 and 256 (inclusive)", ButtonType.CLOSE);
            alert.showAndWait();
            return false;
        }
    }
}
