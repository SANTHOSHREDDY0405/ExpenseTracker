package com.jsp.expenseTracker.dao;

import java.sql.Date;
import java.util.List;

import com.jsp.expenseTracker.entity.Expense;

public interface ExpenseDao {
   int addExpense(Expense expense,int userId) throws Exception;
   
   List<Expense> ViewExpense(int userId) throws Exception;
   
	int deleteExpenseById(int expenseId) throws Exception;
	Expense findexpensebyid(int expenseid) throws Exception;
	int updateexpense(Expense expense, int expenseid) throws Exception;
	List<Expense> totalExpense(Date first,Date last) throws Exception;

}
