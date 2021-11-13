package baseline;

import javafx.application.HostServices;
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
import java.util.HashMap;
import java.util.Map;

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
    private InventoryList inventoryList;

    //create instance of item validation to validate input
    private ItemValidation itemValidation;

    //create instance variable of serial number to store the selected inventory item
    private Item item;

    private HostServices hostServices;

    public EditInventoryItemController() {
        inventoryList = new InventoryList();
        itemValidation = new ItemValidation();
    }

    @FXML
    void saveInventoryItem(ActionEvent event) {
        //call method to validate inputs
        //if the serial number was not in the correct format, create an alert that pops up and informs the user that the serial number for the item was invalid
        //if the value was not in the correct format, do the same thing
        //if the name was not the correct length, do the same thing
        //if everything is correct, edit the item in the list and pass the data back to the main scene.
        //then show the main scene
        if(itemValidation.itemNameLengthCheck(newNameTextField.getText()) && itemValidation.serialNumberFormatCheck(item.getSerialNumber(), newSerialNumberTextField.getText(), inventoryList) && itemValidation.itemValueValidation(newItemValueTextField.getText())) {
            inventoryList.editItem(item.getSerialNumber(), newNameTextField.getText(), newSerialNumberTextField.getText(), Double.parseDouble(newItemValueTextField.getText()));
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
        controller.inventoryListDataPass(inventoryList, hostServices);
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        //can be used to call focus on a text field and input previous data
        newNameTextField.selectAll();
    }

    public void inventoryListDataPass(InventoryList inventoryList, Item item, HostServices hostServices) {
        //used to retrieve the inventory list from the main scene
        this.inventoryList = inventoryList;
        this.item = item;
        this.hostServices = hostServices;
        initializeFields();
    }

    public void initializeFields() {
        newNameTextField.setText(item.getItemName());
        newSerialNumberTextField.setText(item.getSerialNumber());
        newItemValueTextField.setText(item.getItemValue());
    }
}
