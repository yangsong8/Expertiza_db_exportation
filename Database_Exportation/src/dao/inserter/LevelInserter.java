/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Level;

/**
 * @author Van Duong
 *
 */
public class LevelInserter {

	public static void insertSingle(Level level) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Level (LevelID, LevelLabel, LevelDescription) values (?,?,?)");
				Statement st = con.createStatement();
		   )
		//check if there is another criterion object in the db

		   {
				
		   
			ResultSet rs = st.executeQuery("select count(*) from Criterion where CriterionID = " + level.getLevelID().toString()+";");
			rs.next();
			int num = rs.getInt(1);
			if(num != 0) {
			
			}
				pstmt.clearParameters();
				pstmt.setString(1, level.getLevelID().toString());
				pstmt.setString(2, level.getLevelLabel().toString());
				pstmt.setObject(3, level.getLevelDescription()); 
				 
				pstmt.executeUpdate();
				System.out.println("==========Level object inserted=============");
				
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
