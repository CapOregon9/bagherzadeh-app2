package baseline;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FileIOTest {
    FileIO fileIO;
    InventoryList inventoryList;

    @BeforeEach
    void createObjects() {
        fileIO = new FileIO();
        inventoryList = new InventoryList();
        inventoryList.addItem("Name", "A-XXX-XXX-XXX", 12.00);
    }

    @Test
    void saveJSONFile() {
        //Tests if we can successfully create a JSON file
        File file = new File("docs/test/saveJSONTest.json");
        fileIO.saveJSONFile(file, inventoryList);
        assertTrue(file.exists());

    }

    @Test
    void saveHTMLFile() {
        //Tests if we can successfully create an HTML file
        File file = new File("docs/test/saveHTMLTest.html");
        fileIO.saveHTMLFile(file, inventoryList);
        assertTrue(file.exists());
    }

    @Test
    void saveTSVFile() {
        //Tests if we can successfully create a TSV file
        File file = new File("docs/test/saveTSVTest.txt");
        fileIO.saveTSVFile(file, inventoryList);
        assertTrue(file.exists());
    }


    @Test
    void openJSONFile() {
        //Tests to see if we can open and read a json file
        inventoryList = fileIO.openJSONFile(new File("docs/test/openJSONTest.json"));
        assertEquals(3, inventoryList.getInventoryItems().size());
    }

    @Test
    void openHTMLFile() {
        //Tests to see if we can open and read an HTML file
        inventoryList = fileIO.openHTMLFile(new File("docs/test/openHTMLTest.html"));
        assertEquals(3, inventoryList.getInventoryItems().size());
    }

    @Test
    void openTSVFile() {
        //Tests to see if we can open and read a TSV file
        inventoryList = fileIO.openTSVFile(new File("docs/test/openTSVTest.txt"));
        assertEquals(4, inventoryList.getInventoryItems().size());
    }
}