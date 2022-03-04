package com.system.app.web.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlService {

    Connection conn;

    public MysqlService(Connection connection) {
        this.conn = connection;
        try {
            Statement stmt = conn.createStatement();
            String[] sql =
                    // USER TABLE
                    { "CREATE TABLE IF NOT EXISTS user (" +
                            "user_id int not null auto_increment," +
                            "email VARCHAR(100) unique," +
                            "password VARCHAR(100)," +
                            "PRIMARY KEY (user_id)" +
                            ");",
                            // ROLES TABLE
                            "CREATE TABLE IF NOT EXISTS role (" +
                                    "user_id int not null," +
                                    "ROLE_CLIENTE TINYINT(1) DEFAULT 1," +
                                    "ROLE_FUNC TINYINT(1) DEFAULT 0," +
                                    "ROLE_GERENTE TINYINT(1) DEFAULT 0," +
                                    "PRIMARY KEY (user_id)," +
                                    "FOREIGN KEY (user_id) REFERENCES user(user_id) " +
                                    ");",
                            // USER DATA TABLE
                            "CREATE TABLE IF NOT EXISTS userData ( " +
                                    "user_id int not null," +
                                    "name VARCHAR(50)," +
                                    "lastname VARCHAR(100) ," +
                                    "cpf VARCHAR(11) unique," +
                                    "phone varchar(11)," +
                                    "cep varchar(8)," +
                                    "address varchar (200)," +
                                    "addressNumber varchar(10)," +
                                    "complement varchar(100)," +
                                    "bairro varchar(50)," +
                                    "city varchar(100)," +
                                    "state varchar(50)," +
                                    "primary key(cpf)," +
                                    "FOREIGN KEY (user_id) REFERENCES user(user_id)" +
                                    ");" };
            for (int i = 0; i < sql.length; i++) {
                stmt.executeUpdate(sql[i]);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
