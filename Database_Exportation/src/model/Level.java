/**
 * 
 */
package model;

/**
 * @author kma
 * @author Van Duong
 */
public class Level {
	
	private int levelID;
	private String levelLabel;
	private String levelDescription;
	/**
	 * @param levelID
	 * @param levelLabel
	 * @param levelDescription
	 */
	public Level(int levelID, String levelLabel, String levelDescription) {
		super();
		this.levelID = levelID;
		this.levelLabel = levelLabel;
		this.levelDescription = levelDescription;
	}
	/**
	 * @return the levelID
	 */
	public int getLevelID() {
		return levelID;
	}
	/**
	 * @param levelID the levelID to set
	 */
	public void setLevelID(int levelID) {
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
