package com.example.projectx.controller;

import com.example.projectx.entity.Post;
import com.example.projectx.repository.PostRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST API for Posts
 */
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // GET /posts → return all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // POST /posts → create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }
}

