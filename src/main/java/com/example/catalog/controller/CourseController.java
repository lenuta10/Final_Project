package com.example.catalog.controller;

import com.example.catalog.domain.Course;
import com.example.catalog.service.impl.CourseServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(value = "/course")
public class CourseController {
    private final CourseServiceImpl courseService;

    public CourseController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }


//    @GetMapping("/signup")
//    public String showSignUpCourseForm(Course course) {
//        return "add-course";
//    }

    @PostMapping("/addcourse")
    public String addCourse(@ModelAttribute Course course, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-course";
        }

        courseService.save(course);
        return "redirect:/admin";
    }

//    @GetMapping("/adminCourse")
//    public String showCourseList(Model model) {
//        model.addAttribute("courses", courseService.getAll());
//        return "admin";
//    }

    @GetMapping("/editCourse/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Course course = courseService.findById(id).get();

        model.addAttribute("course", course);
        return "update-course";
    }

    @PostMapping("/updateCourse/{id}")
    public String updateCourse(@PathVariable("id") long id, Course course,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            course.setId(id);
            return "update-course";
        }

        courseService.save(course);
        return "redirect:/admin";
    }

    @GetMapping("/deleteCourse/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Course course = courseService.findById(id).get();

        courseService.delete(course);
        return "redirect:/admin";
    }

}
