/**
 * 
 */
package database_access_object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * A class that will handle the result set
 * @author kma
 *
 */
public class ResultSetParser {
	
	/**
	 * A method that will return a specific value of a given column name 
	 * @param rs current result set
	 * @param name column name at the current row in the result set
	 * @return
	 * @throws SQLException
	 */

	// If the field is NULL, a NULL should be returned.
	public static String parseString(ResultSet rs, String name) throws SQLException {
		
		return rs.getString(name);

	}
	
	public static Integer parseInt(ResultSet rs, String name) throws SQLException {
		if (rs.getString(name) == null || rs.getString(name).length()==0 ){
			//The result for this column is NULL
			return null;
		}
		return rs.getInt(name);

	}
	
	public static char[] parseCharArray(ResultSet rs, String name, int length) throws SQLException {
		String  tempString = rs.getString(name);
		char[] tempCharArray = tempString.substring(0, length).toCharArray();
		return tempCharArray;
	}

	public static String parseString(ResultSet rs, String name, int length) throws SQLException {
		
		return rs.getString(name).substring(0, length);
	}

	public static Date parseDate(ResultSet rs, String name) throws SQLException {
		return rs.getDate(name);
	}
}
