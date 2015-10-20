package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database_access_object.ResultSetParser;
import model.Criterion;
import model.CriterionLevel;

public class CriterionLevelLoader {

	public ArrayList<CriterionLevel> loadList() {
		
		
	}

	private CriterionLevel loadSingle(ResultSet rs) {
		Integer criterionID, levelID;
		boolean levelValueMax, levelValueMin;
		CriterionLevel criterionLevel = null;
		
		try {
			criterionID = ResultSetParser.parseInt(rs, "CriterionID");
			levelID = ResultSetParser.parseInt(rs, "LevelID");
			levelValueMax = ResultSetParser.parseBool
			
			criterionLevel = new CriterionLevel(criterionID, criterionTitle, criterionDescription);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return criterionLevel;
	}
}
