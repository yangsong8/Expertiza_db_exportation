/**
 * 
 */
package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Item;


/**
 * @author kma
 * @author Van Duong
 */

public class ItemLoader{

	public ArrayList<Item> loadList(Integer teamId, Integer artifactId) throws SQLException {
		ArrayList<Item> itemList = new ArrayList<Item>();
		//Query for all the Participants
		
		String sql = "select participants.submitted_hyperlinks from participants, teams where user_id in (select user_id from teams_users where team_id= "+teamId+") and participants.parent_id = teams.parent_id and teams.id="+teamId+";";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			ArrayList<Item> itemSubList = loadSubList(rs, artifactId);
			for(int i = 0; i < itemSubList.size(); i++) {
				itemList.add(itemSubList.get(i));
			}
		}
		rs.close();
		dbc.close();
		return itemList;
	}

	public ArrayList<Item> loadSubList(ResultSet rs, Integer artifactId) {
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		try {
			String temp = ResultSetParser.parseString(rs, "submitted_hyperlinks");
			
			if( temp == null || temp.length()<3) {
				
			} else {
				temp = temp.substring(3);
				temp = temp.replaceAll("\r", " ");
				temp = temp.replaceAll("\n", " ");
				String[] tempArray = temp.split("- ");
				for(int i = 0; i < tempArray.length; i++) {
					if(tempArray[i] == "" || tempArray[i].length() < 3) {
						
					} else {
						itemList.add(new Item(tempArray[i].trim(), artifactId));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itemList;
		
	}

}
