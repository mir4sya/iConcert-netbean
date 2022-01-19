/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concert.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import com.concert.model.addConcert;
import dao.concertUpdateDao;
import javax.servlet.http.HttpSession;
import util.dbconnection;

public class concertupdate extends HttpServlet {
        
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
        try{
          String admin_username = request.getParameter("newadmin_username");
          String admin_email = request.getParameter("newadmin_email");
          String concert_name = request.getParameter("newconcert_name");
          String concert_date = request.getParameter("newconcert_date");
          String concert_time = request.getParameter("newconcert_time");
        
            //set value into donorReg
            addConcert co = new addConcert();
            co.setAdmin_username(admin_username);
            co.setAdmin_email(admin_email);
            co.setConcert_name(concert_name);
            co.setConcert_date(concert_date);
            co.setConcert_time(concert_time);
                 
            //run sql
            concertUpdateDao coDao = new concertUpdateDao();
            String update = coDao.updateConcert(co);            
            HttpSession session = request.getSession();
            if(update.equals("Success")){
                session.setAttribute("admin_username",admin_username);
                request.getRequestDispatcher("/concertdetails.jsp").forward(request,response);
            }else{
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Fail to update!');");
                out.println("location='addconcert.jsp';");
                out.println("</script>");
            }
        }catch(Exception e ){
            out.print("error:"+e); }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
