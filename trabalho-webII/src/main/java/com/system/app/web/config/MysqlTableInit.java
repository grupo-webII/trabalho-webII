package com.system.app.web.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.system.app.web.repo.DAOException;

public class MysqlTableInit {

    Connection conn;

    public MysqlTableInit(Connection connection) throws DAOException {
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
                                    "FOREIGN KEY (user_id) REFERENCES user(user_id) "
                                    +
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
                                    "FOREIGN KEY (user_id) REFERENCES user(user_id)"
                                    +
                                    ");",
                            // CATEGORIA DOS PRODUTOS
                            "CREATE TABLE IF NOT EXISTS productCategory (" +
                                    "cat_id int not null auto_increment" +
                                    "name VARCHAR(50)," +
                                    "primary key(name)" +
                                    ");",
                            // PRODUTOS
                            "CREATE TABLE IF NOT EXISTS product (" +
                                    "product_id int not null auto_increment," +
                                    "name VARCHAR(50)," +
                                    "category int," +
                                    "description TEXT," +
                                    "weight DECIMAL(10, 2)," +
                                    "primary key(product_id)," +
                                    "FOREIGN KEY (category) REFERENCES productCategory(cat_id)"
                                    +
                                    ");",
                            // TIPO DE ATENDIMENTO
                            "CREATE TABLE IF NOT EXISTS attType (" +
                                    "type_id int not null auto_increment" +
                                    "name VARCHAR(50)," +
                                    "primary key(name)" +
                                    ");",
                            // ATENDIMENTOS
                            "CREATE TABLE IF NOT EXISTS att (" +
                                    "at_id int not null auto_increment," +
                                    "data TIMESTAMP," +
                                    "client int not null," +
                                    "status VARCHAR(10)," +
                                    "product int not null," +
                                    "type int," +
                                    "description TEXT," +
                                    "solution TEXT," +
                                    "primary key(at_id)," +
                                    "FOREIGN KEY (type) REFERENCES attType(type_id)" +
                                    ");"

                    };
            for (int i = 0; i < sql.length; i++) {
                stmt.executeUpdate(sql[i]);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new DAOException("Failed to Initialize Tables", e);
        }

    }
}
