package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class AddInventoryItemController {
    //create instance of inventory list to store data
    private InventoryList inventoryList = new InventoryList();

    //create instance of item validation to validate input
    private ItemValidation itemValidation = new ItemValidation();

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
        if(itemValidation.itemNameLengthCheck(newNameTextField.getText()) && itemValidation.serialNumberFormatCheck(newSerialNumberTextField.getText(), inventoryList) && itemValidation.itemValueValidation(newItemValueTextField.getText())) {
            inventoryList.addItem(newNameTextField.getText(), newSerialNumberTextField.getText(), Double.parseDouble(newItemValueTextField.getText()));
            transitionToInventoryList(event);
        }
    }

    public void transitionToInventoryList(ActionEvent event) {
        Stage stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InventoryList.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("Could not load item inventory list fxml.");
        }
        InventoryListController controller = fxmlLoader.getController();
        controller.inventoryListDataPass(inventoryList);
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        //can be used to call focus on a text field
        newNameTextField.selectAll();
    }

    public void inventoryListDataPass(InventoryList inventoryList) {
        //used to retrieve the inventory list from the main scene
        this.inventoryList = inventoryList;
    }
}
