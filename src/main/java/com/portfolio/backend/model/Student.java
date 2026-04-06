package com.portfolio.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String regNo;
    private String course;
    private String year;
    private String portfolioLink;
    private String status;

    // ✅ Use StudentProject instead of Project
    @OneToMany(cascade = CascadeType.ALL)
    private List<StudentProject> projects;

    // ✅ Feedback list
    @ElementCollection
    private List<String> feedback;

    // Getters & Setters

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    public String getPortfolioLink() { return portfolioLink; }
    public void setPortfolioLink(String portfolioLink) { this.portfolioLink = portfolioLink; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<StudentProject> getProjects() { return projects; }
    public void setProjects(List<StudentProject> projects) { this.projects = projects; }

    public List<String> getFeedback() { return feedback; }
    public void setFeedback(List<String> feedback) { this.feedback = feedback; }
}