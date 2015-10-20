package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.CriterionLevel;

/**
 * 
 * @author Weijia Li
 *
 */
public class CriterionLevelInserter {
	
	public static void insertSingle(CriterionLevel criterionLevel) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into CriterionLevel (CriterionID, LevelID, LevelValueMax, "
						+ "LevelValueMin) values (?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, criterionLevel.getCriterionID().toString());
				pstmt.setString(2, criterionLevel.getLevelID().toString());
				pstmt.setString(3, criterionLevel.isLevelValueMax().toString()); 
				pstmt.setString(4, criterionLevel.isLevelValueMin().toString()); 
				
				pstmt.executeUpdate();
				System.out.println("==========CriterionLevel object inserted=============");
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }	
	}
}
