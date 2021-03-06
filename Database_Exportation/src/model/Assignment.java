/**
 * 
 */
package model;

/**
 * A class that represents an assignment object
 * @author kma
 * @author Van Duong
 */
public class Assignment {
	
	private Integer assigmentID;
	private char[] assignCIPCode = new char[7];
	private String assignTitle;
	private String assignDescription;
	private Integer courseID;
	
	
	/**
	 * @param assigmentID
	 * @param assignCIPCode
	 * @param assignTitle
	 * @param assignDescription
	 * @param courseID
	 */
	public Assignment(Integer assigmentID, char[] assignCIPCode,
			String assignTitle, String assignDescription, Integer courseID) {
		super();
		this.assigmentID = assigmentID;
		this.assignCIPCode = assignCIPCode;
		this.assignTitle = assignTitle;
		this.assignDescription = assignDescription;
		this.courseID = courseID;
	}
	/**
	 * @return the courseID
	 */
	public Integer getCourseID() {
		return courseID;
	}
	/**
	 * @param courseID the courseID to set
	 */
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	/**
	 * @return the assigmentID
	 */
	public Integer getAssigmentID() {
		return assigmentID;
	}
	/**
	 * @param assigmentID the assigmentID to set
	 */
	public void setAssigmentID(Integer assigmentID) {
		this.assigmentID = assigmentID;
	}
	/**
	 * @return the assignCIPCode
	 */
	public char[] getAssignCIPCode() {
		return assignCIPCode;
	}
	/**
	 * @param assignCIPCode the assignCIPCode to set
	 */
	public void setAssignCIPCode(char[] assignCIPCode) {
		this.assignCIPCode = assignCIPCode;
	}
	/**
	 * @return the assignTitle
	 */
	public String getAssignTitle() {
		return assignTitle;
	}
	/**
	 * @param assignTitle the assignTitle to set
	 */
	public void setAssignTitle(String assignTitle) {
		this.assignTitle = assignTitle;
	}
	/**
	 * @return the assignDescription
	 */
	public String getAssignDescription() {
		return assignDescription;
	}
	/**
	 * @param assignDescription the assignDescription to set
	 */
	public void setAssignDescription(String assignDescription) {
		this.assignDescription = assignDescription;
	}
	
	
}
