package com.velmar.blog_spring_boot.dto;

public class CommentDTO {
    private Long id;
    private String title;
    private String email;
    private String content;

    public CommentDTO(Long id, String title, String email, String content) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.content = content;
    }

    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
