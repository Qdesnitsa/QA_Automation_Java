package by.it_academy.l3_sql_jdbc.dao.impl;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.repository.TransactionDAO;
import by.it_academy.l3_sql_jdbc.entity.Transaction;

import java.util.List;
import java.util.Optional;

public class TransactionDAOImpl implements TransactionDAO {
    @Override
    public List<Transaction> findAll() throws DAOException {
        return null;
    }

    @Override
    public Optional<Transaction> find(int id) throws DAOException {
        return Optional.empty();
    }

    @Override
    public List<Transaction> findByUserId(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Transaction> findByAccountId(int id) throws DAOException {
        return null;
    }

    @Override
    public boolean add(Transaction transaction) throws DAOException {
        return false;
    }
}
