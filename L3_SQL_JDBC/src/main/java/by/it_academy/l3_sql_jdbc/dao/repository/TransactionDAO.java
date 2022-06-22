package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDAO {
    List<Transaction> findAll() throws DAOException;
    //Optional<Transaction> find(int id) throws DAOException;
    List<Transaction> findByUserId(int id) throws DAOException;
    List<Transaction> findByAccountId(int id) throws DAOException;
    boolean add(Transaction transaction) throws DAOException;
}
