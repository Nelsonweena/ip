package duke.UserInterface;

import duke.Task.Task;
import duke.Task.Tasklist;

//UI class to handle interactions with user
public class UI {
    
    //Greetings logo 
    private String logo = ""
            + "     _   _      _                 \n"
            + "    | \\ | | ___ | | ___  ___  ___ \n"
            + "    |  \\| |/ _ \\| |/ __|/ _ \\|  _ \\\n"
            + "    | |\\  |  __/| |__ \\  (_) | | | |\n"
            + "    |_| \\_|\\___ |_|___/ \\___/|_| |_|\n";

    //Method to print welcome message
    public void welcome() {
        System.out.println("    ____________________________________");
        System.out.println("     Hello! I'm\n" + logo + "\n" + "     What can I do for you?");
        System.out.println("    ____________________________________");
    }

    //Method to print acknowledgement of added task to user 
    public void addToListEB(Task t) {
        System.out.println("    ____________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println("      " + t);
        System.out.println("     Now you have " + Tasklist.Listsize() + " tasks in the list");
        System.out.println("    ____________________________________");
    }

    //method to print goodbye message
    public void bye() {
        System.out.println("    ____________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________");
    }

    /**
    * Method for removing task from list
    *
    * @param i index of task to remove
    */ 
    public void removeFromListEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + t);
        System.out.println("     Now you have " + Tasklist.Listsize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
    }

    /**
    * Method to print acknowledgement of ticked task to user
    *
    * @param i index of task to tick
    */ 
    public void tickboxEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    /**
    * Method to print acknowledgement of ticked task to user
    *
    * @param i index of task to untick
    */
    public void untickboxEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

     
    /**
    * Method to throw exception during error in mark input
    *
    * @throws BotException If mark task has no number
    */
     public void markError() throws BotException {
        throw new BotException("OOPS!!! Mark needs a task number.");
    }

    /**
    * Method to throw exception during error in unmark input
    *
    * @throws BotException If unmark task has no number
    */
    public void unmarkError() throws BotException {
        throw new BotException("OOPS!!! Unmark needs a task number.");
    }

    /**
    * Method to throw exception during error in delete input
    *
    * @throws BotException If delete task has no number
    */
    public void deleteError() throws BotException {
        throw new BotException("OOPS!!! Delete needs a task number.");
    }

    /**
    * Method to throw exception during error in todo input
    *
    * @throws BotException If todo task has no description
    */
    public void todoError() throws BotException {
        throw new BotException("OOPS!!! The description of a Todo cannot be empty.");
    }

    /**
    * Method to throw exception during error in deadline input
    *
    * @throws BotException If deadline task has no description
    */
    public void deadlineError() throws BotException {
        throw new BotException("OOPS!!! The description of a Deadline cannot be empty.");
    }

    /**
    * Method to throw exception during error in event input
    *
    * @throws BotException If event task has no description
    */
    public void eventError() throws BotException {
        throw new BotException("OOPS!!! The description of a Event cannot be empty.");
    }

    /**
    * Method to throw exception during error in unknown input
    *
    * @throws BotException If input is not recognisable
    */
    public void unknownError() throws BotException {
        throw new BotException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}