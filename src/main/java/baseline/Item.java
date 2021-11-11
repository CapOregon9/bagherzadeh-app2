package baseline;

public class Item {
    //create instance variables to store the name, serial number, and value of the item
    private String itemName;
    private String serialNumber;
    private double itemValue;

    public Item(String itemName, String serialNumber, double itemValue) {
        //initialize the values of an item when made and added to the list
        this.itemName = itemName;
        this.serialNumber = serialNumber;
        this.itemValue = itemValue;
    }


    //getters and setters used in inventory adding, editing, sorting, and other management
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getItemValue() {
        return Math.floor(itemValue * 100.00) / 100.00;
    }

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }
}
