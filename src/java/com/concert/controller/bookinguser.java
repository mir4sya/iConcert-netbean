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
import com.concert.model.bookingCust;
import dao.bookingCustDao;
import util.dbconnection;

public class bookinguser extends HttpServlet {
    
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
        String cust_username = request.getParameter("cust_username");
        String cust_phoneno = request.getParameter("cust_phoneno");
        String cust_section = request.getParameter("cust_section");
        String cust_quantity = request.getParameter("cust_quantity");
        String confirm = request.getParameter("confirm");
        
        try{
        //check confirm pass same with password or not
            if(!confirm.equals(cust_phoneno)){
                out.println("<script type=\"text/javascript\">");
                out.println("alert('No phone not match!');");
                out.println("location='custbooking.jsp';");
                out.println("</script>");
            }else if(confirm.equals(cust_phoneno)){
//                out.println(checkUser(cust_username));
                //if yes, check if cust username already exist or not
                if(checkUser(cust_username).equals("fail")){
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Customer booking already exist!');");
                    out.println("location='custbooking.jsp';");
                    out.println("</script>");
                }else if(checkUser(cust_username).equals("pass")){
                    //set value into bookingCust
                    bookingCust cs = new bookingCust();
                    cs.setCust_username(cust_username);
                    cs.setCust_phoneno(cust_phoneno);
                    cs.setCust_section(cust_section);
                    cs.setCust_quantity(cust_quantity);
                   
                    
                    //run sql
                    bookingCustDao custDao = new bookingCustDao();
                    String book = custDao.bookCust(cs);
                    //out.println(regis);
                    if(book.equals("Success")){
                       // out.println(regis);
                        out.println("<script>");
                        out.println("alert('Successfully booked!');");
                        out.println("location='displaydata.jsp';");
                        out.println("</script>");
                    }else if(book.equals("fail")){
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('Failed to make a booking!');");
                        out.println("location='custbooking.jsp';");
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
            resultSet = statement.executeQuery("SELECT CUST_USERNAME FROM BOOKINGUSER");
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
