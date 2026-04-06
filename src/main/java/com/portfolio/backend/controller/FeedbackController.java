package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolio.backend.model.Feedback;
import com.portfolio.backend.repository.FeedbackRepository;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin("*")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repo;

    // ✅ GET ALL
    @GetMapping
    public List<Feedback> getAll() {
        return repo.findAll();
    }

    // ✅ ADD FEEDBACK
    @PostMapping
    public Feedback send(@RequestBody Feedback f) {
        f.setStatus("Pending");
        return repo.save(f);
    }

    // ✅ UPDATE REPLY
    @PutMapping("/{id}")
    public Feedback reply(@PathVariable Long id, @RequestBody Feedback updated) {

        Feedback f = repo.findById(id).orElseThrow();

        f.setReply(updated.getReply());
        f.setStatus("Resolved");

        return repo.save(f);
    }
}