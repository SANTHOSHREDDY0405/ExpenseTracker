package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.Expense;
import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.ExpenseService;
import com.jsp.expenseTracker.service.ExpenseServiceImpl;

@WebServlet("/TotalExpenses")
public class TotalExpenses extends HttpServlet {
	
	private ExpenseService expenseService = new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		Date first = Date.valueOf(request.getParameter("first"));
		Date last =Date.valueOf(request.getParameter("last"));
		List<Expense> listOfExpense = expenseService.totalExpense(first, last);
		System.out.println(listOfExpense);
		request.setAttribute("list1", listOfExpense);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses1.jsp");
		dispatcher.include(request, response);
		
		
	}


}
