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

/**
 * A loader class for loading different tasks
 * @author kma
 * @author Van Duong
 *
 */

public class TaskLoader{
	
	/**
	 * A method that will use the corresponding assignmentId to load a list of tasks
	 * @param assignmentId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Task> loadList(int assignmentId) throws SQLException {

		ArrayList<Task> taskList = new ArrayList<Task>();
		//Query for all the Tasks
		
		String sql = "SELECT due_dates.id as 'TaskID', due_dates.deadline_type_id as 'TaskTypeID', deadline_types.name as 'TaskTitle', due_dates.description_url as 'TaskPrompt', NULL as 'TaskOpen', due_dates.due_at as 'TaskDue' from due_dates, deadline_types where due_dates.deadline_type_id=deadline_types.id and assignment_id = "+assignmentId+";";
		
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

	
	/**
	 * A method that will load a single task
	 * @param rs
	 * @return
	 */

	public Task loadSingle(ResultSet rs) {
		Integer taskID;
		Integer taskTypeID;
		String taskTitle;
		String taskPrompt;
		Date taskOpen;
		Date taskDue;
		Task task = null;
		try {
			taskID = ResultSetParser.parseInt(rs, "TaskID");
			taskTypeID = ResultSetParser.parseInt(rs, "TaskTypeID");
			taskTitle = ResultSetParser.parseString(rs, "TaskTitle");
			taskPrompt = ResultSetParser.parseString(rs, "TaskPrompt");
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
