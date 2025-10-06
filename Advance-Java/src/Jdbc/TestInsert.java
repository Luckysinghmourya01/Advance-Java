package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb" , "root" , "root");
	
	Statement stm = conn.createStatement();
	
    int i = stm.executeUpdate("insert into marksheet values(13 , 'kunal' , 70 , 80 , 90)");
	
	 System.out.println(i+ "row affected");
	}
}
