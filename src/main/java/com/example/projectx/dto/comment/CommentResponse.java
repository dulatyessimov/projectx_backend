package com.example.projectx.dto.comment;

public class CommentResponse {
    private Long id;
    private String text;
    private String authorEmail;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAuthorEmail() { return authorEmail; }
    public void setAuthorEmail(String authorEmail) { this.authorEmail = authorEmail; }
}
