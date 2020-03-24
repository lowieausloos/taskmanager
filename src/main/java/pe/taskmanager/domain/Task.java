package pe.taskmanager.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Task {

    private String name;
    @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Subtask> list;

    public Task(){

    }

    public Task(String name, String description, LocalDateTime dueDate){
        list = new ArrayList<>();
        setName(name);
        setDescription(description);
        setDueDate(dueDate);

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

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String date = dueDate.format(formatter);
        return date;
    }
}
