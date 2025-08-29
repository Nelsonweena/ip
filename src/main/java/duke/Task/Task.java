package duke.Task;

//parent class Task for all task classes
public class Task {
    
    protected String description;
    private boolean isDone;

    //constructor for task class 
    public Task(String description) {
        this.isDone = false;
        this.description = description;
    }

    //method for marking completion of task 
    public void markDone() {
        this.isDone = true;
    }

    //method for marking uncompleted task 
    public void markUndone() {
        this.isDone = false;
    }

    //method for getting completion status of task 
    public String getStatusIcon() {
        return (isDone ? "| 1 |" : "| 0 |");
    }

    //toString method for task class 
    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }

}
