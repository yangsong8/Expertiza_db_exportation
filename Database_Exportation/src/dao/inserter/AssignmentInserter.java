/**
 * 
 */
package dao.inserter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.Assignment;

/**
 * @author kma
 *
 */
public class AssignmentInserter{

	public static void insertSingle(Assignment assignment) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/PRML", "root", "");
				PreparedStatement pstmt = con.prepareStatement("Insert into Assignment (AssignmentID, AssignmentCIPCode, AssignmentTitle, AssignmentDescription) values (?,?,?,?)");
		   )
		   {
				pstmt.clearParameters();
			    //executeUpdate 执行插入语句
				pstmt.setString(1, assignment.getAssigmentID().toString());
				pstmt.setString(2, null);
				pstmt.setObject(3, assignment.getAssignTitle()); //如果不知道占位符是什么类型的数据就用setObject，jdbc会自动为您转成合适的类型
				pstmt.setObject(4, assignment.getAssignDescription()); 
				
				pstmt.executeUpdate();
				System.out.println("==========Assignment object inserted=============");
				
				//clearParameters：清理当前的参数，如果直接执行会带来异常:No value specified for parameter 1
				//pstmt.clearParameters();
				//pstmt.executeUpdate(); 
				
		   }catch(Exception e)
		   {e.printStackTrace();
			   System.out.println("数据库操作出现异常");
		   }
		
	}
}
