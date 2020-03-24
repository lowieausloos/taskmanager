package pe.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.taskmanager.domain.Subtask;
import pe.taskmanager.domain.Task;
import pe.taskmanager.dto.SubtaskDTO;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.service.TaskService;
import pe.taskmanager.service.TaskServiceInterface;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskServiceInterface taskService;

    @GetMapping
    public String index(){
        return "index.html";
    }

    @GetMapping("/tasks")
    public String getTasks(Model model){
        List<TaskDTO> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "tasks.html";
    }

    @GetMapping("/tasks/{id}")
    public String getDetailTask(Model model, @PathVariable("id") String id){
        TaskDTO taskDTO = taskService.getDetail(id);
        model.addAttribute("task", taskDTO);
        return "detail.html";
    }

    @GetMapping("/tasks/new")
    public String form(){
        return "form.html";
    }

    @PostMapping("/tasks/create")
    public String create(@ModelAttribute TaskDTO task){
        taskService.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String getEditForm(Model model, @PathVariable("id") String id){
        TaskDTO task = taskService.getDetail(id);
        model.addAttribute("task", task);
        model.addAttribute("id", id);
        return "editForm.html";
    }

    @PostMapping("/tasks/editTask/{id}")
    public String edit(@ModelAttribute TaskDTO taskDTO, @PathVariable("id") String id){
        taskService.edit(id, taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String createSubForm(Model model, @PathVariable("id") String id){
        model.addAttribute("id", id);
        return "subtaskForm.html";
    }

    @PostMapping("/tasks/createsub/{id}")
    public String createSubtask(@ModelAttribute SubtaskDTO subtaskDTO, @PathVariable("id") String id){
        taskService.addSubtask(subtaskDTO, id);
        return "redirect:/tasks";
    }
}
