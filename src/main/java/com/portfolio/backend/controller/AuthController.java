package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User u = repo.findByEmail(user.getEmail());
        if (u != null && u.getPassword().equals(user.getPassword())) {
            return u;
        }
        return null;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }
}