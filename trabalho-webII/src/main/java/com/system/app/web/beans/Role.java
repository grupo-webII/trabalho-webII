package com.system.app.web.beans;

public class Role {

    private Integer user_id;
    private boolean ROLE_CLIENTE;
    private boolean ROLE_GERENTE;
    private boolean ROLE_FUNC;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public boolean isROLE_CLIENTE() {
        return ROLE_CLIENTE;
    }

    public void setROLE_CLIENTE(boolean rOLE_CLIENTE) {
        ROLE_CLIENTE = rOLE_CLIENTE;
    }

    public boolean isROLE_GERENTE() {
        return ROLE_GERENTE;
    }

    public void setROLE_GERENTE(boolean rOLE_GERENTE) {
        ROLE_GERENTE = rOLE_GERENTE;
    }

    public boolean isROLE_FUNC() {
        return ROLE_FUNC;
    }

    public void setROLE_FUNC(boolean rOLE_FUNC) {
        ROLE_FUNC = rOLE_FUNC;
    }

}
