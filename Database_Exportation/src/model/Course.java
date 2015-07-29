/**
 * 
 */
package model;

import java.util.Date;

/**
 * An object that will represent a course 
 * @author kma
 * @author Van Duong
 */
public class Course {
	
	private Integer courseID;
	private char[] courseCIPCode = new char[7];
	private String courseTitle;
	private String courseDescription;
	private Integer courseLevelID;
	private Date courseCreated;
	private Date courseStarted;
	private Date courseEnded;
	/**
	 * @param courseID
	 * @param courseCIPCode
	 * @param courseTitle
	 * @param courseDescription
	 * @param courseLevelID
	 * @param courseCreated
	 * @param courseStarted
	 * @param courseEnded
	 */
	public Course(Integer courseID, char[] courseCIPCode, String courseTitle, String courseDescription,
			Integer courseLevelID, Date courseCreated, Date courseStarted, Date courseEnded) {
		super();
		this.courseID = courseID;
		this.courseCIPCode = courseCIPCode;
		this.courseTitle = courseTitle;
		this.courseDescription = courseDescription;
		this.courseLevelID = courseLevelID;
		this.courseCreated = courseCreated;
		this.courseStarted = courseStarted;
		this.courseEnded = courseEnded;
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
	 * @return the courseCIPCode
	 */
	public char[] getCourseCIPCode() {
		return courseCIPCode;
	}
	/**
	 * @param courseCIPCode the courseCIPCode to set
	 */
	public void setCourseCIPCode(char[] courseCIPCode) {
		this.courseCIPCode = courseCIPCode;
	}
	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}
	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	/**
	 * @return the courseLevelID
	 */
	public Integer getCourseLevelID() {
		return courseLevelID;
	}
	/**
	 * @param courseLevelID the courseLevelID to set
	 */
	public void setCourseLevelID(Integer courseLevelID) {
		this.courseLevelID = courseLevelID;
	}
	/**
	 * @return the courseCreated
	 */
	public Date getCourseCreated() {
		return courseCreated;
	}
	/**
	 * @param courseCreated the courseCreated to set
	 */
	public void setCourseCreated(Date courseCreated) {
		this.courseCreated = courseCreated;
	}
	/**
	 * @return the courseStarted
	 */
	public Date getCourseStarted() {
		return courseStarted;
	}
	/**
	 * @param courseStarted the courseStarted to set
	 */
	public void setCourseStarted(Date courseStarted) {
		this.courseStarted = courseStarted;
	}
	/**
	 * @return the courseEnded
	 */
	public Date getCourseEnded() {
		return courseEnded;
	}
	/**
	 * @param courseEnded the courseEnded to set
	 */
	public void setCourseEnded(Date courseEnded) {
		this.courseEnded = courseEnded;
	}
	
	
}
