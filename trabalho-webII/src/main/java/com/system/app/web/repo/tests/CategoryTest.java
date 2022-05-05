package com.system.app.web.repo.tests;

import com.system.app.web.beans.ProductCat;
import com.system.app.web.repo.CategoryRepo;

public class CategoryTest {
    public static void main(String[] args) {
        ProductCat category = new ProductCat();

        category.setName("categoria2");
        
        try {
            CategoryRepo categoryRepo = new CategoryRepo();
            categoryRepo.save(category);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
