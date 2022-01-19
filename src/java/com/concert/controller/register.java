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
import com.concert.model.custReg;
import dao.custRegDao;
import util.dbconnection;

public class register extends HttpServlet {
    
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
        String cust_id = request.getParameter("cust_id");
        String cust_username = request.getParameter("cust_username");
        String cust_email = request.getParameter("cust_email");
        String cust_password = request.getParameter("cust_password");
        String cust_usertype = request.getParameter("cust_usertype");
        String confirm = request.getParameter("confirm");
        
        try{
            //check confirm pass same with password or not
            if(!confirm.equals(cust_password)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Password Not Match!');");
                out.println("location='registration.html';");
                out.println("</script>");
            }else if(confirm.equals(cust_password)){
//                out.println(checkUser(cust_username));
                //if yes, check if cust username already exist or not
                if(checkUser(cust_username).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Customer already exist!');");
                    out.println("location='registration.html';");
                    out.println("</script>");
                }else if(checkUser(cust_username).equals("pass")){
                    //set value into custReg
                    custReg cust = new custReg();
                    cust.setCust_id(cust_id);
                    cust.setCust_username(cust_username);
                    cust.setCust_email(cust_email);
                    cust.setCust_password(cust_password);
                    cust.setCust_usertype(cust_usertype);
                   
                    
                    //run sql
                    custRegDao custDao = new custRegDao();
                    String regis = custDao.registerCust(cust);
                    //out.println(regis);
                    if(regis.equals("Success")){
                       // out.println(regis);
                        out.println("<script>");
                        out.println("alert('Successfully Registered!');");
                        out.println("location='custLogin.jsp';");
                        out.println("</script>");
                    }else if(regis.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Fail to register!');");
                        out.println("location='registration.html';");
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
    
    private String checkUser(String cust_username){
        
         try{   
            Connection conn = null;
            Statement statement = null;
            ResultSet resultSet = null;
            conn = dbconnection.createConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT CUST_USERNAME FROM CUSTOMER");
            while(resultSet.next()){
                String username = resultSet.getString("CUST_USERNAME");
                if(cust_username.equals(username)){
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
