package com.system.app.web.DTO;

public class User {

    Integer user_id;
    String email;
    String password;

    public User() {
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

}
