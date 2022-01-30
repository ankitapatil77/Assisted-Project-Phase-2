package com.javaProgram.hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaProgram.hibernate.ProductDAo;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Adding Product</b> " + request.getParameter("name") + "<br>");
        out.println("<a href='index.html'>Return to Main</a><br>");
        out.println("</body></html>");
        
        String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		
		HttpSession session = request.getSession(true);
		try {		
			ProductDAo ProductDAO = new ProductDAo();
			ProductDAO.addProduct(id,name, price);
			response.sendRedirect("Success");
		} catch(Exception e) {
			System.err.println("doGet");
			e.printStackTrace();
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

}
}