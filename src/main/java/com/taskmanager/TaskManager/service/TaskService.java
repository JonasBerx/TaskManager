package com.taskmanager.TaskManager.service;

import com.taskmanager.TaskManager.domain.Task;
import com.taskmanager.TaskManager.dto.TaskDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface TaskService {

    public List<Task> getTasks();

    void addTask(TaskDTO taskDTO);

    Task getTask(String id);

    void editTask(String id, String name, String description, LocalDateTime deadline);

    void deleteTask(String id);
}
