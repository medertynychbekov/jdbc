package org.example;

import org.example.model.User;
import org.example.service.UserService;
import org.example.service.impl.UserServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUserTable();

        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Meder", "Tynychbekov", 22));
        userService.saveUser(new User("Adina", "Atakulova", 18));

        //System.out.println(userService.findById(1));
//        System.out.println(userService.getAllUsers());

        //userService.deleteById(2)
         userService.updateUser(7, new User("MEDER", "TYNYCHBEKOV", 44));
    }
}
