/**
 * 
 */
package model;

/**
 * @author Van Duong
 *
 */
public class Criterion {

	private Integer criterionID;
	private String criterionTitle;
	private String criterionDescription;
	private String type;
	private Integer max_label;
	private Integer min_label;
	
	/**
	 * @param criterionID
	 * @param criterionTitle
	 * @param criterionDescription
	 * @param type
	 * @param max_label
	 * @param min_label
	 */
	public Criterion(Integer criterionID, String criterionTitle,
			String criterionDescription, String type, Integer max_label,
			Integer min_label) {
		super();
		this.criterionID = criterionID;
		this.criterionTitle = criterionTitle;
		this.criterionDescription = criterionDescription;
		this.type = type;
		this.max_label = max_label;
		this.min_label = min_label;
	}
	/**
	 * @return the criterionID
	 */
	public Integer getCriterionID() {
		return criterionID;
	}
	/**
	 * @param criterionID the criterionID to set
	 */
	public void setCriterionID(Integer criterionID) {
		this.criterionID = criterionID;
	}
	/**
	 * @return the criterionTitle
	 */
	public String getCriterionTitle() {
		return criterionTitle;
	}
	/**
	 * @param criterionTitle the criterionTitle to set
	 */
	public void setCriterionTitle(String criterionTitle) {
		this.criterionTitle = criterionTitle;
	}
	/**
	 * @return the criterionDescription
	 */
	public String getCriterionDescription() {
		return criterionDescription;
	}
	/**
	 * @param criterionDescription the criterionDescription to set
	 */
	public void setCriterionDescription(String criterionDescription) {
		this.criterionDescription = criterionDescription;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the max_label
	 */
	public Integer getMax_label() {
		return max_label;
	}
	/**
	 * @param max_label the max_label to set
	 */
	public void setMax_label(Integer max_label) {
		this.max_label = max_label;
	}
	/**
	 * @return the min_label
	 */
	public Integer getMin_label() {
		return min_label;
	}
	/**
	 * @param min_label the min_label to set
	 */
	public void setMin_label(Integer min_label) {
		this.min_label = min_label;
	}
	
	
}
