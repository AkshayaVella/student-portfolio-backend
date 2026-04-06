package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Assignment;
import com.portfolio.backend.repository.AssignmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin("*")
public class AssignmentController {

    @Autowired
    private AssignmentRepository repo;

    // ✅ GET ALL ASSIGNMENTS
    @GetMapping
    public List<Assignment> getAll() {
        return repo.findAll();
    }

    // ✅ ADD ASSIGNMENT
    @PostMapping
    public Assignment add(@RequestBody Assignment a) {
        return repo.save(a);
    }

    // ✅ DELETE (optional)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}