package duke.UserInterface;

import duke.Task.Deadline;
import duke.Task.Event;
import duke.Task.Task;
import duke.Task.Tasklist;
import duke.Task.Todo;

public class Parser {
    private boolean Readback = false;
    private Tasklist lst = new Tasklist();
    private UI voice = new UI();

    public Parser(boolean Readback){
        this.Readback = Readback;
    }

    public boolean parse(String input){
        
            try {
                String[] s = input.split(" ", 2);
                String command = s[0].toLowerCase();
                String discript = (s.length > 1) ? s[1].trim() : "";

                switch(command){
                    case "mark": {
                        if (discript.isEmpty()){
                            if(Readback){
                                voice.markError();
                            }
                        } 
                        lst.tickbox(Integer.parseInt(discript));
                        if(Readback){
                            voice.tickboxEB(Integer.parseInt(discript));
                        }
                        break;
                    }

                    case "unmark": {
                        if (discript.isEmpty()){
                            if(Readback){
                                voice.unmarkError();
                            }
                        } 
                        lst.untickbox(Integer.parseInt(discript));
                        if(Readback){
                            voice.untickboxEB(Integer.parseInt(discript));
                        }
                        break;
                    }

                    case "delete": {
                        if (discript.isEmpty()){
                            if(Readback){
                                voice.deleteError();
                            }
                        } 
                        lst.removeFromList(Integer.parseInt(discript));
                        if(Readback){
                            voice.removeFromListEB(Integer.parseInt(discript));
                        }
                        break;
                    }

                    case "todo": {
                        if (discript.isEmpty()) {
                            if(Readback){
                                voice.todoError();
                            }
                        }
                        Task t = new Todo(discript);
                        lst.addToList(t);
                        if(Readback){
                            voice.addToListEB(t);
                        }
                        break;
                    }
                    case "deadline": {
                        if (discript.isEmpty() || !discript.contains("/by")) {
                            if(Readback){
                                voice.deadlineError();
                            }
                        }
                        Task t = new Deadline(discript);
                        lst.addToList(t);
                        if(Readback){
                            voice.addToListEB(t);
                        }
                        break;
                    } 
                    case "event": {
                        if (discript.isEmpty() || !discript.contains("/from") || !discript.contains("/to")) {
                            if(Readback){
                                voice.eventError();
                            }
                        
                        }
                        Task t = new Event(discript);
                        lst.addToList(t);
                        if(Readback){
                            voice.addToListEB(t);
                        }
                        break;
                    }
                    case "list": {
                        if(Readback){
                            lst.displayList();
                        }
                        break;
                    } 
                    case "bye": {
                        if(Readback){
                            voice.bye();
                            return false;
                        }
                        break;
                    } 
                    default: {
                        if(Readback){
                            voice.unknownError();
                        }
                    }
                }
                
            } catch (BotException e){
                Errormsg.printError(e.getMessage());
            }
            return true;
    }

    public void enableReadback(){
        this.Readback = true;
    }
}
