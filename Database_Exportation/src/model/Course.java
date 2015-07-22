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
	
	private int levelID;
	
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
	 * @return the levelID
	 */
	public int getLevelID() {
		return levelID;
	}

	/**
	 * @param levelID the levelID to set
	 */
	public void setLevelID(int levelID) {
		this.levelID = levelID;
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
			int levelID, Date courseCreated, Date courseStarted,
			Date courseEnded) {
		super();
		if(description.length() > 250) {
			this.description = description.substring(0, 250);
		} else {
			this.description = description;
		}
		this.courseId = courseId;
		this.cipId = cipId;
		this.title = title;
		this.levelID = levelID;
		this.courseCreated = courseCreated;
		this.courseStarted = courseStarted;
		this.courseEnded = courseEnded;
	}
	
	
	
	
	
}
