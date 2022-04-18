package com.system.app.web.repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.system.app.web.beans.Product;
import com.system.app.web.beans.ProductCat;
import com.system.app.web.config.MySqlConnector;

public class ProductRepo implements DAOinterface<Product> {

    private MySqlConnector conector = null;
    private String sql = null;

    public ProductRepo() {
        this.conector = new MySqlConnector();
    }

    @Override
    public boolean save(Product product) throws DAOException {
        sql = "INSERT INTO product (name, category ,description, weight)"
                +
                "VALUES (?,?,?,?)";
        boolean isSaved = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory().getName());
            statement.setString(3, product.getDescription());
            statement.setFloat(4, product.getWeight());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isSaved = true;
                System.out.println("INSERTED NEW PRODUCT!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error INSERTING new Product: " + sql + "/" + product.toString(), e);
        }
        return isSaved;
    }

    @Override
    public boolean delete(Integer id) throws DAOException {
        sql = "DELETE FROM product WHERE product_id = ?";
        boolean isDeleted = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                isDeleted = true;
                System.out.println("DELETED PRODUCT " + id.toString() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error DELETING Product by id: " + sql + "/" + id.toString(), e);
        }
        return isDeleted;

    }

    @Override
    public boolean update(Product product) throws DAOException {
        String sql = "UPDATE product SET name=?, category=?, description=?, weight=? WHERE product_id = ?";
        boolean isUpdated = false;
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory().getName());
            statement.setString(3, product.getDescription());
            statement.setFloat(4, product.getWeight());
            statement.setInt(5, product.getProduct_id());
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                isUpdated = true;
                System.out.println("UPDATED PRODUCT " + product.getProduct_id() + "!");
            }
        } catch (SQLException e) {
            throw new DAOException("Error UPDATING Product: " + sql + "/" + product.toString(), e);
        }
        return isUpdated;

    }

    @Override
    public List<Product> getAll() throws DAOException {
        sql = "SELECT * FROM product";
        List<Product> productlist = new ArrayList<>();
        try (Connection conn = conector.getConn()) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            Product product = new Product();
            while (rs.next()) {
                product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                ProductCat prodCat = new ProductCat();
                prodCat.setName(rs.getString("category"));
                product.setCategory(prodCat);
                product.setDescription(rs.getString("description"));
                product.setWeight(rs.getFloat("weight"));
                productlist.add(product);
                product = null;
            }
        } catch (SQLException e) {
            productlist = null;
            throw new DAOException("Error GETTING ALL Products: " + sql, e);

        }
        return productlist;
    }

    @Override
    public Product getByID(Integer id) throws DAOException {
        sql = "SELECT * from user where product_id = ?";
        Product product = new Product();
        try (Connection conn = conector.getConn()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                product.setProduct_id(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                ProductCat prodCat = new ProductCat();
                prodCat.setName(rs.getString("category"));
                product.setCategory(prodCat);
                product.setDescription(rs.getString("description"));
                product.setWeight(rs.getFloat("weight"));
            }
        } catch (SQLException e) {
            product = null;
            throw new DAOException("Error GETTING User by id: " + sql + "/" + id.toString(), e);

        }
        return product;
    }

}
