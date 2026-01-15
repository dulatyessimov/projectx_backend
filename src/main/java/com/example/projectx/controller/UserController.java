package com.example.projectx.controller;

import com.example.projectx.dto.user.UserCreateRequest;
import com.example.projectx.dto.user.UserResponse;
import com.example.projectx.entity.User;
import com.example.projectx.repository.UserRepository;
import com.example.projectx.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API for Users
 */

//2 CHANGE
@RestController
@RequestMapping("/users") // Base URL for this controller
public class UserController {

    private final UserService userService;

    // Controller depends on SERVICE, not repository now (2)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /users → returns list of users (DTOs)
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // POST /users → create new user
    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest dto) {
        return userService.createUser(dto);
    }
}

