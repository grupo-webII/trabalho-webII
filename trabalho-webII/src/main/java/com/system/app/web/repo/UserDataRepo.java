package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.UserData;
import com.system.app.web.config.MySqlConnector;

public class UserDataRepo implements DAOinterface<UserData> {

    private MySqlConnector conector = null;
    private String sql = null;

    public UserDataRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean save(UserData data) throws DAOException {
        sql = "INSERT INTO userData (user_id, name, lastname, cpf, phone, cep, address, addressNumber, complement, bairro, city, state)"
                +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, data.getUser_id());
            statement.setString(2, data.getName());
            statement.setString(3, data.getLastname());
            statement.setString(4, data.getCpf());
            statement.setString(5, data.getPhone());
            statement.setString(6, data.getCep());
            statement.setString(7, data.getAddress());
            statement.setInt(8, data.getAdressNumber());
            statement.setString(9, data.getComplement());
            statement.setString(10, data.getBairro());
            statement.setString(11, data.getCity());
            statement.setString(12, data.getState());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("INSERTED NEW USER DATA!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new USERDATA: " + e.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM userData WHERE user_id= ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            RoleRepo roleRepo = new RoleRepo();
            roleRepo.delete(id);
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("DELETED USERDATA!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING USERDATA BY ID: " + id.toString() + e.toString(), e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(UserData data) throws DAOException {
        String sql = "UPDATE userData SET name=?, lastname=?, cpf=?, phone=?, cep=?, address=?, addressNumber=?,complement=?,bairro=?, city=?, state=?  WHERE user_id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, data.getName());
            statement.setString(2, data.getLastname());
            statement.setString(3, data.getCpf());
            statement.setString(4, data.getPhone());
            statement.setString(5, data.getCep());
            statement.setString(6, data.getAddress());
            statement.setInt(7, data.getAdressNumber());
            statement.setString(8, data.getComplement());
            statement.setString(9, data.getBairro());
            statement.setString(10, data.getCity());
            statement.setString(11, data.getState());
            statement.setInt(12, data.getUser_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("UPDATED USERDATA!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING User: " + e.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<UserData> getAll() throws DAOException {
        sql = "SELECT * FROM userData";
        List<UserData> datalist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            UserData data = null;
            while (rs.next()) {
                data = new UserData();
                data.setUser_id(rs.getInt("user_id"));
                data.setName(rs.getString("name"));
                data.setLastname(rs.getString("lastname"));
                data.setCpf(rs.getString("cpf"));
                data.setPhone(rs.getString("phone"));
                data.setCep(rs.getString("cep"));
                data.setAddress(rs.getString("address"));
                data.setAdressNumber(rs.getInt("addressNumber"));
                data.setComplement(rs.getString("complement"));
                data.setBairro(rs.getString("bairro"));
                data.setCity(rs.getString("city"));
                data.setState(rs.getString("state"));
                datalist.add(data);
                data = null;
            }
        } catch (SQLException e) {
            datalist = null;
            throw new DAOException("Error GETTING ALL USERDATA: " + e.toString(), e);

        }
        return datalist;
    }

    @Override
    public UserData getByID(Integer id) throws DAOException {
        sql = "SELECT * from userData where user_id = ?";
        UserData data = new UserData();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                data.setUser_id(rs.getInt("user_id"));
                data.setName(rs.getString("name"));
                data.setLastname(rs.getString("lastname"));
                data.setCpf(rs.getString("cpf"));
                data.setPhone(rs.getString("phone"));
                data.setCep(rs.getString("cep"));
                data.setAddress(rs.getString("address"));
                data.setAdressNumber(rs.getInt("addressNumber"));
                data.setComplement(rs.getString("complement"));
                data.setBairro(rs.getString("bairro"));
                data.setCity(rs.getString("city"));
                data.setState(rs.getString("state"));
            }
        } catch (SQLException e) {
            data = null;
            throw new DAOException("Error GETTING USERDATA by ID: " + e.toString(), e);

        }

        return data;

    }

}
