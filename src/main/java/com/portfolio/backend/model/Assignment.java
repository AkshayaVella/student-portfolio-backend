package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String course;
    private String code;
    private String opened;
    private String due;
    private String description;
    private String status;
    private String grading;
    private String timeRemaining;

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getOpened() { return opened; }
    public void setOpened(String opened) { this.opened = opened; }

    public String getDue() { return due; }
    public void setDue(String due) { this.due = due; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getGrading() { return grading; }
    public void setGrading(String grading) { this.grading = grading; }

    public String getTimeRemaining() { return timeRemaining; }
    public void setTimeRemaining(String timeRemaining) { this.timeRemaining = timeRemaining; }
}