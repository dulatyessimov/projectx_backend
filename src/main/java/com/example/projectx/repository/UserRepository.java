package com.example.projectx.repository;

import com.example.projectx.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface to manage users in DB.
 * JpaRepository provides methods like save(), findAll(), findById(), delete(), etc.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email); // Custom query by email
}
