/**
 * 
 */
package model;

/**
 * A basic object for a bid in database
 * @author kma
 *
 */
public class Bid {
	private int id;
	
	private int team_id;
	
	private int topic_id;
	
	private int priority;

	public Bid(int id, int team_id, int topic_id, int priority) {
		super();
		this.id = id;
		this.team_id = team_id;
		this.topic_id = topic_id;
		this.priority = priority;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the team_id
	 */
	public int getTeam_id() {
		return team_id;
	}

	/**
	 * @param team_id the team_id to set
	 */
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}

	/**
	 * @return the topic_id
	 */
	public int getTopic_id() {
		return topic_id;
	}

	/**
	 * @param topic_id the topic_id to set
	 */
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	
	
	
}
