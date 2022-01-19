
package dao;
import java.sql.*;
import com.concert.model.addConcert;
import util.dbconnection;

public class concertUpdateDao {
    public String updateConcert(addConcert co){
        
        //assign entered value into temporary
        String admin_username = co.getAdmin_username();
        String admin_email = co.getAdmin_email();
        String concert_name = co.getConcert_name();
        String concert_date = co.getConcert_date();
        String concert_time = co.getConcert_time();
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try{
            //fetch database connection object
            con = dbconnection.createConnection();
            //statement used to write queries
            pstmt = con.prepareStatement("UPDATE CONCERT SET ADMIN_USERNAME=?,ADMIN_EMAIL=?,CONCERT_NAME=?,CONCERT_DATE=?,CONCERT_TIME=? WHERE ADMIN_USERNAME=?");
            
            pstmt.setString(1,admin_username);
            pstmt.setString(2,admin_email);
            pstmt.setString(3,concert_name);
            pstmt.setString(4,concert_date);
            pstmt.setString(5,concert_time);
            pstmt.setString(6,admin_username);
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
