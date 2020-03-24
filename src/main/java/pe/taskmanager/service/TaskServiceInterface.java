package pe.taskmanager.service;

import pe.taskmanager.domain.Subtask;
import pe.taskmanager.domain.Task;
import pe.taskmanager.dto.SubtaskDTO;
import pe.taskmanager.dto.TaskDTO;

import java.util.List;
import java.util.Map;

public interface TaskServiceInterface {

    List<TaskDTO> getTasks();
    TaskDTO getDetail(String id);
    void add(TaskDTO task);
    void addSubtask(SubtaskDTO subtaskDTO, String id);
    void verwijder(String id);
    void edit(String id, TaskDTO task);
}
