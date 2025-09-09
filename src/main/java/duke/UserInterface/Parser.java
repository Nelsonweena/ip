package duke.userinterface;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.Tasklist;
import duke.task.Todo;

/**
 * Parser class to interpret user inputs into commands.
 */
public class Parser {
    private boolean hasReadBack = false;
    private Tasklist lst = new Tasklist();
    private UI voice = new UI();

    /**
     * Constructs a Parser.
     *
     * @param hasReadBack indicates if current inputs should be echoed back to the user
     */
    public Parser(boolean hasReadBack) {
        this.hasReadBack = hasReadBack;
    }

    /**
     * Parses a user input string and executes the corresponding command.
     *
     * @param input the user input
     * @return true if Duke should continue running, false if it should exit
     */
    public String parse(String input) {
        try {
            String[] inputArr = input.split(" ", 2);
            String command = inputArr[0].toLowerCase();
            String discript = (inputArr.length > 1) ? inputArr[1].trim() : "";

            switch (command) {
            case "mark":
                if (discript.isEmpty()) {
                    if (hasReadBack) {
                        voice.markError();
                    }
                }
                lst.tickbox(Integer.parseInt(discript));
                if (hasReadBack) {
                    return voice.tickboxEB(Integer.parseInt(discript));
                }
                break;

            case "unmark":
                if (discript.isEmpty()) {
                    if (hasReadBack) {
                        voice.unmarkError();
                    }
                }
                lst.untickbox(Integer.parseInt(discript));
                if (hasReadBack) {
                    return voice.untickboxEB(Integer.parseInt(discript));
                }
                break;

            case "delete":
                if (discript.isEmpty()) {
                    if (hasReadBack) {
                        voice.deleteError(); // throws BotException
                    }
                }
                int index = Integer.parseInt(discript);
                Task removedTask = Tasklist.peekList(index - 1);
                lst.removeFromList(index);
                if (hasReadBack) {
                    return voice.removeFromListEB(removedTask);
                }
                break;

            case "todo":
                if (discript.isEmpty()) {
                    if (hasReadBack) {
                        voice.todoError();
                    }
                }
                Task t1 = new Todo(discript);
                lst.addToList(t1);
                if (hasReadBack) {
                    return voice.addToListEB(t1);
                }
                break;

            case "deadline":
                if (discript.isEmpty() || !discript.contains("/by")) {
                    if (hasReadBack) {
                        voice.deadlineError();
                    }
                }
                Task t2 = new Deadline(discript);
                lst.addToList(t2);
                if (hasReadBack) {
                    return voice.addToListEB(t2);
                }
                break;

            case "event":
                if (discript.isEmpty() || !discript.contains("/from") || !discript.contains("/to")) {
                    if (hasReadBack) {
                        voice.eventError();
                    }
                }
                Task t3 = new Event(discript);
                lst.addToList(t3);
                if (hasReadBack) {
                    return voice.addToListEB(t3);
                }
                break;

            case "list":
                if (hasReadBack) {
                    return lst.displayList();
                }
                break;

            case "find":
                if (hasReadBack) {
                    return lst.find(discript);
                }
                break;

            case "bye":
                if (hasReadBack) {
                    return voice.bye();
                }
                break;

            default:
                if (hasReadBack) {
                    voice.unknownError();
                }
                break;
            }
        } catch (BotException e) {
            return Errormsg.printError(e.getMessage());
        }
        return "";
    }

    /**
     * Enables readback so that commands are echoed back to the user.
     */
    public void enableReadback() {
        this.hasReadBack = true;
    }
}
