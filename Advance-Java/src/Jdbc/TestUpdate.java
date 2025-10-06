package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
		
	  Statement stm = 	conn.createStatement();
	  
	int i =   stm.executeUpdate("update marksheet set maths=65 where rollno=11");
	  int i1 = stm.executeUpdate("update marksheet set maths=88 where rollno=10");
	  int i2 = stm.executeUpdate("update marksheet set maths=55 where rollno=9");
	  	int i3 = 	stm.executeUpdate("update marksheet set name='piyush solanki' where rollno=8");
	  	int i4 = 	stm.executeUpdate("update marksheet set name='kamal thakur' where rollno=3");
	  	int i5 = stm.executeUpdate("update marksheet set name='prince verma' where rollno=11 ");
	  	
	System.out.println(i+ "row updated");
	System.out.println(i1+"row updated");
	System.out.println(i2+"ROw updated");
	System.out.println(i3+ "row updated");
	System.out.println(i4+ "row updated");
	System.out.println(i5+ "row updates");
	}
}
