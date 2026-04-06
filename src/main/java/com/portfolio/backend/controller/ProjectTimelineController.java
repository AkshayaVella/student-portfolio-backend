package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.ProjectTimeline;
import com.portfolio.backend.repository.ProjectTimelineRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/timeline")
@CrossOrigin("*")
public class ProjectTimelineController {

    @Autowired
    private ProjectTimelineRepository repo;

    // ✅ GET ALL PROJECTS
    @GetMapping
    public ResponseEntity<List<ProjectTimeline>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // ✅ ADD PROJECT
    @PostMapping
    public ResponseEntity<ProjectTimeline> add(@RequestBody ProjectTimeline p) {
        return ResponseEntity.ok(repo.save(p));
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProjectTimeline updated) {

        Optional<ProjectTimeline> optional = repo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Project not found");
        }

        ProjectTimeline p = optional.get();
        p.setName(updated.getName());
        p.setDuration(updated.getDuration());

        repo.save(p);

        return ResponseEntity.ok(p);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Project not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}