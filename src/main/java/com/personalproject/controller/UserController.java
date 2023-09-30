package com.personalproject.controller;


import com.personalproject.entity.User;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/employee")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/employee/{id}")
    public User getUsserById(@PathVariable("id") String userId) {
        return userRepository.getUserById(userId);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteUserById(@PathVariable("id") String userId) {
        return userRepository.deleteUserById(userId);
    }

    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable("id") String userId, @RequestBody User user) {
        return userRepository.update(userId, user);
    }

}
