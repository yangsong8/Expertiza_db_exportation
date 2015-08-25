/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Actor;

/**
 * A class for loading an Actor object
 * @author kma
 *
 */
public class ActorLoader {
	
	public ArrayList<Actor> loadList(int assignmentId) throws SQLException {
		ArrayList<Actor> actorList = new ArrayList<Actor>();
		//query for teams
		String sql = "select id as 'ActorID' from teams where type ='AssignmentTeam' and parent_id = "+assignmentId+";";
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Actor actor = loadSingle(rs);
			if(actor == null) {
				
			} else {
				actorList.add(actor);
			}
		}
		//query for participants
		sql = "select id+100000 as 'ActorID' from participants where type='AssignmentParticipant' and parent_id="+assignmentId+";";
		rs = dbc.query(sql);
		while(rs.next()){
			Actor actor = loadSingle(rs);
			if(actor == null) {
				
			} else {
				actorList.add(actor);
			}
		}
		
		rs.close();
		dbc.close();
		return actorList;
	}
	
	public Actor loadSingle(ResultSet rs) {
		Integer actorId;
		Actor actor = null;
		
		try {
			actorId = ResultSetParser.parseInt(rs, "ActorID");
			actor = new Actor(actorId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actor;
	}
}
