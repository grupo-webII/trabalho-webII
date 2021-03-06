package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.Role;
import com.system.app.web.config.MySqlConnector;

public class RoleRepo implements DAOinterface<Role> {

    private String sql = null;
    private MySqlConnector conector = null;

    public RoleRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean delete(Integer user_id) throws DAOException {
        sql = "DELETE FROM role WHERE user_id = ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user_id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("Delted Roles entry for user_id: " + user_id.toString());
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING Role by id: " + user_id.toString() + e.toString(), e);
        }
        return isDeleted;
    }

    @Override
    public List<Role> getAll() throws DAOException {
        sql = "SELECT * FROM role";
        List<Role> rolelist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Role role = new Role();
            while (rs.next()) {
                role = new Role();
                role.setUser_id(rs.getInt("user_id"));
                role.setROLE_CLIENTE(rs.getBoolean("ROLE_CLIENTE"));
                role.setROLE_GERENTE(rs.getBoolean("ROLE_GERENTE"));
                role.setROLE_FUNC(rs.getBoolean("ROLE_FUNC"));
                rolelist.add(role);
                role = null;
            }
        } catch (SQLException e) {
            rolelist = null;
            throw new DAOException("Error GETTING ALL Roles: " + e.toString(), e);

        }
        return rolelist;
    }

    @Override
    public Role getByID(Integer user_id) throws DAOException {
        sql = "SELECT * from role where user_id = ?";
        Role role = new Role();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                role.setUser_id(rs.getInt("user_id"));
                role.setROLE_CLIENTE(rs.getBoolean("ROLE_CLIENTE"));
                role.setROLE_GERENTE(rs.getBoolean("ROLE_GERENTE"));
                role.setROLE_FUNC(rs.getBoolean("ROLE_FUNC"));
            }
        } catch (SQLException e) {
            role = null;
            throw new DAOException("Error GETTING Role by id: " + user_id.toString() + e.toString(), e);
        }
        return role;
    }

    @Override
    public boolean save(Role role) throws DAOException {
        sql = "INSERT INTO role (user_id, ROLE_CLIENTE, ROLE_GERENTE, ROLE_FUNC)"
                +
                "VALUES (?,?,?,?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, role.getUser_id());
            statement.setBoolean(2, role.isROLE_CLIENTE());
            statement.setBoolean(3, role.isROLE_GERENTE());
            statement.setBoolean(4, role.isROLE_FUNC());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("Inserido nova Role para o user_id: " + role.getUser_id().toString());
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new User: " + e.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean update(Role role) throws DAOException {
        String sql = "UPDATE role SET ROLE_CLIENTE=?, ROLE_FUNC=?, ROLE_GERENTE=? WHERE id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setBoolean(1, role.isROLE_CLIENTE());
            statement.setBoolean(2, role.isROLE_FUNC());
            statement.setBoolean(3, role.isROLE_GERENTE());
            statement.setInt(4, role.getUser_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("Role atualizada para o user_id: " + role.getUser_id().toString());
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING Role: " + e.toString(), e);
        }
        return isUpdated;
    }

}
