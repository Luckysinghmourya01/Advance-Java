package com.rays.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserModel {

	public int nextPk() throws ClassNotFoundException, SQLException {

		int pk = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");

		PreparedStatement pstm = conn.prepareStatement("select max(id) from st_user ");

		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id: " + pk);
		}

		conn.close();
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
	
		UserBean existbean = findByLogin(bean.getlogin());
		if(existbean != null ) {
			throw new Exception("login id already exist");
		}
		
		
		Class.forName(driver);

		Connection conn = DriverManager.getConnection(url , username , password);

		PreparedStatement pstm = conn.prepareStatement("insert into st_user values(? , ? , ? , ? , ? , ?)");

		int id = nextPk();
		pstm.setInt(1, id);
		pstm.setString(2, bean.getFirstname());
		pstm.setString(3, bean.getLastname());
		pstm.setString(4, bean.getlogin());
		pstm.setString(5, bean.getpassword());
		pstm.setDate(6, new java.sql.Date(bean.getdob().getTime()));

		int i = pstm.executeUpdate();
		System.out.println("insert data sucessfull" + i);

		conn.close();
	}

	public void update(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");
PreparedStatement pstm = conn.prepareStatement("update st_user set Firstname=? ,Lastname=? , login=? , password=? , dob=? where id=? ");

		pstm.setString(1, bean.getFirstname());
		pstm.setString(2, bean.getLastname());
		pstm.setString(3, bean.getlogin());
		pstm.setString(4, bean.getpassword());
		pstm.setDate(5, new java.sql.Date(bean.getdob().getTime()));
		pstm.setInt(6, bean.getid());

		int i = pstm.executeUpdate();

		System.out.println("update sucessfully" + i);
 
		conn.close();
	}

	public void delete(int id) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");

		PreparedStatement pstm = conn.prepareStatement("delete from st_user where id=?");

		pstm.setInt(1, id);

		int i = pstm.executeUpdate();
		System.out.println("delete sucessfully" + i);

		conn.close();
	}

	public UserBean findByLogin(String login) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");

		PreparedStatement pstm = conn.prepareStatement("select * from st_user where login=?");

		pstm.setString(1, login);

		ResultSet rs = pstm.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setid(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setlogin(rs.getString(4));
			bean.setpassword(rs.getString(5));
			bean.setdob(rs.getDate(6));
		}
		conn.close();
		return bean;
	}

	public UserBean authenticate(String login, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");

		PreparedStatement pstm = conn.prepareStatement("select * from st_user where login=? and password=?");

		pstm.setString(1, login);
		pstm.setString(2, password);

		ResultSet rs = pstm.executeQuery();

		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setid(1);
			bean.setid(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setlogin(rs.getString(4));
			bean.setpassword(rs.getString(5));
			bean.setdob(rs.getDate(6));

			conn.close();
		}
		return bean;
	}

	public UserBean findByPk(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky", "root", "root");
		PreparedStatement pstm = conn.prepareStatement("select * from st_user where id=?");
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
      bean = new UserBean();
      bean.setid(rs.getInt(1));
      bean.setFirstname(rs.getString(2));
      bean.setLastname(rs.getString(3));
      bean.setlogin(rs.getString(4));
      bean.setpassword(rs.getString(5));
      bean.setdob(rs.getDate(6));
		}
		return bean;
	}
	
	public List search(UserBean bean) throws Exception {
		
		List list = new ArrayList();
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:/lucky" , "root" , "root");
		
		PreparedStatement pstm =  conn.prepareStatement("select * from st_user");
		
		 ResultSet rs =  pstm.executeQuery();
		 
		 while(rs.next()) {
			 bean = new UserBean();
			bean.setid(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setlogin(rs.getString(4));
			bean.setpassword(rs.getString(5));
			bean.setdob(rs.getDate(6));
			list.add(bean);
			
		 }
	return list;	 
		 
	}
	
	public void changepassword(String oldpassword , String newpassword , String login) throws Exception, SQLException {
		 UserBean existbean = findByLogin(login);
		 
		 System.out.println("database  password= " + existbean.getpassword());
		 System.out.println("old password= " + oldpassword);
		 
		 if(existbean.getpassword().equals(oldpassword)) {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = 	 DriverManager.getConnection("jdbc:mysql://localhost:3306/lucky" , "root" , "root");
		    PreparedStatement pstm =  conn.prepareStatement("update st_user set password=? where login=?");
		    
		    pstm.setString(1, newpassword);
		    pstm.setString(2, login);
		    
		    int i = pstm.executeUpdate();
		    
		    System.out.println("change sucessfully"+ i);
		    conn.close();
		 }
		 else {
			 throw new Exception("old password is incorect");
		 }
	}
}
