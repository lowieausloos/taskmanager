package pe.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.taskmanager.domain.Subtask;
import pe.taskmanager.domain.Task;
import pe.taskmanager.dto.SubtaskDTO;
import pe.taskmanager.dto.TaskDTO;
import pe.taskmanager.repository.TaskRepository;

import javax.persistence.Convert;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService implements TaskServiceInterface {


    @Autowired
    private TaskRepository repository;

    public TaskService(){

    }

    @Override
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setDescription(h.getDescription());
            dto.setDueDate(h.getDueDate());
            dto.setName(h.getName());
            dto.setId(h.getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public void add(TaskDTO taskDTO){
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setName(taskDTO.getName());
        task.setId(taskDTO.getId());
        repository.save(task);

    }

    @Override
    public void edit(String id, TaskDTO taskDTO){
        UUID uuid = UUID.fromString(id);
        List<Task> tasks = repository.findAll();
        Task toedit = repository.findById(uuid).orElse(null);
        if(toedit != null){
            toedit.setName(taskDTO.getName());
            toedit.setDueDate(taskDTO.getDueDate());
            toedit.setDescription(taskDTO.getDescription());
        }
        repository.save(toedit);
    }

    @Override
    public void addSubtask(SubtaskDTO subtaskDTO, String id) {
        Subtask subtask = new Subtask();
        subtask.setDescription(subtaskDTO.getDescription());
        subtask.setTitle(subtaskDTO.getTitle());
        subtask.setId(subtaskDTO.getId());

        UUID uuid = UUID.fromString(id);
        Task task = repository.findById(uuid).get();
        task.addSubTask(subtask);

        repository.save(task);

    }


    @Override
    public void verwijder(String id) {
        UUID uuid = UUID.fromString(id);
        repository.deleteById(uuid);
    }

    @Override
    public TaskDTO getDetail(String id){
        UUID uuid = UUID.fromString(id);
        Task task = repository.findById(uuid).orElse(null);
        TaskDTO dto = new TaskDTO();
        dto.setDueDate(task.getDueDate());
        dto.setDescription(task.getDescription());
        dto.setName(task.getName());
        return dto;
    }
}
