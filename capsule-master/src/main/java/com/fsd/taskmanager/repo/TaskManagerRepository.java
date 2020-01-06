package com.fsd.taskmanager.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fsd.taskmanager.entity.Task;

@Repository
public interface TaskManagerRepository extends JpaRepository<Task, Long> {

	@Query("select a from Task a")
	public List<Task> getAllTask();
	
	@Query("update Task set status=?1 where taskid=?2")
	public void softDeleteTask(String status,int taskid);
	
}
