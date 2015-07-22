/**
 * 
 */
package model;

/**
 * A class that represents a Review object
 * @author kma
 *
 */
public class Review {
	private int assessorActorId;
	
	private int assessedArtifactId;
	
	private int critiqueArtifactId;
	
	private int taskId;

	/**
	 * @return the taskId
	 */
	public int getTaskId() {
		return taskId;
	}

	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	/**
	 * @return the assessorActorId
	 */
	public int getAssessorActorId() {
		return assessorActorId;
	}

	/**
	 * @param assessorActorId the assessorActorId to set
	 */
	public void setAssessorActorId(int assessorActorId) {
		this.assessorActorId = assessorActorId;
	}

	/**
	 * @return the assessedArtifactId
	 */
	public int getAssessedArtifactId() {
		return assessedArtifactId;
	}

	/**
	 * @param assessedArtifactId the assessedArtifactId to set
	 */
	public void setAssessedArtifactId(int assessedArtifactId) {
		this.assessedArtifactId = assessedArtifactId;
	}

	/**
	 * @return the critiqueArtifactId
	 */
	public int getCritiqueArtifactId() {
		return critiqueArtifactId;
	}

	/**
	 * @param critiqueArtifactId the critiqueArtifactId to set
	 */
	public void setCritiqueArtifactId(int critiqueArtifactId) {
		this.critiqueArtifactId = critiqueArtifactId;
	}

	/**
	 * @param assessorActorId
	 * @param assessedArtifactId
	 * @param critiqueArtifactId
	 */
	public Review(int assessorActorId, int assessedArtifactId,
			int critiqueArtifactId) {
		super();
		this.assessorActorId = assessorActorId;
		this.assessedArtifactId = assessedArtifactId;
		this.critiqueArtifactId = critiqueArtifactId;
	}
	
	
}
