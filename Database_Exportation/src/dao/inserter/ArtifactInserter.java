/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Artifact;


/**
 * @author kma
 *
 */
public class ArtifactInserter {
	
	public static void insertSingle(Artifact artifact) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Artifact (ActorID, TaskID, ArtifactContent, ArtifactCharLength, ArtifactOpen, ArtifactEnd) values (?,?,?,?,?,?)");
				Statement st = con.createStatement();
		   )
		   {	
				ResultSet rs = st.executeQuery("select count(*) from Artifact where ActorID="+ artifact.getActorID().toString()+" and TaskID="+artifact.getTaskID().toString()+";");
				rs.next();
				int num = rs.getInt(1);
				if( num != 0 ) {
					
				} else {
					pstmt.clearParameters();
					pstmt.setString(1, artifact.getActorID().toString());
					pstmt.setString(2, artifact.getTaskID().toString());
					pstmt.setString(3, artifact.getArtifactContent());
					pstmt.setString(4, artifact.getArtifactCharLength().toString());
					pstmt.setObject(5, artifact.getArtifactOpen());
					pstmt.setObject(6, artifact.getArtifactEnd());
					
					
					pstmt.executeUpdate();
					System.out.println("==========Artifact object inserted=============");
				}

		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
