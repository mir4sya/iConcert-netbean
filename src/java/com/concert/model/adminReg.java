/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concert.model;

public class adminReg implements java.io.Serializable{
    String admin_id;
    String admin_username;
    String admin_email;
    String admin_password;
    String admin_usertype;
    
    
    public adminReg(){}

    //getter
    public String getAdmin_id(){
        return admin_id;
    }
    public String getAdmin_username() {
        return admin_username;
    }
    public String getAdmin_email() {
        return admin_email;
    }
    public String getAdmin_password() {
        return admin_password;
    }
    public String getAdmin_usertype() {
        return admin_usertype;
    }

    //setter
    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }
    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }
    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }
    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    public void setAdmin_usertype(String admin_usertype) {
        this.admin_usertype = admin_usertype;
    }
    
}


