package com.jsp.expenseTracker.utility;

import java.sql.*;

public class SingletonClass {
   private static SingletonClass sc;
   private Connection connect;
   
   private SingletonClass()
   {
	   
   }
   
   public static SingletonClass getSingletonClass() {
	   if(sc==null) {
		   //create object of SingletonClass
		   sc=new SingletonClass();
		   System.out.println("Singleton object created");
	       System.out.println(sc);  
	   }
	   return sc;
   }
   public Connection getConnection() {
	   String url="jdbc:mysql://localhost:3306/expensetracker?user=root&password=12345";
	   
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		connect=DriverManager.getConnection(url);
		System.out.println("connection established");
		return connect;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return connect;
   }
}
