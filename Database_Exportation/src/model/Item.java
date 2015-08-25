/**
 * 
 */
package model;


/**
 * A class that represents an Item object
 * @author kma
 * @author Van Duong
 */
public class Item {
	
	//we will use auto-incremental method to handle the itemID
	private Integer itemID;
	private String itemContent;
	private Integer artifactID;
	/**
	 * @param itemID
	 * @param itemContent
	 * @param artifactID
	 */
	public Item(String itemContent, Integer artifactID) {
		super();
		this.itemContent = itemContent;
		this.artifactID = artifactID;
	}
	/**
	 * @return the itemID
	 */
	public Integer getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
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
	 * @return the artifactID
	 */
	public Integer getArtifactID() {
		return artifactID;
	}
	/**
	 * @param artifactID the artifactID to set
	 */
	public void setArtifactID(Integer artifactID) {
		this.artifactID = artifactID;
	}
	
	
}
