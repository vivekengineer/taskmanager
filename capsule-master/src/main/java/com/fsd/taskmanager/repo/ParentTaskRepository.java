package com.fsd.taskmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fsd.taskmanager.entity.ParentTask;

@Repository
public interface ParentTaskRepository extends JpaRepository<ParentTask, Long> {

	@Query("select a from ParentTask a where a.parenttaskname=?1")
	public ParentTask getParentRow(String parenttaskname); 
	
}
