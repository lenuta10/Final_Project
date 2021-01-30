package com.example.catalog.controller;

import com.example.catalog.domain.Course;
import com.example.catalog.domain.User;
import com.example.catalog.dto.LoginDto;
import com.example.catalog.service.impl.CourseServiceImpl;
import com.example.catalog.service.impl.GroupServiceImpl;
import com.example.catalog.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = "/user")
public class UserController {

    private final UserServiceImpl userService;
    private final CourseServiceImpl courseService;
    private final GroupServiceImpl groupService;

    public UserController(UserServiceImpl userService, CourseServiceImpl courseService, GroupServiceImpl groupService) {
        this.userService = userService;
        this.courseService = courseService;
        this.groupService = groupService;
    }

    @GetMapping("/adduser")
    public String create(Model model) {
        model.addAttribute("classes", groupService.getAll());
        model.addAttribute("courses", courseService.getAll());
 //       model.addAttribute("user", new User()); //or try to fetch an existing object
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin")
    public String showLists(Model model) {
        model.addAttribute("users", userService.getAll());
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("classes", groupService.getAll());
        return "admin";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).get();

        model.addAttribute("user", user);
        model.addAttribute("classes", groupService.getAll());
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
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).get();

        userService.delete(user);
        return "redirect:/admin";
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute LoginDto loginDto, BindingResult result, Model model){
//        return userService.login(loginDto);
//    }
}
