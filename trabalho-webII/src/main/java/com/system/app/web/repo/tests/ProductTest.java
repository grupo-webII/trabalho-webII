package com.system.app.web.repo.tests;

import com.system.app.web.beans.Product;
import com.system.app.web.repo.CategoryRepo;
import com.system.app.web.repo.DAOException;
import com.system.app.web.repo.ProductRepo;

public class ProductTest {

    public static void main(String[] args) {

        CategoryRepo categoryRepo = new CategoryRepo();

        Product product = new Product();
        product.setDescription("descricao1");
        product.setName("produto3");
        product.setWeight((float) 50.00);
        ProductRepo productRepo = new ProductRepo();
        try {
            product.setCategory(categoryRepo.getByName("categoria2"));
            productRepo.save(product);
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }
}
