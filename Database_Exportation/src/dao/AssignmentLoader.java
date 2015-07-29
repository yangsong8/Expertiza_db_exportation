/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.ResultSetParser;
import model.Assignment;

/**
 * @author kma
 *
 */
public class AssignmentLoader{

	public ArrayList<Assignment> loadList(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Assignment loadSingle(ResultSet rs) {
		Integer tempId;
		char[] tempCIPCode;
		String tempTitle;
		String tempDescription;
		
		Assignment temp = null;
		
		try {
			tempId = ResultSetParser.parseInt(rs, "AssignmentId");
			tempCIPCode = ResultSetParser.parseCharArray(rs, "AssignmentCIPCode", 7);
			tempTitle = ResultSetParser.parseString(rs, "AssignmentTitle");
			tempDescription = ResultSetParser.parseString(rs, "AssignmentDescription");
			
			temp = new Assignment(tempId, tempCIPCode, tempTitle, tempDescription);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}

}
