package com.portfolio.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Portfolio;
import com.portfolio.backend.repository.PortfolioRepository;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin("*")
public class PortfolioController {

    @Autowired
    private PortfolioRepository repo;

    // ✅ SAVE PORTFOLIO
    @PostMapping
    public Portfolio save(@RequestBody Portfolio p) {
        return repo.save(p);
    }

    // ✅ GET ALL PORTFOLIOS
    @GetMapping
    public List<Portfolio> getAll() {
        return repo.findAll();
    }
}