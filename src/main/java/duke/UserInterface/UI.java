package duke.UserInterface;

import duke.Task.Task;
import duke.Task.Tasklist;

public class UI {
    
    private String logo = ""
            + "     _   _      _                 \n"
            + "    | \\ | | ___ | | ___  ___  ___ \n"
            + "    |  \\| |/ _ \\| |/ __|/ _ \\|  _ \\\n"
            + "    | |\\  |  __/| |__ \\  (_) | | | |\n"
            + "    |_| \\_|\\___ |_|___/ \\___/|_| |_|\n";

    public void welcome(){
        System.out.println("    ____________________________________");
        System.out.println("     Hello! I'm\n" + logo + "\n" + "     What can I do for you?");
        System.out.println("    ____________________________________");
    }

    public void addToListEB(Task t){
        System.out.println("    ____________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println("      " + t);
        System.out.println("     Now you have " + Tasklist.Listsize() + " tasks in the list");
        System.out.println("    ____________________________________");
    }

    public void bye(){
        System.out.println("    ____________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________");
    }

    public void removeFromListEB(int i){
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + t);
        System.out.println("     Now you have " + Tasklist.Listsize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
    }

    public void tickboxEB(int i){
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    public void untickboxEB(int i){
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    public void markError() throws BotException{
        throw new BotException("OOPS!!! Mark needs a task number.");
    }

    public void unmarkError() throws BotException{
        throw new BotException("OOPS!!! Unmark needs a task number.");
    }

    public void deleteError() throws BotException{
        throw new BotException("OOPS!!! Delete needs a task number.");
    }

    public void todoError() throws BotException{
        throw new BotException("OOPS!!! The description of a Todo cannot be empty.");
    }

    public void deadlineError() throws BotException{
        throw new BotException("OOPS!!! The description of a Deadline cannot be empty.");
    }

    public void eventError() throws BotException{
        throw new BotException("OOPS!!! The description of a Event cannot be empty.");
    }

    public void unknownError() throws BotException{
        throw new BotException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
