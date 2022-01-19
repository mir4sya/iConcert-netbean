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
import com.concert.model.addConcert;
import dao.addConcertDao;
import util.dbconnection;

public class addconcert extends HttpServlet {
    
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
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
       //obtain parameters from the client
        String admin_username = request.getParameter("admin_username");
        String admin_email = request.getParameter("admin_email");
        String concert_name = request.getParameter("concert_name");
        String concert_date = request.getParameter("concert_date");
        String concert_time = request.getParameter("concert_time");
        String confirm = request.getParameter("confirm");
        
        try{
            //check confirm pass same with password or not
            if(!confirm.equals(admin_email)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Email Not Match!');");
                out.println("location='addconcert.jsp';");
                out.println("</script>");
            }else if(confirm.equals(admin_email)){
//                out.println(checkUser(cust_username));
                //if yes, check if cust username already exist or not
                if(checkUser(admin_email).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Error!');");
                    out.println("location='addconcert.jsp';");
                    out.println("</script>");
                }else if(checkUser(admin_username).equals("pass")){
                    //set value into addConcert
                    addConcert concert = new addConcert();
                    concert.setAdmin_username(admin_username);
                    concert.setAdmin_email(admin_email);
                    concert.setConcert_name(concert_name);
                    concert.setConcert_date(concert_date);
                    concert.setConcert_time(concert_time);
                   
                    
                    //run sql
                    addConcertDao concertDao = new addConcertDao();
                    String c = concertDao.iConcert(concert);
                    //out.println(regis);
                    if(c.equals("Success")){
                       // out.println(regis);
                        out.println("<script>");
                        out.println("alert('Successfully Add Concert!');");
                        out.println("location='concertdetails.jsp';");
                        out.println("</script>");
                    }else if(c.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Fail to add new concert!');");
                        out.println("location='addconcert.jsp';");
                        out.println("</script>");
                    }
                }
            }
        } catch (Exception ex){
            out.println("Error: "+ex.getMessage());
        } finally{
            out.close();
        }
    }
       
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String checkUser(String admin_username){
        
         try{   
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
            conn = dbconnection.createConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT ADMIN_USERNAME FROM CONCERT");
            while(resultSet.next()){
                String username = resultSet.getString("ADMIN_USERNAME");
                if(admin_username.equals(username)){
                    return "fail";
                }else {
                    return "pass";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "pass";
    }
}
