package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import com.jsp.expenseTracker.service.ExpenseService;
import com.jsp.expenseTracker.service.ExpenseServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.Expense;
import com.jsp.expenseTracker.entity.User;


@WebServlet("/AddExpense")
public class AddExpense extends HttpServlet {
	
	private ExpenseService expenseService=new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from HTML FORM and store in Expense object
		Expense expense=new Expense();
		expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		expense.setDescription(request.getParameter("description"));
		expense.setDate(Date.valueOf(request.getParameter("date")));
		expense.setCategory(request.getParameter("utility"));
		//get user id of an user who logged in an application
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("userInfo");
		int expenseId= expenseService.addExpense(expense,user.getUserId());
		//PrintWriter writer = response.getWriter();
		//writer.print("<h1>Expense Added succesfully,ExpenseId="+expenseId+"</h1>");
		if(expenseId!=0)
		{
			//call viewExpense method-->ExpenseService
			List<Expense> list = expenseService.ViewExpense(user.getUserId());
			request.setAttribute("expenseId",list);
			System.out.println(list);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
			dispatcher.include(request, response);
		}
		else {
			request.setAttribute("msg", "please enter valid details");
			RequestDispatcher dispatcher = request.getRequestDispatcher("addExpenses.jsp");
			dispatcher.include(request, response);
		}
		
	}

}
