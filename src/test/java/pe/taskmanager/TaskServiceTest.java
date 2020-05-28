package pe.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.service.TaskService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskServiceTest {

    @Autowired
    private TaskService service;


    @Test
    public void addTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(UUID.randomUUID());
        taskDTO.setName("name");
        taskDTO.setDueDate(LocalDateTime.of(2020, 05, 20, 15, 15));
        taskDTO.setDescription("description");

        //test method
        service.add(taskDTO);

        //checks
        assertNotNull(service.getTasks());
        assertEquals(1, service.getTasks().size());

    }

    @Test
    public void editTask(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(UUID.randomUUID());
        taskDTO.setName("name");
        taskDTO.setDueDate(LocalDateTime.of(2020, 05, 20, 15, 15));
        taskDTO.setDescription("description");

        service.add(taskDTO);


        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setId(UUID.randomUUID());
        taskDTO2.setName("name2");
        taskDTO2.setDueDate(LocalDateTime.of(2021, 05, 20, 15, 15));
        taskDTO2.setDescription("description2");


        String test = service.getTasks().get(0).getId().toString();
        service.edit(test, taskDTO2);

        TaskDTO inlist= service.getDetail(test);
        assertEquals("name2", inlist.getName());
        assertEquals("description2", inlist.getDescription());
    }

}
