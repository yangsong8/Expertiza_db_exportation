package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import mapping.ActorTask;


public class ActorTaskInserter {
	public static void insertSingle(ActorTask actorTask) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into ActorTask (ActorID, TaskID) values (?, ?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, actorTask.getActorId().toString());
				pstmt.setString(2, actorTask.getTaskId().toString());
				
				
				pstmt.executeUpdate();
				System.out.println("==========ActorTask object inserted=============");
				
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
