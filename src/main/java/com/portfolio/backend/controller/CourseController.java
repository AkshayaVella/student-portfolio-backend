package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.portfolio.backend.model.Course;
import com.portfolio.backend.repository.CourseRepository;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

    @Autowired
    private CourseRepository repo;

    @GetMapping
    public List<Course> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Course add(@RequestBody Course c) {
        return repo.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}