/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.Atendimento;
import com.system.app.web.beans.User;
import com.system.app.web.repo.AtendRepo;
import com.system.app.web.repo.DAOException;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ClientMain", urlPatterns = { "/client/main" })
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

        AtendRepo attRepo = new AtendRepo();
        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<Atendimento> allAtends = attRepo.getAllByUser(user.getUser_id());
            request.setAttribute("atendimentos", allAtends);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/client/main.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
            // REDIRECT TO ERROR.JSP
        } catch (NullPointerException e) {
            // REDIRECT TO ERROR.JSP
            e.printStackTrace();
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
