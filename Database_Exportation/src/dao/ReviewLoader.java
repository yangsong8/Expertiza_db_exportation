/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Artifact;
import model.Review;
import model.Task;


/**
 * A loader for loading review objects
 * @author kma
 * @author Van Duong
 */
public class ReviewLoader {

	public ArrayList<Review> loadList(Task task, Artifact artifact) throws SQLException {
		ArrayList<Review> reviewList = new ArrayList<Review>();
		//Query for all the Reviews
		
		String sql = "select id from response_maps where type = 'ReviewResponseMap' and reviewee_id="+artifact.getActorID()+";";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		ArrayList<Integer> mapIDs = new ArrayList<Integer>();
		
		while(rs.next()){
			Integer temp = ResultSetParser.parseInt(rs, "id");
			if(temp == null) {
				
			} else {
				mapIDs.add(temp);
			}
		}
		rs.close();
		dbc.close();
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/expertiza_development", "root", "");
		for(int i = 0; i < mapIDs.size(); i++){
			PreparedStatement pstmt = con.prepareStatement("select response_maps.reviewer_id+100000 as 'AssessorActorID', "+task.getTaskID()+" as 'TaskID', "
					+ ""+artifact.getArtifactID()+" as AssessedArtifactID, NULL as 'CritiqueArtifactID',"+mapIDs.get(i)+" as 'MapID' from responses, response_maps "
							+ "where responses.map_id = ? and response_maps.id=responses.map_id and "
							+ "responses.updated_at< ? order by responses.updated_at desc limit 1;");
			
			
			pstmt.clearParameters();
		    //set parameters
			pstmt.setString(1, mapIDs.get(i).toString());
			pstmt.setObject(2, task.getTaskDue()); 
			
			
			ResultSet rsReview = pstmt.executeQuery();
			if (!rsReview.isBeforeFirst())
			{
			
			}
			else
			{
				rsReview.next();
				reviewList.add(loadSingle(rsReview));
			}
			pstmt.close();
			rsReview.close();
		}
		con.close();
		
		return reviewList;
	
	}

	public Review loadSingle(ResultSet rs) {
		Integer assessorActorID;
		Integer TaskID;
		Integer assessedArtifactID;
		Integer critiqueArtifactID;
		Integer mapID;
		Review review = null;
		
		try {
			assessorActorID = ResultSetParser.parseInt(rs, "AssessorActorID");
			TaskID = ResultSetParser.parseInt(rs, "TaskID");
			assessedArtifactID = ResultSetParser.parseInt(rs, "AssessedArtifactID");
			critiqueArtifactID = ResultSetParser.parseInt(rs, "CritiqueArtifactID");
			mapID = ResultSetParser.parseInt(rs, "MapID");
			review = new Review(assessorActorID, TaskID, assessedArtifactID, critiqueArtifactID, mapID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return review;
	}

}
