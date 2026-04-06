package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String theme;          // light / dark
    private boolean notifications; // true / false

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public boolean isNotifications() { return notifications; }
    public void setNotifications(boolean notifications) {
        this.notifications = notifications;
    }
}