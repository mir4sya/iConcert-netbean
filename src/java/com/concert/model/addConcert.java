/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.concert.model;

public class addConcert implements java.io.Serializable{
    String admin_username;
    String admin_email;
    String concert_name;
    String concert_date;
    String concert_time;
    
    
    public addConcert(){}

    //getter
    public String getAdmin_username() {
        return admin_username;
    }
    public String getAdmin_email() {
        return admin_email;
    }
    public String getConcert_name() {
        return concert_name;
    }
    public String getConcert_date() {
        return concert_date;
    }
    public String getConcert_time() {
        return concert_time;
    }
    

    //setter
    public void setAdmin_username(String admin_username) {
        this.admin_username = admin_username;
    }
    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }
    public void setConcert_name(String concert_name) {
        this.concert_name = concert_name;
    }
    public void setConcert_date(String concert_date) {
        this.concert_date = concert_date;
    }
    public void setConcert_time(String concert_time) {
        this.concert_time = concert_time;
    }
    
}


