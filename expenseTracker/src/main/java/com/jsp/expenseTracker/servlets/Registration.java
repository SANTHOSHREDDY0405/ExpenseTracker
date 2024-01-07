
package com.jsp.expenseTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.expenseTracker.entity.User;
import com.jsp.expenseTracker.service.*;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	private UserService service=new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//fetch data from HTML form
		String fullname=request.getParameter("fullname");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		//store the data in user object
		User user=new User();
		user.setFullname(fullname);
		user.setUsername(username);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setPassword(cpassword);
		
		
		int userId=service.register(user, cpassword);
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(userId!=0) {
			//display login.jsp file
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			//to complete servlet chaining
			dispatcher.include(request, response);
			writer.print("<h1>Registration succesfull!!!</h1>");
			writer.print("<h1>Your userId = "+userId+" </h1>");
		}
		else {
			//display register.jsp
			RequestDispatcher dispatcher=request.getRequestDispatcher("register.jsp");
			dispatcher.include(request, response);
			writer.print("enter valid details");
		}
	}

}
