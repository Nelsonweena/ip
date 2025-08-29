package duke.userinterface;

import duke.task.Task;
import duke.task.Tasklist;

/**
 * UI class to handle interactions with the user.
 */
public class UI {

    private String logo = ""
            + "     _   _      _                 \n"
            + "    | \\ | | ___ | | ___  ___  ___ \n"
            + "    |  \\| |/ _ \\| |/ __|/ _ \\|  _ \\\n"
            + "    | |\\  |  __/| |__ \\  (_) | | | |\n"
            + "    |_| \\_|\\___ |_|___/ \\___/|_| |_|\n";

    /**
     * Prints the welcome message.
     */
    public void welcome() {
        System.out.println("    ____________________________________");
        System.out.println("     Hello! I'm\n" + logo + "\n" + "     What can I do for you?");
        System.out.println("    ____________________________________");
    }

    /**
     * Prints acknowledgement of added task.
     *
     * @param t the task added
     */
    public void addToListEB(Task t) {
        System.out.println("    ____________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println("      " + t);
        System.out.println("     Now you have " + Tasklist.listSize() + " tasks in the list");
        System.out.println("    ____________________________________");
    }

    /**
     * Prints goodbye message.
     */
    public void bye() {
        System.out.println("    ____________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________");
    }

    /**
     * Prints acknowledgement of task removal.
     *
     * @param i index of task removed
     */
    public void removeFromListEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________________________________");
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + t);
        System.out.println("     Now you have " + Tasklist.listSize() + " tasks in the list.");
        System.out.println("    ____________________________________________________________");
    }

    /**
     * Prints acknowledgement of task completion.
     *
     * @param i index of task marked as done
     */
    public void tickboxEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    /**
     * Prints acknowledgement of task unmark.
     *
     * @param i index of task marked as not done
     */
    public void untickboxEB(int i) {
        Task t = Tasklist.peekList(i - 1);
        System.out.println("    ____________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    // Error methods
    public void markError() throws BotException {
        throw new BotException("OOPS!!! Mark needs a task number.");
    }

    public void unmarkError() throws BotException {
        throw new BotException("OOPS!!! Unmark needs a task number.");
    }

    public void deleteError() throws BotException {
        throw new BotException("OOPS!!! Delete needs a task number.");
    }

    public void todoError() throws BotException {
        throw new BotException("OOPS!!! The description of a Todo cannot be empty.");
    }

    public void deadlineError() throws BotException {
        throw new BotException("OOPS!!! The description of a Deadline cannot be empty.");
    }

    public void eventError() throws BotException {
        throw new BotException("OOPS!!! The description of an Event cannot be empty.");
    }

    public void unknownError() throws BotException {
        throw new BotException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
