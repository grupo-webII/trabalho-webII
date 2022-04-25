/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.employee.categories;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.app.web.beans.ProductCat;
import com.system.app.web.repo.CategoryRepo;
import com.system.app.web.repo.DAOException;

/**
 *
 * @author costiss
 */
@WebServlet(name = "employeeCategorydetails", urlPatterns = { "/employee/categorydetails" })
public class categorydetails extends HttpServlet {

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

        CategoryRepo categoryRepo = new CategoryRepo();
        try {
            ProductCat category = categoryRepo.getByID(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("category", category);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/employee/categorydetails.jsp");
            rd.forward(request, response);
        } catch (NumberFormatException e) {
            // REDIRECT TO ERROR.JSP
            e.printStackTrace();
        } catch (DAOException e) {
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

        CategoryRepo categoryRepo = new CategoryRepo();
        try {
            ProductCat category = categoryRepo.getByName(request.getParameter("name"));
            category.setName(request.getParameter("name"));
            categoryRepo.update(category);
        } catch (DAOException e) {
            // REDIRECT TO ERROR.JSP
            e.printStackTrace();
        } catch (NullPointerException e) {
            // REDIRECT TO ERROR.JSP
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
