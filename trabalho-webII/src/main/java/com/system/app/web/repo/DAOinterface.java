package com.system.app.web.repo;

import java.util.List;

public interface DAOinterface<T> {
    public boolean save(T t) throws DAOException ;

    public boolean delete(Integer id) throws DAOException ;

    public boolean update(T t) throws DAOException ;

    public List<T> getAll() throws DAOException ;

    public T getByID(Integer id) throws DAOException ;

}
