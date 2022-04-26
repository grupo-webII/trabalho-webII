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

import com.system.app.web.beans.AtendType;
import com.system.app.web.beans.Atendimento;
import com.system.app.web.beans.Product;
import com.system.app.web.beans.User;
import com.system.app.web.repo.AtendRepo;
import com.system.app.web.repo.AttTypeRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.ProductRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ClientAskSupport", urlPatterns = { "/client/asksupport" })
public class asksupport extends HttpServlet {

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

        AttTypeRepo attTypeRepo = new AttTypeRepo();
        ProductRepo productRepo = new ProductRepo();
        try {
            List<AtendType> atendimentos = attTypeRepo.getAll();
            List<Product> products = productRepo.getAll();
            request.setAttribute("products", products);
            request.setAttribute("atendimentos", atendimentos);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/client/asksupport.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            // TODO Auto-generated catch block
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

        AtendRepo atendRepo = new AtendRepo();
        Atendimento atendimento = new Atendimento();
        ProductRepo productRepo = new ProductRepo();
        AttTypeRepo attTypeRepo = new AttTypeRepo();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            atendimento.setClient(user);
            atendimento.setDescription(request.getParameter("description"));
            Product product = productRepo.getByID(Integer.parseInt(request.getParameter("product")));
            atendimento.setProduct(product);
            AtendType atendType = attTypeRepo.getByID(Integer.parseInt(request.getParameter("type")));
            atendimento.setType(atendType);
            atendRepo.save(atendimento);
        } catch (NumberFormatException e) {
            // REDIRECT ERROR JSP
            e.printStackTrace();
        } catch (DAOException e) {
            // REDIRECT ERROR JSP
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
