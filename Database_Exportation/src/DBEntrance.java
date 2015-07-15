import java.sql.SQLException;
import java.util.ArrayList;

import model.Bid;
import dao.BidLoader;

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
		BidLoader bidLoader = new BidLoader();
		ArrayList<Bid> bidList = bidLoader.getBids();
		
		for(int i = 0; i < bidList.size(); i++) {
			System.out.print(bidList.get(i).getId() + " " + bidList.get(i).getTeam_id() 
					+ " " + bidList.get(i).getTopic_id() + " " + bidList.get(i).getPriority() + "\n");
		}
	}

}
