package duke.Task;

//Todo class for Tasks labelled as todo
public class Todo extends Task{
    
<<<<<<< HEAD
    //constructor class for todo tasks 
    public Todo(String input){
=======
    /**
    * constructor class for todo tasks
    *
    * @param input input descripton of task 
    */ 
    public Todo(String input) {
>>>>>>> branch-A-CodingStandard
        super(input);
    }

    //toString method for todo class 
    @Override
    public String toString() {
        return " T " + super.toString();
    }
}
