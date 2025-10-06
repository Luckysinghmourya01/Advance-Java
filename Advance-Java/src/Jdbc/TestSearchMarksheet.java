package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSearchMarksheet {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
	
	 Statement stm =  conn.createStatement();
	 
	ResultSet rs  = stm.executeQuery("select * ,(phy+chem+maths) as total ,((phy+chem+maths)/3) as percentage from marksheet order by percentage desc");
	
	System.out.print("\t rollno");
	System.out.print("\t name");
	System.out.print("\t \t phy");
	System.out.print("\t chem");
	System.out.println("\t maths");
	while(rs.next()) {
		System.out.print("\t"+rs.getInt(1));
		System.out.print("\t"+ rs.getString(2));
		System.out.print("\t"+rs.getInt(3));
		System.out.print("\t"+rs.getInt(4));
		System.out.print("\t"+ rs.getInt(5));
		
		int total = rs.getInt(3) + rs.getInt(4) + rs.getInt(5);
		double percentage = total/3;
		System.out.print("\t"+total);
		System.out.print("\t" + percentage);
		
		if(rs.getInt(3)<33 || rs.getInt(4)<33 || rs.getInt(5)<33) {
			
			System.out.println("\tfail");
		}
		else {
			System.out.println("\tpass");
		}
	}
	}
}
