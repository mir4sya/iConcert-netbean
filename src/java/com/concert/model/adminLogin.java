/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concert.model;

public class adminLogin implements java.io.Serializable {
    
    String admin_username;
    String admin_password;
    
    public adminLogin(){}
    
    //constructor
    public adminLogin(String admin_username, String admin_password) {
        this.admin_username = admin_username;
        this.admin_password = admin_password;
    }
    
    //getter
    public String getAdmin_username() {
        return admin_username;
    }
    public String getAdmin_password() {
        return admin_password;
    }

    //setter
    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }
    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    
}


