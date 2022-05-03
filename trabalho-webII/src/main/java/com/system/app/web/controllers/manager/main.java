/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.app.web.beans.FullUser;
import com.system.app.web.beans.User;
import com.system.app.web.beans.UserData;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.UserDataRepo;
import com.system.app.web.repo.UserRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ManagerMain", urlPatterns = { "/manager/main" })
public class main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */

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

        UserRepo userRepo = new UserRepo();
        UserDataRepo userDataRepo = new UserDataRepo();
        try {
            List<User> users = userRepo.getAll();
            List<FullUser> fullusers = new ArrayList<>();
            for (User user : users) {
                UserData userData = userDataRepo.getByID(user.getUser_id());
                FullUser newFullUser = new FullUser();
                newFullUser.setUser(user);
                newFullUser.setUserData(userData);
                fullusers.add(newFullUser);
            }
            request.setAttribute("fullusers", fullusers);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/manager/main.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Erro no banco de dados");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
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
