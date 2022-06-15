package by.it_academy.l3_sql_jdbc.dao.repository;


import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.User;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll() throws DAOException, IOException, ClassNotFoundException;
    Optional<User> find(int id) throws DAOException, IOException, ClassNotFoundException;
    boolean add(User user) throws DAOException, IOException, ClassNotFoundException;
    Optional<User> findUserByEmail(String email) throws DAOException, IOException, ClassNotFoundException;
    Optional<String> findPasswordByEmail(String email) throws DAOException, IOException, ClassNotFoundException;
}
