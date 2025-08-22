import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Greeting.welcome();
        Scanner sc = new Scanner(System.in);
        Tasklist lst = new Tasklist();
        String input;

        while (true) {
            input = sc.nextLine();

            try {
                String[] s = input.split(" ", 2);
                String r = (s.length > 1) ? s[1].trim() : "";

                if(s[0].equals("mark") || s[0].equals("Mark")){
                    if (r.isEmpty()){
                        throw new BotException("OOPS!!! Mark needs a task number.");
                    } 
                    lst.tickbox(Integer.parseInt(s[1]));
                } else if(s[0].equals("unmark") || s[0].equals("Unmark")){
                    if (r.isEmpty()){
                        throw new BotException("OOPS!!! Unmark needs a task number.");
                    } 
                    lst.untickbox(Integer.parseInt(s[1]));
                } else if(s[0].equals("todo") || s[0].equals("Todo")){
                    if (r.isEmpty()) {
                        throw new BotException("OOPS!!! The description of a todo cannot be empty.");
                    }
                    Task t = new Todo(s[1]);
                    lst.addToList(t);
                } else if(s[0].equals("deadline") || s[0].equals("Deadline")){
                    if (r.isEmpty()) {
                        throw new BotException("OOPS!!! The description of a Deadline cannot be empty.");
                    }
                    Task t = new Deadline(s[1]);
                    lst.addToList(t);
                } else if(s[0].equals("event") || s[0].equals("Event")){
                    if (r.isEmpty()) {
                        throw new BotException("OOPS!!! The description of a Event cannot be empty.");
                    }
                    Task t = new Event(s[1]);
                    lst.addToList(t);
                } else if(input.equals("bye") || input.equals("Bye")){
                    Goodbye.bye();
                    sc.close();
                    break;
                } else if(input.equals("list") || input.equals("List")){
                    lst.displayList();
                } else {
                    throw new BotException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                } 
                
            } catch (BotException e){
                Errormsg.printError(e.getMessage());
            }

            
        }
    }
}
