package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class ManageCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String code;
    private String description;
    private String category;
    private String level;
    private int students;

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public int getStudents() { return students; }
    public void setStudents(int students) { this.students = students; }
}