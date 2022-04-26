package com.system.app.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.User;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.UserRepo;

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
		response.getWriter().append("Served attt: ").append(request.getContextPath());
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
		UserRepo userRepo = new UserRepo();
		// Database Validation
		try {
			User user = userRepo.handleLogin(uemail, upass);
			System.out.println(user.getIsAuthenticated());
			if (user.getIsAuthenticated()) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				if (user.getRole().isROLE_FUNC()) {
					response.sendRedirect("employee/main");
				} else if (user.getRole().isROLE_GERENTE()) {
					response.sendRedirect("manager/main");
				} else {
					response.sendRedirect("client/main");
				}
			} else {
				request.setAttribute("error", "Atenticacao falhou");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				pwriter.print("Usuário/senha não encontrado!");
				pwriter.print("<a href=\"index.jsp\">Página inicial</a>");
			}
		} catch (DAOException e) {
            request.setAttribute("error", "Autenticacao falhou");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
		}

		pwriter.close();

		doGet(request, response);
	}

}
