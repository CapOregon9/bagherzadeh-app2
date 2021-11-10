package baseline;

public class FileIO {

    public InventoryList openJSONFile(String URI) {
        //used to read a json file and pass the object back to the called class
        return null;
    }

    public InventoryList openHTMLFile(String URI) {
        //used to read data from a HTML file and return an object storing all the data
        return null;
    }

    public InventoryList openTSVFile(String URI) {
        //used to read data from a tab separated file and return an object storing all the data
        return null;
    }

    public void saveJSONFile(String URI) {
        //save inventory list as a JSON file using a google GSON
    }

    public void saveHTMLFile(String URI) {
        //use a file writer to write a html file giving the data in a tabular format
    }

    public void saveTSVFile(String URI) {
        //Use a formatter writer to write a tabbed separated file
    }
}
