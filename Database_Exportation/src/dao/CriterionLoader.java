package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Criterion;
import model.Rubric;
import model.Task;

/**
 * 
 */

/**
 * @author Van Duong
 *
 */
public class CriterionLoader {

  public ArrayList<Criterion> loadList(Integer taskType, Integer assignmentId, Integer round)
    {
        ArrayList<Criterion> criterionList = new ArrayList<Criterion>();
        String type = new String();
        if (taskType==1)
        {
            return criterionList; //return a empty array list for "submission task" because in Expertiza we do not use any rubric for submission phase
        }
        if (taskType==2)
        {
            type = "ReviewQuestionnaire";
        }
        if (taskType==5)
        {
            type = "MetareviewQuestionnaire";
        }
        //use assignment id and type to find the questionnaire id(s) first, this query will return one or a list of Integers (questionnaire ids in Expertiza)
        String sqlForQuestionnaireIds = "select questionnaires.id ,assignment_questionnaires.used_in_round from questionnaires, assignment_questionnaires where assignment_questionnaires.assignment_id = "+assignmentId+" and assignment_questionnaires.questionnaire_id=questionnaires.id and questionnaires.type = '"+type +"' order by assignment_questionnaires.used_in_round;";
        ArrayList<Integer> questionnaireIds = new ArrayList<Integer>();
        Integer questionnaire_id;

        DBConnector dbc = new DBConnector(); 

        ResultSet rs = dbc.query(sqlForQuestionnaireIds );
        try {
			while(rs.next()){
			    questionnaire_id = ResultSetParser.parseInt(rs, "id");
			    questionnaireIds.add(questionnaire_id );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        String sql = null;
        if (questionnaireIds.size()==0)
        {
            return criterionList;
        }
        // if there is only one questionnaireId in the arraylist, use it anyway
        if (questionnaireIds.size()==1)
        {
        	questionnaire_id = questionnaireIds.get(0);
        	//now we have that questionnaire_id, go ahead and load the criterion
            sql = "select questions.id as 'CriterionID', questions.txt as 'CriterionTitle', "
            		+ " NULL as 'CriterionDescription',questions.type as 'Type', "
            		+ " questionnaires.max_question_score as'MaxLabel', questionnaires.min_question_score as 'MinLabel' "
            		+ " from questions, questionnaires "
            		+ " where questions.questionnaire_id="+questionnaire_id +" "
            		+ " and questions.questionnaire_id=questionnaires.id; ";
        }
        // if there are multiple questionnaire_ids in this assignment, it indicates that this assignment uses "vary_rubric_by_rounds" feature, use the round # to find the right questionnaire_id
        if (questionnaireIds.size()>1)
        {
        	questionnaire_id = questionnaireIds.get(round);
        	//now we have that questionnaire_id, go ahead and load the criterion
             sql = "select id as 'CriterionID', txt as 'CriterionTitle', NULL as 'CriterionDescription' from questions where questionnaire_id="+questionnaire_id +"; ";
        }
 
        //DBConnector dbc1 = new DBConnector();
        System.out.println(sql);
    	ResultSet rs1 = dbc.query(sql);
    	try {
			while(rs1.next()){
				Criterion criterion = loadSingle(rs1);
				if(criterion == null) {
		
				} else {
					criterionList.add(criterion);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			rs1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	dbc.close();
    	return criterionList;
    }

	private Criterion loadSingle(ResultSet rs) {
		Integer criterionID;
		String criterionTitle;
		String criterionDescription;
		String criterionType;
		Integer criterionMaxLabel;
		Integer criterionMinLabel;
		
		Criterion criterion = null;
		
		try {
			criterionID = ResultSetParser.parseInt(rs, "CriterionID");
			criterionTitle = ResultSetParser.parseString(rs, "CriterionTitle");
			criterionDescription = ResultSetParser.parseString(rs, "CriterionDescription");
			criterionType = ResultSetParser.parseString(rs, "Type");
			criterionMaxLabel = ResultSetParser.parseInt(rs, "MaxLabel");
			criterionMinLabel = ResultSetParser.parseInt(rs, "MinLabel");
			
			
			criterion = new Criterion(criterionID, criterionTitle, criterionDescription,criterionType,criterionMaxLabel,criterionMinLabel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return criterion;
	}

}