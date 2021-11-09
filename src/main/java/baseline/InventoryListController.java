package baseline;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class InventoryListController {

    @FXML
    private TableView<?> InventoryTableView;

    @FXML
    private Button addItemButton;

    @FXML
    private Button closeButton;

    @FXML
    private Button editSelectedButton;

    @FXML
    private TableColumn<?, ?> itemNameColumn;

    @FXML
    private TableColumn<?, ?> itemValueColumn;

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
    private TableColumn<?, ?> serialNumberColumn;

    @FXML
    private TextField serialNumberSearchTextField;

    @FXML
    void addNewItem(ActionEvent event) {

    }

    @FXML
    void closeInventoryList(ActionEvent event) {

    }

    @FXML
    void editSelectedItem(ActionEvent event) {

    }

    @FXML
    void openNewInventoryList(ActionEvent event) {

    }

    @FXML
    void removeAllItems(ActionEvent event) {

    }

    @FXML
    void removeSelectedItem(ActionEvent event) {

    }

    @FXML
    void saveInventoryToFile(ActionEvent event) {

    }

    @FXML
    void searchByName(InputMethodEvent event) {

    }

    @FXML
    void searchBySerialNumber(InputMethodEvent event) {

    }

    @FXML
    void sortInventoryTableView(ActionEvent event) {

    }

}
