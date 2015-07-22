/**
 * 
 */
package model;

/**
 * A class that reprents an Item object
 * @author kma
 *
 */
public class Item {
	 private int itemId;
	 
	 private String itemContent;
	 
	 private int artifactId;

	/**
	 * @return the itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * @return the itemContent
	 */
	public String getItemContent() {
		return itemContent;
	}

	/**
	 * @param itemContent the itemContent to set
	 */
	public void setItemContent(String itemContent) {
		this.itemContent = itemContent;
	}

	/**
	 * @return the artifactId
	 */
	public int getArtifactId() {
		return artifactId;
	}

	/**
	 * @param artifactId the artifactId to set
	 */
	public void setArtifactId(int artifactId) {
		this.artifactId = artifactId;
	}

	/**
	 * @param itemId
	 * @param itemContent
	 * @param artifactId
	 */
	public Item(int itemId, String itemContent, int artifactId) {
		super();
		this.itemId = itemId;
		this.itemContent = itemContent;
		this.artifactId = artifactId;
	}
	 
	 
}
