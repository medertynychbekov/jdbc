package org.example.service.impl;

import org.example.config.Jdbc;
import org.example.model.User;
import org.example.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUserTable() {
        String query = """
                drop table if exists users;
                create  table users(
                id serial primary key,
                name varchar(50) not null,
                last_name varchar(70) not null,
                age integer not null
                );
                """;

        try (Connection connection = Jdbc.getConnection()) {

            Statement statement = connection.createStatement();

            statement.execute(query);

            System.out.println("Table users successfully created!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(User user) {

        String query = """
                insert into users (name, last_name, age) values (?, ?, ?);
                """;

        try (Connection connection = Jdbc.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User findById(int id) {
        String query = "select * from users where id =? ";

        User user = new User();

        try (Connection connection = Jdbc.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public List<User> getAllUsers() {

        String query = """
                select * from users;
                """;

        List<User> users = new ArrayList<>();
        try (Connection connection = Jdbc.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getInt("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void updateUser(int id, User user) {

        String query = """
                update users set name =?, last_name =?, age =? where id =?;
                """;
        try (Connection connection = Jdbc.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteById(int id) {
        String query = """
                delete from users where id =?;
                """;

        try (Connection connection = Jdbc.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
