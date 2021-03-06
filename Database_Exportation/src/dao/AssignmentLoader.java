/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Assignment;

/**
 * @author kma
 *
 */
public class AssignmentLoader{
	
	/**
	 * A method that will use the id from a course to load associated assignments
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Assignment> loadList(int courseId) throws SQLException {
		ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
		String sql = "SELECT id as 'AssignmentID', name as 'AssignmentTitle', spec_location as 'AssignmentDescription', NULL as 'AssignmentCIPCode', course_id as 'CourseID' from assignments where course_id="+courseId+" ;";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Assignment assignment = loadSingle(rs);
			if(assignment == null) {
				
			} else {
					assignmentList.add(assignment);
			}
		}
		rs.close();
		dbc.close();
		return assignmentList;
	}
	
	/**
	 * A method that load a single assignment 
	 * @param rs
	 * @return
	 */
	public Assignment loadSingle(ResultSet rs) {
		Integer tempId;
		char[] tempCIPCode;
		String tempTitle;
		String tempDescription;
		Integer tempCourseID;
		Assignment temp = null;
		
		try {
			tempId = ResultSetParser.parseInt(rs, "AssignmentId");
			tempCIPCode = ResultSetParser.parseCharArray(rs, "AssignmentCIPCode", 7);
			tempTitle = ResultSetParser.parseString(rs, "AssignmentTitle");
			tempDescription = ResultSetParser.parseString(rs, "AssignmentDescription");
			tempCourseID = ResultSetParser.parseInt(rs, "CourseID");
			temp = new Assignment(tempId, tempCIPCode, tempTitle, tempDescription, tempCourseID);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}

}
