package com.example.projectx.controller;

import com.example.projectx.entity.User;
import com.example.projectx.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API for Users
 */
@RestController
@RequestMapping("/users") // Base URL for this controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET /users → returns list of all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST /users → create new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}

