/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database_access_object.DBConnector;
import database_access_object.ResultSetParser;
import model.Criterion;
import model.Level;
import model.Level;

/**
 * @author Van Duong
 *
 */
public class LevelLoader {

	public ArrayList<Level> loadList(Criterion criterion) throws SQLException {
		ArrayList<Level> levelList = new ArrayList<Level>();
		if(criterion.getType().equals("Criterion"))
		{
			//Query for all the levels
			
			String sql = "SELECT question_advices.id as 'LevelID', question_advices.score as 'LevelLabel', "
					+ " question_advices.advice as 'LevelDescription' from question_advices where question_id=" +criterion.getCriterionID()+ ";"; 
			System.out.println(sql);
			
			DBConnector dbc = new DBConnector();
			ResultSet rs = dbc.query(sql);
			while(rs.next()){
				Level level = loadSingle(rs);
				if(level == null) {
					
				} else {
					levelList.add(level);
				}
			}
			rs.close();
			dbc.close();
			int expectedNumOfLevels = criterion.getMax_label()-criterion.getMin_label()+1;
			
			if (expectedNumOfLevels!=levelList.size())
			{
				for (int i=criterion.getMin_label();i<=criterion.getMax_label();i++)
				{
					Level tempLevel = getLevel(levelList,i);
					if (tempLevel == null)
					{
						Integer levelMaxId = getLevelMaxId();
						Level newLevel = new Level(levelMaxId, i+"", "");
						levelList.add(newLevel);
					}
				}
			}
		}
		return levelList;
	}

	private static int getLevelMaxId() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select max(LevelID) from level;");
		rs.next();
		int num = rs.getInt(1);
		
		if(num<100000)
		{
			return 100000;
		}
		
		return num+1;
	}

	private static Level getLevel(ArrayList<Level> levelList, int i) {
		for (int j = 0; j < levelList.size(); j++){
			if (levelList.get(j).getLevelLabel().equals(""+i)) {
				return levelList.get(j);
			}
		}
		return null;	
	}
	
	public Level loadSingle(ResultSet rs) {
		Integer levelID;
		String levelLabel;
		String levelDescription;
		
		Level level = null;
		
		try {
			levelID = ResultSetParser.parseInt(rs, "LevelID");
			levelLabel = ResultSetParser.parseString(rs, "LevelLabel");
			levelDescription = ResultSetParser.parseString(rs, "LevelDescription");
						
			level = new Level(levelID, levelLabel, levelDescription);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
	}

}
