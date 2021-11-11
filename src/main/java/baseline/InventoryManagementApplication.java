package baseline;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InventoryManagementApplication extends Application {
    private InventoryListController inventoryListController;
    Map<String, Stage> stages = new HashMap<>();
    private FileIO fileIO = new FileIO();

    public static void main(String[] args) {
        //launches the javafx application and calls the overridden start method
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //opens the initial scene and used the JMetro javafx skin to modernize the look of the application.
        fileIO.saveHTMLFile("", new InventoryList());
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("InventoryList.fxml")));
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage.setTitle("Item Inventory"); // displayed in window's title bar
        stage.setScene(scene);
        stage.show();
    }
}
