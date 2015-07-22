/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Bid;

/**
 * A class that will return a list of bids based
 * @author kma
 *
 */
public class BidLoader {
	
	
	/**
	 * A method that will return all of bids in this table via a list
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Bid> getBids() throws SQLException {
		ArrayList<Bid> bidList = new ArrayList<Bid>();
		String sql = "SELECT id, topic_id, team_id, priority FROM bids";
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Bid bid = createBid(rs);
			if(bid == null) {
				//TO DO
			} else { 	
				bidList.add(bid);
			}
		}
		rs.close();
		dbc.close();
		return bidList;
	}
	
	/**
	 * A private helper method that will take result set and set all of parameters in a new Bid object
	 * @param rs
	 * @return
	 */
	private Bid createBid(ResultSet rs) {
		int tempID;
		int tempTeamID;
		int tempTopicID;
		int tempPriority;
		Bid b = null;
		try {
			tempID = ResultSetParser.parseInt(rs, "id");
			tempTeamID = ResultSetParser.parseInt(rs, "team_id");
			tempTopicID = ResultSetParser.parseInt(rs, "topic_id");
			tempPriority = ResultSetParser.parseInt(rs, "priority");
			b = new Bid(tempID, tempTeamID, tempTopicID, tempPriority);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
	}
}
