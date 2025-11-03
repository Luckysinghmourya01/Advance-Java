package com.rays.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestAppProperties {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		
		String url = rb.getString("url");
		String driver = rb.getString("driver");
		String username = rb.getString("username");
		String password = rb.getString("password");
		
		System.out.println(url + "\n" + driver + "\n" + username + "\n" + password);
		
		System.out.println("------------- change a multi language -------------");
		
		ResourceBundle rb1 = ResourceBundle.getBundle("com.rays.bundle.app" , new Locale("msg"));
		
		System.out.println("hindi= "+rb1.getString("hi"));
		System.out.println("japanese= "+rb1.getString("hii"));
		System.out.println(rb1.getString("badhai"));
	}
}
