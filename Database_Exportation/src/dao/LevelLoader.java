/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import model.Criterion;
import model.Level;
import model.Level;

/**
 * @author Van Duong
 *
 */
public class LevelLoader {

	public ArrayList<Level> loadList(int criterion, int rubric) throws SQLException {
		ArrayList<Level> levelList = new ArrayList<Level>();
		//Query for all the levels
		
		String sql = "SELECT " + ";"; //???
		System.out.println(sql);
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Level level = loadSingle(rs);
			if(level == null) {
				
			} else {
				levelList.add(level);
			}
		}
		rs.close();
		dbc.close();
		return levelList;
	}

	public Level loadSingle(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
