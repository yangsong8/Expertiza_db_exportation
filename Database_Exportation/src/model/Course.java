/**
 * 
 */
package model;

import java.util.Date;

/**
 * An object that will represent a course 
 * @author kma
 *
 */
public class Course {
	private int courseId;
	
	private char[] cipId = new char[7];
	
	private String title;
	
	private String description;
	
	private String level;
	
	private Date courseCreated;
	
	private Date courseStarted;
	
	private Date courseEnded;

	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the cipId
	 */
	public char[] getCipId() {
		return cipId;
	}

	/**
	 * @param cipId the cipId to set
	 */
	public void setCipId(char[] cipId) {
		this.cipId = cipId;
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
	 * @param decription the description to set
	 */
	public void setDecription(String description) {
		this.description = description;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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

	/**
	 * @param courseId
	 * @param cipId
	 * @param title
	 * @param decription
	 * @param level
	 * @param courseCreated
	 * @param courseStarted
	 * @param courseEnded
	 */
	public Course(int courseId, char[] cipId, String title, String description,
			String level, Date courseCreated, Date courseStarted,
			Date courseEnded) {
		super();
		this.courseId = courseId;
		this.cipId = cipId;
		this.title = title;
		this.description = description;
		this.level = level;
		this.courseCreated = courseCreated;
		this.courseStarted = courseStarted;
		this.courseEnded = courseEnded;
	}
	
	
	
	
	
}
