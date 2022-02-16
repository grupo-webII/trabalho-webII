package com.system.app.web.config;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.system.app.web.models.User;

public class UserRepository {

    Field[] fields;
    Connection conn = null;
    Statement stmt = null;
    String sql = null;

    UserRepository() {
        try {
            this.conn = new MySqlConnector().conn;
            this.stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS User ( " +
                    "name VARCHAR(50)," +
                    "lastname VARCHAR(100) ," +
                    "cpf VARCHAR(11)," +
                    "phone varchar(11)," +
                    "email varchar(100)," +
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

    void save(User user) throws SQLException {
        sql = "INSERT INTO User (name, lastname, cpf, phone, email, password, cep, address, addressNumber, complement, bairro, city, state)"
                +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getLastname());
        statement.setString(3, user.getCpf());
        statement.setString(4, user.getPhone());
        statement.setString(5, user.getEmail());
        statement.setString(6, user.getPassword());
        statement.setString(7, user.getCep());
        statement.setString(8, user.getAddress());
        statement.setString(9, user.getAdressNumb());
        statement.setString(10, user.getComplement());
        statement.setString(11, user.getBairro());
        statement.setString(12, user.getCity());
        statement.setString(13, user.getState());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Inserido novo user!");
        } else {
            throw new SQLException("Algo de errado no BD");
        }
    }

    User getUserByCPF(String cpf) throws SQLException {
        sql = "SELECT * from User where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        ResultSet rs = statement.executeQuery();
        User user = new User();
        while (rs.next()) {
            user.setName(rs.getString(1));
            user.setLastname(rs.getString(2));
            user.setCpf(rs.getString(3));
            user.setPhone(rs.getString(4));
            user.setEmail(rs.getString(5));
            user.setPassword(rs.getString(6));
            user.setCep(rs.getString(7));
            user.setAddress(rs.getString(8));
            user.setAdressNumb(rs.getString(9));
            user.setComplement(rs.getString(10));
            user.setBairro(rs.getString(11));
            user.setCity(rs.getString(12));
            user.setState(rs.getString(13));
        }
        return user;
    }

}


