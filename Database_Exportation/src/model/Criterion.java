/**
 * 
 */
package model;

/**
 * @author Van Duong
 *
 */
public class Criterion {

	Integer criterionID;
	String criterionTitle;
	String criterionDescription;
	/**
	 * @param criterionID
	 * @param criterionTitle
	 * @param criterionDescription
	 */
	public Criterion(Integer criterionID, String criterionTitle, String criterionDescription) {
		super();
		this.criterionID = criterionID;
		this.criterionTitle = criterionTitle;
		this.criterionDescription = criterionDescription;
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
	
	
}
