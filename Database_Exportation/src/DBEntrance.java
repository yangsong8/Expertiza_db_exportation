import java.sql.SQLException;
import java.util.ArrayList;

import mapping.ActorParticipant;
import mapping.ActorTask;
import model.Actor;
import model.Assignment;
import model.Course;
import model.Enrollment;
import model.Participant;
import model.Rubric;
import model.Task;
import dao.ActorLoader;
import model.Criterion;
import model.Rubric;
import model.Task;
import dao.AssignmentLoader;
import dao.CourseLoader;
import dao.ParticipantLoader;
import dao.TaskLoader;
import dao.inserter.ActorInserter;
import dao.inserter.ActorTaskInserter;
import dao.inserter.AssignmentInserter;
import dao.CriterionLoader;
import dao.LevelLoader;
import dao.RubricLoader;

import dao.TaskLoader;
import dao.inserter.ActorParticipantInserter;
import dao.inserter.AssignmentInserter;
import dao.inserter.CourseInserter;
import dao.inserter.CriterionInserter;
import dao.inserter.EnrollmentInserter;


import dao.inserter.LevelInserter;
import dao.inserter.ParticipantInserter;

import dao.inserter.RubricInserter;
import dao.inserter.TaskInserter;
import model.Level;

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
				for(int taskIndex = 0; taskIndex < taskList.size(); taskIndex++) 
				{
					TaskInserter.insertSingle(taskList.get(taskIndex));
					

					RubricLoader rubricLoader = new RubricLoader();
					ArrayList<Rubric> rubricList = rubricLoader.loadList(taskList.get(taskIndex).getTaskID(), assignmentList.get(assignmentIndex).getAssigmentID());
					for(int rubricIndex=0; rubricIndex<rubricList.size(); rubricIndex++)
					{
						RubricInserter.insert(rubricList.get(rubricIndex));	
						CriterionLoader criterionLoader = new CriterionLoader();
						ArrayList<Criterion> criterionList = criterionLoader.loadList(rubricList.get(rubricIndex).getRubricID());
						for (int criterionIndex =0; criterionIndex < criterionList.size(); criterionIndex++)
						{
							CriterionInserter.insertSingle(criterionList.get(criterionIndex));
							//for Van
							LevelLoader levelLoader = new LevelLoader();
							//return a list of levels for each question
							//1) if there are question advice associated with this question, use the advice,
							//2) if not, read the max/min level from questionnaire table in Expertiza
							ArrayList<Level>levelList = levelLoader.loadList(criterionList.get(criterionIndex),rubricList.get(rubricIndex).getRubricID());
							for(int levelIndex=0;levelIndex<levelList.size();levelIndex++)
							{
								LevelInserter.insertSingle(levelList.get(levelIndex));
							}
						}
					}

					
					ActorLoader actorLoader = new ActorLoader();
					ArrayList<Actor> actorList = actorLoader.loadList(assignmentList.get(assignmentIndex).getAssigmentID());
					for (int actorIndex=0; actorIndex<actorList.size();actorIndex++)
					{
						ActorInserter.insertSingle(actorList.get(actorIndex));
						ActorTask actorTask = new ActorTask(taskList.get(taskIndex).getTaskID(),actorList.get(actorIndex).getActorID());
						ActorTaskInserter.insertSingle(actorTask);
						
						//for Kai
						ParticipantLoader participantLoader = new ParticipantLoader();
						ArrayList<Participant> participantList = participantLoader.loadList(actorList.get(actorIndex).getActorID());
						for(int participantIndex=0; participantIndex<participantList.size();participantIndex++)
						{
							ParticipantInserter.insertSingle(participantList.get(participantIndex));
							
							ActorParticipant actorParticipant = new ActorParticipant(participantList.get(participantIndex).getParticipantID(),actorList.get(actorIndex).getActorID(), null);
							ActorParticipantInserter.insertSingle(actorParticipant);
							
							Enrollment enrollment = new Enrollment(participantList.get(participantIndex).getParticipantID(),participantList.get(participantIndex).getAppID(),courseList.get(courseIndex).getCourseID());
							//should check duplicated record before insert
							EnrollmentInserter.insertSingle(enrollment);
						}
					}
					
					
				}
			}
			System.out.println("Done!!!");
		}
		
	}

}
