/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Participant;

/**
 * A class for ParticipantInserter Object
 * @author kma
 * @author Van Duong
 *
 */
public class ParticipantInserter {
	
	public static void insertSingle(Participant participant)
	{
		try(
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt=con.prepareStatement("Insert into Participant (ParticipantID, AppID) values (?,?)");
				Statement st = con.createStatement();
		   )
		   {	
				ResultSet rs = st.executeQuery("select count(*) from Participant where ParticipantID="+ participant.getParticipantID().toString()+" and AppId="+participant.getAppID().toString()+";");
				rs.next();
				int num = rs.getInt(1);
				if(num != 0) {
					
				} else {
					pstmt.clearParameters();
				    //set parameters
					pstmt.setString(1, participant.getParticipantID().toString());
					pstmt.setString(2, participant.getAppID().toString());
					
					pstmt.executeUpdate();
					System.out.println("=========Participant Object Inserted==============");
				}
				rs.close();
				pstmt.close();
				st.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("SQL Exception");
		   }
	}
}
