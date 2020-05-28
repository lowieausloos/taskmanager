package pe.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestContr {

    private final TaskService service;

    @Autowired
    public RestContr(TaskService service){
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public List<TaskDTO> getTasks(){
        return this.service.getTasks();
    }
}
