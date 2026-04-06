package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.AdminSettings;
import com.portfolio.backend.repository.AdminSettingsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin-settings")
@CrossOrigin("*")
public class AdminSettingsController {

    @Autowired
    private AdminSettingsRepository repo;

    // ✅ GET ALL SETTINGS
    @GetMapping
    public ResponseEntity<List<AdminSettings>> getAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    // ✅ SAVE / UPDATE SETTINGS
    @PostMapping
    public ResponseEntity<AdminSettings> save(@RequestBody AdminSettings settings) {
        return ResponseEntity.ok(repo.save(settings));
    }

    // ✅ UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody AdminSettings updated) {

        Optional<AdminSettings> optional = repo.findById(id);

        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Settings not found");
        }

        AdminSettings s = optional.get();

        s.setFullName(updated.getFullName());
        s.setEmail(updated.getEmail());
        s.setPassword(updated.getPassword());
        s.setTheme(updated.getTheme());
        s.setNotifications(updated.isNotifications());

        repo.save(s);

        return ResponseEntity.ok(s);
    }

    // ✅ DELETE (OPTIONAL)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if (!repo.existsById(id)) {
            return ResponseEntity.status(404).body("Settings not found");
        }

        repo.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}