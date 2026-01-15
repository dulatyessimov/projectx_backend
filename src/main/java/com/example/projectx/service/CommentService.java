package com.example.projectx.service;

import com.example.projectx.dto.comment.CommentCreateRequest;
import com.example.projectx.dto.comment.CommentResponse;
import com.example.projectx.entity.Comment;
import com.example.projectx.entity.Post;
import com.example.projectx.entity.User;
import com.example.projectx.repository.CommentRepository;
import com.example.projectx.repository.PostRepository;
import com.example.projectx.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository,
                          UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    // Create a comment
    public CommentResponse createComment(CommentCreateRequest dto) {
        Post post = postRepository.findById(dto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        User author = userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setPost(post);
        comment.setAuthor(author);

        commentRepository.save(comment);

        CommentResponse res = new CommentResponse();
        res.setId(comment.getId());
        res.setText(comment.getText());
        res.setAuthorEmail(author.getEmail());

        return res;
    }

    // Get all comments
    public List<CommentResponse> getAllComments() {
        return commentRepository.findAll().stream()
                .map(comment -> {
                    CommentResponse res = new CommentResponse();
                    res.setId(comment.getId());
                    res.setText(comment.getText());
                    res.setAuthorEmail(comment.getAuthor().getEmail());
                    return res;
                })
                .collect(Collectors.toList());
    }
}
