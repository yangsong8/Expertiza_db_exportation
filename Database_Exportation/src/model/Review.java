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
	
	private String assessorActorID;
	private String taskID;
	private String assessedArtifactID;
	private String critiqueArtifactID;
	/**
	 * @param assessorActorID
	 * @param taskID
	 * @param assessedArtifactID
	 * @param critiqueArtifactID
	 */
	public Review(String assessorActorID, String taskID, String assessedArtifactID, String critiqueArtifactID) {
		super();
		this.assessorActorID = assessorActorID;
		this.taskID = taskID;
		this.assessedArtifactID = assessedArtifactID;
		this.critiqueArtifactID = critiqueArtifactID;
	}
	/**
	 * @return the assessorActorID
	 */
	public String getAssessorActorID() {
		return assessorActorID;
	}
	/**
	 * @param assessorActorID the assessorActorID to set
	 */
	public void setAssessorActorID(String assessorActorID) {
		this.assessorActorID = assessorActorID;
	}
	/**
	 * @return the taskID
	 */
	public String getTaskID() {
		return taskID;
	}
	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}
	/**
	 * @return the assessedArtifactID
	 */
	public String getAssessedArtifactID() {
		return assessedArtifactID;
	}
	/**
	 * @param assessedArtifactID the assessedArtifactID to set
	 */
	public void setAssessedArtifactID(String assessedArtifactID) {
		this.assessedArtifactID = assessedArtifactID;
	}
	/**
	 * @return the critiqueArtifactID
	 */
	public String getCritiqueArtifactID() {
		return critiqueArtifactID;
	}
	/**
	 * @param critiqueArtifactID the critiqueArtifactID to set
	 */
	public void setCritiqueArtifactID(String critiqueArtifactID) {
		this.critiqueArtifactID = critiqueArtifactID;
	}
	
}
