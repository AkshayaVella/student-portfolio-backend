package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.ManageProjects;
import com.portfolio.backend.repository.ManageProjectsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/manage-projects")
@CrossOrigin("*")
public class ManageProjectsController {

    @Autowired
    private ManageProjectsRepository repo;

    // ✅ GET ALL
    @GetMapping
    public ResponseEntity<List<ManageProjects>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // ✅ ADD PROJECT
    @PostMapping
    public ResponseEntity<ManageProjects> add(@RequestBody ManageProjects project) {
        return ResponseEntity.ok(repo.save(project));
    }

    // ✅ UPDATE PROJECT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ManageProjects updated) {

        Optional<ManageProjects> optional = repo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Project not found");
        }

        ManageProjects p = optional.get();

        p.setTitle(updated.getTitle());
        p.setCategory(updated.getCategory());
        p.setDescription(updated.getDescription());
        p.setProgress(updated.getProgress());
        p.setStatus(updated.getStatus());
        p.setMembers(updated.getMembers());

        repo.save(p);

        return ResponseEntity.ok(p);
    }

    // ✅ DELETE PROJECT
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Project not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Project deleted successfully");
    }
}