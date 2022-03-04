package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.system.app.web.DTO.User;
import com.system.app.web.config.MySqlConnector;

public class UserRepo implements UserRepoInterface {

    Connection conn = null;
    String sql = null;

    public UserRepo() {
        try {
            this.conn = new MySqlConnector().getConn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public boolean save(User user) {
        sql = "INSERT INTO user (email, password)"
                +
                "VALUES (?,?)";
        boolean isSaved = false;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("Inserido novo user!");
            } else {
                throw new SQLException("Algo de errado no BD");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(String email) {
        sql = "DELETE FROM user WHERE email = ?";
        boolean isDeleted = false;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("User deletado!");
            } else {
                throw new SQLException("User não existe");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(User user) {
        String sql = "UPDATE user SET email=?, password=? WHERE id = ?";
        boolean isUpdated = false;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getUser_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("User atualizado!");
            } else {
                throw new SQLException("User não existe");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return isUpdated;

    }

    @Override
    public List<User> getAllUsers() {
        sql = "SELECT * FROM user";
        List<User> userlist = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            User user = new User();
            while (rs.next()) {
                user = new User();
                user.setUser_id(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                userlist.add(user);
                user = null;
            }
        } catch (Exception e) {
            if (e != null) {
                userlist = null;
                System.out.println(e);
            }
        }
        return userlist;
    }

    @Override
    public User getUserByID(Integer id) {
        sql = "SELECT * from user where id = ?";
        User user = new User();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUser_id(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            if (e != null) {
                user = null;
                System.out.println(e);
            }
        }

        return user;

    }

    @Override
    public User getUserByEmail(String email) {
        sql = "SELECT * from User where email = ?";
        User user = new User();
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUser_id(rs.getInt("user_id"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
            }
        } catch (Exception e) {
            if (e != null) {
                user = null;
                System.out.println(e);

            }
        }

        return user;
    }

    @Override
    public User handleLogin(String email, String testPassword) {
        sql = "SELECT password from User where email = ?";
        User user = null;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
                user.setUser_id(rs.getInt("user_id"));
            }
            if (!user.getPassword().equals(testPassword)) {
                user.setIsAuthenticated(true);
            }
        } catch (Exception e) {
            if (e != null) {
                user = null;
            }
        }
        return user;
    }

}