package duke.UserInterface;

import duke.Task.Deadline;
import duke.Task.Event;
import duke.Task.Task;
import duke.Task.Tasklist;
import duke.Task.Todo;

//Parser class to turn user inputs into commands 
public class Parser {
    private boolean hasReadBack = false;
    private Tasklist lst = new Tasklist();
    private UI voice = new UI();

    /**
    * Parser class contructor
    *
    * @param hasReadBack indicates if current inputs being passed should be readback to user
    */
    public Parser(boolean hasReadBack) {
        this.hasReadBack = hasReadBack;
    }

    /**
    * method to change user input into commands
    *
    * @param input input to parse into database
    */ 
    public boolean parse(String input) {
        
            try {
                String[] inputArr = input.split(" ", 2);
                String command = inputArr[0].toLowerCase();
                String discript = (inputArr.length > 1) ? inputArr[1].trim() : "";

                switch(command) {
                case "mark": {
                    if (discript.isEmpty()) {
                        if (hasReadBack) {
                            voice.markError();
                        }
                    } 
                    lst.tickbox(Integer.parseInt(discript));
                    if (hasReadBack) {
                        voice.tickboxEB(Integer.parseInt(discript));
                    }
                    break;
                }
                case "unmark": {
                    if (discript.isEmpty()) {
                        if (hasReadBack) {
                            voice.unmarkError();
                        }
                    } 
                    lst.untickbox(Integer.parseInt(discript));
                    if (hasReadBack) {
                        voice.untickboxEB(Integer.parseInt(discript));
                    }
                    break;
                }
                case "delete": {
                    if (discript.isEmpty()) {
                        if (hasReadBack) {
                            voice.deleteError();
                        }
                    } 
                    lst.removeFromList(Integer.parseInt(discript));
                    if (hasReadBack) {
                        voice.removeFromListEB(Integer.parseInt(discript));
                    }
                    break;
                }
                case "todo": {
                    if (discript.isEmpty()) {
                        if (hasReadBack) {
                            voice.todoError();
                        }
                    }
                    Task t = new Todo(discript);
                    lst.addToList(t);
                    if (hasReadBack) {
                        voice.addToListEB(t);
                    }
                    break;
                }
                case "deadline": {
                    if (discript.isEmpty() || !discript.contains("/by")) {
                        if (hasReadBack) {
                            voice.deadlineError();
                        }
                    }
                    Task t = new Deadline(discript);
                    lst.addToList(t);
                    if (hasReadBack) {
                        voice.addToListEB(t);
                    }
                    break;
                } 
                case "event": {
                    if (discript.isEmpty() || !discript.contains("/from") || !discript.contains("/to")) {
                        if (hasReadBack) {
                            voice.eventError();
                        }
                    }
                    Task t = new Event(discript);
                    lst.addToList(t);
                    if (hasReadBack) {
                        voice.addToListEB(t);
                    }
                    break;
                }
                case "list": {
                    if (hasReadBack) {
                        lst.displayList();
                    }
                    break;
                } 

                case "find": {
                    if (hasReadBack) {
                        lst.find(discript);
                    }
                    break;
}
                case "bye": {
                    if (hasReadBack) {
                        voice.bye();
                        return false;
                    }
                    break;
                } 
                default: {
                    if (hasReadBack) {
                        voice.unknownError();
                    }
                }
                }      
            } catch (BotException e) {
                Errormsg.printError(e.getMessage());
            }
            return true;
    }

    //method to enable readback, used to switch between no print statements during loading of tasks 
    public void enableReadback(){
        this.hasReadBack = true;
    }
}