package com.project.javaProgram;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutPage
 */
@WebServlet("/LogoutPage")
public class LogoutPage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
//		Invalidate the session here
		
		request.getSession().invalidate();
		
		out.println("<h2>You are now logged out...<br></h2>");
		
		out.println("<a href='index.html'>Login again</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		doGet(request, response);
	}

}
