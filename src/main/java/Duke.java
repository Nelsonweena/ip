import java.util.*;

public class Duke {
    public static void main(String[] args) {
        Greeting.welcome();
        Scanner sc = new Scanner(System.in);
        Tasklist lst = new Tasklist();
        String input;

        while (true) {
            input = sc.nextLine();
            if(input.contains(" ")){
                String[] s = input.split(" ", 2);

                if(s[0].equals("mark") || s[0].equals("Mark")){
                    lst.tickbox(Integer.parseInt(s[1]));
                } else if(s[0].equals("unmark") || s[0].equals("Unmark")){
                    lst.untickbox(Integer.parseInt(s[1]));
                    
                } else if(s[0].equals("todo") || s[0].equals("Todo")){
                    Task t = new Todo(s[1]);
                    lst.addToList(t);
                } else if(s[0].equals("deadline") || s[0].equals("Deadline")){
                    Task t = new Deadline(s[1]);
                    lst.addToList(t);
                } else if(s[0].equals("event") || s[0].equals("Event")){
                    Task t = new Event(s[1]);
                    lst.addToList(t);

                } else {
                    Task t = new Unknowntask(input);
                    lst.addToList(t);
                }

            } else {

                if(input.equals("bye") || input.equals("Bye")){
                    Goodbye.bye();
                    sc.close();
                    break;
                } else if(input.equals("list") || input.equals("List")){
                    lst.displayList();
                } else {
                    Task t = new Unknowntask(input);
                    lst.addToList(t);
                }
            }
        }
    }
}
