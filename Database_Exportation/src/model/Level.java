/**
 * 
 */
package model;

/**
 * @author kma
 *
 */
public class Level {
	private int levelId;
	
	private String levelLabel;
	
	private String levelDescription;

	/**
	 * @return the levelId
	 */
	public int getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId the levelId to set
	 */
	public void setLevelId(int levelId) {
		this.levelId = levelId;
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

	/**
	 * @param levelId
	 * @param levelLabel
	 * @param levelDescription
	 */
	public Level(int levelId, String levelLabel, String levelDescription) {
		super();
		this.levelId = levelId;
		this.levelLabel = levelLabel;
		this.levelDescription = levelDescription;
	} 
	
	
}
