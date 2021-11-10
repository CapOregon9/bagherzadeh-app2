package baseline;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.stage.FileChooser;

public class InventoryListController {
    //create instance of inventory list
    private InventoryList inventoryList = new InventoryList();

    //create observable list to be linked to the table view
    private final ObservableList<Item> list = FXCollections.observableArrayList();

    //create file chooser to be able to open and close files
    private FileChooser fileChooser = new FileChooser();

    @FXML
    private TableView<Item> inventoryTableView;

    @FXML
    private Button addItemButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button editSelectedButton;

    @FXML
    private TableColumn<Item, String> itemNameColumn;

    @FXML
    private TableColumn<Item, Double> itemValueColumn;

    @FXML
    private TextField nameSearchTextField;

    @FXML
    private Button openFileButton;

    @FXML
    private Button removeItemsButton;

    @FXML
    private Button removeSelectedButton;

    @FXML
    private Button saveFileButton;

    @FXML
    private TableColumn<Item, String> serialNumberColumn;

    @FXML
    private TextField serialNumberSearchTextField;

    @FXML
    void addNewItem(ActionEvent event) {
        //open scene to add an item
        //pass the information of the inventory list over in order to keep the data while transitioning scenes
    }

    @FXML
    void closeInventoryList(ActionEvent event) {
        //close the application
    }

    @FXML
    void editSelectedItem(ActionEvent event) {
        //open scene to edit the item that is selected
        //pass the information of the inventory list over in order to keep the data while transitioning scenes
    }

    @FXML
    void openNewInventoryList(ActionEvent event) {
        //call a method to open file depending on the file extension
        //method in class FileIO
    }

    @FXML
    void removeAllItems(ActionEvent event) {
        //call method to remove all items from inventory list
        //update observable list
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {
        //get the item that is selected
        //use the serial number to know which one to remove from the inventory list and call method
        //update observable list
    }

    @FXML
    void saveInventoryToFile(ActionEvent event) {
        //call a method to save file depending on the file extension
        //method in class FileIO
    }

    @FXML
    void searchByName(InputMethodEvent event) {
        //everytime a letter is entered, pull the string and check if the name contains the string
        //clear the observable list
        //if it does add it to the observable list
        //if the string is empty
        //call method to add all items from inventory list to the observable list
    }

    @FXML
    void searchBySerialNumber(InputMethodEvent event) {
        //everytime a letter is entered, pull the string and check if the serial number contains the string
        //clear the observable list
        //if it does add it to the observable list
        //if the string is empty
        //call method to add all items from inventory list to the observable list
    }

    @FXML
    void sortInventoryTableView(ActionEvent event) {
        //sort inventory depending on which column is clicked on to sort
        //inventoryTableView.getSortOrder().add(itemNameColumn);
    }

    public void initialize() {
        //initialize file chooser's extensions

        //test value to validate working tableView
        list.add(new Item("Name", "A-XXX-XXX-XXX", 99.99));
        list.add(new Item("Zame", "B-XXX-XXX-XXX", 99.99));
        list.add(new Item("Aame", "C-XXX-XXX-XXX", 99.99));

        //initialize table column cell factories to understand where the information is getting pulled
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("itemValue"));

        //initialize table column sort parameters


        //initialize tableview values by connecting the array list
        inventoryTableView.setItems(list);

        //add listener to get selected inventory item from the table view
    }

    public void inventoryListDataPass(InventoryList inventoryList) {
        //used to retrieve inventory data from other scenes when moving between them
        this.inventoryList = inventoryList;
    }
}
