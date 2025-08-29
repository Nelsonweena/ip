package duke;
import java.util.Scanner;
import java.util.List;

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
        if (storage.hasData()) {
            List<String> Storedinputs = storage.loadAll();
            p = new Parser(false);
            for(String prev : Storedinputs) {
                p.parse(prev);
            } 
        } 
        p = new Parser(true);
        voice.welcome();

        String input;
        boolean isNotFinished = true;

        //handles new user commands and stores it into current existing database 
        while (isNotFinished) {
            input = sc.nextLine();
            storage.storeData(input);
            isNotFinished = p.parse(input);
        }
        sc.close();
    }
}