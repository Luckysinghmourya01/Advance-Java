package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConncetion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// step 1 load driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2 make connection to the database	
	Connection conn = 	DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root" , "root");
	
	// step 3 create statement
        Statement stm =	conn.createStatement();
	
        // step 4 execute qurey and get resultset
         ResultSet rs =  stm.executeQuery("select * from employe");
         
         while(rs.next()) {
        System.out.print(rs.getInt(1));
        System.out.print("\t"+rs.getString(2));
        System.out.print("\t"+rs.getString(3));
        System.out.println("\t"+rs.getInt(4));
        	 
         }
         
         System.out.println("----------------------");
         
        ResultSet rs1 =  stm.executeQuery("select * from marksheet");
        while(rs1.next()) {
        	System.out.println( +rs1.getInt(1));
        	System.out.println("\t" +rs1.getString(2));
        	System.out.println( +rs1.getInt(3));
        	System.out.println("\t" +rs1.getInt(4));
        	System.out.println("\t" +rs1.getInt(5));
        }
	}
}
