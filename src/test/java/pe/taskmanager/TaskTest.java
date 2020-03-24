package pe.taskmanager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pe.taskmanager.domain.Task;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskTest {

    private Task task = new Task();

    @Test
    public void testSetName(){
        task.setName("name");

        assertEquals("name", task.getName());
        assertNotNull(task.getName());

    }

    @Test
    public void testSetDescription(){
        task.setDescription("description");

        assertEquals("description", task.getDescription());
        assertNotNull(task.getDescription());

    }

    @Test
    public void testSetDuedate(){
        LocalDateTime date = LocalDateTime.now();
        task.setDueDate(date);

        assertEquals(date, task.getDueDate());
        assertNotNull(task.getDueDate());

    }
}
