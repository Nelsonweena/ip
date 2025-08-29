package duke.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//RemoveListTest for junit test on removing task from list 
public class RemoveListTest {
    @Test

    //method for testing if the removefromlist method works as expected 
    public void removeTask_validTask_taskAdded() {
        Tasklist taskList = new Tasklist();
        Task task = new Todo("read book");
        taskList.addToList(task);
        taskList.removeFromList(1);

        assertEquals(0, Tasklist.Listsize());
    }
}