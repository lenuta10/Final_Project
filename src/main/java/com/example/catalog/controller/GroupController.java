package com.example.catalog.controller;

import com.example.catalog.domain.Group;
import com.example.catalog.service.impl.GroupServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {

    private final GroupServiceImpl groupService;

    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/addgroup")
    public String addGroup(@ModelAttribute Group group, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-group";
        }

        groupService.save(group);
        return "redirect:/admin";
    }

    @GetMapping("/editGroup/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Group group = groupService.findById(id).get();

        model.addAttribute("group", group);
        return "update-group";
    }

    @PostMapping("/updateGroup/{id}")
    public String updateCourse(@PathVariable("id") long id, Group group,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            group.setId(id);
            return "update-group";
        }

        groupService.save(group);
        return "redirect:/admin";
    }

    @GetMapping("/deleteGroup/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Group group = groupService.findById(id).get();

        groupService.delete(group);
        return "redirect:/admin";
    }
}
