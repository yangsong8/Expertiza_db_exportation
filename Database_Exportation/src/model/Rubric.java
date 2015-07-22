/**
 * 
 */
package model;

/**
 * A class that represents a Rubric object
 * @author kma
 *
 */
public class Rubric {
	private int taskId;
	
	private int criterionId;

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
	 * @return the criterionId
	 */
	public int getCriterionId() {
		return criterionId;
	}

	/**
	 * @param criterionId the criterionId to set
	 */
	public void setCriterionId(int criterionId) {
		this.criterionId = criterionId;
	}

	/**
	 * @param taskId
	 * @param criterionId
	 */
	public Rubric(int taskId, int criterionId) {
		super();
		this.taskId = taskId;
		this.criterionId = criterionId;
	}
	
	
}
