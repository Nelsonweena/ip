package duke.Task;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaskListTest {
    @Test
    public void addTask_validTask_taskAdded() {
        Tasklist taskList = new Tasklist();
        Task task = new Todo("read book");
        taskList.addToList(task);

        assertEquals(1, Tasklist.Listsize());
    }
}
