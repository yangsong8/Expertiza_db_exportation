/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Rubric;

/**
 * @author Van Duong
 *
 */
public class RubricInserter {

	public static void insert(Rubric rubric) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Rubric (TaskID, CriterionID) values (?,?)");
				Statement st = con.createStatement();
		
		   	)
			{
				ResultSet rs = st.executeQuery("select count(*) from Rubric where taskID="+ rubric.getTaskID().toString()+" and criterionID="+rubric.getCriterionID().toString()+";");
				rs.next();
				int num = rs.getInt(1);
				if(num != 0) {
				
				} else {
					pstmt.clearParameters();
					//set parameters
					pstmt.setString(1, rubric.getTaskID().toString());
					pstmt.setString(2, rubric.getCriterionID().toString());
					pstmt.clearParameters();
					pstmt.setString(1, rubric.getTaskID().toString());
					pstmt.setString(2, rubric.getCriterionID().toString());
				
					pstmt.executeUpdate();
					System.out.println("==========Rubric object inserted=============");
				
				}
		   } catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}	

	
}
