package com.taskmanager.TaskManager.controller;


import com.taskmanager.TaskManager.domain.SubTask;
import com.taskmanager.TaskManager.domain.Task;
import com.taskmanager.TaskManager.dto.TaskDTO;
import com.taskmanager.TaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.context.SpringContextUtils;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Controller

public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasks(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "task";
    }

    @PostMapping("/taskAdd")
    public String addTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addTask";
        }
        taskService.addTask(taskDTO);
        return "redirect:/tasks";
    }

    @GetMapping("/new")
    public String addTask(Model model) {
        model.addAttribute("task", new TaskDTO());
        return "addTask";
    }

    @GetMapping("/tasks/{id}")
    public String specificTask(Model model, @PathVariable String id) {
        model.addAttribute("task", taskService.getTask(id));
        model.addAttribute("subtasks", taskService.getTask(id).getSubTasks());
        return "specific";
    }

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTask(Model model, @PathVariable String id) {
        model.addAttribute("task", taskService.getTask(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editTask(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("deadline") String deadline, @RequestParam("id") String id) {
        taskService.editTask(id, name, description, LocalDateTime.parse(deadline));
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/sub/create")
    public String subTask(Model m, @PathVariable String id) {
        m.addAttribute("task", taskService.getTask(id));
        return "subtask";
    }

    @PostMapping("/subtask")
    public String addSubTask(Model m, @RequestParam("subName") String subName, @RequestParam("subDescr") String subDescription, @RequestParam("id") String parentID) {
        SubTask t = new SubTask(subName, subDescription);
        taskService.getTask(parentID).addSubTask(t);
        return "redirect:/tasks/" + parentID;
    }

//    @GetMapping("/delete/{id}")
//    public String deleteTask(@PathVariable String id) {
//        taskService.deleteTask(id);
//        return "redirect:/tasks";
//    }
}
