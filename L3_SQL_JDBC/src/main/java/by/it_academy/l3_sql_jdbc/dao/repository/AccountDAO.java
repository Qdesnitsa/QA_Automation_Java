package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    List<Account> findAll() throws DAOException;
    Optional<Account> findByAccountId(int id) throws DAOException;
    List<Account> findByUserId(int id) throws DAOException;
    boolean addAccount(Account account) throws DAOException;
    Optional<Account> getBalanceByCurrencyAndUserId(int id, Account.Currency currency) throws DAOException;
}
