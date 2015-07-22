/**
 * 
 */
package model;

/**
 * A class that represents a Rubric object
 * @author kma
 * @author Van Duong
 */
public class Rubric {
	
	private String taskID;
	private String criterionID;
	/**
	 * @param taskID
	 * @param criterionID
	 */
	public Rubric(String taskID, String criterionID) {
		super();
		this.taskID = taskID;
		this.criterionID = criterionID;
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
	 * @return the criterionID
	 */
	public String getCriterionID() {
		return criterionID;
	}
	/**
	 * @param criterionID the criterionID to set
	 */
	public void setCriterionID(String criterionID) {
		this.criterionID = criterionID;
	}
	
}
