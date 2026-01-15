package com.example.projectx.repository;

import com.example.projectx.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository to manage comments
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {}

