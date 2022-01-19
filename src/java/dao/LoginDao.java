package dao;
import java.sql.*;
import util.dbconnection;
import com.concert.model.login;
/**
 *
 * @author USER
 */
public class LoginDao {
    public String authenticateUser (login loginBean){
        
        //assign user entered values to temporary
        String username = loginBean.getUsername(); 
        String password = loginBean.getPassword();
        
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
            resultSet = statement.executeQuery("SELECT CUST_USERNAME,CUST_PASSWORD FROM CUSTOMER");
            //until the next row is present otherwise it return false
            while(resultSet.next()){
                userNameDB = resultSet.getString("cust_username");
                passwordDB = resultSet.getString("cust_password");
                if(username.equals(userNameDB)&& password.equals(passwordDB)){
                    return "Success";
                }else if(!username.equals(userNameDB)&& password.equals(passwordDB)|| 
                        username.equals(userNameDB)&& !password.equals(passwordDB)){
                    return "Username and Password not match!";
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Invalid User Credentials";
    }
}

    
