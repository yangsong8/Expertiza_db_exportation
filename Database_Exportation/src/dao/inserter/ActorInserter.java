/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Actor;


/**
 * @author kma
 *
 */
public class ActorInserter {

	public static void insertSingle(Actor actor) {
		try(	
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				//PreparedStatement queryPstmt = con.prepareStatement("select count(*) from Actor where id="+ actor.getActorID().toString()+";");
				PreparedStatement pstmt = con.prepareStatement("Insert into Actor (ActorID) values (?);");
				Statement st = con.createStatement();
		   )
		   {	
				ResultSet rs = st.executeQuery("select count(*) from Actor where ActorID="+ actor.getActorID().toString()+";");
				rs.next();
				int num = rs.getInt(1);
				if( num != 0) {
					
				} else {
					pstmt.clearParameters();
					pstmt.setString(1, actor.getActorID().toString());
					//For testing reason
					//System.out.println(pstmt.toString());
					
					
					pstmt.executeUpdate();
					System.out.println("==========Actor object inserted=============");
				}
				
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
