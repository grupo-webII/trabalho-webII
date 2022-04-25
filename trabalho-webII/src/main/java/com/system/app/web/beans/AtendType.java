package com.system.app.web.beans;

import java.io.Serializable;

public class AtendType implements Serializable {

    private Integer type_id;
    private String name;

    public String getName() {
        return name;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
