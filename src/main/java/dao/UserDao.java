package dao;

import Util.ConnectionProvider;
import Util.DbException;
import entity.Car;
import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private static ConnectionProvider connectionProvider;

    public UserDao(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    public UserDao() {

    }

    public User geUserByUsernameAndPassword(String username, String password) throws DbException {
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("SELECT * FROM users WHERE email= ? AND password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2,password);
            ResultSet result = preparedStatement.executeQuery();
            boolean hasOne = result.next();
            if(hasOne) {
                return new User(
                      result.getInt("id"),
                        result.getString("email"),
                        null,
                        result.getString("role")
                );
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new DbException("Cant get user from db", e);
        }
    }
    public List<User> findAll() throws SQLException {
        // language=SQL
        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<User> list = new LinkedList<>();

            while (resultSet.next()) {
                User user = User.builder()
                        .id(resultSet.getInt("id"))
                        .username(resultSet.getString("email"))
                        .password(resultSet.getString("password"))
                        .role(resultSet.getString("role"))
                        .build();
                list.add(user);
            }

            return list;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void save(User user) throws SQLException {
        // language=SQL

        try {
            PreparedStatement preparedStatement = this.connectionProvider.getConnection().prepareStatement("insert into users (email, password) values (?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}

