package com.jsp.expenseTracker.dao;

import java.io.InputStream;
import java.sql.*;

import com.jsp.expenseTracker.entity.User;
//all database operation on user table
//Data Access Object
public interface UserDao {
   int register(User user) throws Exception;//return id of user after inserting data
   User login(String userName,String password) throws Exception;
   
   String forgetPassword(String email)throws Exception;
   User findUserById(int id) throws Exception;
   int updateUserProfile(User user,InputStream is) throws Exception;
}
  