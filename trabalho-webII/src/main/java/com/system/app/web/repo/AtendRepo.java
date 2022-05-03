package com.system.app.web.repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.Atendimento;
import com.system.app.web.config.MySqlConnector;

public class AtendRepo implements DAOinterface<Atendimento> {

    private MySqlConnector conector = null;
    private String sql = null;

    public AtendRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean save(Atendimento attend) throws DAOException {
        sql = "INSERT INTO att (data, client ,status, product, type, description, solution)"
                +
                "VALUES (?,?,?,?,?,?,?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            Timestamp ts = new Timestamp(attend.getData().getTime());
            statement.setTimestamp(1, ts);
            statement.setInt(2, attend.getClient().getUser_id());
            statement.setString(3, attend.getStatus().toLowerCase());
            statement.setInt(4, attend.getProduct().getProduct_id());
            statement.setInt(5, attend.getType().getType_id());
            statement.setString(6, attend.getDescription());
            statement.setString(7, attend.getSolution());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("INSERTED NEW ATTEND!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new ATTEND: " + sql + "/" + attend.toString() + "\n" + e.toString(),
                    e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM att WHERE at_id = ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("DELETED ATTEND " + id.toString() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING Attend by id: " + sql + "/" + id.toString() + "\n" + e.toString(),
                    e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(Atendimento attend) throws DAOException {
        String sql = "UPDATE att SET data=?, client=?, status=?, product=?, type=?, description=?, solution=? WHERE at_id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            Timestamp ts = new Timestamp(attend.getData().getTime());
            statement.setTimestamp(1, ts);
            statement.setInt(2, attend.getClient().getUser_id());
            statement.setString(3, attend.getStatus().toLowerCase());
            statement.setInt(4, attend.getProduct().getProduct_id());
            statement.setInt(5, attend.getType().getType_id());
            statement.setString(6, attend.getDescription());
            statement.setString(7, attend.getSolution());
            statement.setInt(8, attend.getAt_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("UPDATED ATTEND " + attend.getAt_id() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING ATTEND: " + sql + "/" + attend.toString() + "\n" + e.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<Atendimento> getAll() throws DAOException {
        sql = "SELECT * FROM att";
        List<Atendimento> attlist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Atendimento attend = new Atendimento();
                attend.setAt_id(rs.getInt("at_id"));
                Timestamp ts = rs.getTimestamp("data");
                attend.setData(new Date(ts.getTime()));
                UserRepo uRepo = new UserRepo();
                attend.setClient(uRepo.getByID(rs.getInt("client")));
                attend.setStatus(rs.getString("status"));
                ProductRepo pRepo = new ProductRepo();
                attend.setProduct(pRepo.getByID(rs.getInt("product")));
                AttTypeRepo aTypeRepo = new AttTypeRepo();
                attend.setType(aTypeRepo.getByID(rs.getInt("type")));
                attend.setDescription(rs.getString("description"));
                attend.setSolution(rs.getString("solution"));
                attlist.add(attend);
                attend = null;
            }
        } catch (SQLException e) {
            attlist = null;
            throw new DAOException("Error GETTING ALL Attends: " + sql + "\n" + e.toString(), e);

        }
        return attlist;
    }

    public List<Atendimento> getAllOpen() throws DAOException {
        sql = "SELECT * FROM att where status=" + "\"em aberto\"";
        List<Atendimento> attlist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Atendimento attend = new Atendimento();
                attend.setAt_id(rs.getInt("at_id"));
                Timestamp ts = rs.getTimestamp("data");
                attend.setData(new Date(ts.getTime()));
                UserRepo uRepo = new UserRepo();
                attend.setClient(uRepo.getByID(rs.getInt("client")));
                attend.setStatus(rs.getString("status"));
                ProductRepo pRepo = new ProductRepo();
                attend.setProduct(pRepo.getByID(rs.getInt("product")));
                AttTypeRepo aTypeRepo = new AttTypeRepo();
                attend.setType(aTypeRepo.getByID(rs.getInt("type")));
                attend.setDescription(rs.getString("description"));
                attend.setSolution(rs.getString("solution"));
                attlist.add(attend);
                attend = null;
            }
        } catch (SQLException e) {
            attlist = null;
            throw new DAOException("Error GETTING ALL Attends: " + sql + "\n" + e.toString(), e);

        }
        return attlist;
    }

    @Override
    public Atendimento getByID(Integer id) throws DAOException {
        sql = "SELECT * from  att where at_id = ?";
        Atendimento attend = new Atendimento();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                attend.setAt_id(rs.getInt("at_id"));
                Timestamp ts = rs.getTimestamp("data");
                attend.setData(new Date(ts.getTime()));
                UserRepo uRepo = new UserRepo();
                attend.setClient(uRepo.getByID(rs.getInt("client")));
                attend.setStatus(rs.getString("status"));
                ProductRepo pRepo = new ProductRepo();
                attend.setProduct(pRepo.getByID(rs.getInt("product")));
                AttTypeRepo aTypeRepo = new AttTypeRepo();
                attend.setType(aTypeRepo.getByID(rs.getInt("type")));
                attend.setDescription(rs.getString("description"));
                attend.setSolution(rs.getString("solution"));
            }
        } catch (SQLException e) {
            attend = null;
            throw new DAOException("Error GETTING Attend by id: " + sql + "/" + id.toString() + "\n" + e.toString(), e);

        }
        return attend;
    }

    public List<Atendimento> getAllByUser(Integer id) throws DAOException {
        sql = "SELECT * FROM att where client= ?";
        List<Atendimento> attlist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Atendimento attend = new Atendimento();
                attend.setAt_id(rs.getInt("at_id"));
                Timestamp ts = rs.getTimestamp("data");
                attend.setData(new Date(ts.getTime()));
                UserRepo uRepo = new UserRepo();
                attend.setClient(uRepo.getByID(rs.getInt("client")));
                attend.setStatus(rs.getString("status"));
                ProductRepo pRepo = new ProductRepo();
                attend.setProduct(pRepo.getByID(rs.getInt("product")));
                AttTypeRepo aTypeRepo = new AttTypeRepo();
                attend.setType(aTypeRepo.getByID(rs.getInt("type")));
                attend.setDescription(rs.getString("description"));
                attend.setSolution(rs.getString("solution"));
                attlist.add(attend);
                attend = null;
            }
        } catch (SQLException e) {
            attlist = null;
            throw new DAOException("Error GETTING ALL Attends: " + sql + "\n" + e.toString(), e);

        }
        return attlist;
    }

}
