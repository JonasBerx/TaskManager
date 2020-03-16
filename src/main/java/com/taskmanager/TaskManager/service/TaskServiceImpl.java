package com.taskmanager.TaskManager.service;


import com.taskmanager.TaskManager.database.TaskDAO;
import com.taskmanager.TaskManager.database.TaskRepository;
import com.taskmanager.TaskManager.domain.Task;
//import com.taskmanager.TaskManager.dto.TaskDTO;
import com.taskmanager.TaskManager.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskDAO taskDAO;


    @Transactional
    public void add(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getId(), taskDTO.getName(), taskDTO.getDescription(), taskDTO.getDeadline());
        taskDAO.add(task);
    }

    @Transactional
    public List<Task> listTasks() {
        return taskDAO.listTasks();
    }

    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getTasks() {
        return repository.getTasks();
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task(taskDTO.getId(),taskDTO.getName(),taskDTO.getDescription(),taskDTO.getDeadline());
        repository.addTask(task);
    }

    @Override
    public Task getTask(String id) {
        return repository.getTask(id);
    }

    @Override
    public void editTask(String id, String name, String description, LocalDateTime deadline) {
        repository.editTask(id, name, description, deadline);
    }

    @Override
    public void deleteTask(String id) {
        repository.delete(id);
    }
}
