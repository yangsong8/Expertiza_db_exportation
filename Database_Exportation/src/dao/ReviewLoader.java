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


/**
 * @author Van Duong
 *NEEDS REVISION
 */
public class ReviewLoader {

	public ArrayList<Review> loadList() throws SQLException {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		//Query for all the Reviews
		
		String sql = "SELECT id as 'AssessorActorID', reviewed_object_id as 'TaskID', reviewer_id as 'CritiqueArtifactID', reviewee_id as 'AssessedArtifactID' where id = 1;";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Review review = loadSingle(rs);
			if(review == null) {
				
			} else {
				reviewList.add(review);
			}
		}
		rs.close();
		dbc.close();
		return reviewList;
	
	}

	public Review loadSingle(ResultSet rs) {
		String assessorActorID;
		String TaskID;
		String assessedArtifactID;
		String critiqueArtifactID;
		Review review = null;
		
		try {
			assessorActorID = ResultSetParser.parseString(rs, "AssessorActorID");
			TaskID = ResultSetParser.parseString(rs, "TaskID");
			assessedArtifactID = ResultSetParser.parseString(rs, "AssessedArtifactID");
			critiqueArtifactID = ResultSetParser.parseString(rs, "CritiqueArtifactID");
			review = new Review(assessorActorID, TaskID, assessedArtifactID, critiqueArtifactID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return review;
	}

}
