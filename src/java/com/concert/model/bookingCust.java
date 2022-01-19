/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concert.model;

/**
 *
 * @author USER
 */
public class bookingCust {
    String cust_username;
    String cust_phoneno;
    String cust_section;
    String cust_quantity;
    
    
    public bookingCust(){}

    //getter
    public String getCust_username() {
        return cust_username;
    }
    public String getCust_phoneno() {
        return cust_phoneno;
    }
    public String getCust_section() {
        return cust_section;
    }
    public String getCust_quantity() {
        return cust_quantity;
    }

    //setter
    public void setCust_username(String cust_username) {
        this.cust_username = cust_username;
    }
    public void setCust_phoneno(String cust_phoneno) {
        this.cust_phoneno = cust_phoneno;
    }
    public void setCust_section(String cust_section) {
        this.cust_section = cust_section;
    }
    public void setCust_quantity(String cust_quantity) {
        this.cust_quantity = cust_quantity;
    }
    
}


    


    

