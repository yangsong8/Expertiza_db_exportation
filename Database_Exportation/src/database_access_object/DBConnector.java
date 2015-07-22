package database_access_object;

import java.sql.*;


/**
 * A class that connects with database
 * @author kma
 *
 */
public class DBConnector {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/Testing";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   private Connection conn;
	   private Statement stmt;
	   /**
	    * A method that will handle the connection with the database and return a result set
	    * @param sql
	    * @return the result set which is the result of executing a statement
	    */
	   public ResultSet query(String sql) {
		   //What is STEP 1?
	   conn = null;
	   stmt = null;
	   ResultSet rs = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      //String sql;
	      //sql = "SELECT id, topic_id, team_id, priority FROM bids";
	      rs = stmt.executeQuery(sql);
	      
	      return rs;
	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   return rs;
	}
	 
	/**
	 * A method that can be used to close statement and connection
	 */
	public void close() {
		try {
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
