package com.system.app.web.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.system.app.web.service.MysqlService;

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
            new MysqlService(this.conn);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Connection getConn() {
        return conn;
    }

}
