/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Review;
import model.ReviewCriterionLevel;

/**
 * @author kma
 *
 */
public class ReviewCriterionLevelLoader {

	public ArrayList<ReviewCriterionLevel> loadList(Review review) throws SQLException{
		ArrayList<ReviewCriterionLevel> reviewCriterionLevelList = new ArrayList<ReviewCriterionLevel>();
		//Query for all the Participants
		
		String sql = "select max(id) from responses where map_id="+review.getMapID()+";";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		Integer responseID = 0;
		try {
			rs.next();
			responseID = ResultSetParser.parseInt(rs, "max(id)");
			rs.close();
		} catch (SQLException e) {
			return reviewCriterionLevelList;
		}
		
		
		if(responseID != 0) {
			sql = "Select "+review.getAssessorActorID() +" as 'AssessorActorID', "+review.getTaskID()+" as 'TaskID', "+review.getAssessedArtifactID()+
					" as 'AssessedArtifactID', " +review.getCritiqueArtifactID()+
					" as CritiqueArtifactID, question_id as 'CriterionID', 1 as EvalMode, answer as 'EvalLevelID', comments as 'Comment', "+
					"NULL as ValueOrdinal, NULL as ValueCardinal from answers where response_id ="+responseID+";";
			System.out.println(sql);
			ResultSet rsReviewCriterionLevel = dbc.query(sql);
			while(rsReviewCriterionLevel.next()){
				ReviewCriterionLevel reviewCriterionLevel = loadSingle(rsReviewCriterionLevel);
				if(reviewCriterionLevel == null) {
					
				} else {
					reviewCriterionLevelList.add(reviewCriterionLevel);
				}
			}
			rsReviewCriterionLevel.close();
		}
		
		dbc.close();
		return reviewCriterionLevelList;
	}
	
	public ReviewCriterionLevel loadSingle(ResultSet rs) {
		Integer assessorActorID;
		Integer taskID;
		Integer assessedArtifactID;
		Integer criterionID;
		Integer critiqueArtifactID;
		Integer evalMode;
		Integer evalLevelID;
		Integer valueOrdinal;
		Float valueCardinal;
		String comment;
		ReviewCriterionLevel reviewCriterionLevel = null;
		
		try {
			assessorActorID = ResultSetParser.parseInt(rs, "AssessorActorID");
			taskID = ResultSetParser.parseInt(rs, "TaskID");
			assessedArtifactID = ResultSetParser.parseInt(rs, "AssessedArtifactID");
			critiqueArtifactID = ResultSetParser.parseInt(rs, "CritiqueArtifactID");
			criterionID = ResultSetParser.parseInt(rs, "CriterionID");
			evalMode = ResultSetParser.parseInt(rs, "EvalMode");
			evalLevelID = ResultSetParser.parseInt(rs, "EvalLevelID");
			valueOrdinal = ResultSetParser.parseInt(rs, "ValueOrdinal");
			valueCardinal = ResultSetParser.parseFloat(rs, "ValueCardinal");
			comment = ResultSetParser.parseString(rs, "Comment");
			reviewCriterionLevel = new ReviewCriterionLevel(assessorActorID, taskID, assessedArtifactID, 
					criterionID, critiqueArtifactID, evalMode, evalLevelID, valueOrdinal, valueCardinal, comment);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return reviewCriterionLevel;
	}
}
