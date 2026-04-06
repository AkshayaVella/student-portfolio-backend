package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}