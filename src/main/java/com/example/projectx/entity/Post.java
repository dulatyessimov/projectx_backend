package com.example.projectx.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a blog post.
 * Each post belongs to a single author (User)
 * Each post can have multiple comments
 */
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    private String title; // Post title

    @Column(columnDefinition="TEXT") // Long text content
    private String content;

    @ManyToOne // Many posts belong to one author
    @JoinColumn(name="author_id") // Foreign key column
    private User author;

    private LocalDateTime createdAt = LocalDateTime.now(); // Timestamp

    @OneToMany(mappedBy = "post") // A post can have many comments
    private List<Comment> comments;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
}


