/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import mapping.ActorTask;
import model.Artifact;
import database_access_object.DBConnector;
import database_access_object.ResultSetParser;

/**
 * @author kma
 *
 */
public class ArtifactLoader {
	
	public ArrayList<Artifact> loadList(ActorTask actorTask, Integer typeID) throws SQLException {
		ArrayList<Artifact> artifactList = new ArrayList<Artifact>();
		String sql = "";
		if(typeID==1)//submission: we cannot use team_id as artifact id! we have to rely on auto-incremental
		{
			if(actorTask.getActorId()>100000) // this actor is a participant in Expertiza, so it does not have any artifact.
			{
				return artifactList;
			}
			sql = "SELECT "+actorTask.getActorId()+" as ActorID, "+actorTask.getTaskId()+" as TaskID, name as ArtifactContent, NULL as ArtifactCharLength, NULL as ArtifactOpen, NULL as ArtifactEnd from teams where id="+actorTask.getActorId()+";";
		} 
		else if(typeID == 2) 
		{
			return artifactList;
		} 
		else if( typeID == 5) 
		{
			return artifactList;
		}
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Artifact artifact = loadSingle(rs);
			if(artifact == null) {
				
			} else {
				artifactList.add(artifact);
			}
		}
		rs.close();
		dbc.close();
		return artifactList;
	}

	public Artifact loadSingle(ResultSet rs) {
		Integer actorID;
		Integer taskID;
		String artifactContent;
		Integer artifactCharLength;
		Date artifactOpen;
		Date artifactEnd;
		
		
		Artifact artifact = null;
		try {
			
			actorID = ResultSetParser.parseInt(rs, "ActorID");
			taskID = ResultSetParser.parseInt(rs, "TaskID");
			artifactContent = ResultSetParser.parseString(rs, "ArtifactContent");
			artifactCharLength = ResultSetParser.parseInt(rs, "ArtifactCharLength");
			artifactOpen = ResultSetParser.parseDate(rs, "ArtifactOpen");
			artifactEnd = ResultSetParser.parseDate(rs, "ArtifactEnd");
			
			artifact = new Artifact(actorID, taskID, artifactContent, artifactCharLength,
				 artifactOpen, artifactEnd);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artifact;

	}
}
