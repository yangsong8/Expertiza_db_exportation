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
import model.Participant;

/**
 * @author Van Duong
 *NEEDS REVISION
 */
public class ParticipantLoader {

	public ArrayList<Participant> loadList() throws SQLException {
		ArrayList<Participant> participantList = new ArrayList<Participant>();
		//Query for all the Participants
		
		String sql = "SELECT id as 'ParticipantID', NULL as 'AppID' from participants;";
		
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

	public Participant loadSingle(ResultSet rs) {
		int appID;
		String participantID;
		Participant participant = null;
		 try {
			appID = ResultSetParser.parseInt(rs, "AppID");
			participantID = ResultSetParser.parseString(rs, "ParticipantID");
			 participant = new Participant(participantID, appID); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return participant;
	}

}
