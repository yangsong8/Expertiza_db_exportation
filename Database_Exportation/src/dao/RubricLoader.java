/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import model.Rubric;
import model.Rubric;

/**
 * @author Van Duong
 *NEEDS REVISION, NOT DONE YET
 */
public class RubricLoader implements Loader<Rubric> {

	@Override
	public ArrayList<Rubric> loadList() throws SQLException {
		ArrayList<Rubric> rubricList = new ArrayList<Rubric>();
		//Query for all the Rubrics
		
		String sql = "SELECT id as 'RubricID', name as 'RubricTitle', info as 'RubricDescription', NULL as 'RubricLevelID', NULL as 'RubricCIPCode', created_at as 'RubricCreated', NULL as 'RubricStarted', NULL as RubricEnded FROM Rubrics where id=155;";
		
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

	@Override
	public Rubric loadSingle(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
