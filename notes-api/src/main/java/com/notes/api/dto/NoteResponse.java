package com.notes.api.dto;

public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private String ownerEmail;

    public NoteResponse(Long id, String title, String content, String ownerEmail) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ownerEmail = ownerEmail;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
}
