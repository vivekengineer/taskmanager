package com.fsd.taskmanager.dto;

public class TaskDTO {
	private int taskid;
	private String taskname;
	private String parentname;
	private int priority;
	private String startDate;
	private String toDate;
	private String status;
	
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
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", taskname=" + taskname + ", parentname=" + parentname + ", priority="
				+ priority + ", startDate=" + startDate + ", toDate=" + toDate + "]";
	}
	
	
	

}
