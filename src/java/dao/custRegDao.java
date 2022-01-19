/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import com.concert.model.custReg;
import util.dbconnection;

public class custRegDao {
    public String registerCust(custReg cust){
        
        //assign entered value into temporary
        String cust_id = cust.getCust_id();
        String cust_username = cust.getCust_username();
        String cust_email = cust.getCust_email();
        String cust_password = cust.getCust_password();
        String cust_usertype = cust.getCust_usertype();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO CUSTOMER(CUST_ID,CUST_USERNAME,CUST_EMAIL,CUST_PASSWORD,CUST_USERTYPE) VALUES(?,?,?,?,?)");
            
            pstmt.setString(1,cust_id);
            pstmt.setString(2,cust_username);
            pstmt.setString(3,cust_email);
            pstmt.setString(4,cust_password);
            pstmt.setString(5,cust_usertype);
           
            
            int i = pstmt.executeUpdate();
            if(i>0){
                return "Success";
            }else{
                return "fail";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}

