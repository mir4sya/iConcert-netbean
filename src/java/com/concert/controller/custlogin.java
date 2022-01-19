/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.concert.model.login;
import dao.LoginDao;
import util.dbconnection;

public class custlogin extends HttpServlet {
    
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
            String cust_username = request.getParameter("cust_username");
            String cust_password = request.getParameter("cust_password");

            login l = new login();
            l.setUsername(cust_username);
            l.setPassword(cust_password);
            LoginDao logindao = new LoginDao();
            String uservalidate = logindao.authenticateUser(l);
            HttpSession session = request.getSession();
            if(uservalidate.equals("Success")){
                session.setAttribute("cust_username",cust_username);
                request.getRequestDispatcher("/home.jsp").forward(request,response);
            }else{
                
                request.setAttribute("errMessage",uservalidate);
                request.getRequestDispatcher("/custLogin.jsp").forward(request,response);
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
