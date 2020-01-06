package com.fsd.taskmanager.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8471980158617551877L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="taskid")
	private int taskid;
	private String taskname;
	private int priority;
	private Date startdate;
	private Date todate;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="parentid")
	private ParentTask parentid;
	
	public Task() {
		super();
	}
	
	public Task(int taskid, String taskname, int priority, Date startdate, Date todate, String status,
			ParentTask parentid) {
		super();
		this.taskid = taskid;
		this.taskname = taskname;
		this.priority = priority;
		this.startdate = startdate;
		this.todate = todate;
		this.status = status;
		this.parentid = parentid;
	}
	public int getTaskid() {
		return taskid;
	}
	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public ParentTask getParentTask() {
		return parentid;
	}
	public void setParentTask(ParentTask parentid) {
		this.parentid = parentid;
	}
	
	
	
}
