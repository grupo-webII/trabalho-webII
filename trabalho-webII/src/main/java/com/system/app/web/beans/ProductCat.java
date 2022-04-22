package com.system.app.web.beans;

import java.io.Serializable;

public class ProductCat implements Serializable {

    private Integer cat_id;
    private String name;

    

    public Integer getCat_id() {
        return cat_id;
    }

    public void setCat_id(Integer cat_id) {
        this.cat_id = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
