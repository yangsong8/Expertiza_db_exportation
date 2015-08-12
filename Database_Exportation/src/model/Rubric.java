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
	
	private Integer taskID;
	private Integer criterionID;
	/**
	 * @param taskID
	 * @param criterionID
	 */
	public Rubric(Integer taskID, Integer criterionID) {
		super();
		this.taskID = taskID;
		this.criterionID = criterionID;
		
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
	 * @return the criterionID
	 */
	public Integer getCriterionID() {
		return criterionID;
	}
	/**
	 * @param criterionID the criterionID to set
	 */
	public void setCriterionID(Integer criterionID) {
		this.criterionID = criterionID;
	}
	
}
