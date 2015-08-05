/**
 * 
 */
package mapping;

/**
 * A class for representing a mapping table between Actor and Participant
 * @author kma
 *
 */
public class ActorParticipant {
	private Integer ActorID;
	private Integer ParticipantID;
	private Integer RoleID;
	/**
	 * @return the actorID
	 */
	public Integer getActorID() {
		return ActorID;
	}
	/**
	 * @param actorID the actorID to set
	 */
	public void setActorID(Integer actorID) {
		ActorID = actorID;
	}
	/**
	 * @return the participantID
	 */
	public Integer getParticipantID() {
		return ParticipantID;
	}
	/**
	 * @param participantID the participantID to set
	 */
	public void setParticipantID(Integer participantID) {
		ParticipantID = participantID;
	}
	/**
	 * @return the roleID
	 */
	public Integer getRoleID() {
		return RoleID;
	}
	/**
	 * @param roleID the roleID to set
	 */
	public void setRoleID(Integer roleID) {
		RoleID = roleID;
	}
	/**
	 * @param actorID
	 * @param participantID
	 * @param roleID
	 */
	public ActorParticipant(Integer actorID, Integer participantID,
			Integer roleID) {
		super();
		ActorID = actorID;
		ParticipantID = participantID;
		RoleID = roleID;
	}
	
	
	
}
