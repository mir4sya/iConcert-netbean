
package dao;
import java.sql.*;
import util.dbconnection;
import com.concert.model.adminLogin;

/**
 *
 * @author USER
 */
public class adminLoginDao {
        public String authenticateUser (adminLogin loginBean){
        
        //assign user entered values to temporary
        String admin_username = loginBean.getAdmin_username(); 
        String admin_password = loginBean.getAdmin_password();
        
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String userNameDB = "";
        String passwordDB = "";
        
        try{
            //fetch database connection object
            conn = dbconnection.createConnection();
            //statement is used to write queries 
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT ADMIN_USERNAME,ADMIN_PASSWORD FROM ADMIN");
            //until the next row is present otherwise it return false
            while(resultSet.next()){
                userNameDB = resultSet.getString("admin_username");
                passwordDB = resultSet.getString("admin_password");
                if(admin_username.equals(userNameDB)&& admin_password.equals(passwordDB)){
                    return "Success";
                }else if(!admin_username.equals(userNameDB)&& admin_password.equals(passwordDB)|| 
                        admin_username.equals(userNameDB)&& !admin_password.equals(passwordDB)){
                    return "Username and Password not match!";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}

    

    

