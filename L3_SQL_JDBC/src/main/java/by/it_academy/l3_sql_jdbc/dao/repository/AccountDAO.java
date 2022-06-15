package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Account;

import java.io.IOException;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {
    List<Account> findAll() throws DAOException, IOException, ClassNotFoundException;
    Optional<Account> findByAccountId(int id) throws DAOException, IOException, ClassNotFoundException;
    List<Account> findByUsertId(int id) throws DAOException, IOException, ClassNotFoundException;
    boolean addAccount(Account account) throws DAOException, IOException, ClassNotFoundException;
    Optional<Account> getBalanceByCurrencyAndUserId(int id, Currency currency) throws DAOException, IOException, ClassNotFoundException;
}
