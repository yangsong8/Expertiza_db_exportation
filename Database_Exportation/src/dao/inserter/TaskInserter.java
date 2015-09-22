/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Task;

/**
 * A class for inserting tasks into PRML database
 * @author kma
 *
 */
public class TaskInserter {
	
	public static void insertSingle(Task task) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Task (TaskID, TaskTypeID, TaskTitle, TaskDescription, TaskOpen, TaskDue) values (?,?,?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
				pstmt.setString(1, task.getTaskID().toString());
				pstmt.setString(2, task.getTaskTypeID().toString());
				pstmt.setObject(3, task.getTaskTitle()); 
				pstmt.setObject(4, task.getTaskDescription()); 
				pstmt.setObject(5, null); 
				pstmt.setObject(6, task.getTaskDue()); 
				
				pstmt.executeUpdate();
				System.out.println("==========Task object inserted=============");
				
				pstmt.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
