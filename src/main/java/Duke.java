import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Greeting.welcome();
        Scanner sc = new Scanner(System.in);
        chatlist lst = new chatlist();
        String input;

        while (true) {
            input = sc.nextLine();
            if(input.contains(" ")){
                String[] s = input.split(" ");

                if(s[0].equals("mark") || s[0].equals("Mark")){
                    lst.tickbox(Integer.parseInt(s[1]));

                } else if(s[0].equals("unmark") || s[0].equals("Unmark")){
                    lst.untickbox(Integer.parseInt(s[1]));
                } else {
                    lst.addToList(input);
                }

            } else {

                if(input.equals("bye") || input.equals("Bye")){
                    Goodbye.bye();
                    sc.close();
                    break;
                } else if(input.equals("list") || input.equals("List")){
                    lst.displayList();
                } else {
                    lst.addToList(input);
                }
            }
        }
    }
}
