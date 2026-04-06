package com.portfolio.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ManageProjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String category;
    private String description;
    private int progress;
    private String status;

    // ✅ Store members list
    @ElementCollection
    private List<String> members;

    // Getters & Setters

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<String> getMembers() { return members; }
    public void setMembers(List<String> members) { this.members = members; }
}