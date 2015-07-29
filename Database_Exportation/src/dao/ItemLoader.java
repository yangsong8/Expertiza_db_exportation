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
public class ItemLoader implements Loader<Item> {

	@Override
	public ArrayList<Item> loadList() throws SQLException {
		ArrayList<Item> itemList = new ArrayList<Item>();
		//Query for all the Items
		
		String sql = "SELECT id as 'ItemID', name as 'itemTitle', info as 'itemDescription', NULL as 'itemLevelID', NULL as 'ItemCIPCode', created_at as 'ItemCreated', NULL as 'ItemStarted', NULL as ItemEnded FROM Items where id=155;";
		
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

	@Override
	public Item loadSingle(ResultSet rs) {
		String itemID = "";
		File itemContent = null;
		String artifactID = "";
		Item item = null;
		
		try {
			itemID = ResultSetParser.parseString(rs, itemID);
			//itemContent = 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return item;
		
		
	}

}
