package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String week;
    private int progress;

    private String courseName;
    private int courseProgress;

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getWeek() { return week; }
    public void setWeek(String week) { this.week = week; }

    public int getProgress() { return progress; }
    public void setProgress(int progress) { this.progress = progress; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public int getCourseProgress() { return courseProgress; }
    public void setCourseProgress(int courseProgress) { this.courseProgress = courseProgress; }
}