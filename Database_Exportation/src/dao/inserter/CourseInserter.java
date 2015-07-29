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
			    //executeUpdate 执行插入语句
				pstmt.setString(1, course.getCourseID().toString());
				pstmt.setString(2, null);
				pstmt.setObject(3, course.getCourseTitle()); //如果不知道占位符是什么类型的数据就用setObject，jdbc会自动为您转成合适的类型
				pstmt.setObject(4, course.getCourseDescription()); 
				pstmt.setObject(5, null); 
				pstmt.setObject(6, course.getCourseCreated()); 
				pstmt.setObject(7, course.getCourseStarted()); 
				pstmt.setObject(8, course.getCourseEnded()); 
				
				pstmt.executeUpdate();
				System.out.println("=======================");
				
				//clearParameters：清理当前的参数，如果直接执行会带来异常:No value specified for parameter 1
				//pstmt.clearParameters();
				//pstmt.executeUpdate(); 
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("数据库操作出现异常");
		   }
	}

}
