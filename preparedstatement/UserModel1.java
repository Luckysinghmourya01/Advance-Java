package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel1 {

	String name = null;
	
	public String Nextname() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky" , "root" , "root");
	
	 PreparedStatement pstm =   conn.prepareStatement("select * from st_user where Firstname='amit'");
	 
	   ResultSet rs = pstm.executeQuery();
	   while(rs.next()) {
		 String name =   rs.getString(2);
		 
		 System.out.println("name= "+ name);
	   }
		return name;
	}

}
