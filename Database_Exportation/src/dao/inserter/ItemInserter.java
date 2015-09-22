/**
 * 
 */
package dao.inserter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Item;

/**
 * @author kma
 *
 */
public class ItemInserter {

	public static void insertSingle(Item item) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Item (ItemContent, ArtifactId) values (?,?)");
				Statement st = con.createStatement();
		   )
		   {	
				
				ResultSet rs = st.executeQuery("select count(*) from Item where ItemContent='"+ item.getItemContent() +"' and ArtifactID="+ item.getArtifactID()+";");
				
				rs.next();
				int num = rs.getInt(1);
				if(num != 0) {
					
				} else {
					pstmt.clearParameters();
					pstmt.setString(1, item.getItemContent());
					pstmt.setString(2, item.getArtifactID().toString());
					
					pstmt.executeUpdate();
					System.out.println("==========Item object inserted=============");
				}
				
				rs.close();
				pstmt.close();
				st.close();
				con.close();
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("Database error");
		   }
		
	}
}
	

