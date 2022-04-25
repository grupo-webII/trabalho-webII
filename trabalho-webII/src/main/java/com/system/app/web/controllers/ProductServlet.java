/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.Product;
import com.system.app.web.beans.ProductCat;
import com.system.app.web.beans.User;
import com.system.app.web.repo.CategoryRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.ProductRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ProductServlet", urlPatterns = { "/ProductServlet" })
public class ProductServlet extends HttpServlet {

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

        ProductRepo pRepo = new ProductRepo();
        String option = request.getParameter("option").toUpperCase();
        Integer id = 0;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }
        HttpSession session = request.getSession();
        // User reqUser = (User) session.getAttribute("user");
        // if (reqUser.getIsAuthenticated()) {
        try {
            switch (option) {
                case "GETALL":
                    List<Product> products = pRepo.getAll();
                    request.setAttribute("allProducts", products);
                    break;
                case "GETBYID":
                    Product product = pRepo.getByID(id);
                    request.setAttribute("product", product);
                    break;
                case "DELETE":
                    Boolean isDeleted = pRepo.delete(id);
                    request.setAttribute("isDeleted", isDeleted);
                    break;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            // REDIRECT TO ERROR.JSP
        }
        // } else {
        // // REDIRECT TO LOGIN
        // }

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
        System.out.println("Servlet");
        ProductRepo pRepo = new ProductRepo();
        CategoryRepo categoryRepo = new CategoryRepo();
        String option = request.getParameter("option").toUpperCase();
        HttpSession session = request.getSession();
        // User reqUser = (User) session.getAttribute("user");
        // if (reqUser.getIsAuthenticated()) {
        Product product = new Product();
        ProductCat pCat = new ProductCat();
        product.setName(request.getParameter("name"));
        pCat.setCat_id(Integer.parseInt(request.getParameter("category")));
        product.setCategory(pCat);
        product.setDescription(request.getParameter("description"));
        product.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
        product.setWeight(Float.parseFloat(request.getParameter("weight")));
        try {
            switch (option) {
                case "UPDATE":
                    Boolean isUpdated = pRepo.update(product);
                    request.setAttribute("isUpdated", isUpdated);
                    break;
                case "SAVE":
                    Boolean isSaved = pRepo.save(product);
                    request.setAttribute("isSaved", isSaved);
                    break;
            }
        } catch (DAOException e) {
            e.printStackTrace();
            // REDIRECT TO ERROR.JSP
        }
        // } else {
        // // REDIRECT TO LOGIN
        // }

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
