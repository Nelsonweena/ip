package duke.Task;

//Todo class for Tasks labelled as todo
public class Todo extends Task{
    
    //constructor class for todo tasks 
    public Todo(String input){
        super(input);
    }

    //toString method for todo class 
    @Override
    public String toString() {
        return " T " + super.toString();
    }
}
