import java.sql.SQLException;
import java.util.ArrayList;

import model.Assignment;
import model.Course;
import dao.AssignmentLoader;
import dao.CourseLoader;
import dao.inserter.AssignmentInserter;
import dao.inserter.CourseInserter;

/**
 * 
 */

/**
 * An entrance to the database
 * @author kma
 *
 */
public class DBEntrance {
	
	/**
	 * A main method
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		CourseLoader courseLoader = new CourseLoader();
		ArrayList<Course> courseList = courseLoader.loadList();
		
//		for(int i = 0; i < courseList.size(); i++) {
//			String tempCIP = new String(courseList.get(i).getCourseCIPCode());
//			System.out.print(courseList.get(i).getCourseID() + " " + tempCIP + " " 
//					+ courseList.get(i).getCourseLevelID() + " " + courseList.get(i).getCourseTitle() + " " 
//					+ courseList.get(i).getCourseDescription() + " " + courseList.get(i).getCourseCreated() + " " 
//					+ courseList.get(i).getCourseStarted() + " " + courseList.get(i).getCourseEnded() + 
//					 "\n");
//		}
		
		for(int i=0;i<courseList.size();i++)
		{
			CourseInserter.insertSingle(courseList.get(i));
			
			//new task b4 Wednesday:
			//Create assignment class
			//attribute mapping between Expertiza and PRML:AssignmentID-id;AssignmentCIPCode-null;AssignmentTitle-name;AssignmentDescription-spec_location
			//Create assignmentloader and implement loadlist
			//Create assignment inserter and implement insertSingle
			AssignmentLoader assignmentLoader = new AssignmentLoader();
			ArrayList<Assignment> assignmentList = assignmentLoader.loadList(courseList.get(i).getCourseID());
			for(int j=0; j<assignmentList.size();j++)
			{
				AssignmentInserter.insertSingle(assignmentList.get(j));
			}
			System.out.println("Done!!!");
		}
		
	}

}
