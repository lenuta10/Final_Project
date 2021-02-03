package com.example.catalog.controller;

import com.example.catalog.domain.Course;
import com.example.catalog.domain.CourseRegistration;
import com.example.catalog.domain.User;
import com.example.catalog.service.SecurityService;
import com.example.catalog.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userService;
    private final CourseServiceImpl courseService;
    private final GroupServiceImpl groupService;
    private final CourseRegistrationServiceImpl courseRegistrationService;

    public UserController(UserServiceImpl userService, CourseServiceImpl courseService, GroupServiceImpl groupService, CourseRegistrationServiceImpl courseRegistrationService) {
        this.userService = userService;
        this.courseService = courseService;
        this.groupService = groupService;
        this.courseRegistrationService = courseRegistrationService;
    }

    @GetMapping("/adduser")
    public String create(Model model) {
        model.addAttribute("classes", groupService.getAll());
        model.addAttribute("courses", courseService.getAll());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user, BindingResult result, Model model,
                          @RequestParam(value = "courseRegistrations" , required = false) Long[] courseRegistrations) {
        if (result.hasErrors()) {
            return "add-user";
        }

        if(courseRegistrations != null) {
            CourseRegistration courseRegistration;
            Course course;
            for (Long registration : courseRegistrations) {
                if (courseService.existsById(registration)) {
                    course = courseService.findById(registration).get();
                    courseRegistration = new CourseRegistration();
                    courseRegistration.setCourse(course);
                    courseRegistration.setUser(user);
                    courseRegistrationService.save(courseRegistration);
                }
            }
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

    @GetMapping("/editGrade/{id}")
    public String showUpdateGradeForm(@PathVariable("id") long id, Model model) {
        CourseRegistration courseRegistration = courseRegistrationService.findById(id).get();

        model.addAttribute("courseRegistration", courseRegistration);

        return "update-grade";
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

    @PostMapping("/updateGrade/{id}")
    public String updateCourseRegistration(@PathVariable("id") long id, CourseRegistration courseRegistration,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            courseRegistration.setId(id);
            return "update-grade";
        }

        courseRegistrationService.save(courseRegistration);
        return "redirect:/professor";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).get();

        userService.delete(user);
        return "redirect:/admin";
    }
    @GetMapping("/student/{username}")
    public String showListOfCourseRegistration(@PathVariable("username") String username,Model model) {

        model.addAttribute("courseRegistrations", courseRegistrationService.getCourseRegistrations(username));

        return "redirect:/student";
    }

    @GetMapping("/professor/{username}")
    public String showCourseRegistrations(@PathVariable("username") String username,Model model) {

        model.addAttribute("courseRegistrations", courseRegistrationService.getFinalList(username));

        return "professor";
    }

}
