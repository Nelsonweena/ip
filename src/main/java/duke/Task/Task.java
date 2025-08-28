package duke.Task;
public class Task {
    
    protected String description;
    private boolean isDone;

    public Task(String description) {
        this.isDone = false;
        this.description = description;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markUndone() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "| 1 |" : "| 0 |");
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }

}
