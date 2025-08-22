public class Greeting {
    private static String logo = ""
            + "     _   _      _                 \n"
            + "    | \\ | | ___ | | ___  ___  ___ \n"
            + "    |  \\| |/ _ \\| |/ __|/ _ \\|  _ \\\n"
            + "    | |\\  |  __/| |__ \\  (_) | | | |\n"
            + "    |_| \\_|\\___ |_|___/ \\___/|_| |_|\n";

    public static void welcome(){
        System.out.println("    ____________________________________");
        System.out.println("     Hello! I'm\n" + logo + "\n" + "    What can I do for you?");
        System.out.println("    ____________________________________");
    }
}
