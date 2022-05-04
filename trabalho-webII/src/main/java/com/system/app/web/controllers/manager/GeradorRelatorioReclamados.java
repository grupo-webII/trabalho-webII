package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.HashMap;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.app.web.beans.AtendType;
import com.system.app.web.config.MySqlConnector;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


@WebServlet(name = "GeradorRelatorioReclamados", urlPatterns = { "/manager/GeradorRelatorioReclamados" })
public class GeradorRelatorioReclamados extends HttpServlet {

  private MySqlConnector conector = null;
  private String sql = null;

  public GeradorRelatorioReclamados() {
      this.conector = new MySqlConnector();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

    try (Connection conn = conector.getConn()) {// Host onde o servletesta executando 
      String host = "http://"+ request.getServerName() + ":" + request.getServerPort();  
      // Caminho contextualizado do relatório compilado
      String jasper = request.getContextPath() + "/reports/Reclamados.jasper";
      // URL para acesso ao relatório
      URL jasperURL = new URL(host + jasper);
      // Parâmetros do relatório
      HashMap params = new HashMap();
      // Geração do relatório
      byte[] bytes = JasperRunManager.runReportToPdf(
          jasperURL.openStream(),
          params,
          conn);
      if(bytes!= null) { // A página será mostrada em PDF
          response.setContentType("application/pdf");
          // EnviaoPDF para o Cliente
          OutputStream ops = response.getOutputStream();  
          ops.write(bytes);  
      } 
    }
    catch(DAOException e) {
      request.setAttribute("mensagem", "Erro de DAO : " + e.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }
    catch(JRException e) {
      request.setAttribute("mensagem", "Erro no Jasper: " + e.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }
    catch (SQLException e) {
      request.setAttribute("mensagem", "Erro de DAO : " + e.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }
  }
}
