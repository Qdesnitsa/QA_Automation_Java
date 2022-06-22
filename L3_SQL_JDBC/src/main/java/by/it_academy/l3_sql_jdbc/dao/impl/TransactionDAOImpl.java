package by.it_academy.l3_sql_jdbc.dao.impl;

import by.it_academy.l3_sql_jdbc.dao.connection.ConnectionFactory;
import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.repository.TransactionDAO;
import by.it_academy.l3_sql_jdbc.entity.Transaction;
import by.it_academy.l3_sql_jdbc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransactionDAOImpl implements TransactionDAO {
    private static final String SQL_FIND_ALL_TRANSACTIONS
            = "SELECT transaction_id, type_transaction, account_id, amount FROM transactions";
    private static final String SQL_FIND_TRANSACTION_BY_USER_ID
            = "SELECT t.transaction_id, t.type_transaction as typeTransaction, t.account_id, t.amount FROM transactions t" +
            "INNER JOIN accounts a on t.accounts_id=a.accounts_id WHERE a.account_id=?";
    @Override
    public List<Transaction> findAll() throws DAOException {
        List<Transaction> transactions = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_TRANSACTIONS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transactions.add(retrieve(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find all transactions in the database");
        }
        return transactions;
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

    private Transaction retrieve(ResultSet resultSet) throws SQLException {
        return new Transaction.Builder()
                .setId(resultSet.getInt("user_id"))
                .setAmount(resultSet.getBigDecimal("amount"))
                .setTypeTransaction(Transaction.TypeTransaction.valueOf(resultSet.getString("type_transaction")))
                .build();
    }
}
