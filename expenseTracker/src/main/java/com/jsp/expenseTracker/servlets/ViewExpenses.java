package com.jsp.expenseTracker.servlets;

import java.io.IOException;
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

import com.jsp.expenseTracker.service.*;

/**
 * Servlet implementation class ViewExpenses
 */
@WebServlet("/ViewExpenses")
public class ViewExpenses extends HttpServlet {
	private ExpenseService expenseService = new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Fetch User object from session
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("userInfo");
		
		List<Expense> listOfExpense = expenseService.ViewExpense(user.getUserId());
		System.out.println(listOfExpense);
		request.setAttribute("list", listOfExpense);
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
		dispatcher.include(request, response);
		
	}

	

}