package com.concert.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;  
import javax.servlet.http.*;  
import com.concert.model.adminLogin;
import dao.adminLoginDao;
import util.dbconnection;

public class adminlogin extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            String admin_username = request.getParameter("admin_username");
            String admin_password = request.getParameter("admin_password");

            adminLogin l = new adminLogin();
            l.setAdmin_username(admin_username);
            l.setAdmin_password(admin_password);
            adminLoginDao logindao = new adminLoginDao();
            String uservalidate = logindao.authenticateUser(l);
            HttpSession session = request.getSession();
            if(uservalidate.equals("Success")){
                session.setAttribute("admin_username",admin_username);
                request.getRequestDispatcher("/homee.jsp").forward(request,response);
            }else{
                
                request.setAttribute("errMessage",uservalidate);
                request.getRequestDispatcher("/adminLogin.jsp").forward(request,response);
            }
      
        }catch(Exception e ){
            out.print("error:"+e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
        
}
