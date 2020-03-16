package com.taskmanager.TaskManager.domain;

public class SubTask {

    private String name;
    private String description;

    public SubTask() {

    }

    public SubTask(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
