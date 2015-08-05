/**
 * 
 */
package model;

/**
 * A class that represents the Enrollment object
 * @author kma
 *
 */
public class Enrollment {
	
	private Integer participantID;
	
	private Integer appID;
	
	private Integer courseID;

	/**
	 * @return the participantID
	 */
	public Integer getParticipantID() {
		return participantID;
	}

	/**
	 * @param participantID the participantID to set
	 */
	public void setParticipantID(Integer participantID) {
		this.participantID = participantID;
	}

	/**
	 * @return the appID
	 */
	public Integer getAppID() {
		return appID;
	}

	/**
	 * @param appID the appID to set
	 */
	public void setAppID(Integer appID) {
		this.appID = appID;
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
	 * @param participantID
	 * @param appID
	 * @param courseID
	 */
	public Enrollment(Integer participantID, Integer appID, Integer courseID) {
		super();
		this.participantID = participantID;
		this.appID = appID;
		this.courseID = courseID;
	}
	
}
