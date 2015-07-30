/**
 * 
 */
package model;

import java.io.File;

/**
 * A class that represents an Item object
 * @author kma
 * @author Van Duong
 */
public class Item {
	
	private Integer itemID;
	private String itemContent;
	private String artifactID;
	/**
	 * @param itemID
	 * @param itemContent
	 * @param artifactID
	 */
	public Item(Integer itemID, String itemContent, String artifactID) {
		super();
		this.itemID = itemID;
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
	public String getArtifactID() {
		return artifactID;
	}
	/**
	 * @param artifactID the artifactID to set
	 */
	public void setArtifactID(String artifactID) {
		this.artifactID = artifactID;
	}
	
	
}
