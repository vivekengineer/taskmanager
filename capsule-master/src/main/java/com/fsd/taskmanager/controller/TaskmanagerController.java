package com.fsd.taskmanager.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.taskmanager.dto.TaskDTO;
import com.fsd.taskmanager.service.TaskManagerService;

@RestController
public class TaskmanagerController {
	
	@Autowired
	private TaskManagerService taskMgrService;
	
	Logger logger = LoggerFactory.getLogger(TaskmanagerController.class);
	
	@GetMapping(value="/getTask", produces="application/json")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public List<TaskDTO> getAllTask() {
		

		List<TaskDTO> taskList =taskMgrService.getAllTask();
		
		return taskList;
	}
	
	@PostMapping(value="/addTask", produces="application/json")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public String addTask(@RequestBody TaskDTO taskDto) {
		try {
			System.out.println("Task DTO==>"+taskDto );
			taskMgrService.addTask(taskDto);
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
			return "Failure";
		}
		
		return "SUCCESS";
	}
	
	@PutMapping(value="/updateTask", produces="application/json")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public String updateTask(@RequestBody TaskDTO taskupdate) {
		try {
			System.out.println("Task DTO==>"+taskupdate );
			taskMgrService.updateTask(taskupdate);
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
			return "Failure";
		}
		
		return "SUCCESS";
	}
	
	@PutMapping(value="/deleteTask", produces="application/json")
	@CrossOrigin(origins="*", allowedHeaders="*")
	public String deleteTask(@RequestBody TaskDTO deleteTask) {
		try {
			taskMgrService.deleteTask(deleteTask);
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
			return "Failure";
		}
		
		return "SUCCESS";
	}

}
