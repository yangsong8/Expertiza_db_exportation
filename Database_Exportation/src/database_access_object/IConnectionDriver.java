/**
 * 
 */
package database_access_object;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kma
 *
 */
public interface IConnectionDriver {
	public Connection getConnection() throws SQLException;
}
