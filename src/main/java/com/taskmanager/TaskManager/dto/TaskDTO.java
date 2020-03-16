package com.taskmanager.TaskManager.dto;

import com.taskmanager.TaskManager.domain.SubTask;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskDTO {

    @NotEmpty
    @Size(min = 4)

    private String id;
    private String name;
    private String description;
    private LocalDateTime deadline;
    private List<SubTask> subTasks;

    public void addSubTask(SubTask t) {
        if (t != null) {
            subTasks.add(t);
        }
    }

    public List<SubTask> getSubTasks(){
        return this.subTasks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    };

    public void setName(String name) {
        this.name = name;
    };

    public String getDescription() {
        return description;
    };

    public void setDescription(String description) {
        this.description = description;
    };

    public LocalDateTime getDeadline() {
        return deadline;
    };

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    };

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
}
