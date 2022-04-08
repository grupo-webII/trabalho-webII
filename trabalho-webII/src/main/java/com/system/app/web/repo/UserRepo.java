package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.Role;
import com.system.app.web.beans.User;
import com.system.app.web.config.MySqlConnector;

public class UserRepo implements DAOinterface<User> {

    private Connection conn = null;
    private String sql = null;

    public UserRepo() throws DAOException {
        try {
            this.conn = new MySqlConnector().getConn();
        } catch (DAOException e) {
            throw new DAOException("Error establishing connection with DB", e);
        }
    }

    @Override
    public boolean save(User user) throws DAOException {
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
            }
            User savedUser = getUserByEmail(user.getEmail());
            Role newRole = new Role();
            newRole.setUser_id(savedUser.getUser_id());
            boolean roleRepo = new RoleRepo().save(newRole);
            if (roleRepo) {
                System.out.println("Saved default Role for User: " + savedUser.getUser_id().toString());
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new User: " + sql + "/" + user.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM user WHERE id = ?";
        boolean isDeleted = false;
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            RoleRepo roleRepo = new RoleRepo();
            roleRepo.delete(id);
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("User deletado!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING User by id: " + sql + "/" + id.toString(), e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(User user) throws DAOException {
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
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING User: " + sql + "/" + user.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<User> getAll() throws DAOException {
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
                user.setRole(new RoleRepo().getByID(rs.getInt("user_id")));
                userlist.add(user);
                user = null;
            }
        } catch (SQLException e) {
            userlist = null;
            throw new DAOException("Error GETTING ALL Users: " + sql, e);

        }
        return userlist;
    }

    @Override
    public User getByID(Integer id) throws DAOException {
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
                user.setRole(new RoleRepo().getByID(rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            user = null;
            throw new DAOException("Error GETTING User by id: " + sql + "/" + id.toString(), e);

        }

        return user;

    }

    public User getUserByEmail(String email) throws DAOException {
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
                user.setRole(new RoleRepo().getByID(rs.getInt("user_id")));
            }
        } catch (SQLException e) {
            user = null;
            throw new DAOException("Error GETTING User by email: " + sql + "/" + email.toString(), e);
        }

        return user;
    }

    public User handleLogin(String email, String testPassword) throws DAOException {
        sql = "SELECT password from User where email = ?";
        User user = null;
        try {
            // PreparedStatement statement = conn.prepareStatement(sql);
            // statement.setString(1, email);
            // ResultSet rs = statement.executeQuery();
            // while (rs.next()) {
            // user = new User();
            // user.setEmail(rs.getString("email"));
            // user.setUser_id(rs.getInt("user_id"));
            // user.setRole(new RoleRepo().getByID(rs.getInt("user_id")));
            // }
            user = getUserByEmail(email);
            if (!user.getPassword().equals(testPassword)) {
                user.setIsAuthenticated(true);
                System.out.println("Authenticated User: " + user.getEmail());
            }
        } catch (DAOException e) {
            user = null;
            throw new DAOException("Error AUTHENTICATING user: " + sql + "/" + email.toString(), e);
        }
        return user;
    }

}