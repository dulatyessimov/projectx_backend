package com.example.projectx.service;

import com.example.projectx.dto.post.PostCreateRequest;
import com.example.projectx.dto.post.PostResponse;
import com.example.projectx.entity.Post;
import com.example.projectx.entity.User;
import com.example.projectx.repository.PostRepository;
import com.example.projectx.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // Create a post
    public PostResponse createPost(PostCreateRequest dto) {
        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(author);

        postRepository.save(post);

        PostResponse res = new PostResponse();
        res.setId(post.getId());
        res.setTitle(post.getTitle());
        res.setContent(post.getContent());
        res.setAuthorEmail(author.getEmail());
        return res;
    }

    // Get all posts
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> {
                    PostResponse res = new PostResponse();
                    res.setId(post.getId());
                    res.setTitle(post.getTitle());
                    res.setContent(post.getContent());
                    res.setAuthorEmail(post.getAuthor().getEmail());
                    return res;
                })
                .collect(Collectors.toList());
    }

    // Optional: get by ID
    public PostResponse getPostById(Long id) {
        return postRepository.findById(id)
                .map(post -> {
                    PostResponse res = new PostResponse();
                    res.setId(post.getId());
                    res.setTitle(post.getTitle());
                    res.setContent(post.getContent());
                    res.setAuthorEmail(post.getAuthor().getEmail());
                    return res;
                })
                .orElse(null);
    }

    // Optional: delete
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
