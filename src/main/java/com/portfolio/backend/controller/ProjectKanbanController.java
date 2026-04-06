package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.ProjectKanban;
import com.portfolio.backend.repository.ProjectKanbanRepository;

import java.util.*;

@RestController
@RequestMapping("/api/kanban")
@CrossOrigin("*")
public class ProjectKanbanController {

    @Autowired
    private ProjectKanbanRepository repo;

    // ✅ GET ALL (GROUPED BY STATUS)
    @GetMapping
    public ResponseEntity<Map<String, List<ProjectKanban>>> getAll() {

        Map<String, List<ProjectKanban>> board = new HashMap<>();

        board.put("todo", repo.findByStatus("todo"));
        board.put("progress", repo.findByStatus("progress"));
        board.put("done", repo.findByStatus("done"));

        return ResponseEntity.ok(board);
    }

    // ✅ ADD TASK
    @PostMapping
    public ResponseEntity<ProjectKanban> add(@RequestBody ProjectKanban task) {
        return ResponseEntity.ok(repo.save(task));
    }

    // ✅ UPDATE STATUS (DRAG & DROP)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProjectKanban updated) {

        Optional<ProjectKanban> optional = repo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Task not found");
        }

        ProjectKanban t = optional.get();
        t.setName(updated.getName());
        t.setStatus(updated.getStatus());

        repo.save(t);

        return ResponseEntity.ok(t);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Task not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
}