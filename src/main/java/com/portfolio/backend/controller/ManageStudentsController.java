package com.portfolio.backend.controller;

import com.portfolio.backend.model.Student;
import com.portfolio.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:3000")
public class ManageStudentsController {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ @Transactional fixes lazy loading
    @GetMapping
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    @Transactional
    public Student getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Transactional
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    @Transactional
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}