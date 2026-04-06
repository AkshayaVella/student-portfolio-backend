package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Project;
import com.portfolio.backend.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    // ✅ GET ALL PROJECTS
    @GetMapping
    public List<Project> getAll() {
        return repo.findAll();
    }

    // ✅ GET PROJECT BY ID (NEW)
    @GetMapping("/{id}")
    public Project getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // ✅ ADD PROJECT
    @PostMapping
    public Project add(@RequestBody Project p) {
        return repo.save(p);
    }

    // ✅ UPDATE PROJECT (NEW)
    @PutMapping("/{id}")
    public Project update(@PathVariable Long id, @RequestBody Project p) {
        Project existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setTitle(p.getTitle());
            existing.setCategory(p.getCategory());
            existing.setDescription(p.getDescription());
            existing.setProgress(p.getProgress());
            existing.setStatus(p.getStatus());

            return repo.save(existing);
        }

        return null;
    }

    // ✅ DELETE PROJECT
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}