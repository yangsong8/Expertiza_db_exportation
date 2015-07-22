package model;

import java.util.Date;

/**
 * A class that reprents a task object
 * @author kma
 * @author Van Duong
 */
public class Task {
	
	private String taskID;
	private int taskTypeID;
	private String taskTitle;
	private String taskPrompt;
	private Date taskOpen;
	private Date taskDue;
	/**
	 * @param taskID
	 * @param taskTypeID
	 * @param taskTitle
	 * @param taskPrompt
	 * @param taskOpen
	 * @param taskDue
	 */
	public Task(String taskID, int taskTypeID, String taskTitle, String taskPrompt, Date taskOpen, Date taskDue) {
		super();
		this.taskID = taskID;
		this.taskTypeID = taskTypeID;
		this.taskTitle = taskTitle;
		this.taskPrompt = taskPrompt;
		this.taskOpen = taskOpen;
		this.taskDue = taskDue;
	}
	/**
	 * @return the taskID
	 */
	public String getTaskID() {
		return taskID;
	}
	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	/**
	 * @return the taskTypeID
	 */
	public int getTaskTypeID() {
		return taskTypeID;
	}
	/**
	 * @param taskTypeID the taskTypeID to set
	 */
	public void setTaskTypeID(int taskTypeID) {
		this.taskTypeID = taskTypeID;
	}
	/**
	 * @return the taskTitle
	 */
	public String getTaskTitle() {
		return taskTitle;
	}
	/**
	 * @param taskTitle the taskTitle to set
	 */
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	/**
	 * @return the taskPrompt
	 */
	public String getTaskPrompt() {
		return taskPrompt;
	}
	/**
	 * @param taskPrompt the taskPrompt to set
	 */
	public void setTaskPrompt(String taskPrompt) {
		this.taskPrompt = taskPrompt;
	}
	/**
	 * @return the taskOpen
	 */
	public Date getTaskOpen() {
		return taskOpen;
	}
	/**
	 * @param taskOpen the taskOpen to set
	 */
	public void setTaskOpen(Date taskOpen) {
		this.taskOpen = taskOpen;
	}
	/**
	 * @return the taskDue
	 */
	public Date getTaskDue() {
		return taskDue;
	}
	/**
	 * @param taskDue the taskDue to set
	 */
	public void setTaskDue(Date taskDue) {
		this.taskDue = taskDue;
	}
	
}
