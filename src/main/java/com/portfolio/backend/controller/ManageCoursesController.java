package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.ManageCourses;
import com.portfolio.backend.repository.ManageCoursesRepository;

import java.util.List;

@RestController
@RequestMapping("/api/manage-courses")
@CrossOrigin("*")
public class ManageCoursesController {

    @Autowired
    private ManageCoursesRepository repo;

    // ✅ GET ALL COURSES
    @GetMapping
    public List<ManageCourses> getAll() {
        return repo.findAll();
    }

    // ✅ ADD COURSE
    @PostMapping
    public ManageCourses add(@RequestBody ManageCourses course) {
        return repo.save(course);
    }

    // ✅ UPDATE COURSE
    @PutMapping("/{id}")
    public ManageCourses update(@PathVariable Long id, @RequestBody ManageCourses updated) {
        ManageCourses c = repo.findById(id).orElseThrow();

        c.setTitle(updated.getTitle());
        c.setCode(updated.getCode());
        c.setDescription(updated.getDescription());
        c.setCategory(updated.getCategory());
        c.setLevel(updated.getLevel());
        c.setStudents(updated.getStudents());

        return repo.save(c);
    }

    // ✅ DELETE COURSE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}