/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.ReviewCriterionLevel;

/**
 * @author kma
 *
 */
public class ReviewCriterionLevelInserter {

	public static void insertSingle(ReviewCriterionLevel reviewCriterionLevel) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into ReviewCriterionLevel (AssessorActorID, TaskID, AssessedArtifactID, "
						+ "CriterionID, CritiqueArtifactID, EvalMode, EvalLevelID, ValueOrdinal, ValueCardinal, Comment) values (?,?,?,?,?,?,?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, reviewCriterionLevel.getAssessorActorID().toString());
				pstmt.setString(2, reviewCriterionLevel.getTaskID().toString());
				pstmt.setString(3, reviewCriterionLevel.getAssessedArtifactID().toString()); 
				pstmt.setString(4, reviewCriterionLevel.getCriterionID().toString()); 
				pstmt.setNull(5, java.sql.Types.INTEGER);
				pstmt.setString(6, reviewCriterionLevel.getEvalMode().toString());
				if (reviewCriterionLevel.getEvalLevelID() == null) {
					pstmt.setNull(7, java.sql.Types.INTEGER);
				} else {
					pstmt.setString(7, reviewCriterionLevel.getEvalLevelID().toString());
				}
				pstmt.setNull(8, java.sql.Types.INTEGER);
				pstmt.setNull(9, java.sql.Types.INTEGER);
				pstmt.setString(10, reviewCriterionLevel.getComment());
				
				pstmt.executeUpdate();
				System.out.println("==========ReviewCriterionLevel object inserted=============");
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
		
	}

}
