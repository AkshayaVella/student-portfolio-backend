package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String date;
    private String year;
    private String medal;

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getMedal() { return medal; }
    public void setMedal(String medal) { this.medal = medal; }
}