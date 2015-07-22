/**
 * 
 */
package mapping;

/**
 * A mapping table for representing the relation between a participant and a team
 * @author kma
 *
 */
public class Participant_Actor_Mapping {
	
	private int participantId;
	
	private int actorId;

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

	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}

	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	/**
	 * @param participantId
	 * @param actorId
	 */
	public Participant_Actor_Mapping(int participantId, int actorId) {
		super();
		this.participantId = participantId;
		this.actorId = actorId;
	}
	
	
}
