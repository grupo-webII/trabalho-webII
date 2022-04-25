/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.employee.products;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.app.web.beans.Product;
import com.system.app.web.beans.ProductCat;
import com.system.app.web.repo.CategoryRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.ProductRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "employeeNewproduct", urlPatterns = { "/employee/newproduct" })
public class newproduct extends HttpServlet {

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
            List<ProductCat> categories = categoryRepo.getAll();
            request.setAttribute("categories", categories);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/employee/newproduct.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            // REDIRECT ERROR JSP
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

        ProductRepo productRepo = new ProductRepo();
        CategoryRepo categoryRepo = new CategoryRepo();
        try {
            Product product = new Product();
            ProductCat category = categoryRepo.getByID(Integer.parseInt(request.getParameter("category")));
            product.setCategory(category);
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setWeight(Float.parseFloat(request.getParameter("weight")));
            productRepo.save(product);
        } catch (DAOException e) {
            // REDIRECT TO ERROR.JSP
            e.printStackTrace();
        } catch (NumberFormatException e) {
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
