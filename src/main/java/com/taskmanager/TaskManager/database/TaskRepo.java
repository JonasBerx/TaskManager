package com.taskmanager.TaskManager.database;

import com.taskmanager.TaskManager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Long> {

    List<Task> getAllById();

    Task getByName(String name);

    Task getById(String id);

}
