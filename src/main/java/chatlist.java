import java.util.ArrayList;

public class chatlist {
    private ArrayList<String> lst = new ArrayList<>();

    public void addToList(String input){
        lst.add(input);
        Echo.echoback(input);
    }

    public void displayList(){
        int len = lst.size();

        System.out.println("    ____________________________________");
        for(int i = 0; i < len; i++){
            System.out.println("     " + (i + 1) + ". " + lst.get(i));
        }
        System.out.println("    ____________________________________");
    }
}