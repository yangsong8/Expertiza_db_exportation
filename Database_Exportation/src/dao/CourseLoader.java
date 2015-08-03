/**
 * 
 */
package dao;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Course;

/**
 * A loader class for Course object
 * @author kma
 * @author Van Duong
 */
public class CourseLoader{

	public ArrayList<Course> loadList() throws SQLException {
		ArrayList<Course> courseList = new ArrayList<Course>();
		//Query for all the courses
		//String sql = "SELECT id as 'CourseID', name as 'CourseTitle', info as 'CourseDescription', NULL as 'CourseLevelID', NULL as 'CourseCIPCode', created_at as 'CourseCreated', NULL as 'CourseStarted', NULL as CourseEnded FROM courses;";
		//Query for course 155
		String sql = "SELECT id as 'CourseID', name as 'CourseTitle', info as 'CourseDescription', NULL as 'CourseLevelID', NULL as 'CourseCIPCode', created_at as 'CourseCreated', NULL as 'CourseStarted', NULL as CourseEnded FROM courses where id=155;";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Course course = loadSingle(rs);
			if(course == null) {
				
			} else {
				courseList.add(course);
			}
		}
		rs.close();
		dbc.close();
		return courseList;
	}

	public Course loadSingle(ResultSet rs) {
		Integer tempCourseID;
		char[] tempCourseCIPCode;
		String tempCourseTitle;
		String tempCourseDescription;
		Integer tempCourseLevelID;
		Date tempCourseCreated;
		Date tempCourseStarted;
		Date tempCourseEnded;
		
		Course course = null;
		try {
			tempCourseID = ResultSetParser.parseInt(rs, "CourseID");// Should we restrict number of chars of courseID?
			tempCourseCIPCode = ResultSetParser.parseCharArray(rs, "CourseCIPCode", 7);
			tempCourseTitle = ResultSetParser.parseString(rs, "CourseTitle");
			tempCourseDescription = ResultSetParser.parseString(rs, "CourseDescription");
			tempCourseLevelID = ResultSetParser.parseInt(rs, "CourseLevelID");//Should we restrict number of chars of courseLevelID?
			tempCourseCreated = ResultSetParser.parseDate(rs, "CourseCreated");
			tempCourseStarted = ResultSetParser.parseDate(rs, "CourseStarted");
			tempCourseEnded  = ResultSetParser.parseDate(rs, "CourseEnded");
			
			course = new Course(tempCourseID, tempCourseCIPCode, tempCourseTitle, tempCourseDescription,
					tempCourseLevelID, tempCourseCreated, tempCourseStarted,
					tempCourseEnded);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return course;

	}

}
