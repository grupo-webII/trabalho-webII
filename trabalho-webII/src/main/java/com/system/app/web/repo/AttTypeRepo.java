package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.AtendType;
import com.system.app.web.config.MySqlConnector;

public class AttTypeRepo implements DAOinterface<AtendType> {

    private MySqlConnector conector = null;
    private String sql = null;

    public AttTypeRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean save(AtendType type) throws DAOException {
        sql = "INSERT INTO attType (type_id, name)"
                +
                "VALUES (?,?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, type.getType_id());
            statement.setString(2, type.getName());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("INSERTED new AttType: " + type.getName());
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new AttType: " + sql + "/" + type.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM attType WHERE type_id = ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("DELETED AttType " + id.toString() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING AttType by id: " + sql + "/" + id.toString(), e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(AtendType cat) throws DAOException {
        String sql = "UPDATE attType SET name=? WHERE type_id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cat.getName());
            statement.setInt(2, cat.getType_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("UPDATED AttType " + cat.getName() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING AttType: " + sql + "/" + cat.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<AtendType> getAll() throws DAOException {
        sql = "SELECT * FROM attType";
        List<AtendType> typeList = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            AtendType type;
            while (rs.next()) {
                type = new AtendType();
                type.setType_id(rs.getInt("type_id"));
                type.setName(rs.getString("name"));
                typeList.add(type);
                type = null;
            }
        } catch (SQLException e) {
            typeList = null;
            throw new DAOException("Error GETTING ALL AttType: " + sql, e);

        }
        return typeList;
    }

    @Override
    public AtendType getByID(Integer id) throws DAOException {
        sql = "SELECT * from attType where type_id = ?";
        AtendType type = new AtendType();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                type.setType_id(rs.getInt("cat_id"));
                type.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            type = null;
            throw new DAOException("Error GETTING AttType by id: " + sql + "/" + id.toString(), e);

        }
        return type;
    }

}
