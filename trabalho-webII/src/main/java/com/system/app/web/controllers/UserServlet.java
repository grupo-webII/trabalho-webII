/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 *
 * @author costiss
 */
@WebServlet(name = "UserServlet", urlPatterns = { "/UserServlet" })
public class UserServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        UserRepo uRepo = new UserRepo();
        String option = request.getParameter("option").toUpperCase();
        Integer id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        User reqUser = (User) session.getAttribute("user");
        if (reqUser.getIsAuthenticated()) {
            try {
                switch (option) {
                    case "GETALL":
                        List<User> users = uRepo.getAll();
                        request.setAttribute("allUsers", users);
                        break;
                    case "GETBYID":
                        User userid = uRepo.getByID(id);
                        request.setAttribute("resUser", userid);
                        break;
                    case "DELETE":
                        Boolean isDeleted = uRepo.delete(id);
                        request.setAttribute("isDeleted", isDeleted);
                        break;
                    case "GETBYEMAIL":
                        User usermail = uRepo.getUserByEmail(email);
                        request.setAttribute("resUser", usermail);
                        break;
                }
            } catch (DAOException e) {
                e.printStackTrace();
                // REDIRECT TO ERROR.JSP
            }
        } else {
            // REDIRECT TO LOGIN
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        UserRepo uRepo = new UserRepo();
        String option = request.getParameter("option").toUpperCase();
        HttpSession session = request.getSession();
        User reqUser = (User) session.getAttribute("user");
        if (reqUser.getIsAuthenticated()) {
            User sUser = new User();
            sUser.setIsAuthenticated(false);
            sUser.setEmail(request.getParameter("email"));
            sUser.setPassword(request.getParameter("password"));
            sUser.setUser_id(Integer.parseInt(request.getParameter("user_id")));
            try {
                switch (option) {
                    case "UPDATE":
                        Boolean isUpdated = uRepo.update(sUser);
                        request.setAttribute("isUpdated", isUpdated);
                        break;
                    case "SAVE":
                        Boolean isSaved = uRepo.save(sUser);
                        request.setAttribute("isSaved", isSaved);
                        break;
                }
            } catch (DAOException e) {
                e.printStackTrace();
                // REDIRECT TO ERROR.JSP
            }
        } else {
            // REDIRECT TO LOGIN
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
