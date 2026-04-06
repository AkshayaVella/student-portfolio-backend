package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String code;

    private String description;
    private String category;
    private String level;

    // ✅ REQUIRED: Default Constructor
    public Course() {}

    // ✅ Optional Constructor
    public Course(String title, String code, String description, String category, String level) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.category = category;
        this.level = level;
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    // ✅ Optional: toString (debugging)
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}