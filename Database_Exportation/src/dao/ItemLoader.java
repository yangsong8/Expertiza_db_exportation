/**
 * 
 */
package dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Item;

/**
 * @author Van Duong
 * NEEDS MORE CODING NOT DONE YET
 */

public class ItemLoader{

	public ArrayList<Item> loadList() throws SQLException {
		ArrayList<Item> itemList = new ArrayList<Item>();
		//Query for all the Items
		
		String sql = "SELECT 0 as 'itemID', participants.submitted_hyperlinks as itemDescription, FROM Items;";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Item Item = loadSingle(rs);
			if(Item == null) {
				
			} else {
				itemList.add(Item);
			}
		}
		rs.close();
		dbc.close();
		return itemList;
	}

	public Item loadSingle(ResultSet rs) {
		Integer itemID;
		String itemContent = "";
		String artifactID = "";
		Item item = null;
		
		try {
			itemID = ResultSetParser.parseInt(rs, "itemID");
			//itemContent = 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
		
		
	}

}
