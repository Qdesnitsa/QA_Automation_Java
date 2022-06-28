package by.it_academy.l3_sql_jdbc.dao.impl;

import by.it_academy.l3_sql_jdbc.dao.connection.ConnectionFactory;
import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.repository.AccountDAO;
import by.it_academy.l3_sql_jdbc.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements AccountDAO<Account> {
    private static final String SQL_FIND_ALL_ACCOUNTS
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency as currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN  users u ON u.user_id=a.user_id " +
            "LEFT JOIN transactions t ON t.account_id=a.account_id";
    private static final String SQL_FIND_ACCOUNT_BY_ID
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency as currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN users u on u.user_id=a.user_id " +
            "LEFT JOIN transactions t ON t.account_id=a.account_id WHERE a.account_id=?";
    private static final String SQL_FIND_ACCOUNT_BY_USER_ID
            = "SELECT a.account_id, a.user_id as user_id, sum(t.amount) as balance, a.currency as currency, " +
            "u.name, u.address, u.email FROM accounts a INNER JOIN users u on u.user_id=a.user_id " +
            "INNER JOIN transactions t ON t.account_id=a.account_id WHERE u.user_id=?" +
            "GROUP BY currency ORDER BY a.account_id";
    private static final String SQL_GET_BALANCE_BY_USER_ID_AND_CURRENCY
            = "SELECT a.account_id as account_id, a.user_id as user_id, sum(t.amount) as balance, a.currency as currency" +
            " FROM accounts a LEFT JOIN transactions t ON t.account_id=a.account_id WHERE user_id=? AND currency=?";
    private static final String SQL_ADD_ACCOUNT
            = "INSERT INTO accounts (user_id, currency) values(?,?)";

    @Override
    public List<Account> findAll() throws DAOException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_ACCOUNTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accounts.add(retrieve(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find all accounts in the database", e);
        }
        return accounts;
    }

    @Override
    public Optional<Account> findById(int id) throws DAOException {
        Optional<Account> optional = Optional.empty();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ACCOUNT_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Account account = retrieve(resultSet);
                optional = Optional.of(account);
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find account by account ID in the database", e);
        }
        return optional;
    }

    public List<Account> findByUserId(int id) throws DAOException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ACCOUNT_BY_USER_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accounts.add(retrieve(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find account by user ID in the database", e);
        }
        return accounts;
    }

    @Override
    public boolean add(Account account) throws DAOException {
        boolean isAdded;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_ACCOUNT)) {
            statement.setInt(1, account.getUser_id());
            statement.setString(2, String.valueOf(account.getCurrency()));
            int counter = statement.executeUpdate();
            if (counter != 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to add new account to the database");
        }
        return isAdded;
    }

    @Override
    public Optional<Account> getBalanceByCurrencyAndUserId(int user_id, Account.Currency currency) throws DAOException {
        Optional<Account> optional;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_BALANCE_BY_USER_ID_AND_CURRENCY)) {
            statement.setInt(1, user_id);
            statement.setString(2, currency.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() && null != resultSet.getString("currency")) {
                Account account = retrieve(resultSet);
                optional = Optional.of(account);
            } else {
                optional = Optional.empty();
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find balance by user ID and currency in the database");
        }
        return optional;
    }

    private Account retrieve(ResultSet resultSet) throws SQLException {
        return new Account.Builder()
                .setAccountId(resultSet.getInt("account_id"))
                .setUser_id(resultSet.getInt("user_id"))
                .setBalance(resultSet.getBigDecimal("balance"))
                .setCurrency(Account.Currency.valueOf(resultSet.getString("currency")))
                .build();
    }
}
