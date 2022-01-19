/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import com.concert.model.addConcert;
import util.dbconnection;
public class addConcertDao {
     public String iConcert(addConcert concert ){
         
        //assign entered value into temporary
        String admin_username = concert.getAdmin_username();
        String admin_email = concert.getAdmin_email();
        String concert_name = concert.getConcert_name();
        String concert_date = concert.getConcert_date();
        String concert_time = concert.getConcert_time();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("INSERT INTO CONCERT(ADMIN_USERNAME,ADMIN_EMAIL,CONCERT_NAME,CONCERT_DATE,CONCERT_TIME) VALUES(?,?,?,?,?)");
            
            pstmt.setString(1,admin_username);
            pstmt.setString(2,admin_email);
            pstmt.setString(3,concert_name);
            pstmt.setString(4,concert_date);
            pstmt.setString(5,concert_time);
           
            
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


