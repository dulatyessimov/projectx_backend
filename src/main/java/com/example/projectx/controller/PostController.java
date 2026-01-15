package com.example.projectx.controller;

import com.example.projectx.dto.post.PostCreateRequest;
import com.example.projectx.dto.post.PostResponse;
import com.example.projectx.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // GET /posts → all posts
    @GetMapping
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    // POST /posts → create new post
    @PostMapping
    public PostResponse createPost(@RequestBody PostCreateRequest dto) {
        return postService.createPost(dto);
    }
}
