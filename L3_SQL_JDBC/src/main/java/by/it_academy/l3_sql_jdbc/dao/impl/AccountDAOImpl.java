package by.it_academy.l3_sql_jdbc.dao.impl;

import by.it_academy.l3_sql_jdbc.dao.connection.ConnectionFactory;
import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.repository.AccountDAO;
import by.it_academy.l3_sql_jdbc.entity.Account;
import by.it_academy.l3_sql_jdbc.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Optional;

public class AccountDAOImpl implements AccountDAO {
    private static final String SQL_FIND_ALL_ACCOUNTS
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN  users u ON u.user_id=a.user_id " +
            "INNER JOIN transactions t ON t.account_id=a.account_id";
    private static final String SQL_FIND_ACCOUNT_BY_ID
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN users u on u.user_id=a.user_id " +
            "INNER JOIN transactions t ON t.account_id=a.account_id WHERE a.account_id=?";
    private static final String SQL_FIND_ACCOUNT_BY_USER_ID
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN users u on u.user_id=a.user_id " +
            "INNER JOIN transactions t ON t.account_id=a.account_id WHERE u.user_id=?";
    private static final String SQL_GET_BALANCE_BY_USER_ID_AND_CURRENCY
            = "SELECT a.account_id, a.user_id, sum(t.amount) as balance, a.currency, u.name, u.address, u.email" +
            " FROM accounts a INNER JOIN users u ON u.user_id=a.user_id " +
            "INNER JOIN transactions t ON t.account_id=a.account_id WHERE u.user_id=? AND a.currency=?";
    private static final String SQL_ADD_ACCOUNT
            = "INSERT INTO accounts (user_id, currency) values(?,?)";
    private ConnectionFactory jdbcConnection;
    @Override
    public List<Account> findAll() throws DAOException, IOException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = jdbcConnection.getConnection();
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
    public Optional<Account> findByAccountId(int id) throws DAOException, IOException, ClassNotFoundException {
        Optional<Account> optional = Optional.empty();
        try (Connection connection = jdbcConnection.getConnection();
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

    @Override
    public List<Account> findByUsertId(int id) throws DAOException, IOException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = jdbcConnection.getConnection();
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
    public boolean addAccount(Account account) throws DAOException, IOException, ClassNotFoundException {
        boolean isAdded;
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_ACCOUNT)) {
            statement.setInt(1, account.getUser().getId());
            statement.setString(2, account.getCurrency().toString());
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
    public Optional<Account> getBalanceByCurrencyAndUserId(int user_id, Currency currency) throws DAOException, IOException, ClassNotFoundException {
        Optional<Account> optional;
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_GET_BALANCE_BY_USER_ID_AND_CURRENCY)) {
            statement.setInt(1, user_id);
            statement.setString(2, currency.toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Account account = retrieve(resultSet);
                optional = Optional.of(account);
            } else {
                optional = Optional.empty();
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find acount by user ID and currency in the database");
        }
        return optional;
    }

    private Account retrieve(ResultSet resultSet) throws SQLException {
        return new Account.Builder()
                .setAccountId(resultSet.getInt("account_id"))
                .setUser(new User.Builder()
                        .setId(resultSet.getInt("user_id"))
                        .setName(resultSet.getString("name"))
                        .setAddress(resultSet.getString("address"))
                        .setEmail(resultSet.getString("email"))
                        .build())
                .setBalance(resultSet.getBigDecimal("balance"))
                .setCurrency(Account.Currency.valueOf(resultSet.getString("currency")))
                .build();
    }
}
