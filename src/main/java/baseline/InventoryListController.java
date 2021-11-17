/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Alexander Bagherzadeh
 */
package baseline;

import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class InventoryListController {
    //create instance of inventory list
    private InventoryList inventoryList = new InventoryList();

    //create observable list to be linked to the table view
    private final ObservableList<Item> list = FXCollections.observableArrayList();

    //create file chooser to be able to open and close files
    private FileChooser fileChooser = new FileChooser();

    //create stage variable to store the current stage
    Stage stage;

    @FXML
    private Button helpButton;

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
    private TextField searchTextField;

    @FXML
    private RadioButton nameSearchRadioButton;

    @FXML
    private RadioButton serialNumberSearchRadioButton;

    @FXML
    private ToggleGroup searchToggleGroup;

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

    private HostServices hostServices;

    @FXML
    void addNewItem(ActionEvent event) {
        //open scene to add an item
        //pass the information of the inventory list over in order to keep the data while transitioning scenes
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddInventoryItem.fxml"));

        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("Could not load add inventory item fxml.");
        }
        AddInventoryItemController controller = fxmlLoader.getController();
        controller.inventoryListDataPass(inventoryList, hostServices);
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void closeInventoryList(ActionEvent event) {
        //close the application
        stage = (Stage) ((Button)event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void editSelectedItem(ActionEvent event) {
        //open scene to edit the item that is selected
        //pass the information of the inventory list over in order to keep the data while transitioning scenes
        if (!inventoryTableView.getSelectionModel().isEmpty()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EditInventoryItem.fxml"));

            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                System.out.println("Could not load edit inventory item fxml.");
            }
            EditInventoryItemController controller = fxmlLoader.getController();
            controller.inventoryListDataPass(inventoryList, inventoryTableView.getSelectionModel().getSelectedItem(), hostServices);
            Scene scene = new Scene(root);
            JMetro jMetro = new JMetro(Style.LIGHT);
            jMetro.setScene(scene);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    void openNewInventoryList(ActionEvent event) {
        //call a method to open file depending on the file extension
        //method in class FileIO
        FileIO fileIO = new FileIO();
        fileChooser.setTitle("Open File");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            if (fileChooser.getSelectedExtensionFilter().getExtensions().get(0).equals("*.html")) {
                inventoryList = fileIO.openHTMLFile(file);
                resetObservableList(inventoryList);
            } else if (fileChooser.getSelectedExtensionFilter().getExtensions().get(0).equals("*.txt")) {
                inventoryList = fileIO.openTSVFile(file);
                resetObservableList(inventoryList);
            } else {
                inventoryList = fileIO.openJSONFile(file);
                resetObservableList(inventoryList);
            }
        }
    }

    public void resetObservableList(InventoryList inventoryList) {
        list.clear();
        list.addAll(inventoryList.getInventoryItems());
    }

    @FXML
    void removeAllItems(ActionEvent event) {
        //call method to remove all items from inventory list
        //update observable list
        inventoryList.clearAllItems();
        list.clear();
    }

    @FXML
    void removeSelectedItem(ActionEvent event) {
        //get the item that is selected
        //use the serial number to know which one to remove from the inventory list and call method
        //update observable list
        if (!inventoryTableView.getSelectionModel().isEmpty()) {
            inventoryList.removeItem(inventoryTableView.getSelectionModel().getSelectedItem().getSerialNumber());
            resetObservableList(inventoryList);
        }
    }

    @FXML
    void saveInventoryToFile(ActionEvent event) {
        //call a method to save file depending on the file extension
        //method in class FileIO
        FileIO fileIO = new FileIO();
        fileChooser.setTitle("Save File");
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            if (fileChooser.getSelectedExtensionFilter().getExtensions().get(0).equals("*.html")) {
                fileIO.saveHTMLFile(file, inventoryList);
            } else if (fileChooser.getSelectedExtensionFilter().getExtensions().get(0).equals("*.txt")) {
                fileIO.saveTSVFile(file, inventoryList);
            } else {
                fileIO.saveJSONFile(file, inventoryList);
            }
        }
    }

    @FXML
    void openUserGuide(ActionEvent event) {
        hostServices.showDocument("docs\\ItemInventoryUserGuide.pdf");
    }

    public List<Item> serialNumberContained(String serialNumber) {
        List<Item> tempList = new ArrayList<>();
        for (Item item : inventoryList.getInventoryItems()) {
            if (item.getSerialNumber().contains(serialNumber)) {
                tempList.add(item);
            }
        }
        return tempList;
    }

    public List<Item> itemNameContained(String itemName) {
        List<Item> tempList = new ArrayList<>();
        for (Item item : inventoryList.getInventoryItems()) {
            if (item.getItemName().toLowerCase().contains(itemName.toLowerCase())) {
                tempList.add(item);
            }
        }
        return tempList;
    }

    public void initialize() {
        //initialize radio button user data
        nameSearchRadioButton.setUserData("Name");
        serialNumberSearchRadioButton.setUserData("Serial");

        //initialize file chooser's extensions
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV file", "*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML File", "*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON File", "*.json"));

        //Connect inventory list to observable list
        list.addAll(inventoryList.getInventoryItems());

        //initialize table column cell factories to understand where the information is getting pulled
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        itemValueColumn.setCellValueFactory(new PropertyValueFactory<>("itemValue"));
        itemValueColumn.setCellFactory(column -> new ValueTableCell());

        //initialize table column sort parameters


        //initialize tableview values by connecting the array list
        inventoryTableView.setItems(list);

        //add listener to listen for a change in the item search text field
        //everytime a letter is entered, pull the string and check if the name contains the string
        //clear the observable list
        //if it does add it to the observable list
        //if the string is empty
        //call method to add all items from inventory list to the observable list
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            String searchData = searchTextField.getText();
            if (searchToggleGroup.getSelectedToggle().getUserData().equals("Name")) {
                List<Item> tempList = itemNameContained(searchData);
                list.clear();
                list.addAll(tempList);
            } else {
                List<Item> tempList = serialNumberContained(searchData);
                list.clear();
                list.addAll(tempList);
            }
        });
    }

    public void inventoryListDataPass(InventoryList inventoryList, HostServices hostServices) {
        //used to retrieve inventory data from other scenes when moving between them
        this.inventoryList = inventoryList;
        this.hostServices = hostServices;
        resetObservableList(inventoryList);
    }

    public void setHostServices(HostServices hostServices) {
        //used to be able to show user guide when clicking the help button
        this.hostServices = hostServices;
    }

    public void setInventoryList(InventoryList inventoryList) {
        //used for junit testing
        this.inventoryList = inventoryList;
    }
}
