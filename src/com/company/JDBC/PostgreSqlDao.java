package com.company.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSqlDao implements DAO<User, Integer> {

    private static final Logger LOGGER =
            Logger.getLogger(PostgreSqlDao.class.getName());
    private final Optional<Connection> connection;

    public PostgreSqlDao() {
        this.connection = JDBCConnection.getConnection();
    }

    @Override
    public Optional<User> get(int id) {
        return connection.flatMap(conn -> {
            Optional<User> user = Optional.empty();
            String sql = "SELECT * FROM test.user WHERE id = " + id;

            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                if (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    Integer height = resultSet.getInt("height");
                    Integer weight = resultSet.getInt("weight");



                    user = Optional.of(
                            new User(id, firstName, lastName, height, weight));

                    LOGGER.log(Level.INFO, "Found {0} in database", user.get());
                }
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return user;
        });
    }

    @Override
    public Collection<User> getAll() {
        Collection<User> users = new ArrayList<>();
        String sql = "SELECT * FROM test.user";

        connection.ifPresent(conn -> {
            try (Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    Integer height = resultSet.getInt("height");
                    Integer weight = resultSet.getInt("weight");

                    User customer =  new User(id, firstName, lastName, height, weight);

                    users.add(customer);

                    LOGGER.log(Level.INFO, "Found {0} in database", customer);
                }

            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });

        return users;
    }

    @Override
    public Optional<Integer> save(User User) {
        String message = "The User to be added should not be null";
        User nonNullUser = Objects.requireNonNull(User, message);
        String sql = "INSERT INTO "
                + "test.user(first_name, last_name, height, weight) "
                + "VALUES(?, ?, ?, ?)";

        return connection.flatMap(conn -> {
            Optional<Integer> generatedId = Optional.empty();

            try (PreparedStatement statement = //PreparedStatement: предварительно компилирует запросы, которые могут содержать входные параметры
                         conn.prepareStatement(
                                 sql,
                                 Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, nonNullUser.getFirstName());
                statement.setString(2, nonNullUser.getLastName());
                statement.setInt(3, nonNullUser.getHeight());
                statement.setInt(4, nonNullUser.getWeight());

                int numberOfInsertedRows = statement.executeUpdate();

                // Retrieve the auto-generated id
                if (numberOfInsertedRows > 0) {
                    try (ResultSet resultSet = statement.getGeneratedKeys()) {
                        if (resultSet.next()) {
                            generatedId = Optional.of(resultSet.getInt(1));
                        }
                    }
                }

                LOGGER.log(
                        Level.INFO,
                        "{0} created successfully? {1}",
                        new Object[]{nonNullUser,
                                (numberOfInsertedRows > 0)});
            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }

            return generatedId;
        });
    }

    @Override
    public void update(User user) {
        String message = "The user to be updated should not be null";
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "UPDATE test.user "
                + "SET "
                + "first_name = ?, "
                + "last_name = ?, "
                + "height = ?, "
                + "weight = ?"
                + "WHERE "
                + "id = ?";

        connection.ifPresent(conn -> {
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setString(1, nonNullUser.getFirstName());
                statement.setString(2, nonNullUser.getLastName());
                statement.setInt(3, nonNullUser.getHeight());
                statement.setInt(4, nonNullUser.getWeight());
                statement.setInt(5, nonNullUser.getId());

                int numberOfUpdatedRows = statement.executeUpdate();

                LOGGER.log(Level.INFO, "Was the user updated successfully? {0}",
                        numberOfUpdatedRows > 0);

            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });
    }

    @Override
    public void delete(User user) {
        String message = "The user to be deleted should not be null";
        User nonNullUser = Objects.requireNonNull(user, message);
        String sql = "DELETE FROM test.user WHERE id = ?";

        connection.ifPresent(conn -> {
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setInt(1, nonNullUser.getId());

                int numberOfDeletedRows = statement.executeUpdate();

                LOGGER.log(Level.INFO, "Was the user deleted successfully? {0}",
                        numberOfDeletedRows > 0);

            } catch (SQLException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
        });
    }
}
