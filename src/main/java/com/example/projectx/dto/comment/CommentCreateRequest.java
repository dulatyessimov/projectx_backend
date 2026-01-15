package com.example.projectx.dto.comment;

public class CommentCreateRequest {
    private String text;
    private Long postId;
    private Long authorId;

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }
}
