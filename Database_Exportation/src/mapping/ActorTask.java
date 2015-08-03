/**
 * 
 */
package mapping;

/**
 * @author kma
 *
 */
public class ActorTask {
	Integer actorId;
	Integer taskId;
	/**
	 * @return the actorId
	 */
	public Integer getActorId() {
		return actorId;
	}
	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
	/**
	 * @return the taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	/**
	 * @param actorId
	 * @param taskId
	 */
	public ActorTask(Integer taskId, Integer actorId) {
		super();
		this.actorId = actorId;
		this.taskId = taskId;
	}
	
	
}
