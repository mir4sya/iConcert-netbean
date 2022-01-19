/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import com.concert.model.bookingCust;
import util.dbconnection;

public class bookingCustDao {
     public String bookCust(bookingCust cs){
        
        //assign entered value into temporary
        String cust_username = cs.getCust_username();
        String cust_phoneno = cs.getCust_phoneno();
        String cust_section = cs.getCust_section();
        String cust_quantity = cs.getCust_quantity();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO BOOKINGUSER(CUST_USERNAME,CUST_PHONENO,CUST_SECTION,CUST_QUANTITY) VALUES(?,?,?,?)");
            
            pstmt.setString(1,cust_username);
            pstmt.setString(2,cust_phoneno);
            pstmt.setString(3,cust_section);
            pstmt.setString(4,cust_quantity);
           
            
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


