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

	public ArrayList<Rubric> loadList(Integer taskID, Integer assignmentID) throws SQLException {
		ArrayList<Rubric> rubricList = new ArrayList<Rubric>();
		//Query for all the Rubrics
		
		String sql = "SELECT questionnaires.id as RubricID, due_dates.id as TaskID, questions.id as CriterionID from  questionnaires, due_dates, questions where due_dates.id = "+ taskID + "and assignment_id =" + assignmentID + ";"; //???
		
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
		Integer rubricID;
		Integer taskID;
		Integer criterionID;
		Rubric rubric = null;
		try {
			rubricID = ResultSetParser.parseInt(rs, "RubricID");
			taskID = ResultSetParser.parseInt(rs, "TaskID");
			criterionID = ResultSetParser.parseInt(rs, "CriterionID");
			
			rubric = new Rubric(rubricID, taskID, criterionID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rubric;
		
	}

}
