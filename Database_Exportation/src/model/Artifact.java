/**
 * 
 */
package model;

import java.util.Date;

/**
 * A class that represents an artifact object
 * @author kma
 * @author Van Duong
 */
public class Artifact {
	
	private String artifactID;
	private String actorID;
	private String taskID;
	private String artifactContent;
	private int artifactCharLength;
	private Date artifactOpen;
	private Date artifactEnd;
	
	/**
	 * @param artifactID
	 * @param actorID
	 * @param taskID
	 * @param artifactContent
	 * @param artifactCharLength
	 * @param artifactOpen
	 * @param artifactEnd
	 */
	public Artifact(String artifactID, String actorID, String taskID, String artifactContent, int artifactCharLength,
			Date artifactOpen, Date artifactEnd) {
		super();
		this.artifactID = artifactID;
		this.actorID = actorID;
		this.taskID = taskID;
		this.artifactContent = artifactContent;
		this.artifactCharLength = artifactCharLength;
		this.artifactOpen = artifactOpen;
		this.artifactEnd = artifactEnd;
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

	/**
	 * @return the actorID
	 */
	public String getActorID() {
		return actorID;
	}

	/**
	 * @param actorID the actorID to set
	 */
	public void setActorID(String actorID) {
		this.actorID = actorID;
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
	 * @return the artifactContent
	 */
	public String getArtifactContent() {
		return artifactContent;
	}

	/**
	 * @param artifactContent the artifactContent to set
	 */
	public void setArtifactContent(String artifactContent) {
		this.artifactContent = artifactContent;
	}

	/**
	 * @return the artifactCharLength
	 */
	public int getArtifactCharLength() {
		return artifactCharLength;
	}

	/**
	 * @param artifactCharLength the artifactCharLength to set
	 */
	public void setArtifactCharLength(int artifactCharLength) {
		this.artifactCharLength = artifactCharLength;
	}

	/**
	 * @return the artifactOpen
	 */
	public Date getArtifactOpen() {
		return artifactOpen;
	}

	/**
	 * @param artifactOpen the artifactOpen to set
	 */
	public void setArtifactOpen(Date artifactOpen) {
		this.artifactOpen = artifactOpen;
	}

	/**
	 * @return the artifactEnd
	 */
	public Date getArtifactEnd() {
		return artifactEnd;
	}

	/**
	 * @param artifactEnd the artifactEnd to set
	 */
	public void setArtifactEnd(Date artifactEnd) {
		this.artifactEnd = artifactEnd;
	}
	
	
}
