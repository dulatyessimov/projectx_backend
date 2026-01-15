package com.example.projectx.repository;

import com.example.projectx.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage posts
 */
public interface PostRepository extends JpaRepository<Post, Long> {}
