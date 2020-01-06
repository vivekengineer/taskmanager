package com.fsd.taskmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="parenttask")
public class ParentTask implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9086903541734690911L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parentid")
	private int parentid;
	
	private String parenttaskname;
	
	public ParentTask() {
		super();
	}
	
	public ParentTask(int parentid, String parenttaskname) {
		super();
		this.parentid = parentid;
		this.parenttaskname = parenttaskname;
	}
	
	@OneToMany(mappedBy="parentid")
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getParenttaskname() {
		return parenttaskname;
	}
	public void setParenttaskname(String parenttaskname) {
		this.parenttaskname = parenttaskname;
	}
	
	
}
