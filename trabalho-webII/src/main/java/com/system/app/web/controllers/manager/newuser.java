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
@WebServlet(name = "ClientNewuser", urlPatterns = { "/manager/newuser" })
public class newuser extends HttpServlet {

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

        RoleRepo roleRepo = new RoleRepo();
        try {
            List<Role> roles = roleRepo.getAll();
            request.setAttribute("roles", roles);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/views/manager/newuser.jsp");
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
     * @param request  servlet requestÃ£o Sallumrror occurs
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
            userData.setAdressNumber(Integer.parseInt(request.getParameter("adressNumber")));
            userData.setComplement(request.getParameter("complement"));
            userData.setState(request.getParameter("state"));

            String roleP = request.getParameter("role");
            Role role = new Role();
            if (roleP.equals("gerente")) {
                role.setROLE_GERENTE(true);
            } else if (roleP.equals("funcionario")) {
                role.setROLE_GERENTE(false);
                role.setROLE_FUNC(true);
            } else {
                role.setROLE_GERENTE(false);
                role.setROLE_FUNC(false);
                role.setROLE_CLIENTE(true);
            }
            User user = new User();
            user.setRole(role);
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            userRepo.save(user);
            user = userRepo.getUserByEmail(request.getParameter("email"));

            userData.setUser_id(user.getUser_id());
            userDataRepo.save(userData);
            response.sendRedirect("main");

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
