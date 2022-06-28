package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;

import java.util.Optional;

public interface UserDAO<T> extends BaseDAO<T>{

    Optional<T> findUserByEmail(String email) throws DAOException;

    Optional<T> findUserByEmailAndPassword(String email, String password) throws DAOException;

    Optional<String> findPasswordByEmail(String email) throws DAOException;
}
