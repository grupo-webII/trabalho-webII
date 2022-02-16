package com.system.app.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pwriter = response.getWriter();

		String user = request.getParameter("uemail");
		String pass = request.getParameter("upass");

		if (user.equals("gerente@test.com") && pass.equals("123")) {
			response.sendRedirect("views/manager/main.jsp");  
		} else if (user.equals("cliente@test.com") && pass.equals("123")) {
			response.sendRedirect("views/client/main.jsp");  
		} else if (user.equals("funcionario@test.com") && pass.equals("123")) {
			response.sendRedirect("views/employee/main.jsp");  
		} else {
			pwriter.print("Uus�rio/senha n�o encontrado!");
			pwriter.print("<a href=\"index.jsp\">P�gina inicial</a>");
		}

		pwriter.close();
		
		doGet(request, response);
	}

}
