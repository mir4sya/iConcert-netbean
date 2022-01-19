/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import com.concert.model.adminReg;
import util.dbconnection;

public class adminRegDao {
    public String registerAdmin(adminReg admin ){
        
        //assign entered value into temporary
        String admin_id = admin.getAdmin_id();
        String admin_username = admin.getAdmin_username();
        String admin_email = admin.getAdmin_email();
        String admin_password = admin.getAdmin_password();
        String admin_usertype = admin.getAdmin_usertype();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO ADMIN(ADMIN_ID,ADMIN_USERNAME,ADMIN_EMAIL,ADMIN_PASSWORD,ADMIN_USERTYPE) VALUES(?,?,?,?,?)");
            
            pstmt.setString(1,admin_id);
            pstmt.setString(2,admin_username);
            pstmt.setString(3,admin_email);
            pstmt.setString(4,admin_password);
            pstmt.setString(5,admin_usertype);
           
            
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

