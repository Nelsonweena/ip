import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Greeting.welcome();
        Scanner sc = new Scanner(System.in);
        String input;

        while (true) {
            input = sc.nextLine();

            if(input.equals("bye") || input.equals("Bye")){
                Goodbye.Goodbye();
                sc.close();
                break;
            } else {
                Echo.echoback(input);
            }
        }
    }
}
