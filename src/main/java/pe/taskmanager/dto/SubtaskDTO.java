package pe.taskmanager.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class SubtaskDTO {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private String title;

    public SubtaskDTO(){

    }
    public SubtaskDTO(String title, String description){
        this.description = description;
        this.title = title;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
