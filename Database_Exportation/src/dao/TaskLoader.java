/**
 * 
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	private static Integer roundID1 = 0;
	private static Integer roundID2 = 0;
	private static Integer roundID5 = 0;
	/**
	 * A method that will use the corresponding assignmentId to load a list of tasks
	 * @param assignmentId
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Task> loadList(int assignmentId) throws SQLException {

		ArrayList<Task> taskList = new ArrayList<Task>();
		//Query for all the Tasks
		
		String sql = "SELECT due_dates.id as 'TaskID', due_dates.deadline_type_id as 'TaskTypeID', deadline_types.name as 'TaskTitle', due_dates.description_url as 'TaskDescription', NULL as 'TaskOpen', due_dates.due_at as 'TaskDue' from due_dates, deadline_types where due_dates.deadline_type_id=deadline_types.id and assignment_id = "+assignmentId+";";
		
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
		
		// sort the tasklist based on TaskDue field. TaskTypeID can be 1,2,5 etc...
		Collections.sort(taskList, new CompareByTaskDue());
		
		//after sorting
		System.out.println("After sorting:");
		for (int i = 0; i < taskList.size();i++){
			System.out.println(taskList.get(i).toString());
		}
		
		return taskList;
	}

	private class CompareByTaskDue implements Comparator<Task>{

		@Override
		public int compare(Task task1, Task task2) {
			// TODO Auto-generated method stub
			return task1.getTaskDue().compareTo(task2.getTaskDue());
		}
		
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
			taskPrompt = ResultSetParser.parseString(rs, "TaskDescription");
			taskOpen = ResultSetParser.parseDate(rs, "TaskOpen");
			taskDue = ResultSetParser.parseDate(rs, "TaskDue");
			
			switch(taskTypeID){
			case 1:
				++roundID1;
				task = new Task(taskID, taskTypeID, taskTitle, taskPrompt, taskOpen, taskDue, roundID1);
				break;
			case 2:
				++roundID2;
				task = new Task(taskID, taskTypeID, taskTitle, taskPrompt, taskOpen, taskDue, roundID2);
				break;
			case 5:
				task = new Task(taskID, taskTypeID, taskTitle, taskPrompt, taskOpen, taskDue,roundID5);
				break;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return task;
	}

}
