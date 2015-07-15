/**
 * 
 */
package database_access_object;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A class that will handle the result set
 * @author kma
 *
 */
public class ResultSetParser {
	
	/**
	 * A method that will return a specific value of a given column name 
	 * @param rs
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public static int parseInt(ResultSet rs, String name) throws SQLException {
		int i  = rs.getInt(name);
		return i;
	}
}
