package com.system.app.web.repo;

public class DAOException extends Exception {

    public DAOException() {

    }

    public DAOException(String msg) {
        super(msg);
    }

    public DAOException(String msg, Throwable thrwbl) {
        super(msg, thrwbl);
    }
}
