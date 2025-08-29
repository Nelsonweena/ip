package duke;

import java.util.List;
import java.util.Scanner;

import duke.userinterface.Parser;
import duke.userinterface.UI;

/**
 * Represents the main entry point for the Duke application.
 */
public class Duke {

    /**
     * Runs the program, loads data, then invites user to input commands.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UI voice = new UI();
        Storage storage = new Storage();
        Parser p;

        // Loads previously stored data into current database
        if (storage.hasData()) {
            List<String> storedInputs = storage.loadAll();
            p = new Parser(false);
            for (String prev : storedInputs) {
                p.parse(prev);
            }
        }

        p = new Parser(true);
        voice.welcome();

        String input;
        boolean isNotFinished = true;

        // Handles new user commands and stores them into the current database
        while (isNotFinished) {
            input = sc.nextLine();
            storage.storeData(input);
            isNotFinished = p.parse(input);
        }
        sc.close();
    }
}
