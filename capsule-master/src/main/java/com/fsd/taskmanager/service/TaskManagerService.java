package com.fsd.taskmanager.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fsd.taskmanager.dto.TaskDTO;

@Component
public interface TaskManagerService {
	
	public List<TaskDTO> getAllTask();
	
	public void addTask(TaskDTO taskDto);

	public void updateTask(TaskDTO updateTask);
	
	public void deleteTask(TaskDTO deleteTask);
}
