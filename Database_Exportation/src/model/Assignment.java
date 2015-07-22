/**
 * 
 */
package model;

/**
 * A class that represents an assignment object
 * @author kma
 *
 */
public class Assignment {
	private int assignmentId;
	
	private char[] assignmentCIPId = new char[7];
	
	private String title;
	
	private String description;

	/**
	 * @return the assignmentId
	 */
	public int getAssignmentId() {
		return assignmentId;
	}

	/**
	 * @param assignmentId the assignmentId to set
	 */
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	/**
	 * @return the assignmentCIPId
	 */
	public char[] getAssignmentCIPId() {
		return assignmentCIPId;
	}

	/**
	 * @param assignmentCIPId the assignmentCIPId to set
	 */
	public void setAssignmentCIPId(char[] assignmentCIPId) {
		this.assignmentCIPId = assignmentCIPId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param assignmentId
	 * @param assignmentCIPId
	 * @param title
	 * @param description
	 */
	public Assignment(int assignmentId, char[] assignmentCIPId, String title,
			String description) {
		super();
		this.assignmentId = assignmentId;
		this.assignmentCIPId = assignmentCIPId;
		this.title = title;
		this.description = description;
	}
	
	
}
