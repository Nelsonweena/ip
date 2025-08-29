package duke.Task;

import java.util.ArrayList;


//Tasklist class to manage tasks in list 
public class Tasklist {
    private static ArrayList<Task> lst = new ArrayList<>();

    //method for adding tasks to list 
    public void addToList(Task t) {
        lst.add(t);
    }

    //method for removing tasks from list 
    public void removeFromList(int i) {
        lst.remove(i - 1);
    }

    //method for ticking checkbox in list 
    public void tickbox(int i) {
        Task t = lst.get(i - 1);
        t.markDone();
    }

    //method for unticking checkbox in list 
    public void untickbox(int i) {
        Task t = lst.get(i - 1);
        t.markUndone();
    }

    //getter method to return task inside specified list index 
    public static Task peekList(int i) {
        return lst.get(i);
    }

    //method for getting number of tasks in the list 
    public static int Listsize() {
        return lst.size();
    }

    //method to display all the tasks in the list 
    public void displayList() {
        System.out.println("    ____________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < Listsize(); i++) {
            System.out.println("     " + (i + 1) + "." + peekList(i));
        }
        System.out.println("    ____________________________________");
    }

    public void find(String keyword) {
    System.out.println("    ____________________________________");
    System.out.println("     Here are the matching tasks in your list:");
    for (int i = 0; i < Listsize(); i++) {
        Task t = peekList(i);
        if (t.toString().contains(keyword)) {
            System.out.println("     " + (i + 1) + "." + t);
        }
    }
    System.out.println("    ____________________________________");
    }
}