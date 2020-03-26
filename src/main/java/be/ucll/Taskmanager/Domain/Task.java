package be.ucll.Taskmanager.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private long id;

    @NotNull(message = "Name cannot be emtpy")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "deadline cannot be empty")
    private LocalDateTime deadline;
    @NotNull(message = "description cannot be empty")
    @NotEmpty(message = "description cannot be empty")
    private String description;
    private boolean completed = false;
    @Transient
    private List<SubTask> subtasks;

    public Task(String name, String description,LocalDateTime deadline) {
        setName(name);
        setDescription(description);
        setDeadline(deadline);
        subtasks = new ArrayList<>();
    }

    public Task(){
        subtasks = new ArrayList<>();
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name must not be empty");
        }
    }

    public void setDeadline(LocalDateTime deadline) {
        if (deadline != null) {
            this.deadline = deadline;
        } else {
            throw new IllegalArgumentException("Deadline must not be empty");
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

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String deadlineToString(){
        DateFormatter formatter =new DateFormatter();
        return formatter.print(deadline, null);
    }

    public void setId(long id){
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return name + " " + this.deadlineToString();
    }

    public void addSubTask(SubTask t){
        long id = 1;
        if (t != null) {
            if (this.subtasks.size() > 0) {
                id = this.subtasks.get(subtasks.size() - 1).getId() + 1;
            }
            t.setId(id);
            this.subtasks.add(t);
        } else {
            throw new IllegalArgumentException("Subtask is empty");
        }
    }

    public List<SubTask> getSubtasks(){
        return this.subtasks;
    }

    public boolean isCompleted(){
        return this.completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public void setSubtasks(List<SubTask> subtasks){
        if (subtasks != null) {
            this.subtasks = subtasks;
        } else {
            throw new IllegalArgumentException("This list is empty");
        }
    }
}
