package duke.userinterface;

/**
 * Utility class for printing error messages in a formatted style.
 */
public class Errormsg {

    /**
     * Prints an error message in a formatted box.
     *
     * @param msg the error message to display
     */
    public static void printError(String msg) {
        System.out.println("    ____________________________________");
        System.out.println("     " + msg);
        System.out.println("    ____________________________________");
    }
}
