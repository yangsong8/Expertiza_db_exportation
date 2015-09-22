/**
 * 
 */
package model;

/**
 * A class that represents a Review object
 * @author kma
 * @author Van Duong
 */
public class Review {
	
	private Integer assessorActorID;
	private Integer taskID;
	private Integer assessedArtifactID;
	private Integer critiqueArtifactID;
	private Integer mapID;
	
	/**
	 * @return the assessorActorID
	 */
	public Integer getAssessorActorID() {
		return assessorActorID;
	}
	/**
	 * @param assessorActorID the assessorActorID to set
	 */
	public void setAssessorActorID(Integer assessorActorID) {
		this.assessorActorID = assessorActorID;
	}
	/**
	 * @return the taskID
	 */
	public Integer getTaskID() {
		return taskID;
	}
	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	/**
	 * @return the assessedArtifactID
	 */
	public Integer getAssessedArtifactID() {
		return assessedArtifactID;
	}
	/**
	 * @param assessedArtifactID the assessedArtifactID to set
	 */
	public void setAssessedArtifactID(Integer assessedArtifactID) {
		this.assessedArtifactID = assessedArtifactID;
	}
	/**
	 * @return the critiqueArtifactID
	 */
	public Integer getCritiqueArtifactID() {
		return critiqueArtifactID;
	}
	/**
	 * @param critiqueArtifactID the critiqueArtifactID to set
	 */
	public void setCritiqueArtifactID(Integer critiqueArtifactID) {
		this.critiqueArtifactID = critiqueArtifactID;
	}
	/**
	 * @param assessorActorID
	 * @param taskID
	 * @param assessedArtifactID
	 * @param critiqueArtifactID
	 * @param mapID
	 */
	public Review(Integer assessorActorID, Integer taskID,
			Integer assessedArtifactID, Integer critiqueArtifactID,
			Integer mapID) {
		super();
		this.assessorActorID = assessorActorID;
		this.taskID = taskID;
		this.assessedArtifactID = assessedArtifactID;
		this.critiqueArtifactID = critiqueArtifactID;
		this.mapID = mapID;
	}
	/**
	 * @return the mapID
	 */
	public Integer getMapID() {
		return mapID;
	}
	/**
	 * @param mapID the mapID to set
	 */
	public void setMapID(Integer mapID) {
		this.mapID = mapID;
	}
	
	
	
}
