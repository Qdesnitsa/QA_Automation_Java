package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO<T> {
    List<T> findAll() throws DAOException;

    Optional<T> findByAccountId(int id) throws DAOException;

    List<T> findByUserId(int id) throws DAOException;

    boolean addAccount(T account) throws DAOException;

    Optional<T> getBalanceByCurrencyAndUserId(int id, Account.Currency currency) throws DAOException;
}
