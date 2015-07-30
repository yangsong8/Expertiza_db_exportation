/**
 * 
 */
package model;

/**
 * @author kma
 * @author Van Duong
 */
public class Level {
	
	private Integer levelID;
	private String levelLabel;
	private String levelDescription;
	/**
	 * @param levelID
	 * @param levelLabel
	 * @param levelDescription
	 */
	public Level(Integer levelID, String levelLabel, String levelDescription) {
		super();
		this.levelID = levelID;
		this.levelLabel = levelLabel;
		this.levelDescription = levelDescription;
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
	/**
	 * @return the levelLabel
	 */
	public String getLevelLabel() {
		return levelLabel;
	}
	/**
	 * @param levelLabel the levelLabel to set
	 */
	public void setLevelLabel(String levelLabel) {
		this.levelLabel = levelLabel;
	}
	/**
	 * @return the levelDescription
	 */
	public String getLevelDescription() {
		return levelDescription;
	}
	/**
	 * @param levelDescription the levelDescription to set
	 */
	public void setLevelDescription(String levelDescription) {
		this.levelDescription = levelDescription;
	}
	
}
