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
	// If the field is NULL, a NULL should be returned.
	public static Integer parseInt(ResultSet rs, String name) throws SQLException {
		if (rs.getString(name) == null || rs.getString(name).length()==0 ){
			//The result for this column is NULL
			return null;
		}
		int i  = rs.getInt(name);
		return i;
	}
	
	public static char[] parseCharArray(ResultSet rs, String name, int length) throws SQLException {
		String  tempString = rs.getString(name);
		char[] tempCharArray = tempString.substring(0, length).toCharArray();
		return tempCharArray;
	}
}
