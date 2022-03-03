package com.system.app.web.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class MySqlConnector {
    Connection conn = null;
    Properties prop = new Properties();
    InputStream mysqlConf = MySqlConnector.class.getClassLoader().getResourceAsStream("mysql.properties");

    public MySqlConnector() {
        try {
            this.prop.load(this.mysqlConf);
            String connStr = String.format("%s?" + "user=%s&password=%s", this.prop.getProperty("mysql.url"),
                    this.prop.getProperty("mysql.username"), this.prop.getProperty("mysql.password"));
            this.conn = DriverManager.getConnection(connStr);

            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS User ( " +
                    "name VARCHAR(50)," +
                    "lastname VARCHAR(100) ," +
                    "cpf VARCHAR(11)," +
                    "phone varchar(11)," +
                    "email varchar(100) unique," +
                    "password varchar(200)," +
                    "cep varchar(8)," +
                    "address varchar (200)," +
                    "addressNumber varchar(10)," +
                    "complement varchar(100)," +
                    "bairro varchar(50)," +
                    "city varchar(100)," +
                    "state varchar(50)," +
                    "primary key(cpf)" +
                    ")";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Connection getConn() {
        return conn;
    }

}
