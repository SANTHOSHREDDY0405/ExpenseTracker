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

@WebServlet("/UpdateExpense")
public class UpdateExpense extends HttpServlet{
	private ExpenseService expenseService=new ExpenseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	int expenseId=Integer.parseInt(request.getParameter("eId"));
    	
    	Expense expense=new Expense();
    	
		expense.setAmount(Double.parseDouble(request.getParameter("amount")));
		expense.setDescription(request.getParameter("description"));
		expense.setDate(Date.valueOf(request.getParameter("date")));
		expense.setCategory(request.getParameter("category"));
		//get user id of an user who logged in an application
		
		int status= expenseService.updateExpense(expense, expenseId);
		//PrintWriter writer = response.getWriter();
		//writer.print("<h1>Expense Added succesfully,ExpenseId="+expenseId+"</h1>");
		if(status!=0)
		{
			//call viewExpense method-->ExpenseService
			HttpSession session = request.getSession();
			User user=(User) session.getAttribute("userInfo");
			List<Expense> expenses = expenseService.ViewExpense(user.getUserId());
			request.setAttribute("list",expenses);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewExpenses.jsp");
			dispatcher.include(request, response);
		}
		else {
			request.setAttribute("msg", "please enter valid details");
			RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateExpense.jsp");
			dispatcher.include(request, response);
		}
    }
}
