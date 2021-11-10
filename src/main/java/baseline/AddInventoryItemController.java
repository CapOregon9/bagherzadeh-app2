package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddInventoryItemController {
    //create instance of inventory list to store data
    private InventoryList inventoryList = new InventoryList();

    @FXML
    private TextField newItemValueTextField;

    @FXML
    private TextField newNameTextField;

    @FXML
    private TextField newSerialNumberTextField;

    @FXML
    private Button saveInventoryItemButton;

    @FXML
    void saveInventoryItem(ActionEvent event) {
        //call method to validate inputs
        //if the serial number was not in the correct format, create an alert that pops up and informs the user that the serial number for the item was invalid
        //if the value was not in the correct format, do the same thing
        //if the name was not the correct length, do the same thing
        //if everything is correct, add item to the list and pass the data back to the main scene.
        //then show the main scene
    }

    public void initialize() {
        //can be used to call focus on a text field
    }

    public void inventoryListDataPass(InventoryList inventoryList) {
        //used to retrieve the inventory list from the main scene
        this.inventoryList = inventoryList;
    }
}
