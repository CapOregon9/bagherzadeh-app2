package baseline;

public class ItemValidation {
    //This class is used to store methods that validate input from the user

    public boolean itemValueValidation(String itemValue) {
        //checks if the item value is grater than or equal to 0
        return false;
    }

    public boolean serialNumberFormatCheck(String serialNumber) {
        //checks if the item serial number is in the format of A-XXX-XXX-XXX where A must be a letter and X can be a letter or a digit
        //Serial number unique check is done in the inventory list to see if the item exists
        String regex = "[A-Za-z]-\\w{3}-\\w{3}-\\w{3}\\Z";
        serialNumber.matches(regex);
        return false;
    }

    public boolean itemNameLengthCheck(String itemName) {
        //checks if the item name is between 2 and 256 (inclusive)
        //returns the boolean value of the result
        return false;
    }
}
