package com.system.app.web.repo;

import java.util.List;

import com.system.app.web.DTO.User;

public interface UserRepoInterface {
    public boolean save(User user) ;

    public boolean delete(String cpf) ;

    public boolean update(User user) ;

    public List<User> getAllUsers() ;

    public User getUserByEmail(String email) ;

    public User getUserByID(Integer id) ;
}