package duke.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Tasklist for junit test on adding task to list 
public class TaskListTest {
    @Test

    //method for testing if the addtolist method works as expected 
    public void addTask_validTask_taskAdded() {
        Tasklist taskList = new Tasklist();
        Task task = new Todo("read book");
        taskList.addToList(task);

        assertEquals(1, Tasklist.Listsize());
    }
}