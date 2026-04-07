package com.portfolio.backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "student")
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

    // ✅ Fix lazy loading issue
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> feedback;

    // ✅ Fix lazy loading issue for projects
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<StudentProject> projects;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public List<String> getFeedback() { return feedback; }
    public void setFeedback(List<String> feedback) { this.feedback = feedback; }

    public List<StudentProject> getProjects() { return projects; }
    public void setProjects(List<StudentProject> projects) { this.projects = projects; }
}