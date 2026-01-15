package com.example.projectx.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents a comment on a post.
 * Each comment belongs to a single post and a single author (User)
 */
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;

    @Column(columnDefinition="TEXT")
    private String text; // Comment text

    @ManyToOne
    @JoinColumn(name="post_id") // Foreign key to post
    private Post post;

    @ManyToOne
    @JoinColumn(name="author_id") // Foreign key to user
    private User author;

    private LocalDateTime createdAt = LocalDateTime.now(); // Timestamp

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }

    public User getAuthor() { return author; }
    public void setAuthor(User author) { this.author = author; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
