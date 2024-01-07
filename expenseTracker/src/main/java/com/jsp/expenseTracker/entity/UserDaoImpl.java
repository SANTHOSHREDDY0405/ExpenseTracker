package com.jsp.expenseTracker.entity;

import java.io.InputStream;
import java.sql.*;

import com.jsp.expenseTracker.dao.UserDao;
import com.jsp.expenseTracker.utility.SingletonClass;

public class UserDaoImpl implements UserDao{
    
	//Establish connection
	private Connection connect=SingletonClass.getSingletonClass().getConnection();
	//create platform
	private PreparedStatement pstmt;
	
	@Override
	public int register(User user) throws Exception {
		//insert query - to insert data in user table
		String insert="insert into user(username,fullname,email,mobile,password)values(?,?,?,?,?)";
		
	pstmt=connect.prepareStatement(insert);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getFullname());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getMobile());
		pstmt.setString(5, user.getPassword());
	
	int status = pstmt.executeUpdate();
	if(status!=0) {
		//retrieve userId from dataBase
		String select ="select userId from user where email=?";
		pstmt=connect.prepareStatement(select);
		pstmt.setString(1, user.getEmail());
		ResultSet rs = pstmt.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			System.out.println("userId = "+rs.getInt("userId"));
			
			return rs.getInt("userId");
		}
	}
		return 0;	
	}

	@Override
	public User login(String userName, String password) throws Exception {
		String query="select * from user where username=? and password=?";
		 pstmt = connect.prepareStatement(query);
		 pstmt.setString(1, userName);
		 pstmt.setString(2, password);
		 ResultSet rs = pstmt.executeQuery();
		 if(rs.isBeforeFirst()) {
			 rs.next();
			 
			 String un=rs.getString("username");
			 String email=rs.getString("email");
			 String fullname=rs.getString("fullname");
			 String mobile=rs.getString("mobile");
			 String pwd=rs.getString("password");
			 int userId = rs.getInt("userId");
			 
			 User user =new User();
			 user.setUsername(un);
			 user.setEmail(email);
			 user.setFullname(fullname);
			 user.setMobile(mobile);
			 user.setPassword(pwd);
			 user.setUserId(userId);
			 return user;
		 }
		return null;
	}

	@Override
	public String forgetPassword(String email) throws Exception {
		String query="select * from user where email=?";
		
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1,email);
		
		ResultSet rs = ps.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			
			return rs.getString("password");
		}
		
		return null;
	}

	@Override
	public User findUserById(int id) throws Exception {
		String query="select * from user where userid=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.isBeforeFirst()) {
			rs.next();
			
			//fetch data from database
			//store data in user object
			User user =new User();
			user.setEmail(rs.getString("email"));
			user.setFullname(rs.getString("fullname"));
			user.setMobile(rs.getString("mobile"));
			user.setPassword(rs.getString("password"));
			user.setUsername(rs.getString("username"));
			
			return user;
		}
		
		return null;
	}

	@Override
	public int updateUserProfile(User user, InputStream is) throws Exception {
		String query="update user set fullname=?,username=?,mobile=?,email=?,password=?,image=? where userId=?";
		pstmt=connect.prepareStatement(query);
		pstmt.setString(1, user.getFullname());
		pstmt.setString(2, user.getUsername());
		pstmt.setString(3, user.getMobile());
		pstmt.setString(4, user.getEmail());
		pstmt.setString(5, user.getPassword());
		pstmt.setBlob(6, is);
		pstmt.setInt(7, user.getUserId());
		int status=pstmt.executeUpdate();
		return status;
		
	}

}
