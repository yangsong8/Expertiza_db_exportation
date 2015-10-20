package model;

/**
 * A class that represents a criterion level object
 * @author Weijia Li
 *
 */
public class CriterionLevel {
	private Integer criterionID;
	private Integer levelID;
	private boolean levelValueMax;
	private boolean levelValueMin;
	
	public CriterionLevel(Integer criterionID, Integer levelID, boolean levelValueMax, boolean levelValueMin) {
		this.criterionID = criterionID;
		this.levelID = levelID;
		this.levelValueMax = levelValueMax;
		this.levelValueMin = levelValueMin;
	}
	
	/**
	 * @return the levelValueMax
	 */
	public Boolean isLevelValueMax() {
		return levelValueMax;
	}
	/**
	 * @param levelValueMax the levelValueMax to set
	 */
	public void setLevelValueMax(Boolean levelValueMax) {
		this.levelValueMax = levelValueMax;
	}
	/**
	 * @return the levelValueMin
	 */
	public Boolean isLevelValueMin() {
		return levelValueMin;
	}
	/**
	 * @param levelValueMin the levelValueMin to set
	 */
	public void setLevelValueMin(Boolean levelValueMin) {
		this.levelValueMin = levelValueMin;
	}
	/**
	 * @return the criterionID
	 */
	public Integer getCriterionID() {
		return criterionID;
	}
	/**
	 * @param criterionID the criterionID to set
	 */
	public void setCriterionID(Integer criterionID) {
		this.criterionID = criterionID;
	}
	/**
	 * @return the levelID
	 */
	public Integer getLevelID() {
		return levelID;
	}
	/**
	 * @param levelID the levelID to set
	 */
	public void setLevelID(Integer levelID) {
		this.levelID = levelID;
	}
	
}
