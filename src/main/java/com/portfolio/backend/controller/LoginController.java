package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Login;
import com.portfolio.backend.repository.LoginRepository;

@RestController
@RequestMapping("/api/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginRepository repo;

    // ✅ LOGIN
    @PostMapping
    public Login login(@RequestBody Login login) {

        Login found = repo.findByEmailAndPassword(
                login.getEmail(),
                login.getPassword()
        );

        // ✅ IMPORTANT FIX (no crash)
        if (found == null) {
            return null;
        }

        return found;
    }

    // ✅ SIGNUP
    @PostMapping("/signup")
    public Login signup(@RequestBody Login login) {
        return repo.save(login);
    }
}