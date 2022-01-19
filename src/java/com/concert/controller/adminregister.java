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
import com.concert.model.adminReg;
import dao.adminRegDao;
import util.dbconnection;

public class adminregister extends HttpServlet {
    
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
        String admin_id = request.getParameter("admin_id");
        String admin_username = request.getParameter("admin_username");
        String admin_email = request.getParameter("admin_email");
        String admin_password = request.getParameter("admin_password");
        String admin_usertype = request.getParameter("admin_usertype");
        String confirm = request.getParameter("confirm");
        
        try{
            //check confirm pass same with password or not
            if(!confirm.equals(admin_password)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password Not Match!');");
                out.println("location='adminregistration.html';");
                out.println("</script>");
            }else if(confirm.equals(admin_password)){
//                out.println(checkUser(cust_username));
                //if yes, check if cust username already exist or not
                if(checkUser(admin_username).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Customer already exist!');");
                    out.println("location='adminregistration.html';");
                    out.println("</script>");
                }else if(checkUser(admin_username).equals("pass")){
                    //set value into custReg
                    adminReg admin = new adminReg();
                    admin.setAdmin_id(admin_id);
                    admin.setAdmin_username(admin_username);
                    admin.setAdmin_email(admin_email);
                    admin.setAdmin_password(admin_password);
                    admin.setAdmin_usertype(admin_usertype);
                   
                    
                    //run sql
                    adminRegDao adminDao = new adminRegDao();
                    String regis = adminDao.registerAdmin(admin);
                    //out.println(regis);
                    if(regis.equals("Success")){
                       // out.println(regis);
                        out.println("<script>");
                        out.println("alert('Successfully Registered!');");
                        out.println("location='adminLogin.jsp';");
                        out.println("</script>");
                    }else if(regis.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Fail to register!');");
                        out.println("location='adminregistration.html';");
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
            resultSet = statement.executeQuery("SELECT ADMIN_USERNAME FROM ADMIN");
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
