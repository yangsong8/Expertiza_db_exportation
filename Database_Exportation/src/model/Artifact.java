/**
 * 
 */
package model;

import java.util.Date;

/**
 * A class that represents an artifact object
 * @author kma
 *
 */
public class Artifact {
	private int arftifactId;
	
	private String artifactContent;
	
	private int artifactCharLength;
	
	private Date artifactBegin;
	
	private Date artifactEnd;
	
	private int actorId;
	
	private int taskId;

	/**
	 * @return the arftifactId
	 */
	public int getArftifactId() {
		return arftifactId;
	}

	/**
	 * @param arftifactId the arftifactId to set
	 */
	public void setArftifactId(int arftifactId) {
		this.arftifactId = arftifactId;
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
	 * @return the artifactBegin
	 */
	public Date getArtifactBegin() {
		return artifactBegin;
	}

	/**
	 * @param artifactBegin the artifactBegin to set
	 */
	public void setArtifactBegin(Date artifactBegin) {
		this.artifactBegin = artifactBegin;
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

	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}

	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

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
	 * @param arftifactId
	 * @param artifactContent
	 * @param artifactCharLength
	 * @param artifactBegin
	 * @param artifactEnd
	 * @param actorId
	 * @param taskId
	 */
	public Artifact(int arftifactId, String artifactContent,
			int artifactCharLength, Date artifactBegin, Date artifactEnd,
			int actorId, int taskId) {
		super();
		this.arftifactId = arftifactId;
		this.artifactContent = artifactContent;
		this.artifactCharLength = artifactCharLength;
		this.artifactBegin = artifactBegin;
		this.artifactEnd = artifactEnd;
		this.actorId = actorId;
		this.taskId = taskId;
	}
	
	
	
}
