package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Reports;
import com.portfolio.backend.repository.ReportsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin("*")
public class ReportsController {

    @Autowired
    private ReportsRepository repo;

    // ✅ GET ALL REPORTS
    @GetMapping
    public ResponseEntity<List<Reports>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // ✅ GET BY TYPE (VERY IMPORTANT)
    @GetMapping("/{type}")
    public ResponseEntity<List<Reports>> getByType(@PathVariable String type) {
        return ResponseEntity.ok(repo.findByType(type));
    }

    // ✅ ADD REPORT DATA
    @PostMapping
    public ResponseEntity<Reports> add(@RequestBody Reports report) {
        return ResponseEntity.ok(repo.save(report));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}