/**
 * 
 */
package model;

/**
 * A class that represents a ReviewCriterionLevel object
 * @author kma
 *
 */
public class ReviewCriterionLevel {
	
	private Integer assessorActorID;
	private Integer taskID;
	private Integer assessedArtifactID;
	private Integer CriterionID;
	private Integer critiqueArtifactID;
	private Integer EvalMode;
	private Integer EvalLevelID;
	private Integer ValueOrdinal;
	private Float ValueCardinal;
	private String comment;
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
	 * @return the criterionID
	 */
	public Integer getCriterionID() {
		return CriterionID;
	}
	/**
	 * @param criterionID the criterionID to set
	 */
	public void setCriterionID(Integer criterionID) {
		CriterionID = criterionID;
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
	 * @return the evalMode
	 */
	public Integer getEvalMode() {
		return EvalMode;
	}
	/**
	 * @param evalMode the evalMode to set
	 */
	public void setEvalMode(Integer evalMode) {
		EvalMode = evalMode;
	}
	/**
	 * @return the evalLevelID
	 */
	public Integer getEvalLevelID() {
		return EvalLevelID;
	}
	/**
	 * @param evalLevelID the evalLevelID to set
	 */
	public void setEvalLevelID(Integer evalLevelID) {
		EvalLevelID = evalLevelID;
	}
	/**
	 * @return the valueOridinal
	 */
	public Integer getValueOrdinal() {
		return ValueOrdinal;
	}
	/**
	 * @param valueOridinal the valueOridinal to set
	 */
	public void setValueOrdinal(Integer valueOrdinal) {
		ValueOrdinal = valueOrdinal;
	}
	/**
	 * @return the valueCardinal
	 */
	public Float getValueCardinal() {
		return ValueCardinal;
	}
	/**
	 * @param valueCardinal the valueCardinal to set
	 */
	public void setValueCardinal(Float valueCardinal) {
		ValueCardinal = valueCardinal;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @param assessorActorID
	 * @param taskID
	 * @param assessedArtifactID
	 * @param criterionID
	 * @param critiqueArtifactID
	 * @param evalMode
	 * @param evalLevelID
	 * @param valueOrdinal
	 * @param valueCardinal
	 * @param comment
	 */
	public ReviewCriterionLevel(Integer assessorActorID, Integer taskID,
			Integer assessedArtifactID, Integer criterionID,
			Integer critiqueArtifactID, Integer evalMode, Integer evalLevelID,
			Integer valueOrdinal, Float valueCardinal, String comment) {
		super();
		this.assessorActorID = assessorActorID;
		this.taskID = taskID;
		this.assessedArtifactID = assessedArtifactID;
		CriterionID = criterionID;
		this.critiqueArtifactID = critiqueArtifactID;
		EvalMode = evalMode;
		EvalLevelID = evalLevelID;
		ValueOrdinal = valueOrdinal;
		ValueCardinal = valueCardinal;
		this.comment = comment;
	}
	
	
}
