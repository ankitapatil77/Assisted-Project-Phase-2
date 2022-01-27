package com.project.javaProgram;

import java.io.IOException;
import java.lang.NullPointerException;

import java.io.PrintWriter;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet(urlPatterns = {"/LoginPage"},
initParams= {
		@WebInitParam(name="appName",value="myApp.com"),
		@WebInitParam(name="appDescription",value="This is myApp.com developed by ankita patil")
		})
public class LoginPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Set the content type
		response.setContentType("text/html");
		
//		Get the writer
		PrintWriter out = response.getWriter();
		
//		Get the userName and password  from the request
		String userName = request.getParameter("userName");
		String Password = request.getParameter("Password");
		
		userName = "Admin";
	    Password = "Admin123";

		
//		Validate the username and password
		if(userName.equals(userName) && Password.equals(Password)) {
			
//				Redirect to the Dashboard
			
            out.println("You have LoggedIn");
            out.println("Welcome "+ userName
			+ ".\n You are now logged in...");
			
	           out.println("<br>");
			

				
//				Get a reference to the ServletConfig
				ServletConfig config = getServletConfig();
			

			out.println("App Name : " + config.getInitParameter("appName") + "<br>");
			out.println("Description : " + config.getInitParameter("appDescription"));
			
			out.println("<p><h4><a href='LogoutPage'>LOGOUT</a></h4>");


			}

		else {
			
			out.println("<h1><font color='Blue'>Invalid username...</font></h1>");
			response.sendRedirect("index.html");
            
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}
