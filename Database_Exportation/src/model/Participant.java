/**
 * 
 */
package model;

/**
 * A class represents the Participant object in PRML
 * @author kma
 * @author Van Duong
 */
public class Participant {
	
	private String participantID;
	private int appID;
	/**
	 * @param participantID
	 * @param appID
	 */
	public Participant(String participantID, int appID) {
		super();
		this.participantID = participantID;
		this.appID = appID;
	}
	/**
	 * @return the participantID
	 */
	public String getParticipantID() {
		return participantID;
	}
	/**
	 * @param participantID the participantID to set
	 */
	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}
	/**
	 * @return the appID
	 */
	public int getAppID() {
		return appID;
	}
	/**
	 * @param appID the appID to set
	 */
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
}
