package com.system.app.web.beans;

import java.io.Serializable;

public class User implements Serializable {

    private Integer user_id;
    private String email;
    private String password;
    private Boolean isAuthenticated;
    private Role role;


    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User() {
        this.isAuthenticated = false;
    }

    public User(Integer id, String email, String pass) {
        this.user_id = id;
        this.email = email;
        this.password = pass;
    }

    public User(String email, String pass) {
        this.email = email;
        this.password = pass;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAuthenticated() {
        return isAuthenticated;
    }

    public void setIsAuthenticated(Boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    

}
