package com.system.app.web.repo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.DTO.User;
import com.system.app.web.config.MySqlConnector;

public class UserRepository implements UserRepoInterface {

    Field[] fields;
    Connection conn = null;
    String sql = null;
    User user;

    UserRepository() {
        try {
            this.user = null;
            this.conn = new MySqlConnector().getConn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    UserRepository(User user) {
        try {
            this.user = user;
            this.conn = new MySqlConnector().getConn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void save() throws SQLException {
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

    @Override
    public void delete() throws SQLException {
        sql = "DELETE FROM User WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, user.getCpf());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("User deletado!");
        } else {
            throw new SQLException("User não existe");
        }
    }

    @Override
    public void update() throws SQLException {
        String sql = "UPDATE User SET name=?, lastname=?, phone=?, email=?, password=?," +
                "cep=?, address=?, addressNumber=?, complement=?, bairro=?, city=?, state=? WHERE cpf = ?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, this.user.getName());
        statement.setString(2, this.user.getLastname());
        statement.setString(3, this.user.getPhone());
        statement.setString(4, this.user.getEmail());
        statement.setString(5, this.user.getPassword());
        statement.setString(6, this.user.getCep());
        statement.setString(7, this.user.getAddress());
        statement.setString(8, this.user.getAdressNumb());
        statement.setString(9, this.user.getComplement());
        statement.setString(10, this.user.getBairro());
        statement.setString(11, this.user.getCity());
        statement.setString(12, this.user.getState());
        statement.setString(13, this.user.getCpf());
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("User atualizado!");
        } else {
            throw new SQLException("User não existe");
        }

    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        sql = "SELECT * FROM User";
        List<User> userlist = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            User user = new User();
            while (rs.next()) {
                user = new User();
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
                userlist.add(user);
                user = null;
            }
        } catch (Exception e) {
            if (e != null) {
                user = null;
                System.out.println(e);
                throw new SQLException("erro no bd");
            }
        }
        return userlist;
    }

    @Override
    public User getUserByCPF(String cpf) throws SQLException {
        sql = "SELECT * from User where cpf = ?";
        User user = new User();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cpf);
            ResultSet rs = statement.executeQuery();
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
        } catch (Exception e) {
            if (e != null) {
                user = null;
                throw new SQLException("User não existe");
            }
        }

        return user;

    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        sql = "SELECT * from User where email = ?";
        User user = new User();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
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
        } catch (Exception e) {
            if (e != null) {
                user = null;
                throw new SQLException("User not found!");
            }
        }

        return user;
    }

}

