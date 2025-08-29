package duke;
import java.io.*;
import java.util.*;

//Storage class for storing and loading data 
public class Storage {
    private File file;
    String filePath = "./data/UserInputs.txt";
    BufferedWriter bw;
    BufferedReader br;
    
    //Constructor for storage class
    public Storage() {
        this.file = new File(filePath).getAbsoluteFile();
        try {
            file.getParentFile().mkdirs();

            if (!file.exists()){
                file.createNewFile();  
                System.out.println("     New storage file created");
            } else {
                System.out.println("     Using previous saved data");
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to set up storage file", e);
        }
    }

    //Method for storing data into harddisk 
    public void storeData(String input) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(input);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data", e);
        }
    }

    //Method for loading all of the previous saved data from harddisk 
    public List<String> loadAll(){
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load data", e);
        }

    return lines;
    }

    //Method for checking if harddisk data is available 
    public boolean dataAvail(){
        return file.exists() && file.length() > 0;
    }
}
