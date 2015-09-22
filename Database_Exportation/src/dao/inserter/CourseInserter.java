package dao.inserter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Course;


/**
 * @author sb
 */
public class CourseInserter
{
	public static void insertSingle(Course course)
	{
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt=con.prepareStatement("Insert into Course (CourseID, CourseCIPCode, CourseTitle, CourseDescription, CourseLevelID, CourseCreated, CourseStarted, CourseEnded) values (?,?,?,?,?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, course.getCourseID().toString());
				pstmt.setString(2, null);
				pstmt.setObject(3, course.getCourseTitle()); 
				pstmt.setObject(4, course.getCourseDescription()); 
				pstmt.setObject(5, null); 
				pstmt.setObject(6, course.getCourseCreated()); 
				pstmt.setObject(7, course.getCourseStarted()); 
				pstmt.setObject(8, course.getCourseEnded()); 
				
				pstmt.executeUpdate();
				System.out.println("=======================");
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
	}

}
