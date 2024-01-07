package com.jsp.expenseTracker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.service.*;
import com.jsp.expenseTracker.entity.*;

@WebServlet("/DeleteExpense")
public class DeleteExpense extends HttpServlet {
	
	private ExpenseService service= new ExpenseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from url
		String temp=request.getParameter("expenseId");
		int expenseId=Integer.parseInt(temp);
		int status = service.deleteExpense(expenseId);
		
		if(status!=0) {
			HttpSession session = request.getSession();
			User user=(User)session.getAttribute("userInfo");
			request.setAttribute("list", service.ViewExpense(user.getUserId()));
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
			dispatcher.include(request, response);
		}
	}

}
