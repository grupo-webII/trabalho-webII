/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.app.web.beans.Atendimento;
import com.system.app.web.beans.UserData;
import com.system.app.web.repo.AtendRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.UserDataRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ManagerSupportdescription", urlPatterns = { "/manager/supportdescription" })
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
        UserDataRepo userDataRepo =  new UserDataRepo();
        try {
            Atendimento atendimento = attRepo.getByID(Integer.parseInt(request.getParameter("id")));
            Integer uID = atendimento.getClient().getUser_id();
            UserData userData = userDataRepo.getByID(uID);
            System.out.println("--------------------------" + userData.getName());
            request.setAttribute("atendimento", atendimento);
            request.setAttribute("userData", userData);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/manager/supportdescription.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Erro no banco de dados");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NullPointerException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro ID Nulo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro ID Invalido");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        }
    }

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
