package com.taskmanager.TaskManager;

import be.ucll.Taskmanager.DB.TaskService;
import be.ucll.Taskmanager.DTO.TaskDTO;
import be.ucll.Taskmanager.Domain.Task;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Task.class)
class TaskManagerApplicationTests {

	private TaskService taskService = new TaskService();
	@Test
	void contextLoads() {


		Task t = new Task("t", "t", LocalDateTime.now());


		assertNotNull(t);

	}

}
