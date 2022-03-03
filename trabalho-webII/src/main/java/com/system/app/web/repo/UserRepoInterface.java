package com.system.app.web.repo;

import java.sql.SQLException;
import java.util.List;

import com.system.app.web.DTO.User;

public interface UserRepoInterface {
    public void save(User user) throws SQLException;

    public void delete(String cpf) throws SQLException;

    public void update(User user) throws SQLException;

    public List<User> getAllUsers() throws SQLException;

    public User getUserByCPF(String cpf) throws SQLException;

    public User getUserByEmail(String email) throws SQLException;

}
