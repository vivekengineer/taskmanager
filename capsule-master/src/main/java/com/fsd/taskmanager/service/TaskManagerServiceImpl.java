package com.fsd.taskmanager.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fsd.taskmanager.dto.TaskDTO;
import com.fsd.taskmanager.entity.ParentTask;
import com.fsd.taskmanager.entity.Task;
import com.fsd.taskmanager.repo.ParentTaskRepository;
import com.fsd.taskmanager.repo.TaskManagerRepository;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {
	
	@Autowired
	private TaskManagerRepository taskRepo;
	
	@Autowired
	private ParentTaskRepository parentTaskRepo;
	
	Logger logger = LoggerFactory.getLogger(TaskManagerServiceImpl.class);

	@Override
	public List<TaskDTO> getAllTask() {
		List<TaskDTO> taskDTOList = new ArrayList<TaskDTO>();
		try {
			List<Task> taskList = taskRepo.getAllTask();
			for(Task task:taskList) {
				TaskDTO taskDTO = new TaskDTO();
				taskDTO.setTaskid(task.getTaskid());
				taskDTO.setTaskname(task.getTaskname());
				taskDTO.setStatus(task.getStatus());
				if(task.getParentTask()!=null && StringUtils.hasText(task.getParentTask().getParenttaskname())) {
					taskDTO.setParentname(task.getParentTask().getParenttaskname());
				}
				taskDTO.setPriority(task.getPriority());
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String strartDate=sf.format(task.getStartdate());
				taskDTO.setStartDate(strartDate);
				
				String toDate=sf.format(task.getTodate());
				taskDTO.setToDate(toDate);
				taskDTOList.add(taskDTO);
			}
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
		}
		return taskDTOList;
	}

	@Override
	public void addTask(TaskDTO taskDto) {
		try {
			logger.info("taskDto" + taskDto);
			Task task = new Task();
			ParentTask insertedParentTask =null;
			insertedParentTask=getParentEntry(taskDto.getParentname());
			task.setTaskname(taskDto.getTaskname());
			if(insertedParentTask!=null && insertedParentTask.getParentid()>0) {
				task.setParentTask(insertedParentTask);
			}
			else {
				ParentTask parentTask = new ParentTask();
				parentTask.setParenttaskname(taskDto.getParentname());
				insertedParentTask=parentTaskRepo.save(parentTask);
				task.setParentTask(insertedParentTask);
			}
			task.setPriority(taskDto.getPriority());
			task.setStatus(taskDto.getStatus());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date toDate;
			try {
				startDate = new java.sql.Date(sf.parse(taskDto.getStartDate()).getTime());
				task.setStartdate(startDate);
				toDate = new java.sql.Date(sf.parse(taskDto.getToDate()).getTime());
				task.setTodate(toDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskRepo.save(task);
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
		}
		
	}

	private ParentTask getParentEntry(String parenttaskname) {
		ParentTask parentTask =null;
		try {
			parentTask=parentTaskRepo.getParentRow(parenttaskname);
		}
		catch(Exception ex) {
			logger.error("Exception Occured"+ex.getMessage());
		}
		
		return parentTask;
	}
	
	
	@Override
	public void updateTask(TaskDTO updateTask) {
		logger.info("udateTask==>"+updateTask);
		try{
			Task task = new Task();
			ParentTask insertedParentTask =null;
			insertedParentTask=getParentEntry(updateTask.getParentname());
			task.setTaskname(updateTask.getTaskname());
			task.setStatus(updateTask.getStatus());
			if(insertedParentTask!=null && insertedParentTask.getParentid()>0) {
				task.setParentTask(insertedParentTask);
			}
			else {
				ParentTask parentTask = new ParentTask();
				parentTask.setParenttaskname(updateTask.getParentname());
				insertedParentTask=parentTaskRepo.save(parentTask);
				task.setParentTask(insertedParentTask);
			}
			task.setTaskid(updateTask.getTaskid());
			task.setTaskname(updateTask.getTaskname());
			task.setPriority(updateTask.getPriority());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date toDate;
			try {
				startDate = new java.sql.Date(sf.parse(updateTask.getStartDate()).getTime());
				task.setStartdate(startDate);
				toDate = new java.sql.Date(sf.parse(updateTask.getToDate()).getTime());
				task.setTodate(toDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskRepo.save(task);
		}
		catch(Exception ex) {
			logger.error("Exception Occurred"+ex.getMessage());
		}
	}
	
	public void deleteTask(TaskDTO deleteTask) {
		try{
			Task task = new Task();
			task.setStatus("inactive");
			task.setTaskid(deleteTask.getTaskid());
			ParentTask insertedParentTask =null;
			insertedParentTask=getParentEntry(deleteTask.getParentname());
			task.setTaskname(deleteTask.getTaskname());
			
			if(insertedParentTask!=null && insertedParentTask.getParentid()>0) {
				task.setParentTask(insertedParentTask);
			}
			
			task.setTaskname(deleteTask.getTaskname());
			task.setPriority(deleteTask.getPriority());
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate;
			Date toDate;
			try {
				startDate = new java.sql.Date(sf.parse(deleteTask.getStartDate()).getTime());
				task.setStartdate(startDate);
				toDate = new java.sql.Date(sf.parse(deleteTask.getToDate()).getTime());
				task.setTodate(toDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			taskRepo.save(task);
		}
		catch(Exception ex) {
			logger.error("Exception Occurred"+ex.getMessage());
		}
	}
	
}
