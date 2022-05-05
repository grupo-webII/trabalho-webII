package com.system.app.web.controllers.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.util.HashMap;
import java.util.Date;  
import java.sql.Timestamp;   
import java.text.SimpleDateFormat;
import java.text.ParseException;  
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
import com.system.app.web.repo.DAOException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


@WebServlet(name = "GeradorRelatorioEmAberto", urlPatterns = { "/manager/GeradorRelatorioEmAberto" })
public class GeradorRelatorioEmAberto extends HttpServlet {

  private MySqlConnector conector = null;
  private String sql = null;

  public GeradorRelatorioEmAberto() {
      this.conector = new MySqlConnector();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {
      String data1 = request.getParameter("date1");
      String data2 =  request.getParameter("date2");
      System.out.println(data1);
      
    try (Connection conn = conector.getConn()) {// Host onde o servletesta executando 
      String host = "http://"+ request.getServerName() + ":" + request.getServerPort();  
      // Caminho contextualizado do relatório compilado
      String jasper = request.getContextPath() + "/reports/EmAberto.jasper";
      // URL para acesso ao relatório
      URL jasperURL = new URL(host + jasper);
      // Parâmetros do relatório
      
      String date_string = data1; //todo: Pegar o parametro que veio da chamada
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      Date date1 = formatter.parse(date_string);   
      Timestamp ts1 = new Timestamp(date1.getTime());  
      HashMap params = new HashMap<String, Object>();
      params.put("date1", ts1);

      date_string =  data2; //todo: Pegar o parametro que veio da chamada
      //Somar mais um dia na data que vier, ou fazer ela ser 23:59:59
      formatter = new SimpleDateFormat("yyyy-MM-dd");      
      Date date2 = formatter.parse(date_string);   
      Timestamp ts2 = new Timestamp(date2.getTime());
      params.put("date2", ts2);


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
    catch (ParseException e) {
      request.setAttribute("mensagem", "Erro de DAO : " + e.getMessage());
      request.getRequestDispatcher("error.jsp").forward(request, response);
    }
  }
}
