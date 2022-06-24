package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDAO<T> {
    List<T> findAll() throws DAOException;

    //Optional<Transaction> find(int id) throws DAOException;
    List<T> findByUserId(int id) throws DAOException;

    List<T> findByAccountId(int id) throws DAOException;

    boolean add(T transaction) throws DAOException;
}
