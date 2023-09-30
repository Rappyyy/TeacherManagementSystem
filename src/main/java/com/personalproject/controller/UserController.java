package com.personalproject.controller;


import com.personalproject.entity.User;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/employee")
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @GetMapping("/employee/id")
    public User getEmployee(String userId) {
        return userRepository.getUserById(userId);
    }


}
