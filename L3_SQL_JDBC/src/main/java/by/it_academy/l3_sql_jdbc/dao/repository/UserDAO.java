package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;

import java.util.List;
import java.util.Optional;

public interface UserDAO<T> {
    List<T> findAll() throws DAOException;

    Optional<T> find(int id) throws DAOException;

    boolean add(T user) throws DAOException;

    Optional<T> findUserByEmail(String email) throws DAOException;

    Optional<T> findUserByEmailAndPassword(String email, String password) throws DAOException;

    Optional<String> findPasswordByEmail(String email) throws DAOException;
}
