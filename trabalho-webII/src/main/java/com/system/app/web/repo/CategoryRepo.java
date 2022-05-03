package com.system.app.web.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.ProductCat;
import com.system.app.web.config.MySqlConnector;

public class CategoryRepo implements DAOinterface<ProductCat> {

    private MySqlConnector conector = null;
    private String sql = null;

    public CategoryRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean save(ProductCat cat) throws DAOException {
        sql = "INSERT INTO productCategory ( name)"
                +
                "VALUES (?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cat.getName().toLowerCase());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("INSERTED new Category: " + cat.getName());
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new Category: " +  e.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM productCategory WHERE cat_id = ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("DELETED CATEGORY " + id.toString() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING Category by id: "  + id.toString() +  e.toString(), e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(ProductCat cat) throws DAOException {
        String sql = "UPDATE productCategory SET name=? WHERE cat_id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cat.getName().toLowerCase());
            statement.setInt(2, cat.getCat_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("UPDATED PRODUCT " + cat.getName() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING Product: " +  e.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<ProductCat> getAll() throws DAOException {
        sql = "SELECT * FROM productCategory";
        List<ProductCat> catList = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ProductCat cat;
            while (rs.next()) {
                cat = new ProductCat();
                cat.setCat_id(rs.getInt("cat_id"));
                cat.setName(rs.getString("name"));
                catList.add(cat);
                cat = null;
            }
        } catch (SQLException e) {
            catList = null;
            throw new DAOException("Error GETTING ALL Products: " +  e.toString(), e);

        }
        return catList;
    }

    @Override
    public ProductCat getByID(Integer id) throws DAOException {
        sql = "SELECT * from productCategory where cat_id = ?";
        ProductCat cat = new ProductCat();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cat.setCat_id(rs.getInt("cat_id"));
                cat.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            cat = null;
            throw new DAOException("Error GETTING Category by id: "  + id.toString() +  e.toString(), e);

        }
        return cat;
    }

    public ProductCat getByName(String name) throws DAOException {
        sql = "SELECT * from productCategory where name = ?";
        ProductCat cat = new ProductCat();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                cat.setCat_id(rs.getInt("cat_id"));
                cat.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            cat = null;
            throw new DAOException("Error GETTING Category by name: "+  e.toString(), e);

        }
        return cat;
    }

}
