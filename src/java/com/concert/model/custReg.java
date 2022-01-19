
package com.concert.model;

/**
 *
 * @author USER
 */
public class custReg implements java.io.Serializable{
    String cust_id;
    String cust_username;
    String cust_email;
    String cust_password;
    String cust_usertype;
    
    
    public custReg(){}

    //getter
    public String getCust_id(){
        return cust_id;
    }
    public String getCust_username() {
        return cust_username;
    }
    public String getCust_email() {
        return cust_email;
    }
    public String getCust_password() {
        return cust_password;
    }
    public String getCust_usertype() {
        return cust_usertype;
    }

    //setter
    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }
    public void setCust_username(String cust_username) {
        this.cust_username = cust_username;
    }
    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }
    public void setCust_password(String cust_password) {
        this.cust_password = cust_password;
    }
    public void setCust_usertype(String cust_usertype) {
        this.cust_usertype = cust_usertype;
    }
    
}


    

