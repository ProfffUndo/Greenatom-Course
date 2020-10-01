package com.company.JDBC;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCConnection {
    private static final Logger LOGGER = Logger.getLogger(JDBCConnection.class.getName());
    private static Optional<Connection> connection = Optional.empty();

    public static Optional<Connection> getConnection() {
        if (connection.isEmpty()) {
            final String user = "postgres";
            final String password = "rjhjvsckjd99";
            final String url = "jdbc:postgresql://localhost:5432/Greenatom";
            try {
                connection = Optional.ofNullable(DriverManager.getConnection(url, user, password));
            } catch (SQLException e) {
                LOGGER.log(Level.SEVERE, null, e);
            }
        }
        return connection;
    }
}
