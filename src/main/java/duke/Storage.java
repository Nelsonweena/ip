package duke;
<<<<<<< HEAD
import java.io.*;
import java.util.*;

//Storage class for storing and loading data 
=======

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

// Storage class for storing and loading data
>>>>>>> branch-A-CodingStandard
public class Storage {
    private File file;
    private String filePath = "./data/UserInputs.txt";
    BufferedWriter bw;
    BufferedReader br;
    
    //Constructor for storage class
    public Storage() {
        this.file = new File(filePath).getAbsoluteFile();
        try {
            file.getParentFile().mkdirs();

            if (!file.exists()) {
                file.createNewFile();  
                System.out.println("     New storage file created");
            } else {
                System.out.println("     Using previous saved data");
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to set up storage file", e);
        }
    }

<<<<<<< HEAD
    //Method for storing data into harddisk 
=======
    /**
    * Method for storing data into harddisk
    *
    * @param input input to store into harddisk
    */ 
>>>>>>> branch-A-CodingStandard
    public void storeData(String input) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(input);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data", e);
        }
    }

    //Method for loading all of the previous saved data from harddisk 
<<<<<<< HEAD
    public List<String> loadAll(){
=======
    public List<String> loadAll() {
>>>>>>> branch-A-CodingStandard
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

<<<<<<< HEAD
    //Method for checking if harddisk data is available 
    public boolean dataAvail(){
=======
    /**
    * Method for checking if harddisk data is available
    *
    * @return returns a boolean to indicate if previous data file exists
    */
    public boolean hasData() {
>>>>>>> branch-A-CodingStandard
        return file.exists() && file.length() > 0;
    }
}