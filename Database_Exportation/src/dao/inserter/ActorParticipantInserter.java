/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mapping.ActorParticipant;

/**
 * @author kma
 *
 */
public class ActorParticipantInserter {
	
	public static void insertSingle(ActorParticipant actorParticipant) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into ActorParticipant (ActorID, ParticipantID, RoleID) values (?,?,?)");
				Statement st = con.createStatement();
		   )
		   {	
				ResultSet rs = st.executeQuery("select count(*) from ActorParticipant where ParticipantID="+ actorParticipant.getParticipantID().toString()+" and ActorId="+actorParticipant.getActorID().toString()+";");
				rs.next();
				int num = rs.getInt(1);
				if( num != 0 ) {
					
				} else {
					pstmt.clearParameters();
					pstmt.setString(1, actorParticipant.getActorID().toString());
					pstmt.setString(2, actorParticipant.getParticipantID().toString());
					//temp solution for roleID
					pstmt.setString(3, "5");
					
					
					pstmt.executeUpdate();
					System.out.println("==========ActorParticipant object inserted=============");
				}

		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
	
}
