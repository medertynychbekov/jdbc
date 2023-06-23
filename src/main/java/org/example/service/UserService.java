package org.example.service;

import org.example.model.User;

import java.util.List;

public interface UserService {

    void createUserTable();
    void saveUser(User user);
    User findById(int id);
    List<User> getAllUsers();
    void updateUser(int id, User user);
    void deleteById(int id);

}
