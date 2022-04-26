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

import com.system.app.web.beans.Atendimento;

import com.system.app.web.repo.AtendRepo;
import com.system.app.web.repo.DAOException;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ClientSupportdescription", urlPatterns = { "/client/supportdescription" })
public class supportdescription extends HttpServlet {

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
            Atendimento atendimento = attRepo.getByID(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("atendimento", atendimento);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/client/supportdescription.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Erro no banco de dados");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NullPointerException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro ID nulo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro ID invalido");
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
