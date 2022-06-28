package by.it_academy.l3_sql_jdbc.dao.repository;

import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountDAO<T> extends BaseDAO<T>{

    List<T> findByUserId(int id) throws DAOException;

    Optional<T> getBalanceByCurrencyAndUserId(int id, Account.Currency currency) throws DAOException;
}
