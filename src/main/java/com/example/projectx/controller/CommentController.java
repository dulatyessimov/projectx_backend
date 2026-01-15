package com.example.projectx.controller;

import com.example.projectx.entity.Comment;
import com.example.projectx.repository.CommentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API for Comments
 */
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // GET /comments → list all comments
    @GetMapping
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    // POST /comments → create new comment
    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentRepository.save(comment);
    }
}

