package model;

import java.util.Date;

/**
 * A class that reprents a task object
 * @author kma
 * @author Van Duong
 */
public class Task {
	
	private Integer taskID;

	private Integer taskTypeID;

	private String taskTitle;
	private String taskDescription;
	private Date taskOpen;
	private Date taskDue;
	// this round variable is for keeping track of the round number for each task. It will not be recorded in PRML db.
	private Integer round;
	/**
	 * @param taskID2
	 * @param taskTypeID
	 * @param taskTitle
	 * @param taskPrompt
	 * @param taskOpen
	 * @param taskDue
	 */

	
	public Task(Integer taskID, Integer taskTypeID, String taskTitle, String taskDescription, Date taskOpen, Date taskDue, Integer round) {
		super();
		this.taskID = taskID;
		this.taskTypeID = taskTypeID;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskOpen = taskOpen;
		this.taskDue = taskDue;
		this.round = round;
	}

	/**
	 * @return the round
	 */
	public Integer getRound() {
		return round;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(Integer round) {
		this.round = round;
	}

	/**
	 * @return the taskID
	 */
	public Integer getTaskID() {
		return taskID;
	}
	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	/**
	 * @return the taskTypeID
	 */
	public Integer getTaskTypeID() {
		return taskTypeID;
	}
	/**
	 * @param taskTypeID the taskTypeID to set
	 */
	public void setTaskTypeID(Integer taskTypeID) {
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
	public String getTaskDescription() {
		return taskDescription;
	}
	/**
	 * @param taskPrompt the taskPrompt to set
	 */
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Task [taskID=" + taskID + ", taskTypeID=" + taskTypeID + ", taskTitle=" + taskTitle
				+ ", taskDescription=" + taskDescription + ", taskOpen=" + taskOpen + ", taskDue=" + taskDue
				+ ", round=" + round + "]";
	}
	
}
