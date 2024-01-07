package com.jsp.expenseTracker.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.jsp.expenseTracker.entity.Expense;
import com.jsp.expenseTracker.utility.SingletonClass;

public class ExpenseDaoImpl implements ExpenseDao{

	private Connection connection=SingletonClass.getSingletonClass().getConnection();
	private PreparedStatement pstmt;
	
	@Override
	public int addExpense(Expense expense, int userId) throws Exception {
		String query="insert into expenses(amount,category,description,date,userId)"+"values(?,?,?,?,?)";
		pstmt=connection.prepareStatement(query);
		pstmt.setDouble(1, expense.getAmount());
		pstmt.setString(2, expense.getCategory());
		pstmt.setString(3, expense.getDescription());
		pstmt.setDate(4, expense.getDate());
		pstmt.setInt(5, userId);
		
		int status=pstmt.executeUpdate();
		if(status!=0) {
			String selectQuery = "select Last_Insert_Id";
			pstmt=connection.prepareStatement(selectQuery);
			ResultSet rs=pstmt.executeQuery();
			if(rs.isBeforeFirst()) {
				rs.next();
				int expenseId = rs.getInt(1);
				return expenseId;
			}
		}
		return 0;
	}

	@Override
	public List<Expense> ViewExpense(int userId) throws Exception {
		String query="select * from expenses where userId=?";
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, userId);
		ResultSet rs = pstmt.executeQuery();
		List<Expense> expenseList=new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
			 expenseList.add(new Expense(rs.getDouble("amount"),rs.getString("category"),rs.getString("description"),rs.getDate("date"), rs.getInt("ExpenseId")));
			}
			return expenseList;
		}
		System.out.println(expenseList);
		return null;
	}
	@Override
	public int deleteExpenseById(int expenseId) throws Exception {
		String query = "delete from expenses where expenseId = ?";
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, expenseId);
		int status = pstmt.executeUpdate();
		return status;
	}
	
	@Override
	public Expense findexpensebyid(int expenseid) throws Exception {
		String query="select * from expenses where expenseid=?";
		pstmt=connection.prepareStatement(query);
		pstmt.setInt(1, expenseid);
		 ResultSet rs=pstmt.executeQuery();
		 if(rs.isBeforeFirst()) {
			 rs.next();
			 Expense expense=new Expense();
			 expense.setAmount(rs.getDouble("amount"));
			 expense.setCategory(rs.getString("category"));
			 expense.setDate(rs.getDate("date"));
			 expense.setDescription(rs.getString("description"));
			 // add expenseid
			 expense.setExpenseId(rs.getInt("expenseId"));
			 return expense;
			
		 }
		return null;
	}

	@Override
	public int updateexpense(Expense expense, int expenseid) throws Exception {
		String query="update expenses set amount=?,description=?,date=?,category=?"+
	              "where expenseId=?";
		pstmt=connection.prepareStatement(query);
		pstmt.setDouble(1, expense.getAmount());
		pstmt.setString(2, expense.getDescription());
		pstmt.setDate(3,expense.getDate());
		pstmt.setString(4,expense.getCategory());
		pstmt.setInt(5, expenseid);
		
		int status=pstmt.executeUpdate();
		return status;
	}

	@Override
	public List<Expense> totalExpense(Date first, Date last) throws Exception {
		String query="select * from expenses where date>? and date<?";
		pstmt=connection.prepareStatement(query);
		pstmt.setDate(1, first);
		pstmt.setDate(2, last);
		ResultSet rs = pstmt.executeQuery();
		List<Expense> expenseList=new ArrayList<Expense>();
		if(rs.isBeforeFirst()) {
			while(rs.next()) {
			 expenseList.add(new Expense(rs.getDouble("amount"),rs.getString("category"),rs.getString("description"),rs.getDate("date"), rs.getInt("ExpenseId")));
			}
			return expenseList;
		}
		System.out.println(expenseList);
		return null;
	}


}
