package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Achievement;
import com.portfolio.backend.repository.AchievementRepository;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin("*")
public class AchievementController {

    @Autowired
    private AchievementRepository repo;

    // ✅ GET ALL ACHIEVEMENTS
    @GetMapping
    public List<Achievement> getAll() {
        return repo.findAll();
    }

    // ✅ ADD ACHIEVEMENT
    @PostMapping
    public Achievement add(@RequestBody Achievement a) {
        return repo.save(a);
    }

    // ✅ DELETE (optional)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}