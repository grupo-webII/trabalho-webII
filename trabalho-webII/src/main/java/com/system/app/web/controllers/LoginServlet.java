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

		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");

		// Database Validation
		// UserRepo repo = new UserRepo();
		// User user = repo.getUserByEmail(uemail);

		// if (user.getPassword().equals(upass)) {
		// response.sendRedirect("views/manager/main.jsp");
		// }

		if (uemail.equals("gerente@test.com") && upass.equals("123")) {
			response.sendRedirect("views/manager/main.jsp");
		} else if (uemail.equals("cliente@test.com") && upass.equals("123")) {
			response.sendRedirect("views/client/main.jsp");
		} else if (uemail.equals("funcionario@test.com") && upass.equals("123")) {
			response.sendRedirect("views/employee/main.jsp");
		} else {
			pwriter.print("Uus�rio/senha n�o encontrado!");
			pwriter.print("<a href=\"index.jsp\">P�gina inicial</a>");
		}

		pwriter.close();

		doGet(request, response);
	}

}
