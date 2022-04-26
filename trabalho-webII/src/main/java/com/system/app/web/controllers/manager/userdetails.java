/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.app.web.controllers.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.Role;
import com.system.app.web.beans.User;
import com.system.app.web.beans.UserData;

import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.RoleRepo;
import com.system.app.web.repo.UserDataRepo;
import com.system.app.web.repo.UserRepo;

/**
 *
 * @author costiss
 */
@WebServlet(name = "ClientUserdetails", urlPatterns = { "/manager/userdetails" })
public class userdetails extends HttpServlet {

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
        UserRepo userRepo = new UserRepo();
        RoleRepo roleRepo = new RoleRepo();
        try {
            UserData userData = userDataRepo.getByID(Integer.parseInt(request.getParameter("id")));
            User user = userRepo.getByID(Integer.parseInt(request.getParameter("id")));
            List<Role> roles = roleRepo.getAll();
            request.setAttribute("roles", roles);
            request.setAttribute("user", user);
            request.setAttribute("userData", userData);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/manager/userdetails.jsp");
            rd.forward(request, response);
        } catch (DAOException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Erro no banco de dados");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NullPointerException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro Nulo");
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

        UserData userData = new UserData();
        UserRepo userRepo = new UserRepo();
        UserDataRepo userDataRepo = new UserDataRepo();
        RoleRepo roleRepo = new RoleRepo();
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
            Role role = roleRepo.getByID(Integer.parseInt(request.getParameter("role")));
            user.setRole(role);
            if (!user.getEmail().equals(request.getParameter("email"))) {
                user.setEmail(request.getParameter("email"));
            }
            if (!user.getPassword().equals(request.getParameter("password"))) {
                user.setPassword(request.getParameter("password"));
            }
            userRepo.update(user);
            userDataRepo.update(userData);
        } catch (DAOException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Erro no banco de dados");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro Invalido");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
        } catch (NullPointerException e) {
            request.setAttribute("javaerror", e);
            request.setAttribute("error", "Parametro Nulo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/error.jsp");
            e.printStackTrace();
            rd.forward(request, response);
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
