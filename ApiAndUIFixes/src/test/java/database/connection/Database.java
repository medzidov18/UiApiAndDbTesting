package database.connection;

import java.sql.*;

import static dataread.DataRead.configDataDbDTO;

public class Database {
    private static Connection connection = null;

    public static void initializeConnection() {
        try {
            connection = DriverManager.getConnection(configDataDbDTO.getDatabaseUrl(), configDataDbDTO.getUserName(), configDataDbDTO.getUserPassword());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
