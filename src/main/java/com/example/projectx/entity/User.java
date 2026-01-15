package com.example.projectx.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a user in the system.
 * Each user can have many posts and comments.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(nullable=false, unique=true) // Required and unique
    private String email;

    @Column(nullable=false) // Required field
    private String password;

    private String role; // e.g., admin, user

    private LocalDateTime createdAt = LocalDateTime.now(); // Timestamp when user created

    // One user can write multiple posts
    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    // One user can write multiple comments
    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Post> getPosts() { return posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}
