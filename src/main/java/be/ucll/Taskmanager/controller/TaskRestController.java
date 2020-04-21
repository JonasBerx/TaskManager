package be.ucll.Taskmanager.controller;


import be.ucll.Taskmanager.DB.TaskService;
import be.ucll.Taskmanager.DTO.TaskDTO;
import be.ucll.Taskmanager.Domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    private final TaskService service;

    public TaskRestController(TaskService service) {

        this.service = service;
    }

    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> getTasks() {
        return service.getAll();
    }

    @PostMapping("/tasks")
    public TaskDTO createNewTask(@RequestBody @Valid TaskDTO taskDTO) {
        return service.addTask(taskDTO);
    }
}
