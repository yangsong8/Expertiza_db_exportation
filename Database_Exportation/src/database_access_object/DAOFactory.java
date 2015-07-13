/**
 * 
 */
package database_access_object;

import java.sql.Connection;
import java.sql.SQLException;

import database_access_object.DAOFactory;
import database_access_object.IConnectionDriver;

/**
 * @author kma
 *
 */
public class DAOFactory {
	
	private static DAOFactory productionInstance = null;
	private IConnectionDriver driver;
	
	/**
	 * 
	 * @return A production instance of the DAOFactory, to be used in deployment (by Tomcat).
	 */
	public static DAOFactory getProductionInstance() {
			productionInstance = new DAOFactory();
		return productionInstance;
	}
	
	
	/**
	 * 
	 * @return this DAOFactory's Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return driver.getConnection();
	}
	
	
	
	
}
