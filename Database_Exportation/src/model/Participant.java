/**
 * 
 */
package model;

/**
 * A class represents a Participant object in PRML
 * @author kma
 * @author Van Duong
 */
public class Participant {
	
	private Integer participantID;
	private Integer appID;
	/**
	 * @param participantID
	 * @param appID
	 */
	public Participant(Integer participantID, Integer appID) {
		super();
		this.participantID = participantID;
		this.appID = appID;
	}
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
	
	
}
