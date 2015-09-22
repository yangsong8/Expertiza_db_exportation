/**
 * 
 */
package dao.inserter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Assignment;

/**
 * @author kma
 *
 */
public class AssignmentInserter{

	public static void insertSingle(Assignment assignment) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Assignment (AssignmentID, AssignmentCIPCode, AssignmentTitle, AssignmentDescription, CourseID) values (?,?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, assignment.getAssigmentID().toString());
				pstmt.setString(2, null);
				pstmt.setObject(3, assignment.getAssignTitle()); 
				pstmt.setObject(4, assignment.getAssignDescription()); 
				pstmt.setString(5, assignment.getCourseID().toString());
				
				pstmt.executeUpdate();
				System.out.println("==========Assignment object inserted=============");
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
