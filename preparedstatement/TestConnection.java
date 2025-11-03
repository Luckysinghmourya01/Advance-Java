package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky" , "root" , "root");
	
     Statement stm = 	conn.createStatement();
     
    ResultSet  rs =  stm.executeQuery("select * from st_user");
    
    while(rs.next()) {
    	System.out.print( rs.getInt(1));
    	System.out.print("\t"+rs.getString(2));
    	System.out.print("\t"+rs.getString(3));
    	System.out.print("\t"+ rs.getString(4));
    	System.out.print("\t"+rs.getString(5));
    	System.out.println("\t"+rs.getDate(6));
    }
	}
}
