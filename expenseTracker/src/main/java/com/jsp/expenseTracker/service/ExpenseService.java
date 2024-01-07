package com.jsp.expenseTracker.service;

import java.sql.Date;
import java.util.List;

import com.jsp.expenseTracker.entity.Expense;

public interface ExpenseService {
    int addExpense(Expense expense,int userId);
    List<Expense> ViewExpense(int userId);
    int deleteExpense(int ExpenseId);
    Expense findExpenseById(int expenseId);
    int updateExpense(Expense expense,int expenseId);
    List<Expense> totalExpense(Date first,Date last);
    
}
