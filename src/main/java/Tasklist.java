import java.util.ArrayList;

public class Tasklist {
    private ArrayList<Task> lst = new ArrayList<>();

    public void addToList(Task t){
        lst.add(t);
        System.out.println("    ____________________________________");
        System.out.println("     Got it. I've added this task:");
        System.out.println("      " + t);
        System.out.println("     Now you have " + lst.size() + " tasks in the list");
        System.out.println("    ____________________________________");
    }

    public void tickbox(int i){
        Task t = lst.get(i - 1);
        t.markDone();
        System.out.println("    ____________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    public void untickbox(int i){
        Task t = lst.get(i - 1);
        t.markUndone();
        System.out.println("    ____________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("     " + t);
        System.out.println("    ____________________________________");
    }

    public void displayList(){
        System.out.println("    ____________________________________");
        System.out.println("     Here are the tasks in your list:");
        for(int i = 0; i < lst.size(); i++){
            System.out.println("     " + (i + 1) + "." + lst.get(i));
        }
        System.out.println("    ____________________________________");
    }
}