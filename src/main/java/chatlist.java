import java.util.ArrayList;

public class chatlist {
    private ArrayList<String> lst = new ArrayList<>();
    private ArrayList<String> checkboxlst = new ArrayList<>();

    public void addToList(String input){
        lst.add(input);
        checkboxlst.add("[ ]");
        Echo.echoback(input);
    }

    public void tickbox(int i){
        checkboxlst.set((i - 1), "[X]");
        System.out.println("    ____________________________________");
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("     " + checkboxlst.get(i - 1) + " " + lst.get(i - 1));
        System.out.println("    ____________________________________");
    }

    public void untickbox(int i){
        checkboxlst.set((i - 1), "[ ]");
        System.out.println("    ____________________________________");
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("     " + checkboxlst.get(i - 1) + " " + lst.get(i - 1));
        System.out.println("    ____________________________________");
    }

    public void displayList(){
        System.out.println("    ____________________________________");
        System.out.println("     Here are the tasks in your list:");
        for(int i = 0; i < lst.size(); i++){
            System.out.println("     " + (i + 1) + "." + checkboxlst.get(i) + " " + lst.get(i));
        }
        System.out.println("    ____________________________________");
    }
}