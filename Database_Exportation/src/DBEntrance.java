import java.sql.SQLException;
import java.util.ArrayList;

import mapping.ActorParticipant;
import mapping.ActorTask;
import model.Actor;
import model.Artifact;
import model.Assignment;
import model.Course;
import model.Enrollment;
import model.Item;
import model.Participant;
import model.Review;
import model.ReviewCriterionLevel;
import model.Rubric;
import model.Task;
import dao.ActorLoader;
import model.Criterion;
import model.Rubric;
import model.Task;
import dao.ArtifactLoader;
import dao.AssignmentLoader;
import dao.CourseLoader;
import dao.ItemLoader;
import dao.ParticipantLoader;
import dao.ReviewCriterionLevelLoader;
import dao.ReviewLoader;
import dao.TaskLoader;
import dao.inserter.ActorInserter;
import dao.inserter.ActorTaskInserter;
import dao.inserter.AssignmentInserter;
import dao.CriterionLoader;
import dao.LevelLoader;
import dao.RubricLoader;
import dao.TaskLoader;
import dao.inserter.ActorParticipantInserter;
import dao.inserter.ArtifactInserter;
import dao.inserter.AssignmentInserter;
import dao.inserter.CourseInserter;
import dao.inserter.CriterionInserter;
import dao.inserter.EnrollmentInserter;
import dao.inserter.ItemInserter;
import dao.inserter.LevelInserter;
import dao.inserter.ParticipantInserter;
import dao.inserter.ReviewCriterionLevelInserter;
import dao.inserter.ReviewInserter;
import dao.inserter.RubricInserter;
import dao.inserter.TaskInserter;
import database_access_object.DBConnector;
import model.Level;


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
					
					CriterionLoader criterionLoader = new CriterionLoader();
					ArrayList<Criterion> criterionList = criterionLoader.loadList(taskList.get(taskIndex).getTaskTypeID(), assignmentList.get(assignmentIndex).getAssigmentID(),taskList.get(taskIndex).getRound());		
					for (int i = 0; i < criterionList.size(); i++){
						CriterionInserter.insertSingle(criterionList.get(i));
					}
					
					RubricLoader rubricLoader = new RubricLoader();
					ArrayList<Rubric> rubricList = rubricLoader.loadList(taskList.get(taskIndex).getTaskTypeID(), assignmentList.get(assignmentIndex).getAssigmentID(),taskList.get(taskIndex).getRound());
					for(int rubricIndex=0; rubricIndex<rubricList.size(); rubricIndex++)
					{
						RubricInserter.insert(rubricList.get(rubricIndex));	
					}

/*kai*/					
					ActorLoader actorLoader = new ActorLoader();
					ArrayList<Actor> actorList = actorLoader.loadList(assignmentList.get(assignmentIndex).getAssigmentID());
					for (int actorIndex=0; actorIndex<actorList.size();actorIndex++)
					{
						ActorInserter.insertSingle(actorList.get(actorIndex));
						ActorTask actorTask = new ActorTask(taskList.get(taskIndex).getTaskID(),actorList.get(actorIndex).getActorID());
						ActorTaskInserter.insertSingle(actorTask);
						
						//load participants for each task
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
						
						//for each actor_task, load the *submission*, we deal submitted hyperlinks only at this time
						ArtifactLoader artifactLoader = new ArtifactLoader();
						//if task type id ==1 (submission), only 1 artifact for each actor in each task, the size of the list is 1
						//                  2 (peer-review), not loaded
						//                  5 (meta-review), not loaded
						ArrayList<Artifact> artifactList = artifactLoader.loadList(actorTask, taskList.get(taskIndex).getTaskTypeID());
						for(int artifactIndex =0; artifactIndex<artifactList.size(); artifactIndex++)
						{
							//artifact object does not have it, but after inserted, the id will be updated in the line below
							ArtifactInserter.insertSingle(artifactList.get(artifactIndex));
							
							// if it is submission task, load the artifacts for submission
							if (taskList.get(taskIndex).getTaskTypeID()==1)
							{	
								ItemLoader itemLoader = new ItemLoader();
								ArrayList<Item> itemList = itemLoader.loadList(artifactList.get(artifactIndex).getActorID(),artifactList.get(artifactIndex).getArtifactID());
								for(int itemIndex = 0; itemIndex < itemList.size(); itemIndex++) {
									ItemInserter.insertSingle(itemList.get(itemIndex));
								}	
							}
							
							ReviewLoader reviewLoader =  new ReviewLoader();
							ArrayList<Review> reviewList = reviewLoader.loadList(taskList.get(taskIndex), artifactList.get(artifactIndex));
							for(int reviewIndex = 0 ; reviewIndex < reviewList.size(); reviewIndex++) {
								ReviewInserter.insertSingle(reviewList.get(reviewIndex));
								
								ReviewCriterionLevelLoader reviewCriterionLevelLoader = new ReviewCriterionLevelLoader();
								ArrayList<ReviewCriterionLevel> reviewCriterionLevelList = reviewCriterionLevelLoader.loadList(reviewList.get(reviewIndex));
								
								for(int reviewCriterionLevelIndex = 0; reviewCriterionLevelIndex < reviewCriterionLevelList.size(); reviewCriterionLevelIndex++) {
									ReviewCriterionLevelInserter.insertSingle(reviewCriterionLevelList.get(reviewCriterionLevelIndex));
								}
								
							}	
						}	
					}

				}
			}
			System.out.println("Done!!!");
		}
		
	}
}


