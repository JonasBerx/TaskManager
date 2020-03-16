package com.taskmanager.TaskManager.database;

import com.taskmanager.TaskManager.domain.Task;

import java.util.List;

public interface TaskDAO {
    void add(Task task);

    List<Task> listTasks();
}
