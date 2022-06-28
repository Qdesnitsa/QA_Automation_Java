package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {
    List<T> findAll() throws DAOException;
    Optional<T> findById(int id) throws DAOException;
    boolean add(T entity) throws DAOException;
}
