package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Criterion;
import model.Rubric;
import model.Task;

/**
 * 
 */

/**
 * @author Van Duong
 *
 */
public class CriterionLoader {

	public ArrayList<Criterion> loadList(int rubricID) throws SQLException {
		ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
		//Query for all the Tasks
		
		String sql = "SELECT questions.id as CriterionID, NULL as CriterionTitle, NULL as CriterionDescription from questions where questionnaires_id =" + rubricID +";";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Criterion criterion = loadSingle(rs);
			if(criterion == null) {
				
			} else {
				criterionList.add(criterion);
			}
		}
		rs.close();
		dbc.close();
		return criterionList;
	}

	private Criterion loadSingle(ResultSet rs) {
		Integer criterionID;
		String criterionTitle, criterionDescription;
		Criterion criterion = null;
		
		try {
			criterionID = ResultSetParser.parseInt(rs, "CritertionID");
			criterionTitle = ResultSetParser.parseString(rs, "CriterionTitle");
			criterionDescription = ResultSetParser.parseString(rs, "CriterionDescription");
			
			criterion = new Criterion(criterionID, criterionTitle, criterionDescription);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return criterion;
	}

}