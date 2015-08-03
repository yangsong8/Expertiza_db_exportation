/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Rubric;

/**
 * @author Van Duong
 *
 */
public class RubricInserter {

	public static void insert(Rubric rubric) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Rubric (RubricID, TaskID, CriterionID) values (?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, rubric.getTaskID().toString());
				pstmt.setString(2, rubric.getCriterionID().toString());
				
				pstmt.executeUpdate();
				System.out.println("==========Task object inserted=============");
				
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}

}
