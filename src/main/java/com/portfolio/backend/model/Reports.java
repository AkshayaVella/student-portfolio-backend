package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Type of report
    private String type; 
    // values: "student", "course", "task"

    // 🔹 Common fields
    private String name;   // Completed / CSE / Assignments
    private int value;     // percentage value

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }
}