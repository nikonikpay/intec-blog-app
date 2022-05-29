package com.ali.blogapp.controller;

import com.ali.blogapp.Model.User;
import com.ali.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({ "/", "/list"})
    public ModelAndView listOfUsers() {
        ModelAndView modelAndView = new ModelAndView("user-list");
        List<User> userList = userService.getAllUsers();
        modelAndView.addObject("userList", userList);
        return modelAndView;


    }
    @GetMapping("/addUserForm")
    public ModelAndView addEmployeeForm() {
        ModelAndView mav = new ModelAndView("add-user-form");
        User theUser = new User();
        System.out.println(theUser);
        mav.addObject("theUser", theUser);
        return mav;
    }

    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/list";
    }


    @GetMapping("/updateUser")
    public ModelAndView showUpdateForm(@RequestParam Long userId) {
        ModelAndView mav = new ModelAndView("add-user-form");
        User theUser = userService.findById(userId);
        System.out.println(theUser);
        mav.addObject("theUser", theUser);
        return mav;
    }



}
