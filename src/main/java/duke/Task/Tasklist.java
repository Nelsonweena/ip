package duke.Task;

import java.util.ArrayList;

<<<<<<< HEAD
=======

>>>>>>> branch-A-CodingStandard
//Tasklist class to manage tasks in list 
public class Tasklist {
    private static ArrayList<Task> lst = new ArrayList<>();

    //method for adding tasks to list 
<<<<<<< HEAD
    public void addToList(Task t){
=======
    public void addToList(Task t) {
>>>>>>> branch-A-CodingStandard
        lst.add(t);
    }

    //method for removing tasks from list 
<<<<<<< HEAD
    public void removeFromList(int i){
=======
    public void removeFromList(int i) {
>>>>>>> branch-A-CodingStandard
        lst.remove(i - 1);
    }

    //method for ticking checkbox in list 
<<<<<<< HEAD
    public void tickbox(int i){
=======
    public void tickbox(int i) {
>>>>>>> branch-A-CodingStandard
        Task t = lst.get(i - 1);
        t.markDone();
    }

    //method for unticking checkbox in list 
<<<<<<< HEAD
    public void untickbox(int i){
=======
    public void untickbox(int i) {
>>>>>>> branch-A-CodingStandard
        Task t = lst.get(i - 1);
        t.markUndone();
    }

    //getter method to return task inside specified list index 
<<<<<<< HEAD
    public static Task peekList(int i){
=======
    public static Task peekList(int i) {
>>>>>>> branch-A-CodingStandard
        return lst.get(i);
    }

    //method for getting number of tasks in the list 
<<<<<<< HEAD
    public static int Listsize(){
=======
    public static int Listsize() {
>>>>>>> branch-A-CodingStandard
        return lst.size();
    }

    //method to display all the tasks in the list 
<<<<<<< HEAD
    public void displayList(){
=======
    public void displayList() {
>>>>>>> branch-A-CodingStandard
        System.out.println("    ____________________________________");
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < Listsize(); i++) {
            System.out.println("     " + (i + 1) + "." + peekList(i));
        }
        System.out.println("    ____________________________________");
    }
}