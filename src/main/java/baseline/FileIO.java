package baseline;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.Formatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static j2html.TagCreator.*;

public class FileIO {

    public InventoryList openJSONFile(File file) {
        //used to read a json file and pass the object back to the called class
        InventoryList inventoryList = new InventoryList();
        try (Reader reader = new FileReader(file);){
            Gson gson = new Gson();
            inventoryList = gson.fromJson(reader, InventoryList.class);
        } catch (IOException e) {
            System.out.println("Could not read JSON file.");
        }
        return inventoryList;
    }

    public InventoryList openHTMLFile(File file) {
        //used to read data from an HTML file and return an object storing all the data
        InventoryList inventoryList = new InventoryList();
        String itemName = "";
        String serialNumber = "";
        Double itemValue = 0.0;
        Document doc;
        try {
            doc = Jsoup.parse(file, null);
            Elements tableElements = doc.select("table");

            Elements tableRowElements = tableElements.select(":not(th) tr");

            for (int i = 1; i < tableRowElements.size(); i++) {
                Element row = tableRowElements.get(i);
                Elements rowItems = row.select("td");
                for (int j = 1; j <= rowItems.size(); j++) {
                    if (j % 2 == 0) {
                        itemName = rowItems.get(j - 1).text();
                    } else if (j % 3 == 0){
                        itemValue = Double.parseDouble(rowItems.get(j - 1).text());
                    } else {
                        serialNumber = rowItems.get(j - 1).text();
                    }
                }
                inventoryList.addItem(itemName, serialNumber, itemValue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    public InventoryList openTSVFile(File file) {
        //used to read data from a tab separated file and return an object storing all the data
        InventoryList inventoryList = new InventoryList();
        String fullLine;
        try (Scanner inputLine = new Scanner(file)) {
            inputLine.nextLine();
            while (inputLine.hasNextLine()) {
                fullLine = inputLine.nextLine();
                String[] splitLine = fullLine.split("\t");
                inventoryList.addItem(splitLine[1], splitLine[0], Double.parseDouble(splitLine[2]));
            }
        } catch (NoSuchElementException | IllegalStateException | FileNotFoundException e) {
            System.out.println("Could not read file.");
        }
        return inventoryList;
    }

    public void saveJSONFile(File file, InventoryList inventoryList) {
        //save inventory list as a JSON file using a Google GSON
        Gson gson = new Gson();
        System.out.println(inventoryList.getInventoryItems());
        try {
            Writer writer = new FileWriter(file);
            gson.toJson(inventoryList,writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not write JSON file.");
        }
    }

    public void saveHTMLFile(File file, InventoryList inventoryList) {
        //use a file writer to write a html file giving the data in a tabular format
        final List<Item> itemList = inventoryList.getInventoryItems();
        String table = table(
                th(
                      "Serial Number"
                ),
                th(
                        "Item Name"
                ),
                th(
                        "Item Value"
                ),
                tbody(
                        each(itemList, item -> tr(
                                td(
                                        item.getSerialNumber()
                                ),
                                td(
                                        item.getItemName()
                                ),
                                td(
                                        String.format("%.2f", item.getItemValue())
                                )
                        ))
                )
        ).renderFormatted();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(table);
        } catch (IOException e) {
            System.out.println("Could not write HTML file.");
        }
    }

    public void saveTSVFile(File file, InventoryList inventoryList) {
        //Use a formatter writer to write a tabbed separated file
        List<Item> itemList = inventoryList.getInventoryItems();
        try (Formatter output = new Formatter(file)) {
            output.format("Serial Number\tItem Name\tItem Value%n");
            for (Item item : itemList) {
                output.format("%s\t%s\t%.2f%n", item.getSerialNumber(), item.getItemName(), item.getItemValue());
            }
        } catch (IOException e) {
            System.out.println("Could not write CSV file.");
        }
    }
}
