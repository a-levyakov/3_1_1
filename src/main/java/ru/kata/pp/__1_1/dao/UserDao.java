package ru.kata.pp.__1_1.dao;

import ru.kata.pp.__1_1.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void createUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public User showUserById(int id);
}