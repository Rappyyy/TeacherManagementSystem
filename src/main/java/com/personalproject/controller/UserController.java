package com.personalproject.controller;


import com.personalproject.entity.User;
import com.personalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") String userId) {
        return userRepository.getUserById(userId);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id") String userId) {
        return userRepository.deleteUserById(userId);
    }

    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") String userId, @RequestBody User user) {
        return userRepository.update(userId, user);
    }

}
