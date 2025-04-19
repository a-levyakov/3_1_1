package ru.kata.pp.__1_1.service;

import ru.kata.pp.__1_1.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void createUser(User user);

    public void deleteUser(int id);

    public void updateUser(User user);

    public User showUserById(int id);
}