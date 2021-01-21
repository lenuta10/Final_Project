package com.example.catalog.controller;

import com.example.catalog.domain.User;
import com.example.catalog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller // annotation -> makes the class a BEAN -> managed by the application context
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).get();

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).get();

        userService.delete(user);
        return "redirect:/";
    }


}
