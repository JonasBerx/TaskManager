package com.taskmanager.TaskManager;

import be.ucll.Taskmanager.DB.SubTaskRepository;
import be.ucll.Taskmanager.DB.SubTaskService;
import be.ucll.Taskmanager.DB.TaskService;
import be.ucll.Taskmanager.DTO.TaskDTO;
import be.ucll.Taskmanager.Domain.SubTask;
import be.ucll.Taskmanager.Domain.Task;
import be.ucll.Taskmanager.controller.TaskController;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
@RunWith(SpringRunner.class)
class TaskManagerApplicationTests {

	@Autowired
	private TaskService taskService;
	Task task = new Task("Juist", "Juist", LocalDateTime.of(2020, 11, 18, 12, 12));
	@Test
	void contextLoads() {


		Task t = new Task("t", "t", LocalDateTime.now());


		assertNotNull(t);

	}
	@Test()
	void nameIsNullNewTask() throws IllegalArgumentException {
		try {
			Task nameNot = new Task(null, "Name", LocalDateTime.of(2020, 11, 18, 12, 12));
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Name must not be empty"));
		}
	}
	@Test()
	void descrIsNullNewTask() throws IllegalArgumentException {
		try {
			Task descrNot = new Task("Descr", null, LocalDateTime.of(2020, 11, 18, 12, 12));
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Description must not be empty"));
		}
	}
	@Test()
	void deadlineIsNullNewTask() throws IllegalArgumentException {
		try {
			Task deadlNot = new Task("Deadline", "Deadline", null);
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Deadline must not be empty"));
		}
	}
	@Test()
	void correctTask(){
		try {

			Task correct = new Task("Juist", "Juist", LocalDateTime.of(2020, 11, 18, 12, 12));
			SubTask t = new SubTask("Test", "Test");
			correct.addSubTask(t);
			TaskDTO taskDTO = new TaskDTO();
			taskDTO.setName(correct.getName());
			taskDTO.setDescription(correct.getDescription());
			taskDTO.setDeadline(correct.getDeadline());
			taskDTO.setSubtasks(correct.getSubtasks());
			System.out.println(taskService);



		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Name must not be empty"));
		}

	}

	@Test
	void correctSubTask() {

		SubTask subTask = new SubTask("sub1", "sub");
		task.addSubTask(subTask);
		assertTrue(task.getSubtasks().size() > 0);
	}
	@Test
	void nullNameSubTask() {
		try {
			SubTask subTask = new SubTask(null, "ok");
			task.addSubTask(subTask);

		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Name must not be empty"));
		}
	}
	@Test
	void nullDescrSubTask() {
		try {
			SubTask subTask = new SubTask("sub1", null);
			task.addSubTask(subTask);
		} catch (IllegalArgumentException e) {
			assertThat(e.getMessage(), is("Description must not be empty"));
		}
	}

}
