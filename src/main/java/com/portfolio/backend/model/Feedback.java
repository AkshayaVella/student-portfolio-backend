package com.portfolio.backend.model;

import jakarta.persistence.*;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String student;
    private String regNo;
    private String message;
    private String date;
    private String status;
    private String reply;
    private String email;

    // ✅ Getters & Setters

    public Long getId() { return id; }

    public String getStudent() { return student; }
    public void setStudent(String student) { this.student = student; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}