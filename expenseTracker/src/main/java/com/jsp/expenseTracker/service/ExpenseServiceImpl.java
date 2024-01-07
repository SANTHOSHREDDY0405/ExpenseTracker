package com.jsp.expenseTracker.service;

import java.sql.Date;
import java.util.List;

import com.jsp.expenseTracker.dao.*;
import com.jsp.expenseTracker.entity.Expense;

public class ExpenseServiceImpl implements ExpenseService{
	
     private ExpenseDao expenseDao=new ExpenseDaoImpl();
	
	@Override
	public int addExpense(Expense expense, int userId) {
		try {
			return expenseDao.addExpense(expense, userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Expense> ViewExpense(int userId) {
		try {
			return expenseDao.ViewExpense(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	} 
	@Override
	public int deleteExpense(int expenseId) {
		
		try {
			return expenseDao.deleteExpenseById(expenseId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Expense findExpenseById(int expenseId) {
		try {
			return expenseDao.findexpensebyid(expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateExpense(Expense expense, int expenseId) {
		try {
			return expenseDao.updateexpense(expense, expenseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Expense> totalExpense(Date first, Date last) {
		try {
			return expenseDao.totalExpense(first,last);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
