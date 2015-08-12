/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Rubric;
import model.Task;
import model.Rubric;

/**
 * @author Van Duong
 *NEEDS REVISION, NOT DONE YET
 */
public class RubricLoader  {

	public ArrayList<Rubric> loadList(Integer taskTypeID, Integer assignmentID, Integer taskID) throws SQLException {
		ArrayList<Rubric> rubricList = new ArrayList<Rubric>();
		//Query for all the Rubrics
		//String sql = "SELECT questionnaires.id as 'RubricID', due_dates.id as 'TaskID', questions.id as 'CriterionID' from  questionnaires, due_dates, questions where due_dates.id =  711 and due_dates.assignment_id = 219;"; //???

		if(taskTypeID==1)//submission, return an empty list
		{
			return rubricList;
		}
		String expertizaQuestionnaireType = "";
		if(taskTypeID==2)//peer review
		{
			expertizaQuestionnaireType="ReviewQuestionnaire";
		}
		if(taskTypeID==5)//peer review
		{
			expertizaQuestionnaireType="MetareviewQuestionnaire";
		}
		
		
		String sql = "select questions.id as 'CriterionID', "+taskID+" as TaskID from questions, questionnaires, assignment_questionnaires"+ 
						" where assignment_questionnaires.assignment_id="+assignmentID+
						" And assignment_questionnaires.questionnaire_id=questionnaires.id"+
						" and questions.questionnaire_id = questionnaires.id"+
						" and questionnaires.type='"+expertizaQuestionnaireType+"';";
		System.out.println(sql);
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Rubric rubric = loadSingle(rs);
			if(rubric == null) {
				
			} else {
				rubricList.add(rubric);
			}
		}
		rs.close();
		dbc.close();
		return rubricList;
	}

	public Rubric loadSingle(ResultSet rs) {
		Integer taskID;
		Integer criterionID;
		Rubric rubric = null;
		try {

			taskID = ResultSetParser.parseInt(rs, "TaskID");
			criterionID = ResultSetParser.parseInt(rs, "CriterionID");
			
			rubric = new Rubric(taskID, criterionID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rubric;
		
	}

}
