package com.system.app.web.beans;

import java.io.Serializable;

public class Product implements Serializable{

    private Integer product_id;
    private String name;
    private ProductCat category;
    private String description;
    private Float weight;

    public String getName() {
        return name;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCat getCategory() {
        return category;
    }

    public void setCategory(ProductCat category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

}
