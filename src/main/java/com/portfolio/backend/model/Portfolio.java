package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String about;

    @Column(length = 1000)
    private String skills;

    @Column(length = 1000)
    private String projects;

    @Column(length = 1000)
    private String achievements;

    // ✅ Default constructor (IMPORTANT)
    public Portfolio() {}

    // ✅ Parameterized constructor (optional)
    public Portfolio(String about, String skills, String projects, String achievements) {
        this.about = about;
        this.skills = skills;
        this.projects = projects;
        this.achievements = achievements;
    }

    // ✅ Getters & Setters

    public Long getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getAchievements() {
        return achievements;
    }

    public void setAchievements(String achievements) {
        this.achievements = achievements;
    }

    // ✅ toString (for debugging)
    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", skills='" + skills + '\'' +
                ", projects='" + projects + '\'' +
                ", achievements='" + achievements + '\'' +
                '}';
    }
}