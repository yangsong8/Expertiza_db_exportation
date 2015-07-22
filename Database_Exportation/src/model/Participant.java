/**
 * 
 */
package model;

/**
 * A class represents the Participant object in PRML
 * @author kma
 *
 */
public class Participant {
	
	private int participantId;
	private int appId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	/**
	 * @param id
	 */
	public Participant(int participantId, int appId) {
		super();
		this.participantId = participantId;
		this.appId = appId;
	}

	/**
	 * @return the participantId
	 */
	public int getParticipantId() {
		return participantId;
	}

	/**
	 * @param participantId the participantId to set
	 */
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

		
	
}
