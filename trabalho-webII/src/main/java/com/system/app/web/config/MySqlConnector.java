package com.system.app.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.system.app.web.repo.DAOException;

public class MySqlConnector implements AutoCloseable {
    private Connection conn = null;
    private Properties prop = new Properties();
    // Vai ler dados de src/main/resources/mysql.properties. Como se fosse um .env
    // Veja src/main/resources/mysql.properties.EXEMPLO para os dados
    private InputStream mysqlConf = MySqlConnector.class.getClassLoader().getResourceAsStream("mysql.properties");
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConn() throws DAOException {
        try {
            Class.forName(DRIVER);
            this.prop.load(this.mysqlConf);
            String connStr = String.format("%s?useSSL=false&" + "user=%s&password=%s",
                    this.prop.getProperty("mysql.url"),
                    this.prop.getProperty("mysql.username"), this.prop.getProperty("mysql.password"), "&useSSL=false");
            this.conn = DriverManager.getConnection(connStr);
            new MysqlTableInit(this.conn);

        } catch (ClassNotFoundException e) {
            throw new DAOException("Driver not found: " + DRIVER, e);
        } catch (SQLException e) {
            throw new DAOException("Database connection failed for server: " + this.prop.getProperty("mysql.url"), e);
        } catch (IOException e) {
            throw new DAOException("Mysql Configuration file(src/resources/mysql.properties) not found!", e);
        }
        return conn;
    }

    @Override
    public void close() throws DAOException {
        if (this.conn != null) {
            try {
                this.conn.close();
                this.conn = null;
            } catch (Exception e) {
                throw new DAOException("Error closing DB connection", e);
            }
        }
    }

}
