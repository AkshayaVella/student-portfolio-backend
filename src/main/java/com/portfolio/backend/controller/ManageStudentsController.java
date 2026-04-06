package com.portfolio.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.portfolio.backend.model.Student;
import com.portfolio.backend.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class ManageStudentsController {

    @Autowired
    private StudentRepository repo;

    // ✅ GET ALL STUDENTS
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // ✅ ADD STUDENT
    @PostMapping
    public Student add(@RequestBody Student student) {
        return repo.save(student);
    }

    // ✅ UPDATE STUDENT (projects / feedback / status)
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student updated) {
        Student s = repo.findById(id).orElseThrow();

        s.setProjects(updated.getProjects());
        s.setFeedback(updated.getFeedback());
        s.setStatus(updated.getStatus());

        return repo.save(s);
    }

    // ✅ DELETE STUDENT
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}