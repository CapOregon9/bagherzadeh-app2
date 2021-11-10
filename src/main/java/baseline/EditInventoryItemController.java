package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditInventoryItemController {

    @FXML
    private TextField newItemValueTextField;

    @FXML
    private TextField newNameTextField;

    @FXML
    private TextField newSerialNumberTextField;

    @FXML
    private Button saveInventoryItemButton;

    //create instance of inventory list to store inventory data in this scene
    private InventoryList inventoryList = new InventoryList();

    //create instance variable of serial number to store the selected inventory item
    private String serialNumber;

    @FXML
    void saveInventoryItem(ActionEvent event) {
        //call method to validate inputs
        //if the serial number was not in the correct format, create an alert that pops up and informs the user that the serial number for the item was invalid
        //if the value was not in the correct format, do the same thing
        //if the name was not the correct length, do the same thing
        //if everything is correct, edit the item in the list and pass the data back to the main scene.
        //then show the main scene
    }

    public void inventoryListDataPass(InventoryList inventoryList, String serialNumber) {
        //used to retrieve the inventory list from the main scene
        this.inventoryList = inventoryList;
        this.serialNumber = serialNumber;
    }
}
