package baseline;

import java.util.ArrayList;
import java.util.List;

import static j2html.TagCreator.*;

public class FileIO {

    public InventoryList openJSONFile(String URI) {
        //used to read a json file and pass the object back to the called class
        return null;
    }

    public InventoryList openHTMLFile(String URI) {
        //used to read data from an HTML file and return an object storing all the data
        return null;
    }

    public InventoryList openTSVFile(String URI) {
        //used to read data from a tab separated file and return an object storing all the data
        return null;
    }

    public void saveJSONFile(String URI) {
        //save inventory list as a JSON file using a google GSON
    }

    public void saveHTMLFile(String URI, InventoryList inventoryList) {
        //use a file writer to write a html file giving the data in a tabular format
        inventoryList = new InventoryList();
        inventoryList.addItem("Name1", "123", 1);
        inventoryList.addItem("Name2", "124", 2);
        inventoryList.addItem("Name3", "125", 3);
        inventoryList.addItem("Name4", "126", 4);
        inventoryList.addItem("Name5", "127", 5);
        final List<Item> itemList = inventoryList.getInventoryList();
        String table = table(
                th(
                      "Name"
                ),
                th(
                        "Serial Number"
                ),
                th(
                        "Item Value"
                ),
                tbody(
                        each(itemList, item -> tr(
                                td(
                                        item.getItemName()
                                ),
                                td(
                                        item.getSerialNumber()
                                ),
                                td(
                                        String.format("%.2f", item.getItemValue())
                                )
                        ))
                )
        ).render();
        System.out.println(table);
    }

    public void saveTSVFile(String URI) {
        //Use a formatter writer to write a tabbed separated file
    }
}
