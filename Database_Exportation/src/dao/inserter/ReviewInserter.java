/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Types;

import model.Review;

/**
 * An inserter for review objects
 * @author kma
 *
 */
public class ReviewInserter {
	
	public static void insertSingle(Review review) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Review (AssessorActorID, TaskID, AssessedArtifactID, CritiqueArtifactID) values (?,?,?,?)");
		   )
		   {	
				
				pstmt.clearParameters();
				pstmt.setString(1, review.getAssessorActorID().toString());
				pstmt.setString(2, review.getTaskID().toString());
				pstmt.setString(3, review.getAssessedArtifactID().toString());
				pstmt.setNull(4, java.sql.Types.INTEGER);
				
				pstmt.executeUpdate();
				System.out.println("==========Review object inserted=============");
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
	
}
