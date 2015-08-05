/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Enrollment;

/**
 * A class that represents an Enrollment object
 * @author kma
 *
 */
public class EnrollmentInserter {
	
	public static void insertSingle(Enrollment enrollment) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Enrollment (ParticipantID, AppID, CourseID) values (?,?,?)");
				Statement st = con.createStatement();
		   )
		   {	
				ResultSet rs = st.executeQuery("select count(*) from Enrollment where ParticipantID="+ enrollment.getParticipantID().toString()+" and AppId="+enrollment.getAppID().toString()+" "
						+ "and CourseID = "+ enrollment.getCourseID()+ ";");
				rs.next();
				int num = rs.getInt(1);
				if( num != 0 ) {
					
				} else {
					pstmt.clearParameters();
					pstmt.setString(1, enrollment.getParticipantID().toString());
					pstmt.setString(2, enrollment.getAppID().toString());
					pstmt.setString(3, enrollment.getCourseID().toString());
					
					
					pstmt.executeUpdate();
					System.out.println("==========Enrollment object inserted=============");
				}

		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
