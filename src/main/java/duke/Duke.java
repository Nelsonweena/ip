package duke;
import java.util.*;

import duke.UserInterface.UI;
import duke.UserInterface.Parser;

//Represents main entry point for the Duke application
public class Duke {

    //Runs the program, loads data, then invite user to input commands 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UI voice = new UI();
        Storage storage = new Storage();
        Parser p;

        //loads previously stored data into current database 
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

        //handles new user commands and stores it into current existing database 
        while (loop) {
            input = sc.nextLine();
            storage.storeData(input);
            loop = p.parse(input);
        }
        sc.close();
    }
}
