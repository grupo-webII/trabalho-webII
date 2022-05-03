package com.system.app.web.beans;

import java.io.Serializable;

public class FullUser implements Serializable {
    User user;
    UserData userData;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

}
