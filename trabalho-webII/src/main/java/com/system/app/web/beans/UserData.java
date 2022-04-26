package com.system.app.web.beans;

import java.io.Serializable;

// "CREATE TABLE IF NOT EXISTS userData ( " +
// "user_id int not null," +
// "name VARCHAR(50)," +
// "lastname VARCHAR(100) ," +
// "cpf VARCHAR(11) unique," +
// "phone varchar(11)," +
// "cep varchar(8)," +
// "address varchar (200)," +
// "addressNumber varchar(10)," +
// "complement varchar(100)," +
// "bairro varchar(50)," +
// "city varchar(100)," +
// "state varchar(50)," +
// "primary key(cpf)," +
// "FOREIGN KEY (user_id) REFERENCES user(user_id)"
// +
// ");",

public class UserData implements Serializable {
    private Integer user_id;
    private String name;
    private String lastname;
    private String cpf;
    private String phone;
    private String cep;
    private String address;
    private Integer adressNumber;
    private String Complement;
    private String bairro;
    private String city;
    private String state;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(Integer adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getComplement() {
        return Complement;
    }

    public void setComplement(String complement) {
        Complement = complement;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
