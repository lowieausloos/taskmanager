package pe.taskmanager.dto;

import org.springframework.format.annotation.DateTimeFormat;
import pe.taskmanager.domain.Subtask;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDTO {

    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")

    private LocalDateTime dueDate;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subtask> list;
    @Id
    @GeneratedValue
    private UUID id;

    public TaskDTO(){

    }

    public TaskDTO(String name, String description, LocalDateTime dueDate){
        list = new ArrayList<>();
        setName(name);
        setDescription(description);
        setDueDate(dueDate);

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addSubTask(Subtask subtask){
        list.add(subtask);

    }

    public List<Subtask> getList() {
        return list;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String date = dueDate.format(formatter);
        return date;
    }
}
