/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Task;
import model.Task;

/**
 * @author Van Duong
 *
 */
public class TaskLoader {

	public ArrayList<Task> loadList() throws SQLException {
		ArrayList<Task> taskList = new ArrayList<Task>();
		//Query for all the Tasks
		
		String sql = "SELECT id as 'TaskID', deadline_type_id as 'TaskTypeID', deadline_name as 'TaskTitle', description_url as 'TaskPrompt', NULL as 'TaskOpen', due_at as 'TaskDue' where id = 18;";
		
		DBConnector dbc = new DBConnector();
		ResultSet rs = dbc.query(sql);
		while(rs.next()){
			Task task = loadSingle(rs);
			if(task == null) {
				
			} else {
				taskList.add(task);
			}
		}
		rs.close();
		dbc.close();
		return taskList;
	}

	public Task loadSingle(ResultSet rs) {
		String taskID;
		int taskTypeID;
		String taskTitle;
		String taskPrompt;
		Date taskOpen;
		Date taskDue;
		Task task = null;
		try {
			taskID = ResultSetParser.parseString(rs, "TaskID");
			taskTypeID = ResultSetParser.parseInt(rs, "TaskTypeID");
			taskTitle = ResultSetParser.parseString(rs, "TaskID");
			taskPrompt = ResultSetParser.parseString(rs, "TaskID");
			taskOpen = ResultSetParser.parseDate(rs, "TaskOpen");
			taskDue = ResultSetParser.parseDate(rs, "TaskDue");
			task = new Task(taskID, taskTypeID, taskTitle, taskPrompt, taskOpen, taskDue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}

}
