package be.ucll.Taskmanager.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class SubTask {
    @Id
    @GeneratedValue
    private long id;

    private long taskid;
    @NotNull(message = "Name cannot be emtpy")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "description cannot be empty")
    @NotEmpty(message = "description cannot be empty")
    private String description;
    private boolean completed = false;

    public SubTask(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public SubTask(){}

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    public void setDescription(String description) {
        if (description != null && !description.trim().isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description must not be empty");
        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return this.name;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setTaskid(long taskid){
        this.taskid = taskid;
    }

    public long getTaskid(){
        return this.taskid;
    }
}
