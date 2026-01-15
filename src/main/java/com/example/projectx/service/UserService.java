package com.example.projectx.service;

import com.example.projectx.dto.user.UserCreateRequest;
import com.example.projectx.dto.user.UserResponse;
import com.example.projectx.entity.User;
import com.example.projectx.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public UserResponse createUser(UserCreateRequest dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole("USER");

        userRepository.save(user);

        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setRole(user.getRole());

        return res;
    }

    // Get all users
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> {
                    UserResponse res = new UserResponse();
                    res.setId(user.getId());
                    res.setEmail(user.getEmail());
                    res.setRole(user.getRole());
                    return res;
                })
                .collect(Collectors.toList());
    }
}
