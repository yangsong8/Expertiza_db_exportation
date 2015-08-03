/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Participant;

/**
 * @author Van Duong
 *
 */
public class ParticipantInserter {
	
	public static void insertSingle(Participant Participant)
	{
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt=con.prepareStatement("Insert into participants (ParticipantID, appID) values (?,?)");
		   )
		   {
				pstmt.clearParameters();
			    //set parameters
				pstmt.setString(1, Participant.getParticipantID().toString());
				pstmt.setString(2, null);
				
				pstmt.executeUpdate();
				System.out.println("=======================");
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("SQL Exception");
		   }
	}
}
