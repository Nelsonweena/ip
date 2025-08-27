import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tasklist lst = new Tasklist();
        Voice voice = new Voice();
        voice.welcome();
        boolean loop = true;
        String input;
        Storage storage = new Storage();
        List<String> Storedinputs = storage.loadAll();

        for(String prev : Storedinputs){
            String[] s = prev.split(" ", 2);
            String command = s[0].toLowerCase();
            String discript = (s.length > 1) ? s[1].trim() : "";

            switch(command){
                    case "mark": {
                        if (discript.isEmpty()){
                        break;
                    } 
                        lst.tickbox(Integer.parseInt(discript));
                        break;
                    }

                    case "unmark": {
                        if (discript.isEmpty()){
                        break;
                    } 
                        lst.untickbox(Integer.parseInt(discript));
                        break;
                    }

                    case "delete": {
                        if (discript.isEmpty()){
                        break;
                    } 
                        lst.removeFromList(Integer.parseInt(discript));
                        break;
                    }

                    case "todo": {
                        if (discript.isEmpty()) {
                            break;
                    }
                        Task t = new Todo(discript);
                        lst.addToList(t);
                        break;
                    }
                    case "deadline": {
                        if (discript.isEmpty() || !discript.contains("/by")) {
                            break;
                    }
                        Task t = new Deadline(discript);
                        lst.addToList(t);
                        break;
                    } 
                    case "event": {
                        if (discript.isEmpty() || !discript.contains("/from") || !discript.contains("/to")) {
                    }
                        Task t = new Event(discript);
                        lst.addToList(t);
                        break;
                    }
                    case "list": {
                        break;
                    } 
                    case "bye": {
                        break;
                    } 
                    default: {
                        break;
                    }
                }
            
        }

        while (loop) {
            input = sc.nextLine();
            storage.storeData(input);
            try {
                String[] s = input.split(" ", 2);
                String command = s[0].toLowerCase();
                String discript = (s.length > 1) ? s[1].trim() : "";

                switch(command){
                    case "mark": {
                        if (discript.isEmpty()){
                        throw new BotException("OOPS!!! Mark needs a task number.");
                    } 
                        lst.tickbox(Integer.parseInt(discript));
                        voice.tickboxEB(Integer.parseInt(discript));
                        break;
                    }

                    case "unmark": {
                        if (discript.isEmpty()){
                        throw new BotException("OOPS!!! Unmark needs a task number.");
                    } 
                        lst.untickbox(Integer.parseInt(discript));
                        voice.untickboxEB(Integer.parseInt(discript));
                        break;
                    }

                    case "delete": {
                        if (discript.isEmpty()){
                        throw new BotException("OOPS!!! Delete needs a task number.");
                    } 
                        lst.removeFromList(Integer.parseInt(discript));
                        voice.removeFromListEB(Integer.parseInt(discript));
                        break;
                    }

                    case "todo": {
                        if (discript.isEmpty()) {
                        throw new BotException("OOPS!!! The description of a Todo cannot be empty.");
                    }
                        Task t = new Todo(discript);
                        lst.addToList(t);
                        voice.addToListEB(t);
                        break;
                    }
                    case "deadline": {
                        if (discript.isEmpty() || !discript.contains("/by")) {
                        throw new BotException("OOPS!!! The description of a Deadline cannot be empty.");
                    }
                        Task t = new Deadline(discript);
                        lst.addToList(t);
                        voice.addToListEB(t);
                        break;
                    } 
                    case "event": {
                        if (discript.isEmpty() || !discript.contains("/from") || !discript.contains("/to")) {
                        throw new BotException("OOPS!!! The description of a Event cannot be empty.");
                    }
                        Task t = new Event(discript);
                        lst.addToList(t);
                        voice.addToListEB(t);
                        break;
                    }
                    case "list": {
                        lst.displayList();
                        break;
                    } 
                    case "bye": {
                        voice.bye();
                        loop = false;
                        sc.close();
                        break;
                    } 
                    default: {
                        throw new BotException("OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                }
                
            } catch (BotException e){
                Errormsg.printError(e.getMessage());
            }
            
        }
    }
}
