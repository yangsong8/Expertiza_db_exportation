/**
 * 
 */
package dao.inserter;

import java.sql.*;

import model.Criterion;
import model.Task;

/**
 * @author Van Duong
 *
 */
public class CriterionInserter {

	public static void insertSingle(Criterion criterion) {
		try {
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into criterion (CriterionID, CriterionTitle, CriterionDescription) values (?,?,?)");
				Statement st = con.createStatement();
		   
			ResultSet rs = st.executeQuery("select count(*) from Criterion where CriterionID = " + criterion.getCriterionID().toString()+";");
			rs.next();
			int num = rs.getInt(1);
			if(num != 0) {
			
			} else {
				pstmt.clearParameters();
				pstmt.setString(1, criterion.getCriterionID().toString());
				pstmt.setObject(2, criterion.getCriterionTitle());
				pstmt.setObject(3, criterion.getCriterionDescription()); 
				
				
				pstmt.executeUpdate();
				System.out.println("==========Criterion object inserted=============");
				
			}
			rs.close();
			pstmt.close();
			st.close();
			con.close();
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
