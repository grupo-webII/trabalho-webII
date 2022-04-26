/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.client;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.User;
import com.system.app.web.beans.UserData;

import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.UserDataRepo;
import com.system.app.web.repo.UserRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ClientUpdatedata", urlPatterns = { "/client/updatedata" })
public class updatedata extends HttpServlet {

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

        UserDataRepo userDataRepo = new UserDataRepo();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            UserData userData = userDataRepo.getByID(user.getUser_id());
            request.setAttribute("user", user);
            request.setAttribute("userData", userData);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/client/updatedata.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
            // REDIRECT TO ERROR.JSP
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

        UserData userData = new UserData();
        UserRepo userRepo = new UserRepo();
        UserDataRepo userDataRepo = new UserDataRepo();
        try {
            userData.setName(request.getParameter("name"));
            userData.setLastname(request.getParameter("lastname"));
            userData.setCpf(request.getParameter("cpf"));
            userData.setPhone(request.getParameter("phone"));
            userData.setCep(request.getParameter("cep"));
            userData.setAddress(request.getParameter("address"));
            userData.setAdressNumber(Integer.parseInt(request.getParameter("addressNumber")));
            userData.setComplement(request.getParameter("complement"));
            userData.setState(request.getParameter("state"));
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            userData.setUser_id(user.getUser_id());
            if (!user.getEmail().equals(request.getParameter("email"))) {
                user.setEmail(request.getParameter("email"));
            }
            if (!user.getPassword().equals(request.getParameter("password"))) {
                user.setPassword(request.getParameter("password"));
            }
            userRepo.update(user);
            userDataRepo.update(userData);
        } catch (DAOException e) {
            // redirect to error.jsp
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // redirect to error.jsp
            e.printStackTrace();
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
