package com.taskmanager.TaskManager.domain;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TASK")
public class Task {
    @Id
    private String id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "DEADLINE")
    private LocalDateTime deadline;

    @OneToMany
    private List<SubTask> subTasks;


    public Task() {};

    public Task(String id, String name, String description, LocalDateTime deadline) {
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.setDeadline(deadline);
        this.subTasks = new ArrayList<>();


    };

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
};
