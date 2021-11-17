/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Alexander Bagherzadeh
 */
package baseline;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.util.Objects;

public class InventoryManagementApplication extends javafx.application.Application {
    public static void main(String[] args) {
        //launches the javafx application and calls the overridden start method
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //opens the initial scene and used the JMetro javafx skin to modernize the look of the application.
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("InventoryList.fxml")));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("Could not load item list fxml.");
        }
        InventoryListController inventoryListController = loader.getController();
        inventoryListController.setHostServices(getHostServices());
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage.setTitle("Item Inventory"); // displayed in window's title bar
        stage.setScene(scene);
        stage.show();
    }
}
