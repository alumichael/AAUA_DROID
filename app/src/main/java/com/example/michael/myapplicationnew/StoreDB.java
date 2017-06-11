package com.example.michael.myapplicationnew;

/**
 * Created by MICHAEL on 5/17/2017.
 */

public class StoreDB {

    String username;

    String password;
    String email;
    String Password_Com;

    public void setPassword_Com(String password_Com) {
        Password_Com = password_Com;
    }
    public String getPassword_Com() {
        return Password_Com;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }


}
