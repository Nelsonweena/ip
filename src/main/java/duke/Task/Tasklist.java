package duke.Task;

import java.util.ArrayList;

public class Tasklist {
    private static ArrayList<Task> lst = new ArrayList<>();

    public void addToList(Task t){
        lst.add(t);
    }

    public void removeFromList(int i){
        lst.remove(i - 1);
    }

    public void tickbox(int i){
        Task t = lst.get(i - 1);
        t.markDone();
    }

    public void untickbox(int i){
        Task t = lst.get(i - 1);
        t.markUndone();
    }

    public static Task peekList(int i){
        return lst.get(i);
    }

    public static int Listsize(){
        return lst.size();
    }

    public void displayList(){
        System.out.println("    ____________________________________");
        System.out.println("     Here are the tasks in your list:");
        for(int i = 0; i < Tasklist.Listsize(); i++){
            System.out.println("     " + (i + 1) + "." + Tasklist.peekList(i));
        }
        System.out.println("    ____________________________________");
    }
}