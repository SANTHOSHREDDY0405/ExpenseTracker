package com.jsp.expenseTracker.entity;

import java.sql.Date;

public class Expense {
      private double amount;
      private String category;
      private String description;
      private Date date;
      private int ExpenseId;
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(double amount, String category, String description, Date date,int ExpenseId) {
		super();
		this.amount = amount;
		this.category = category;
		this.description = description;
		this.date = date;
		this.ExpenseId=ExpenseId;
	}
	
	public int getExpenseId() {
		return ExpenseId;
	}
	public void setExpenseId(int expenseId) {
		ExpenseId = expenseId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Expense [amount=" + amount + ", category=" + category + ", description=" + description + ", date="
				+ date + ", ExpenseId=" + ExpenseId + "]";
	}
   
}
