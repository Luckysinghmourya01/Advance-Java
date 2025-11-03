package com.rays.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransctionHandling {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
	
	    conn.setAutoCommit(false);
	   Statement stm =    conn.createStatement();
	   
	 int i =  stm.executeUpdate("insert into employee values(4 , 'piyush' , 45000)");
	     i =  stm.executeUpdate("insert into employee values(5 , 'ashok', 12000)");
	     i = stm.executeUpdate("insert into employee values(6 , 'neeraj', 12000)");
	     
	    conn.commit();
	     System.out.println("transction commited" + i );
		}
		catch(Exception e) {
			System.out.println("transction rollback");
			conn.rollback();
			
		}
	}
}
