package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll() throws DAOException;
    Optional<User> find(int id) throws DAOException;
    boolean add(User user) throws DAOException;
    Optional<User> findUserByEmail(String email) throws DAOException;
    Optional<User> findUserByEmailAndPassword(String email, String password) throws DAOException;
    Optional<String> findPasswordByEmail(String email) throws DAOException;
}
