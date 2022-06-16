package by.it_academy.l3_sql_jdbc.dao.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final Properties PROPERTIES = new Properties();
    private static final String DATABASE_PROPERTIES = "database.properties";
    private static final String PROPERTIES_URL = "url";
    private static final String PROPERTIES_DRIVER = "jdbc_driver";
    private static String url;

    private ConnectionFactory() {
    }

    static {
        try (InputStream inputStream = ConnectionFactory.class.getClassLoader()
                .getResourceAsStream(DATABASE_PROPERTIES)) {
            PROPERTIES.load(inputStream);
            url = PROPERTIES.getProperty(PROPERTIES_URL);
            String driver = PROPERTIES.getProperty(PROPERTIES_DRIVER);
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException("Cannot get information from database.properties file", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
