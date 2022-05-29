package com.ali.blogapp.service;

import com.ali.blogapp.Model.User;

import java.util.List;


public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User findById(Long id);
}
