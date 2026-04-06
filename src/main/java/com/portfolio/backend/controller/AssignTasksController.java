package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.AssignTasks;
import com.portfolio.backend.repository.AssignTasksRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class AssignTasksController {

    @Autowired
    private AssignTasksRepository repo;

    // ✅ GET ALL TASKS
    @GetMapping
    public ResponseEntity<List<AssignTasks>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // ✅ ADD TASK
    @PostMapping
    public ResponseEntity<AssignTasks> add(@RequestBody AssignTasks task) {
        return ResponseEntity.ok(repo.save(task));
    }

    // ✅ UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AssignTasks updated) {

        Optional<AssignTasks> optionalTask = repo.findById(id);

        if (optionalTask.isEmpty()) {
            return ResponseEntity.status(404).body("Task not found");
        }

        AssignTasks t = optionalTask.get();

        t.setTitle(updated.getTitle());
        t.setDescription(updated.getDescription());
        t.setStudent(updated.getStudent());
        t.setDueDate(updated.getDueDate());
        t.setPriority(updated.getPriority());
        t.setStatus(updated.getStatus());

        repo.save(t);

        return ResponseEntity.ok(t);
    }

    // ✅ DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Task not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}