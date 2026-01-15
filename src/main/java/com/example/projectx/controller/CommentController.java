package com.example.projectx.controller;

import com.example.projectx.dto.comment.CommentCreateRequest;
import com.example.projectx.dto.comment.CommentResponse;
import com.example.projectx.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // GET /comments → list all comments
    @GetMapping
    public List<CommentResponse> getAllComments() {
        return commentService.getAllComments();
    }

    // POST /comments → create a comment
    @PostMapping
    public CommentResponse createComment(@RequestBody CommentCreateRequest dto) {
        return commentService.createComment(dto);
    }
}
