package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.UserService;
import com.jsp.expenseTracker.service.UserServiceImpl;




@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private UserService userService=new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user=userService.login(username, password);
		
		PrintWriter writer = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(user!=null) {
			//credentials are valid -show homepage
			//request.setAttribute("userInfo", user);
			
			session.setAttribute("userInfo", user);
			request.setAttribute("msg", "LoginSuccesfull!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.include(request, response);
			//writer.print("login succesfull");
		}
		else {
			//credentials are invalid-show login page
			request.setAttribute("msg", "please valid credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.include(request, response);
			//writer.print("invalid credentials");
		}
	}

}
