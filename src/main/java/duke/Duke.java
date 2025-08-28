package duke;
import java.util.*;

import duke.UserInterface.UI;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI voice = new UI();
        Storage storage = new Storage();
        Parser p;
        if(storage.dataAvail()){
            List<String> Storedinputs = storage.loadAll();
            p = new Parser(false);
            for(String prev : Storedinputs){
                p.parse(prev);
            } 
        } 
        p = new Parser(true);

        voice.welcome();
        boolean loop = true;
        String input;
        while (loop) {
            input = sc.nextLine();
            storage.storeData(input);
            loop = p.parse(input);
        }
        sc.close();
    }
}
