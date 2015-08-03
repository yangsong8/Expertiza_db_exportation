import java.sql.SQLException;
import java.util.ArrayList;

import mapping.ActorTask;
import model.Actor;
import model.Assignment;
import model.Course;
import model.Rubric;
import model.Task;
import dao.ActorLoader;
import dao.AssignmentLoader;
import dao.CourseLoader;
import dao.TaskLoader;
import dao.inserter.ActorInserter;
import dao.inserter.ActorTaskInserter;
import dao.inserter.AssignmentInserter;
import dao.inserter.CourseInserter;
import dao.inserter.TaskInserter;

/**
 * 
 */

/**
 * An entrance to the database
 * @author kma
 *
 */
public class DBEntrance {
	
	/**
	 * A main method
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		CourseLoader courseLoader = new CourseLoader();
		ArrayList<Course> courseList = courseLoader.loadList();
		
//		for(int i = 0; i < courseList.size(); i++) {
//			String tempCIP = new String(courseList.get(i).getCourseCIPCode());
//			System.out.print(courseList.get(i).getCourseID() + " " + tempCIP + " " 
//					+ courseList.get(i).getCourseLevelID() + " " + courseList.get(i).getCourseTitle() + " " 
//					+ courseList.get(i).getCourseDescription() + " " + courseList.get(i).getCourseCreated() + " " 
//					+ courseList.get(i).getCourseStarted() + " " + courseList.get(i).getCourseEnded() + 
//					 "\n");
//		}
		
		for(int courseIndex=0;courseIndex<courseList.size();courseIndex++)
		{
			CourseInserter.insertSingle(courseList.get(courseIndex));
			
			AssignmentLoader assignmentLoader = new AssignmentLoader();
			ArrayList<Assignment> assignmentList = assignmentLoader.loadList(courseList.get(courseIndex).getCourseID());
			for(int assignmentIndex=0; assignmentIndex<assignmentList.size();assignmentIndex++)
			{
				AssignmentInserter.insertSingle(assignmentList.get(assignmentIndex));
				TaskLoader taskLoader = new TaskLoader();
				
				ArrayList<Task> taskList = taskLoader.loadList(assignmentList.get(assignmentIndex).getAssigmentID());
				for(int taskIndex = 0; taskIndex < taskList.size(); taskIndex++) {
					TaskInserter.insertSingle(taskList.get(taskIndex));
					
					//for Van, b4 Friday
					RubricLoader rubricLoader = new RubricLoader();
					ArrayList<Rubric> rubricList = rubricLoader.loadList(taskList.get(taskIndex).getTaskID(), assignmentList.get(assignmentIndex).getAssigmentID());
					for(int rubricIndex=0; rubricIndex<rubricList.size(); rubricIndex++)
					{
						RubricInserter.insert(rubricList.get(rubricIndex));
					}
					
					//for Kai, b4 Friday
					ActorLoader actorLoader = new ActorLoader();
					ArrayList<Actor> actorList = actorLoader.loadList(assignmentList.get(assignmentIndex).getAssigmentID());
					for (int actorIndex=0; actorIndex<actorList.size();actorIndex++)
					{
						ActorInserter.insertSingle(actorList.get(actorIndex));
						ActorTask actorTask = new ActorTask(taskList.get(taskIndex).getTaskID(),actorList.get(actorIndex).getActorID());
						ActorTaskInserter.insertSingle(actorTask);
					}
					
					
				}
			}
			System.out.println("Done!!!");
		}
		
	}

}
