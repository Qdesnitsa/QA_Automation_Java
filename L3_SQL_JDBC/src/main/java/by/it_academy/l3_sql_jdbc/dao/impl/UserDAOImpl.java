package by.it_academy.l3_sql_jdbc.dao.impl;

import by.it_academy.l3_sql_jdbc.dao.connection.ConnectionFactory;
import by.it_academy.l3_sql_jdbc.dao.exception.DAOException;
import by.it_academy.l3_sql_jdbc.dao.repository.UserDAO;
import by.it_academy.l3_sql_jdbc.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_FIND_ALL_USERS
            = "SELECT user_id, name, address, email FROM users";
    private static final String SQL_FIND_USER_BY_ID
            = "SELECT user_id, name, address, email FROM users WHERE user_id=?";
    private static final String SQL_ADD_USER
            = "INSERT INTO users (name, address, email, password) values(?,?,?,?)";
    private static final String SQL_FIND_USER_BY_EMAIL =
            "SELECT user_id, name, address, email FROM users WHERE email=?";
    private static final String SQL_FIND_PASSWORD_BY_EMAIL
            = "SELECT password FROM users WHERE email=?";
    private static final String SQL_FIND_USER_BY_EMAIL_AND_PASSWORD
            = "SELECT user_id, name, address, email FROM users WHERE email=? AND password=?";

    public UserDAOImpl() throws SQLException {
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(retrieve(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find all users in the database");
        }
        return users;
    }


    @Override
    public Optional<User> find(int id) throws DAOException {
        Optional<User> optional = Optional.empty();
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = retrieve(resultSet);
                optional = Optional.of(user);
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find user by user ID in the database");
        }
        return optional;
    }

    @Override
    public boolean add(User user) throws DAOException {
        boolean isAdded;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER)) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getAddress());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            int counter = statement.executeUpdate();
            if (counter != 0) {
                isAdded = true;
            } else {
                isAdded = false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public Optional<User> findUserByEmail(String email) throws DAOException {
        Optional<User> optional;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = retrieve(resultSet);
                optional = Optional.of(user);
            } else {
                optional = Optional.empty();
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find user by email in the database");
        }
        return optional;
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) throws DAOException {
        Optional<User> optional;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER_BY_EMAIL_AND_PASSWORD)) {
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = retrieve(resultSet);
                optional = Optional.of(user);
            } else {
                optional = Optional.empty();
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find user by email and password in the database");
        }
        return optional;
    }

    @Override
    public Optional<String> findPasswordByEmail(String email) throws DAOException {
        Optional<String> optional;
        String password;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_PASSWORD_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                password = resultSet.getString("password");
                optional = Optional.of(password);
            } else {
                optional = Optional.empty();
            }
        } catch (SQLException e) {
            throw new DAOException("Failed attempt to find password by email in the database");
        }
        return optional;
    }

    private User retrieve(ResultSet resultSet) throws SQLException {
        return new User.Builder()
                .setId(resultSet.getInt("user_id"))
                .setEmail(resultSet.getString("email"))
                .setName(resultSet.getString("name"))
                .setAddress(resultSet.getString("address"))
                .build();
    }
}
