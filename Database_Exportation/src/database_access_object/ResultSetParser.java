/**
 * 
 */
package database_access_object;

import java.util.Date;
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
		if (tempString == null)
		{
			tempString = "";
		}
		char[] tempCharArray;
		if(tempString.length() > length)
		{
			tempCharArray = tempString.substring(0, length).toCharArray();
		}
		else
		{
			tempCharArray = tempString.toCharArray();
		}
		return tempCharArray;
	}

	
	/**
	 * A method that will handle the date conversion between sql date and util date
	 * @param rs
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public static Date parseDate(ResultSet rs, String name) throws SQLException {
		if(rs.getDate(name) != null) {
			return new java.util.Date(rs.getDate(name).getTime());
		}
		return null;
	}
	
	
}
