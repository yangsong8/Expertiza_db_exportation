/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Participant;

/**
 * A loader class for loading a list of Participant objects
 * @author kma
 * @author Van Duong
 */
public class ParticipantLoader {
	
	/**
	 * A method that will use loadSingle to load a list of Participants
	 * @param actorID
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Participant> loadList(int actorID) throws SQLException {
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		//Query for all the Participants
		
		String sql = "SELECT user_id as 'ParticipantID' from teams_users where team_id = "+actorID+";";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Participant participant = loadSingle(rs);
			if(participant == null) {
				
			} else {
				participantList.add(participant);
			}
		}
		rs.close();
		dbc.close();
		return participantList;
	}
	
	/**
	 * A method that will load a single Participant from result set
	 * @param rs
	 * @return
	 */
	public Participant loadSingle(ResultSet rs) {
		Integer participantID;
		Participant participant = null;
		 try {
			//appID = ResultSetParser.parseInt(rs, "AppID");
			participantID = ResultSetParser.parseInt(rs, "ParticipantID");
			//We assume that 22 is the appID for expertiza
			participant = new Participant(participantID, 22); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return participant;
	}

}
