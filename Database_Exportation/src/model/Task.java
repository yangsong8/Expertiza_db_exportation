package model;

import java.util.Date;

/**
 * A class that reprents a task object
 * @author kma
 *
 */
public class Task {
	private int taskId;
	
	private String taskType;
	
	private String taskTitle;
	
	private String taskPrompt;
	
	private Date taskOpen;
	
	private Date taskDue;

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
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

	/**
	 * @param taskId
	 * @param taskType
	 * @param taskTitle
	 * @param taskPrompt
	 * @param taskOpen
	 * @param taskDue
	 */
	public Task(int taskId, String taskType, String taskTitle,
			String taskPrompt, Date taskOpen, Date taskDue) {
		super();
		this.taskId = taskId;
		this.taskType = taskType;
		this.taskTitle = taskTitle;
		this.taskPrompt = taskPrompt;
		this.taskOpen = taskOpen;
		this.taskDue = taskDue;
	}
	
	
	
}
