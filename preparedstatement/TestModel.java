package com.rays.preparedstatement;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestModel {

	public static void main(String[] args) throws Exception {
	
//	testNextPK();	
		//add();
		//update();
		//delete();
		//Testfindbylogin();
		//testauthenticate();
	  //  testfindbypk();
		//testsearch();
		//testChangePassword();
	}

	private static void testNextPK() throws ClassNotFoundException, SQLException {
		UserModel model = new UserModel();
	int i = 	 model.nextPk();
		
	System.out.println(i);
	}
	
	private static void add() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		
		bean.setFirstname("malkhan");
		bean.setLastname("yadav");
		bean.setlogin("khan121@gmail.com");
		bean.setpassword("434");
		bean.setdob(sdf.parse("2009-1-8"));
		
		model.add(bean);
	}

	private static void update() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		bean.setid(2);
		bean.setFirstname("amit");
		bean.setLastname("mehra");
		bean.setlogin("amit121@gmail.com");
		bean.setpassword("3333");
		bean.setdob(sdf.parse("2006-10-12"));
		
		model.update(bean);
	}
	
	private static void delete() throws Exception, SQLException {
		
		UserModel model = new UserModel();
		
		
		model.delete(5);
		
	}
	
	private static void Testfindbylogin() throws ClassNotFoundException, SQLException {
		
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
	bean = 	model.findByLogin("amit121@gmail.com");
	if(bean != null) {
		
		System.out.print(bean.getid());
		System.out.print("\t"+bean.getFirstname());
		System.out.print("\t"+bean.getLastname());
		System.out.print("\t"+bean.getlogin());
		System.out.print("\t"+bean.getpassword());
		System.out.print("\t"+bean.getdob());
	}
	else {
		System.out.println("invalid login id");
	}
		
	}
	
	private static void testauthenticate() throws Exception, SQLException {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
	bean =	model.authenticate("amit121@gmail.com", "333");
		if(bean != null) {
		System.out.print(bean.getid());
		System.out.print("\t"+bean.getFirstname());
		System.out.print("\t"+bean.getLastname());
		System.out.print("\t"+bean.getlogin());
		System.out.print("\t"+bean.getpassword());
		System.out.println("\t"+bean.getdob());
		}
		else {
			System.out.println("ivalid login and password");
		}
	}
	
	private static void testfindbypk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
	bean = 	model.findByPk(2);
	System.out.print(bean.getid());
	System.out.print("\t"+bean.getFirstname());
	System.out.print("\t"+bean.getLastname());
	System.out.print("\t"+bean.getlogin());
	System.out.print("\t"+bean.getpassword());
	System.out.println("\t"+bean.getdob());
	

	}
	
	private static void testsearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		List list = model.search(bean);
		
		  Iterator<UserBean> it = list.iterator();
		while(it.hasNext()) {
			bean = it.next();
			System.out.print(bean.getid());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getlogin());
			System.out.print("\t"+bean.getpassword());
			System.out.println("\t"+bean.getdob());
		}
	}
	
	private static void testChangePassword() throws Exception, Exception {
		UserModel model = new UserModel();
		
		model.changepassword("1981", "1982", "mohit221@gmail.com");
	}
	}

