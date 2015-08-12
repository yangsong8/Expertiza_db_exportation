/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Criterion;
import model.Task;

/**
 * @author Van Duong
 *
 */
public class CriterionInserter {

	public static void insertSingle(Criterion criterion) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Criterion (CriterionID, CriterionTitle, CriterionDescription) values (?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, criterion.getCriterionID().toString());
				pstmt.setObject(2, criterion.getCriterionTitle());
				pstmt.setObject(3, criterion.getCriterionDescription()); 
				
				
				pstmt.executeUpdate();
				System.out.println("==========Criterion object inserted=============");
				
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
