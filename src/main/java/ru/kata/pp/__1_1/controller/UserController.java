package ru.kata.pp.__1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.pp.__1_1.model.User;
import ru.kata.pp.__1_1.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUser(Model model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("list", list);
        return "user";
    }

    @GetMapping("/addNewUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "UserInfo";
    }

    @PostMapping("/addNewUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUserById(id));
        return "userEdit";
    }

    @PutMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}