package duke.task;

/**
 * Represents a general task in the Duke application.
 * This is the parent class for all specific task types.
 */
public class Task {

    protected String description;
    private boolean isDone;

    /**
     * Creates a new task with the given description.
     *
     * @param description description of the task
     */
    public Task(String description) {
        this.isDone = false;
        this.description = description;
    }

    /**
     * Marks the task as completed.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as not completed.
     */
    public void markUndone() {
        this.isDone = false;
    }

    /**
     * Returns the status icon representing whether the task is done.
     *
     * @return "| 1 |" if completed, otherwise "| 0 |"
     */
    public String getStatusIcon() {
        return (isDone ? "| 1 |" : "| 0 |");
    }

    /**
     * Returns the string representation of the task.
     *
     * @return status icon and description
     */
    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }
}
