package com.system.app.web.repo;

import java.sql.SQLException;
import java.util.List;

import com.system.app.web.DTO.User;

public interface UserRepoInterface {
    public void save() throws SQLException;

    public void delete() throws SQLException;

    public void update() throws SQLException;

    public List<User> getAllUsers() throws SQLException;

    public User getUserByCPF(String cpf) throws SQLException;

    public User getUserByEmail(String email) throws SQLException;

}
