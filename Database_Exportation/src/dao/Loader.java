/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * An interface for all of the loaders
 * @author kma
 *
 */
public interface Loader<T> {
	
	/**
	 * A method that will load a list of items from the result set
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<T> loadList(ResultSet rs) throws SQLException;
	
	/**
	 * A method that will load a single item from result set
	 * We need to use try/catch to handle the error
	 * if no valid object can be created, return null
	 * @param rs
	 * @return
	 */
	public T loadSingle(ResultSet rs);
}
