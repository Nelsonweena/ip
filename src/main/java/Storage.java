import java.io.*;
import java.util.*;
public class Storage {
    private File file;
    String filePath = "./data/UserInputs.txt";
    BufferedWriter bw;
    BufferedReader br;

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

    public void storeData(String input) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(input);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Failed to store data", e);
        }
    }

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

    public boolean dataAvail(){
        return file.exists() && file.length() > 0;
    }
}
