package com.taskmanager.TaskManager.database;

import com.taskmanager.TaskManager.domain.Task;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
        tasks.add(new Task("1", "2", "3", LocalDateTime.of(2020,12,12,12,12)));
//        tasks.add(new Task("2", "2", "3", LocalDateTime.of(2020,12,12,12,12)));
//        tasks.add(new Task("3", "2", "3", LocalDateTime.of(2020,12,12,12,12)));

    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task t) {
        tasks.add(t);
    }

    public Task getTask(String id) {

        if (id != null) {
            for (Task task : tasks) {
                if (task.getId().equals(id)) {
                    return task;
                }
            }
        } else {
            throw new IllegalArgumentException("Id be empty my guy");
        }
        throw new IllegalArgumentException("Das kaput");

    }

    public void editTask(String id, String name, String description, LocalDateTime deadline) {
        System.out.println(id);
        if (id != null) {
            for (Task task : tasks) {
                if (task.getId().equals(id)) {
                    task.setDescription(description);
                    task.setDeadline(deadline);
                    task.setName(name);
                    task.setId(id);
                }
            }
        } else {
            throw new IllegalArgumentException("Id be empty my guy");
        }

    }

    public void delete(String id) {
        tasks.removeIf(t -> t.getId().equals(id));

    }
}
